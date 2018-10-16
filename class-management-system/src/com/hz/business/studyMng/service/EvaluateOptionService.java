package com.hz.business.studyMng.service;

import java.util.List;
import java.util.Map;

import com.hz.business.studyMng.base.pojo.EvaluateOptionPO;

 
public interface EvaluateOptionService {
	 
	List<EvaluateOptionPO> selectListByUserId(String evaluteKey);

	void insertEvaluateOptionsPO(List<Map<String, Object>> list);

	List<EvaluateOptionPO> selectStuOptionAndScore(String evaluateKey, String studentKey, String teacherKey);
	
}
