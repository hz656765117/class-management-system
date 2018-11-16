package com.hz.springboot.business.studyMng.service;

import com.hz.springboot.business.studyMng.base.pojo.ConnClassCoursePO;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Map;



@Primary
public interface ConnClassCourseService {
	List<ConnClassCoursePO> selectListByClassKey(String classkey);
	
	ConnClassCoursePO insertCourse(ConnClassCoursePO po);
	 
	List<ConnClassCoursePO> selectClassCourseList(Map<String, Object> map);
	
	boolean delClassCourse(String ids);
}
