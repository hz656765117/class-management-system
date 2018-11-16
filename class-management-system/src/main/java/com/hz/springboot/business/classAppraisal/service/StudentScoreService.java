package com.hz.springboot.business.classAppraisal.service;

import com.hz.springboot.business.classAppraisal.base.pojo.StudentCourseScore;

import java.util.List;
import java.util.Map;


 
public interface StudentScoreService {
	 
	StudentCourseScore insert(StudentCourseScore record);
	
	boolean delete(String ids);
	
	List<StudentCourseScore> list(Map<String, Object> map);
	
	 
}
