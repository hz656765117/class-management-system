package com.hz.springboot.business.classAppraisal.service;

import com.hz.springboot.business.classAppraisal.base.pojo.ClassCourse;

import java.util.List;
import java.util.Map;


 
public interface ClassCourseService {
	 
	ClassCourse insertPrizeApply(ClassCourse record);
	 
	List<ClassCourse> prizeApplyListByAuditId(String auditId);
	
	boolean delClassCourse(String ids);
	
	List<ClassCourse> listClassCourse(Map<String, Object> map);
	
	 
}
