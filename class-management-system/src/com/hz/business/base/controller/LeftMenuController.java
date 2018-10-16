package com.hz.business.base.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hz.base.utils.JsonUtil;
import com.hz.base.utils.StringUtil;
import com.hz.business.base.model.JsonResult;
import com.hz.business.base.model.ManagerMenuExt;
import com.hz.business.classActivity.base.pojo.ManagerMenu;
import com.hz.business.classActivity.service.IManagerMenuService;

 

 
@Controller
@RequestMapping("sysm/leftMenu")
public class LeftMenuController extends BaseController {

    @Resource
    private IManagerMenuService managerMenuService;

 

    private List<ManagerMenu> managerMenus;

    @PostConstruct
    private  void initMenu() {
        managerMenus = managerMenuService.listMenus();
    }

    /**
     * 获取左侧菜单
     *
     * @param request request
     * @param authentication authentication
     * @return jsonResult
     */
    @RequestMapping("get")
    @ResponseBody
    public JsonResult getLeftMenu(HttpServletRequest request) {
    	List<ManagerMenu> result = new ArrayList<ManagerMenu>();
    	 managerMenus = managerMenuService.listMenus();
        
    	if ("3".equals(user.getType())) {  
    		List<String> studentForbidMenu = new ArrayList<String>();//学生要屏蔽的链接
            studentForbidMenu.add("基础数据维护");
            studentForbidMenu.add("学院信息维护");
            studentForbidMenu.add("专业信息维护");
            studentForbidMenu.add("班级信息维护");
            studentForbidMenu.add("教师信息维护");
            studentForbidMenu.add("学生信息维护");
            studentForbidMenu.add("用户信息维护");
            studentForbidMenu.add("学年学期维护");
            studentForbidMenu.add("课程信息维护");
            studentForbidMenu.add("课程表信息维护");
            studentForbidMenu.add("评教活动发起");
            studentForbidMenu.add("班级信息课程维护");
            studentForbidMenu.add("评教结果查询");
            for ( ManagerMenu menu :managerMenus) {
            	if (  !studentForbidMenu.contains(menu.getMenuName())) {
            		result.add(menu);
            	}
            }
            managerMenus = result;
    	}
    	
    	if ("2".equals(user.getType())) {  
    		List<String> studentForbidMenu = new ArrayList<String>();//老师要屏蔽的菜单  （如果要老师和管理员要不一致 可以进行拆分）
    		studentForbidMenu.add("基础数据维护");
            studentForbidMenu.add("学院信息维护");
            studentForbidMenu.add("专业信息维护");
            studentForbidMenu.add("班级信息维护");
            studentForbidMenu.add("教师信息维护");
            studentForbidMenu.add("学生信息维护");
            studentForbidMenu.add("用户信息维护");
            studentForbidMenu.add("学年学期维护");
            studentForbidMenu.add("学生课程表信息查询");
            studentForbidMenu.add("评教活动发起");
            studentForbidMenu.add("学生评教");
            studentForbidMenu.add("评教结果查询");
            for ( ManagerMenu menu :managerMenus) {
            	if (  !studentForbidMenu.contains(menu.getMenuName())) {
            		result.add(menu);
            	}
            }
            managerMenus = result;
    	}
    	
    	if ("1".equals(user.getType())) {  
    		List<String> notStudentForbidMenu = new ArrayList<String>();//管理员要屏蔽的菜单  （如果要老师和管理员要不一致 可以进行拆分）
    		notStudentForbidMenu.add("学生课程表信息查询");
    		notStudentForbidMenu.add("学生评教");
            for ( ManagerMenu menu :managerMenus) {
            	if (  !notStudentForbidMenu.contains(menu.getMenuName())) {
            		result.add(menu);
            	}
            }
            managerMenus = result;
    	}
    	
        List<ManagerMenuExt> menus =   getMenu(managerMenus, -1,  new ArrayList<Integer>());
        
        
        
        List<ManagerMenuExt> resultMene =  new ArrayList<ManagerMenuExt>();
		for (ManagerMenuExt menu : menus) {
        	if ( resultMene.contains(menu.getMenuUrl())) {
        		
        	}
       }
        
        
        JsonUtil util = JsonUtil.nonDefaultMapper();
        String json = util.toJson(menus);
        return JsonResult.success(menus);
    }
    
     

    /**
     * 递归查询应用菜单
     *
     * @param managerMenus 所有菜单
     * @param parentId 父appId
     * @param appendedMenuId 已添加的menuID
     * @param isAdmin 是否是超级管理员
     * @param roles 有权限应用
     * @param installApps 已安装应用
     * @return ManagerMenuExt对象集合
     */
    private List<ManagerMenuExt> getMenu(List<ManagerMenu> managerMenus, Integer parentId,  List<Integer> appendedMenuId) {
        List<ManagerMenuExt> result = new ArrayList<>();
        for (ManagerMenu menu : managerMenus) {
            if (parentId != -1 && parentId != menu.getParentId().intValue()
                    || appendedMenuId.contains(menu.getId())) {
                continue;
            }
            ManagerMenuExt ext = new ManagerMenuExt();
            ext.setId(menu.getId());
            
            ext.setName(menu.getMenuName());
            ext.setMenuUrl(menu.getMenuUrl());
            ext.setCode(menu.getRoleCode());
            ext.setAppId(menu.getAppId());
            
            
            if (StringUtil.isEmpty(menu.getMenuUrl())) {//表示有子菜单
                //递归查询子菜单
                ext.setChildren(getMenu(managerMenus, menu.getId(),  appendedMenuId));
                appendedMenuId.add(menu.getId());//已添菜单的id,避免重复添加
                if (!CollectionUtils.isEmpty(ext.getChildren())) {
                    result.add(ext);
                }
            } else {
                appendedMenuId.add(menu.getId());//已添菜单的id,避免重复添加
                result.add(ext);
            }
        }
        return result;
    }
}
