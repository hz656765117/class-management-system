package com.hz.springboot.business.classActivity.controller;

import com.hz.springboot.base.page.Page;
import com.hz.springboot.base.page.PageHelper;
import com.hz.springboot.business.base.controller.BaseController;
import com.hz.springboot.business.base.model.JsonResult;
import com.hz.springboot.business.base.model.SearchParam;
import com.hz.springboot.business.basicDataMng.base.pojo.ClassPO;
import com.hz.springboot.business.basicDataMng.base.pojo.StudentPO;
import com.hz.springboot.business.basicDataMng.service.ClassService;
import com.hz.springboot.business.basicDataMng.service.StudentService;
import com.hz.springboot.business.classActivity.base.pojo.ClassActivity;
import com.hz.springboot.business.classActivity.service.ClassActivityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 * 班级活动controller类
 * @author huangzhuo
 *
 * @version 创建时间： 2017-3-16 下午4:36:48
 */
@Controller
@RequestMapping("/activity")
public class ActivityController extends BaseController {
	
	@Autowired
	public ClassActivityService classActivityService;
	
	@Autowired
	public ClassService classService;
	
	@Autowired
	public StudentService studentService;
	
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
	 
		return  "activity/jsp/index" ;
	}
	
    @RequestMapping("listActivitys")
    @ResponseBody
    public Map<String,Object> listAccounts(@ModelAttribute("search") SearchParam search, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
        
        Map<String,Object> map = new HashMap<>();
        if ( "3".equals(user.getType()) ) {
        	StudentPO student = studentService.getStudentByStuKey(user.getUserName());
        	map.put("classId",student.getClassKey() );
        }
        
   
        PageHelper.startPage(search.getPageNo(), search.getPageSize());
//        Page<ClassActivity> activitys = (Page<ClassActivity>) classActivityService.activityListByUserId(null);
        Page<ClassActivity> activitys = (Page<ClassActivity>) classActivityService.listactivityList(map);
        if(activitys.isEmpty()) {
            return json;
        }
        
        json.put("success", true);
        json.put("obj", activitys);
        json.put("curPage", search.getPageNo());
        json.put("totalPage",  activitys.isEmpty() ? 1 : activitys.getPages());
        return json;
    }
    
    
    @RequestMapping("/toCreateActivity")
	public String toCreateActivity(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
    	List<ClassPO> classes = classService.listAllClass();
    	model.addAttribute("classes", classes);
    	return  "activity/jsp/createActivity" ;
	}
    
    @RequestMapping("insertActivity")
    @ResponseBody
    public JsonResult insertActivity(ClassActivity activity, HttpServletRequest request) {
    	activity.setCreator(user.getUserName());
        classActivityService.insertActivity(activity);
        return JsonResult.success("班级活动新增成功", activity);
    }
    
    @RequestMapping("/toUpdateActivity")
	public String toupdateActivity(HttpServletRequest request,Integer id ,HttpServletResponse response,Model model) throws IOException{
    	ClassActivity activity = classActivityService.getActivityById(id);
    	model.addAttribute("activity", activity);
    	List<ClassPO> classes = classService.listAllClass();
    	model.addAttribute("classes", classes);
    	return  "activity/jsp/createActivity" ;
	}
    
    
    @RequestMapping("updateActivity")
    @ResponseBody
    public JsonResult updateActivity(ClassActivity activity, HttpServletRequest request) {
        classActivityService.updateClassActivity(activity);
        return JsonResult.success("班级活动新增成功", activity);
    }
	
    @RequestMapping("deleteActivity")
    @ResponseBody
    public JsonResult deleteActivity(Integer[] keyArr, HttpServletRequest request) {
    	String ids = StringUtils.join(keyArr, ",");
        classActivityService.delClassActivity(ids);
        return JsonResult.success("班级活动新增成功");
    }
	
     
}
