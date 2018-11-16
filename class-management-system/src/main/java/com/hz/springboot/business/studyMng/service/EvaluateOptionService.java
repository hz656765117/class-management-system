package com.hz.springboot.business.studyMng.service;

import com.hz.springboot.business.studyMng.base.pojo.EvaluateOptionPO;

import java.util.List;
import java.util.Map;



 
public interface EvaluateOptionService {
	 
	List<EvaluateOptionPO> selectListByUserId(String evaluteKey);

	void insertEvaluateOptionsPO(List<Map<String, Object>> list);

	List<EvaluateOptionPO> selectStuOptionAndScore(String evaluateKey, String studentKey, String teacherKey);
	
}
