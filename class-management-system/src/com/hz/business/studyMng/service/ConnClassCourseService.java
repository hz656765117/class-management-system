package com.hz.business.studyMng.service;

import java.util.List;
import java.util.Map;

import com.hz.business.studyMng.base.pojo.ConnClassCoursePO;

 
public interface ConnClassCourseService {
	List<ConnClassCoursePO> selectListByClassKey(String classkey );
	
	ConnClassCoursePO insertCourse(ConnClassCoursePO po);
	 
	List<ConnClassCoursePO> selectClassCourseList(Map<String,Object> map);
	
	boolean delClassCourse(String ids);
}
