package com.hz.springboot.business.classAppraisal.controller;


import com.hz.springboot.base.page.Page;
import com.hz.springboot.base.page.PageHelper;
import com.hz.springboot.business.base.controller.BaseController;
import com.hz.springboot.business.base.model.JsonResult;
import com.hz.springboot.business.base.model.SearchParam;
import com.hz.springboot.business.basicDataMng.base.pojo.ClassPO;
import com.hz.springboot.business.basicDataMng.base.pojo.StudentPO;
import com.hz.springboot.business.basicDataMng.service.ClassService;
import com.hz.springboot.business.basicDataMng.service.StudentService;
import com.hz.springboot.business.classAppraisal.base.pojo.StudentCourseScore;
import com.hz.springboot.business.classAppraisal.service.StudentScoreService;
import com.hz.springboot.business.studyMng.base.pojo.CoursePO;
import com.hz.springboot.business.studyMng.service.CourseService;
import com.hz.springboot.business.systemMng.base.pojo.YearTermPO;
import com.hz.springboot.business.systemMng.service.YearTermService;
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
 * 成绩管理controller
 * @author huangzhuo
 *
 * @version 创建时间： 2017-4-9 下午5:24:11
 */
@Controller
@RequestMapping("/studentScore")
public class StudentScoreManagementController extends BaseController {
	
 
	
	@Autowired
	public CourseService courseService;
	
	@Autowired
	public StudentService studentService;
	
	@Autowired
	public StudentScoreService studentScoreService;
	
	@Autowired
	public YearTermService yearTermService;
	
	@Autowired
	public ClassService classService;
	
	
 
	/**
	 * 跳转到学生成绩列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model  ) throws IOException{
		model.addAttribute("user", user);
    	List<CoursePO> courses = courseService.selectCourseList(null);
    	List<YearTermPO>  years = yearTermService.yearTermListByUserId(null);
    	List<ClassPO> classes = classService.listAllClass();
    	model.addAttribute("courses", courses);
    	model.addAttribute("years", years);
    	model.addAttribute("classes", classes);
		return  "studentScore/jsp/index" ;
	}
	
	/**
	 * 异步加载学生单科成绩列表
	 * @param search
	 * @param request
	 * @return
	 */
    @RequestMapping("listStudentScores")
    @ResponseBody
    public Map<String,Object> listStudentScores(@ModelAttribute("search") SearchParam search  , HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
        
        Map<String, Object> map = new HashMap<String ,Object>();
        if ("3".equals(user.getType())) {  
        	StudentPO student = studentService.getStudentById(user.getUserName());
        	map.put("studentId", student.getStudentKey());
        }
        
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
        Page<StudentCourseScore> list = (Page<StudentCourseScore>) studentScoreService.list(map);
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
     * 跳转到学生单科成绩新增页面
     * @param request
     * @param response
     * @param model
     * @param type
     * @return
     * @throws IOException
     */
    @RequestMapping("/toCreateStudentScore")
	public String toCreateStudentScore(HttpServletRequest request ,HttpServletResponse response,Model model,Integer type) throws IOException{
    	List<CoursePO> courses = courseService.selectCourseList(null);
    	List<YearTermPO>  years = yearTermService.yearTermListByUserId(null);
    	model.addAttribute("courses", courses);
    	model.addAttribute("years", years);
    	return  "studentScore/jsp/createStudentScore" ;
	}
    
 
    
    /**
     * 新增学生单科成绩
     * @param classCommittee
     * @param request
     * @return
     */
    @RequestMapping("insertStudentScore")
    @ResponseBody
    public JsonResult insertStudentScore(StudentCourseScore studentCourseScore, HttpServletRequest request) {
    	if(studentCourseScore.getScore() > 100 || studentCourseScore.getScore() < 0){
    		 return JsonResult.failure("分数只能是0-100的整数");
    	}
    	StudentPO  student = studentService.getStudentById(studentCourseScore.getStudentId());
    	studentCourseScore.setClassId(student.getClassKey());
    	studentScoreService.insert(studentCourseScore);
        return JsonResult.success("新增成功", studentCourseScore);
    }
    
    /**
     * 删除学生单科成绩
     * @param keyArr
     * @param request
     * @return
     */
    @RequestMapping("deleteStudentScore")
    @ResponseBody
    public JsonResult deleteStudentScore(Integer[] keyArr, HttpServletRequest request) {
    	String ids = StringUtils.join(keyArr, ",");
    	studentScoreService.delete(ids);
        return JsonResult.success(true);
    }
	
     
}
