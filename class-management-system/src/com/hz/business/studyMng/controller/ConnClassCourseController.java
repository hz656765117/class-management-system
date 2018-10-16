package com.hz.business.studyMng.controller;

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
import com.hz.business.basicDataMng.base.pojo.ClassPO;
import com.hz.business.basicDataMng.base.pojo.StudentPO;
import com.hz.business.basicDataMng.service.ClassService;
import com.hz.business.studyMng.base.pojo.ConnClassCoursePO;
import com.hz.business.studyMng.base.pojo.CoursePO;
import com.hz.business.studyMng.service.ConnClassCourseService;
import com.hz.business.studyMng.service.CourseService;

@Controller
@RequestMapping("/studyMng/classCourse")
public class ConnClassCourseController extends BaseController{
	
	@Autowired
	public ConnClassCourseService classCourseService;
	@Autowired
	public ClassService classService;
	@Autowired
	public CourseService courseService;
	
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		List<ClassPO> classes = classService.listAllClass();
    	model.addAttribute("classes", classes);
		return  "studyMng/classCourse/jsp/index" ;
	}
	
    @RequestMapping("listClassCourse")
    @ResponseBody
    public Map<String,Object> listclassCourse(@ModelAttribute("search") SearchParam search, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
        
        Map<String, Object> map = new HashMap<String ,Object>();
        if(  StringUtils.isNotBlank(search.getCourseId()) && !"0".equals(search.getCourseId())){
        	map.put("courseId", search.getCourseId());
        }
        
        if(  StringUtils.isNotBlank(search.getYearId()) && !"0".equals(search.getYearId())){
        	map.put("yearId", search.getYearId());
        }
        
        if(  StringUtils.isNotBlank(search.getClassId()) && !"0".equals(search.getClassId())){
        	map.put("classId", search.getClassId());
        }
   
        PageHelper.startPage(search.getPageNo(), search.getPageSize());
        Page<ConnClassCoursePO> activitys = (Page<ConnClassCoursePO>) classCourseService.selectClassCourseList(map);
        if(activitys.isEmpty()) {
            return json;
        }

        
        json.put("success", true);
        json.put("obj", activitys);
        json.put("curPage", search.getPageNo());
        json.put("totalPage",  activitys.isEmpty() ? 1 : activitys.getPages());
        return json;
    }
    
    
    @RequestMapping("/toCreateClassCourse")
	public String toCreateActivity(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
    	List<ClassPO> list=classService.classListByMajorKey(null);
		model.addAttribute("classList", list);
		List<CoursePO> list1=courseService.selectCourseList(null);
		model.addAttribute("courseList", list1);
    	return  "studyMng/classCourse/jsp/createClassCourse" ;
	}
    
    @RequestMapping("insertClassCourse")
    @ResponseBody
    public JsonResult insertActivity(ConnClassCoursePO po, HttpServletRequest request) {
    	po.setCreator(User.getUserKey(request));
       classCourseService.insertCourse(po);
        return JsonResult.success("班级课程新增成功", po);
    }
    
    @RequestMapping("deleteclassCourse")
    @ResponseBody
    public JsonResult deleteclassCourse(Integer[] keyArr, HttpServletRequest request) {
    	String ids = StringUtils.join(keyArr, ",");
    	classCourseService.delClassCourse(ids);
        return JsonResult.success("班级课程删除成功");
    }
     
}
