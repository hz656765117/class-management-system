package com.hz.springboot.business.classAppraisal.service.impl;

import com.hz.springboot.base.utils.common.BoxConvertUtils;
import com.hz.springboot.business.classAppraisal.base.dao.ClassCommitteeMapper;
import com.hz.springboot.business.classAppraisal.base.pojo.ClassCommittee;
import com.hz.springboot.business.classAppraisal.base.pojo.ClassCommitteeExample;
import com.hz.springboot.business.classAppraisal.service.ClassCommitteeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;



 
@Service
@Transactional
public class ClassCommitteeServiceImpl implements ClassCommitteeService {
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
		ClassCommitteeExample.Criteria criteria = example.createCriteria();
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
