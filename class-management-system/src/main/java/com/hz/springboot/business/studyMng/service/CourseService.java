package com.hz.springboot.business.studyMng.service;

import com.hz.springboot.business.studyMng.base.pojo.CoursePO;

import java.util.List;



 
public interface CourseService {
	 
	CoursePO insertCourse(CoursePO po);
	 
	List<CoursePO> selectCourseList(String content);
	
	boolean delCourse(String ids);
	
	boolean updateCourse(CoursePO po);
	
	CoursePO getCourseById(Integer id);
	
	 
}
