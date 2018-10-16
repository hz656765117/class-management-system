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
import com.hz.business.classAppraisal.base.dao.ClassCourseMapper;
import com.hz.business.classAppraisal.base.dao.PrizeApplyMapper;
import com.hz.business.classAppraisal.base.pojo.ClassCommittee;
import com.hz.business.classAppraisal.base.pojo.ClassCommitteeExample;
import com.hz.business.classAppraisal.base.pojo.ClassCommitteeExample.Criteria;
import com.hz.business.classAppraisal.base.pojo.ClassCourse;
import com.hz.business.classAppraisal.base.pojo.ClassCourseExample;
import com.hz.business.classAppraisal.base.pojo.PrizeApply;
import com.hz.business.classAppraisal.base.pojo.PrizeApplyExample;
import com.hz.business.classAppraisal.service.ClassCommitteeService;
import com.hz.business.classAppraisal.service.ClassCourseService;
import com.hz.business.classAppraisal.service.PrizeApplyService;

 
@Service
@Transactional
public class ClassCourseServiceImpl implements ClassCourseService{
    @Autowired
    private ClassCourseMapper classCourseMapper;

	@Override
	public ClassCourse insertPrizeApply(ClassCourse record) {
		record.setCreateTime(new Date());
		classCourseMapper.insertSelective(record);
		return record;
	}

	@Override
	public List<ClassCourse> prizeApplyListByAuditId(String auditId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delClassCourse(String ids) {
		if ( StringUtils.isBlank(ids) ) {
			return false ;
		}
		List<Integer> list = BoxConvertUtils.convert(ids, ",", Integer.class);
		ClassCourseExample example = new ClassCourseExample();
		example.createCriteria().andIdIn(list);
		ClassCourse record = new ClassCourse();
		record.setDeleteFlag(1);
		classCourseMapper.updateByExampleSelective(record, example);
		return true;
	}

	@Override
	public List<ClassCourse> listClassCourse(Map<String, Object> map) {
		 return classCourseMapper.listStudentCourse(map);
	}

 
 

	  
 
	 

	
	

    
}
