package com.hz.business.classAppraisal.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.base.utils.common.BoxConvertUtils;
import com.hz.business.classActivity.base.dao.ClassActivityMapper;
import com.hz.business.classActivity.base.pojo.ClassActivity;
import com.hz.business.classActivity.base.pojo.ClassActivityExample;
import com.hz.business.classActivity.service.ClassActivityService;
import com.hz.business.classAppraisal.base.dao.ClassCommitteeMapper;
import com.hz.business.classAppraisal.base.dao.PrizeApplyMapper;
import com.hz.business.classAppraisal.base.pojo.ClassCommittee;
import com.hz.business.classAppraisal.base.pojo.ClassCommitteeExample;
import com.hz.business.classAppraisal.base.pojo.ClassCommitteeExample.Criteria;
import com.hz.business.classAppraisal.base.pojo.PrizeApply;
import com.hz.business.classAppraisal.base.pojo.PrizeApplyExample;
import com.hz.business.classAppraisal.service.ClassCommitteeService;
import com.hz.business.classAppraisal.service.PrizeApplyService;

 
@Service
@Transactional
public class ClassCommitteeServiceImpl implements ClassCommitteeService{
    @Autowired
    private ClassCommitteeMapper classCommitteeMapper;

 

	@Override
	public boolean delClassCommittee(String ids) {
		if ( StringUtils.isBlank(ids) ) {
			return false ;
		}
		List<Integer> list = BoxConvertUtils.convert(ids, ",", Integer.class);
		ClassCommitteeExample example = new ClassCommitteeExample();
		example.createCriteria().andIdIn(list);
		ClassCommittee record = new ClassCommittee();
		record.setDeleteFlag(1);
		classCommitteeMapper.updateByExampleSelective(record, example);
		return true;
	}

	  

 

	@Override
	public ClassCommittee insertClassCommittee(ClassCommittee record) {
		record.setCreateTime(new Date());
		record.setDeleteFlag(0);
		classCommitteeMapper.insert(record);
		return record;
	}

	@Override
	public List<ClassCommittee> classCommitteeListByClassId(String classId) {
		ClassCommitteeExample example = new ClassCommitteeExample();
		Criteria  criteria = example.createCriteria();
		if ( StringUtils.isNotBlank(classId)) {
			criteria.andClassKeyEqualTo(classId);
		}
		criteria.andDeleteFlagEqualTo(0);
		return classCommitteeMapper.selectByExample(example);
	}





	@Override
	public List<ClassCommittee> listClassCommittee(Map<String, Object> map) {
		return classCommitteeMapper.listClassCommittee(map);
	}

	 

	
	

    
}
