package com.hz.springboot.business.studyMng.controller;

import com.hz.springboot.base.page.Page;
import com.hz.springboot.base.page.PageHelper;
import com.hz.springboot.base.utils.User;
import com.hz.springboot.business.base.controller.BaseController;
import com.hz.springboot.business.base.model.JsonResult;
import com.hz.springboot.business.base.model.SearchParam;
import com.hz.springboot.business.studyMng.base.pojo.CoursePO;
import com.hz.springboot.business.studyMng.service.CourseService;
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
import java.util.Map;


@Controller
@RequestMapping("/studyMng/course")
public class CourseController extends BaseController {
	
	@Autowired
	public CourseService courseService;
	
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		return  "studyMng/course/jsp/index" ;
	}
	
    @RequestMapping("listCourse")
    @ResponseBody
    public Map<String,Object> listCourse(@ModelAttribute("search") SearchParam search, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
   
        PageHelper.startPage(search.getPageNo(), search.getPageSize());
        Page<CoursePO> activitys = (Page<CoursePO>) courseService.selectCourseList(search.getContent());
        if(activitys.isEmpty()) {
            return json;
        }

        
        json.put("success", true);
        json.put("obj", activitys);
        json.put("curPage", search.getPageNo());
        json.put("totalPage",  activitys.isEmpty() ? 1 : activitys.getPages());
        return json;
    }
    
    
    @RequestMapping("/toCreateCourse")
	public String toCreateActivity(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		return  "studyMng/course/jsp/createCourse" ;
	}
    
    @RequestMapping("insertCourse")
    @ResponseBody
    public JsonResult insertActivity(CoursePO po, HttpServletRequest request) {
    	po.setCreator(User.getUserKey(request));
       courseService.insertCourse(po);
        return JsonResult.success("课程新增成功", po);
    }
    
    @RequestMapping("/toUpdateCourse")
	public String toupdateActivity(HttpServletRequest request,Integer id ,HttpServletResponse response,Model model) throws IOException{
    	CoursePO po = courseService.getCourseById(id);
    	model.addAttribute("course", po);
    	return  "studyMng/course/jsp/createCourse" ;
	}
    
    
    @RequestMapping("updateCourse")
    @ResponseBody
    public JsonResult updateCourse(CoursePO po, HttpServletRequest request) {
    	courseService.updateCourse(po);
        return JsonResult.success("课程修改成功", po);
    }
	
    @RequestMapping("deleteCourse")
    @ResponseBody
    public JsonResult deleteCourse(Integer[] keyArr, HttpServletRequest request) {
    	String ids = StringUtils.join(keyArr, ",");
    	courseService.delCourse(ids);
        return JsonResult.success("课程删除成功");
    }
     
}
