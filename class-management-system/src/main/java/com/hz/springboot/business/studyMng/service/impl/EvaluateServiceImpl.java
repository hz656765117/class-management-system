package com.hz.springboot.business.studyMng.service.impl;

import com.hz.springboot.base.utils.common.BoxConvertUtils;
import com.hz.springboot.business.studyMng.base.dao.EvaluatePOMapper;
import com.hz.springboot.business.studyMng.base.pojo.EvaluatePO;
import com.hz.springboot.business.studyMng.base.pojo.EvaluatePOExample;
import com.hz.springboot.business.studyMng.service.EvaluateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



 
@Service
@Transactional
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluatePOMapper evaluatePOMapper;


	@Override
	public List<EvaluatePO> selectListByUserId(String bookName) {
		EvaluatePOExample example = new EvaluatePOExample();
		List<EvaluatePO>  list = evaluatePOMapper.selectByExample(example);
		return list;
	}

	@Override
	public EvaluatePO getEvaluateById(String id) {
		if(id==null){
			return null;
		}
		EvaluatePOExample example = new EvaluatePOExample();
		example.createCriteria().andEvaluateKeyEqualTo(id);
		List<EvaluatePO> list = evaluatePOMapper.selectByExample(example);
		if(list==null || list.size()<=0){
			return null;
		}
		return list.get(0);
	}

	/**
	 * 插入信息
	 */
	@Override
	public void insertEvaluatePO(Map<String, Object> map) {
		EvaluatePO po=new EvaluatePO();
		po.setEvaluateKey((String)map.get("evaluateKey"));
		po.setStatus(Integer.parseInt(""+map.get("status")));
		po.setTitle((String)map.get("title"));
		po.setYearTermKey((String)map.get("yearTermKey"));
		//如果存在就修改，否则就删除
		EvaluatePOExample example = new EvaluatePOExample();
		example.createCriteria().andEvaluateKeyEqualTo(po.getEvaluateKey());
		List<EvaluatePO> list = evaluatePOMapper.selectByExample(example);
		if(list==null || list.size()<=0){
			evaluatePOMapper.insertSelective(po);
		}else{
			evaluatePOMapper.updateByExampleSelective(po, example);
		}
	}

	@Override
	public void deleteInfoById(String ids) {
		if ( StringUtils.isBlank(ids) ) {
			return ;
		}
		List<String> list = BoxConvertUtils.convert(ids, ",", String.class);
		for (String key : list) {
			EvaluatePOExample example = new EvaluatePOExample();
			example.createCriteria().andEvaluateKeyEqualTo(key);
			evaluatePOMapper.deleteByExample(example);
		}
	}

	@Override
	public List<EvaluatePO> selectStuEvalList(String content, String studentKey) {
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("content", content);
		params.put("studentKey", studentKey);
		return evaluatePOMapper.selectStuEvalList(params);
	}

	@Override
	public List<EvaluatePO> selectTeaEvalList(String content) {
		Map<String,Object> params=new HashMap<String, Object>();
		content=content==null?"":content;
		params.put("content", "%"+content+"%");
		return evaluatePOMapper.selectTeaEvalList(params);
	}

}
