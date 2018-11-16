package com.hz.springboot.business.studyMng.service;

import com.hz.springboot.business.studyMng.base.pojo.EvaluatePO;

import java.util.List;
import java.util.Map;



 
public interface EvaluateService {
	 
	List<EvaluatePO> selectListByUserId(String bookName);
	
	EvaluatePO getEvaluateById(String id);

	void insertEvaluatePO(Map<String, Object> map);

	void deleteInfoById(String ids);

	List<EvaluatePO> selectStuEvalList(String content, String studentKey);

	List<EvaluatePO> selectTeaEvalList(String content);
}
