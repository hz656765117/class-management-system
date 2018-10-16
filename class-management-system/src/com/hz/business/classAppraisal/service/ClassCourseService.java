package com.hz.business.classAppraisal.service;

import java.util.List;
import java.util.Map;

import com.hz.business.classAppraisal.base.pojo.ClassCourse;
import com.hz.business.classAppraisal.base.pojo.PrizeApply;

 
public interface ClassCourseService {
	 
	ClassCourse insertPrizeApply(ClassCourse record);
	 
	List<ClassCourse> prizeApplyListByAuditId(String auditId );
	
	boolean delClassCourse(String ids);
	
	List<ClassCourse> listClassCourse(Map<String , Object> map );
	
	 
}
