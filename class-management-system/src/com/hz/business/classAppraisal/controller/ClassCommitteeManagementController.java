package com.hz.business.classAppraisal.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.box.base.page.Page;
import com.box.base.page.PageHelper;
import com.hz.business.base.controller.BaseController;
import com.hz.business.base.model.JsonResult;
import com.hz.business.base.model.SearchParam;
import com.hz.business.basicDataMng.base.pojo.StudentPO;
import com.hz.business.basicDataMng.base.pojo.TeacherPO;
import com.hz.business.basicDataMng.service.StudentService;
import com.hz.business.basicDataMng.service.TeacherService;
import com.hz.business.classActivity.base.pojo.ClassActivity;
import com.hz.business.classActivity.service.ClassActivityService;
import com.hz.business.classAppraisal.base.dao.ClassCommitteeMapper;
import com.hz.business.classAppraisal.base.dao.PrizeAwardsMapper;
import com.hz.business.classAppraisal.base.pojo.ClassCommittee;
import com.hz.business.classAppraisal.base.pojo.PrizeApply;
import com.hz.business.classAppraisal.base.pojo.PrizeAwards;
import com.hz.business.classAppraisal.base.pojo.PrizeAwardsExample;
import com.hz.business.classAppraisal.service.ClassCommitteeService;
import com.hz.business.classAppraisal.service.PrizeApplyService;

 
/**
 * 班委管理
 * @author huangzhuo
 *
 * @version 创建时间： 2017-4-5 下午10:37:41
 */
@Controller
@RequestMapping("/classCommittee")
public class ClassCommitteeManagementController extends BaseController{
	
 
	@Autowired
	public ClassCommitteeMapper classCommitteeMapper;
	
	@Autowired
	public ClassCommitteeService classCommitteeService;
	
	@Autowired
	public StudentService studentService;
	
	
 
 
	/**
	 * 跳转到班委列表页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model  ) throws IOException{
		model.addAttribute("user", user);
		return  "classCommittee/jsp/index" ;
	}
	
	/**
	 * 异步加载班委列表数据
	 * @param search
	 * @param request
	 * @return
	 */
    @RequestMapping("listClassCommittees")
    @ResponseBody
    public Map<String,Object> listClassCommittees(@ModelAttribute("search") SearchParam search  , HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
        
        
        Map<String, Object> map = new HashMap<String ,Object>();
        if ("3".equals(user.getType())) {  
        	StudentPO  student = studentService.getStudentById(user.getUserName());
        	map.put("classKey", student.getClassKey());
        }
        PageHelper.startPage(search.getPageNo(), search.getPageSize());
        Page<ClassCommittee> list = (Page<ClassCommittee>) classCommitteeService.listClassCommittee(map);
        if(list.isEmpty()) {
            return json;
        }
        
        json.put("success", true);
        json.put("obj", list);
        json.put("curPage", search.getPageNo());
        json.put("totalPage",  list.isEmpty() ? 1 : list.getPages());
        return json;
    }
 
    
    /**
     * 跳转到新增班委页面
     * @param request
     * @param response
     * @param model
     * @param type
     * @return
     * @throws IOException
     */
    @RequestMapping("/toCreateClassCommittee")
	public String toCreateClassCommittee(HttpServletRequest request ,HttpServletResponse response,Model model,Integer type) throws IOException{
    	return  "classCommittee/jsp/createClassCommittee" ;
	}
    
    /**
     * 新增班委
     * @param classCommittee
     * @param request
     * @return
     */
    @RequestMapping("insertClassCommittee")
    @ResponseBody
    public JsonResult insertClassCommittee(ClassCommittee classCommittee, HttpServletRequest request) {
    	StudentPO  student = studentService.getStudentById(classCommittee.getStudentKey());
    	classCommittee.setClassKey(student.getClassKey());
    	classCommitteeService.insertClassCommittee(classCommittee);
        return JsonResult.success("班委新增成功", classCommittee);
    }
    
 
    
 
    
    /**
     * 删除班委
     * @param keyArr
     * @param request
     * @return
     */
    @RequestMapping("deleteClassCommittee")
    @ResponseBody
    public JsonResult deleteClassCommittee(Integer[] keyArr, HttpServletRequest request) {
    	String ids = StringUtils.join(keyArr, ",");
    	classCommitteeService.delClassCommittee(ids);
        return JsonResult.success(true);
    }
	
     
}
