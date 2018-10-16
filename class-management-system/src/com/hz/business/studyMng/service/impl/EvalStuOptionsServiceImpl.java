package com.hz.business.studyMng.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.business.studyMng.base.dao.EvalStuOptionPOMapper;
import com.hz.business.studyMng.base.dao.EvalStuPOMapper;
import com.hz.business.studyMng.base.pojo.EvalStuOptionPO;
import com.hz.business.studyMng.base.pojo.EvalStuPO;
import com.hz.business.studyMng.service.EvalStuOptionsService;
import com.hz.business.studyMng.service.EvalStuService;

 
@Service
@Transactional
public class EvalStuOptionsServiceImpl implements EvalStuOptionsService{
    @Autowired
    private EvalStuOptionPOMapper evalStuOptionPOMapper;

	@Override
	public void insertEvalStuOptionsPO(List<Map<String, Object>> list, String evalStuKey) {
		for (Map<String, Object> map : list) {
			EvalStuOptionPO po=new EvalStuOptionPO();
			po.setEvalStuKey(evalStuKey);
			po.setOptionKey((String)map.get("optionKey"));
			po.setScore(Integer.parseInt(""+map.get("score")));
			evalStuOptionPOMapper.insertSelective(po);
		}
	}

	



}
