package com.hz.business.studyMng.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.hz.business.basicDataMng.base.pojo.ClassPO;
import com.hz.business.basicDataMng.base.pojo.MajorPO;
import com.hz.business.basicDataMng.base.pojo.StudentPO;
import com.hz.business.basicDataMng.base.pojo.TeacherPO;
import com.hz.business.basicDataMng.service.ClassAcademyService;
import com.hz.business.basicDataMng.service.ClassMajorService;
import com.hz.business.basicDataMng.service.ClassService;
import com.hz.business.basicDataMng.service.StudentService;
import com.hz.business.basicDataMng.service.TeacherService;
import com.hz.business.studyMng.base.pojo.ConnClassCoursePO;
import com.hz.business.studyMng.base.pojo.SchedulePO;
import com.hz.business.studyMng.service.ConnClassCourseService;
import com.hz.business.studyMng.service.ScheduleService;


@Controller
@RequestMapping("/studyMng/schedule")
public class ScheduleController extends BaseController{
	
	@Autowired
	public ClassAcademyService classAcademyService;
	@Autowired
	public ScheduleService scheduleService;
	@Autowired
	public ClassService classService;
	@Autowired
	public ConnClassCourseService connClassCourseService;
	@Autowired
	public TeacherService teacherService;
	@Autowired
	public StudentService studentService;
	
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		
		List<AcademyPO> list=classAcademyService.academyListByUserId(null);
		model.addAttribute("academyList", list);
		return  "studyMng/schedule/jsp/index" ;
	}
	
	
	@RequestMapping("/setClassCourse")
	public String setClassCourse(String classKey,String type,HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		ClassPO clsssPO = classService.getClassById(classKey);
		//查询这个专班级的课表
		List<SchedulePO> schedulePOList=scheduleService.selectListByClassKey(classKey);
		Map<String,Object> scheduleMap=new HashMap<String,Object>();
		for (SchedulePO po : schedulePOList) {
			scheduleMap.put(po.getWeekSeq()+"-"+po.getOrderSeq(), po);
		}
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Map<String,Object> tempMap=new HashMap<String,Object>();
		for (int i = 1; i <= 9; i++) {
			tempMap=new HashMap<String,Object>();
			for (int j = 1; j <= 7; j++) {
				tempMap.put(j+"", scheduleMap.get(j+"-"+i));
			}
			list.add(tempMap);
		}
		model.addAttribute("scheduleList", list);
		model.addAttribute("clsssPO", clsssPO);
		model.addAttribute("type", type);
		return  "studyMng/schedule/jsp/setClassCourse" ;
	}
	
	@RequestMapping("/searchStuSchedule")
	public String searchStuSchedule(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		String studentKey=User.getUserKey(request);
		String userType=User.getUserType(request);
		if(!"3".equals(userType)){//如果不是学生就跳转到课程设计界面
			return "studyMng/schedule/jsp/index";
		}
		StudentPO stuPO = studentService.getStudentById(studentKey);
		ClassPO clsssPO = classService.getClassById(stuPO.getClassKey());
		//查询这个专班级的课表
		List<SchedulePO> schedulePOList=scheduleService.selectListByClassKey(stuPO.getClassKey());
		Map<String,Object> scheduleMap=new HashMap<String,Object>();
		for (SchedulePO po : schedulePOList) {
			scheduleMap.put(po.getWeekSeq()+"-"+po.getOrderSeq(), po);
		}
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Map<String,Object> tempMap=new HashMap<String,Object>();
		for (int i = 1; i <= 9; i++) {
			tempMap=new HashMap<String,Object>();
			for (int j = 1; j <= 7; j++) {
				tempMap.put(j+"", scheduleMap.get(j+"-"+i));
			}
			list.add(tempMap);
		}
		model.addAttribute("scheduleList", list);
		model.addAttribute("clsssPO", clsssPO);
		model.addAttribute("type", "2");
		return  "studyMng/schedule/jsp/setClassCourse" ;
	}
	
	@RequestMapping("/addClassCourse")
	public String addClassCourse(String classKey,Integer weekSeq,Integer orderSeq,HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		//1、查询这个班级关联的所有的课程信息
		List<ConnClassCoursePO> courseList = connClassCourseService.selectListByClassKey(classKey);
		//2、查询教师信息
		List<TeacherPO> teacherList = teacherService.teacherListByUserId(null);
		//3、查询这个节次课程的信息
		SchedulePO schedulePO=scheduleService.selectPOByClassKeyAndWO(classKey,weekSeq,orderSeq);
		model.addAttribute("courseList", courseList);
		model.addAttribute("teacherList", teacherList);
		model.addAttribute("schedulePO", schedulePO);
		model.addAttribute("weekSeq", weekSeq);
		model.addAttribute("orderSeq", orderSeq);
		model.addAttribute("classKey", classKey);
		return  "studyMng/schedule/jsp/addClassCourse" ;
	}
   
	 /**
     * 插入信息
     * @param activity
     * @param request
     * @return
     */
    @RequestMapping("/insertSchedule")
    @ResponseBody
    public JsonResult insertSchedule(SchedulePO po, HttpServletRequest request) {
    	scheduleService.insertSchedulee(po);
        return JsonResult.success("课程设置成功", po);
    }
    
    /**
     * 保存修改信息
     * @param activity
     * @param request
     * @return
     */
    @RequestMapping("updateSchedule")
    @ResponseBody
    public JsonResult updateSchedule(SchedulePO po, HttpServletRequest request) {
    	scheduleService.updateSchedule(po);
        return JsonResult.success("课程设置成功", po);
    }
}
