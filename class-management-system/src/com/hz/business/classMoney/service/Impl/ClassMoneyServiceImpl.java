package com.hz.business.classMoney.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.base.utils.common.BoxConvertUtils;
import com.hz.business.classMoney.base.dao.ClassMoneyMapper;
import com.hz.business.classMoney.base.pojo.ClassMoney;
import com.hz.business.classMoney.base.pojo.ClassMoneyExample;
import com.hz.business.classMoney.service.ClassMoneyService;

@Service
@Transactional
public class ClassMoneyServiceImpl implements ClassMoneyService {
	@Autowired
	private ClassMoneyMapper mapper;

	@Override
	public List<ClassMoney> classMoneyListByUserId(String content, String classKey) {
		ClassMoneyExample example = new ClassMoneyExample();
		//创建方法，添加搜索条件
		if(classKey!=null && !"".equals(classKey)){
			example.createCriteria().andClassKeyEqualTo(classKey);
		}else{
			example.createCriteria().andClassKeyIsNotNull();
		}
		List<ClassMoney>  activitys = mapper.selectListByExample(example);
		return activitys;
	}

	@Override
	public void insertClassMoney(ClassMoney po) {
		po.setClassMoneyKey(UUID.randomUUID().toString());
		po.setDatetime(new Date());
		mapper.insertSelective(po);
	}

	@Override
	public ClassMoney getClassMoneyById(String classMoneyKey) {
		return mapper.selectByPrimaryKey(classMoneyKey);
	}

	@Override
	public void updateClassMoney(ClassMoney po) {
		po.setDatetime(new Date());
		mapper.updateByPrimaryKeySelective(po);
	}

	@Override
	public boolean delClassMoney(String ids) {
		if ( StringUtils.isBlank(ids) ) {
			return false ;
		}
		List<String> list = BoxConvertUtils.convert(ids, ",", String.class);
		for (String key : list) {
			mapper.deleteByPrimaryKey(key);
		}
		return true;
		
	}
	
}
