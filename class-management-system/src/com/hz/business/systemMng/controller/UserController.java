package com.hz.business.systemMng.controller;

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
import com.hz.base.utils.User;
import com.hz.business.base.controller.BaseController;
import com.hz.business.base.model.JsonResult;
import com.hz.business.base.model.SearchParam;
import com.hz.business.basicDataMng.base.pojo.AcademyPO;
import com.hz.business.basicDataMng.base.pojo.StudentPO;
import com.hz.business.basicDataMng.base.pojo.TeacherPO;
import com.hz.business.basicDataMng.service.ClassAcademyService;
import com.hz.business.basicDataMng.service.StudentService;
import com.hz.business.basicDataMng.service.TeacherService;
import com.hz.business.systemMng.base.pojo.UserPO;
import com.hz.business.systemMng.service.UserService;


@Controller
@RequestMapping("/systemMng/user")
public class UserController extends BaseController{
	
	@Autowired
	public UserService userService;
	@Autowired
	public StudentService studentService;
	@Autowired
	public TeacherService teacherService;
	
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		return  "systemMng/user/jsp/index" ;
	}
	
    @RequestMapping("listUserInfo")
    @ResponseBody
    public Map<String,Object> listAccounts(@ModelAttribute("search") SearchParam search, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
   
//        PageHelper.startPage(search.getPageNo(), search.getPageSize());
//        Page<UserPO> activitys = (Page<UserPO>) userService.selectListByContent(search.getContent());
//        if(activitys.isEmpty()) {
//            return json;
//        }

        List<UserPO> activitys = (List<UserPO>) userService.selectListByContent(search.getContent());
        json.put("success", true);
        json.put("obj", activitys);
        json.put("curPage", search.getPageNo());
//        json.put("totalPage",  activitys.isEmpty() ? 1 : activitys.getPages());
        json.put("totalPage",  1);
        return json;
    }
    
    /**
     * 获取创建面板
     * @param request
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/toCreateUser")
	public String toCreateUser(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
    	List<StudentPO> studentList = studentService.studentListByUserId(null);
    	List<TeacherPO> teacherList = teacherService.teacherListByUserId(null);
    	model.addAttribute("studentList", studentList);
    	model.addAttribute("teacherList", teacherList);
    	return  "systemMng/user/jsp/createUser" ;
	}
    
    /**
     * 插入信息
     * @param activity
     * @param request
     * @return
     */
    @RequestMapping("/insertUser")
    @ResponseBody
    public JsonResult insertActivity(UserPO po, HttpServletRequest request) {
        String result = userService.insertUserInfo(po);
        if("1".equals(result)){
        	return JsonResult.succeed();
        }else{
        	return JsonResult.failure("用户已存在");
        }
        
    }
    
    
    /**
     * 保存修改信息
     * @param activity
     * @param request
     * @return
     */
    @RequestMapping("updateUserPassword")
    @ResponseBody
    public JsonResult updateUserPassword(String userKey,String password, HttpServletRequest request) {
        userService.updatePassword(userKey, password);
        return JsonResult.success("密码重置成功", userKey);
    }
	
    /**
     * 删除信息
     * @param keyArr
     * @param request
     * @return
     */
    @RequestMapping("deleteUser")
    @ResponseBody
    public JsonResult deleteUser(String key, HttpServletRequest request) {
    	userService.delUserInfo(key);
        return JsonResult.success("用户信息删除成功");
    }
	
    /**
     * 获取修改密码面板
     * @param request
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/toUpdatePassword")
	public String toUpdatePassword(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
    	model.addAttribute("userKey", User.getUserId(request));
    	return  "systemMng/user/jsp/updatePassword" ;
	}
     
    @RequestMapping("/toDesktop")
	public String todesktop(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		return  "layouts/desktop" ;
	}
}
