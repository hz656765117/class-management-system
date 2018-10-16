package com.hz.business.classAppraisal.service;

import java.util.List;
import java.util.Map;

import com.hz.business.classAppraisal.base.pojo.ClassCommittee;
import com.hz.business.classAppraisal.base.pojo.PrizeApply;

 
public interface ClassCommitteeService {
	 
	ClassCommittee insertClassCommittee(ClassCommittee record);
	 
	List<ClassCommittee> classCommitteeListByClassId(String classId );
	
	boolean delClassCommittee(String ids);
	
	
	List<ClassCommittee> listClassCommittee(Map<String , Object> map );
	
	 
}
