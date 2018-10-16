package com.hz.business.studyMng.service;

import java.util.List;

import com.hz.business.classActivity.base.pojo.ClassActivity;
import com.hz.business.studyMng.base.pojo.CoursePO;

 
public interface CourseService {
	 
	CoursePO insertCourse(CoursePO po);
	 
	List<CoursePO> selectCourseList(String content);
	
	boolean delCourse(String ids);
	
	boolean updateCourse(CoursePO po);
	
	CoursePO getCourseById(Integer id);
	
	 
}
