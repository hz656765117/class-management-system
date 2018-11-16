package com.hz.springboot.business.classAppraisal.service;

import com.hz.springboot.business.classAppraisal.base.pojo.ClassCommittee;

import java.util.List;
import java.util.Map;



 
public interface ClassCommitteeService {
	 
	ClassCommittee insertClassCommittee(ClassCommittee record);
	 
	List<ClassCommittee> classCommitteeListByClassId(String classId);
	
	boolean delClassCommittee(String ids);
	
	
	List<ClassCommittee> listClassCommittee(Map<String, Object> map);
	
	 
}
