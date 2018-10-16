package com.hz.business.studyMng.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.business.studyMng.base.dao.EvaluateOptionPOMapper;
import com.hz.business.studyMng.base.pojo.EvaluateOptionPO;
import com.hz.business.studyMng.base.pojo.EvaluateOptionPOExample;
import com.hz.business.studyMng.service.EvaluateOptionService;

 
@Service
@Transactional
public class EvaluateOptionServiceImpl implements EvaluateOptionService{
    @Autowired
    private EvaluateOptionPOMapper evaluateOptionPOMapper;

    @Override
    public List<EvaluateOptionPO> selectListByUserId(String evaluteKey){
    	EvaluateOptionPOExample example = new EvaluateOptionPOExample();
    	example.createCriteria().andEvaluateKeyEqualTo(evaluteKey);
    	example.setOrderByClause("seq");
		List<EvaluateOptionPO>  list = evaluateOptionPOMapper.selectByExample(example);
    	return list;
    }

	@Override
	public void insertEvaluateOptionsPO(List<Map<String, Object>> list) {
		for (Map<String, Object> map : list) {
			EvaluateOptionPO po=new EvaluateOptionPO();
			po.setContent((String)map.get("content"));
			po.setEvaluateKey((String)map.get("evaluateKey"));
			po.setSeq(Integer.parseInt(""+map.get("seq")));
			if(map.get("optionKey")==null){
				evaluateOptionPOMapper.insertSelective(po);
			}else{
				po.setOptionKey(Integer.parseInt(""+map.get("optionKey")));
				EvaluateOptionPOExample example = new EvaluateOptionPOExample();
		    	example.createCriteria().andOptionKeyEqualTo(po.getOptionKey());
				evaluateOptionPOMapper.updateByExampleSelective(po, example);
			}
		}
	}

	@Override
	public List<EvaluateOptionPO> selectStuOptionAndScore(String evaluateKey, String studentKey, String teacherKey) {
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("studentKey", studentKey);
		params.put("teacherKey", teacherKey);
		params.put("evaluateKey", evaluateKey);
		return evaluateOptionPOMapper.selectOptionScoreList(params);
	}
}
