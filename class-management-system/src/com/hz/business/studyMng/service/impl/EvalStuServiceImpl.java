package com.hz.business.studyMng.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.business.studyMng.base.dao.EvalStuPOMapper;
import com.hz.business.studyMng.base.pojo.EvalStuPO;
import com.hz.business.studyMng.service.EvalStuService;

 
@Service
@Transactional
public class EvalStuServiceImpl implements EvalStuService{
    @Autowired
    private EvalStuPOMapper evalStuPOMapper;

	@Override
	public void insertEvaluatePO(Map<String, Object> map, String evalStuKey) {
		EvalStuPO po=new EvalStuPO();
		po.setEvalStuKey(evalStuKey);
		po.setEvaluateKey((String)map.get("evaluateKey"));
		po.setStudentKey((String)map.get("studentKey"));
		po.setTeacherKey((String)map.get("teacherKey"));
		po.setTotalScore(Integer.parseInt(""+map.get("totalScore")));
		evalStuPOMapper.insertSelective(po);
	}



}
