package com.hz.business.studyMng.service;

import java.util.List;
import java.util.Map;

import com.box.base.page.Page;
import com.hz.business.studyMng.base.pojo.EvaluatePO;

 
public interface EvaluateService {
	 
	List<EvaluatePO> selectListByUserId(String bookName );
	
	EvaluatePO getEvaluateById(String id);

	void insertEvaluatePO(Map<String, Object> map);

	void deleteInfoById(String ids);

	List<EvaluatePO> selectStuEvalList(String content, String studentKey);

	List<EvaluatePO> selectTeaEvalList(String content);
}
