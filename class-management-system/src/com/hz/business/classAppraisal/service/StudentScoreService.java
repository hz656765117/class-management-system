package com.hz.business.classAppraisal.service;

import java.util.List;
import java.util.Map;

import com.hz.business.classAppraisal.base.pojo.ClassCommittee;
import com.hz.business.classAppraisal.base.pojo.PrizeApply;
import com.hz.business.classAppraisal.base.pojo.StudentCourseScore;

 
public interface StudentScoreService {
	 
	StudentCourseScore insert(StudentCourseScore record);
	
	boolean delete(String ids);
	
	List<StudentCourseScore> list(Map<String , Object> map );
	
	 
}
