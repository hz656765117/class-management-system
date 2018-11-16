package com.hz.springboot.business.classAppraisal.service;

import com.hz.springboot.business.classAppraisal.base.pojo.StuScore;

import java.util.List;
import java.util.Map;



 
public interface AcademicScoreService {
	 
	StuScore insert(StuScore record);
	
	StuScore update(StuScore record);
	
	boolean delete(String ids);
	
	List<StuScore> listByYearIdOrderByAcademicDesc(String yearId);
	
	StuScore getByYearIdAndPersonId(String yearId, String personId);
	
	StuScore getById(Integer id); 
	
	List<StuScore> listStuScore(Map<String, Object> map);
}
