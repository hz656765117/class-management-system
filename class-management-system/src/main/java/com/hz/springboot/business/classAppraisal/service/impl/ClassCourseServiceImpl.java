package com.hz.springboot.business.classAppraisal.service.impl;

import com.hz.springboot.base.utils.common.BoxConvertUtils;
import com.hz.springboot.business.classAppraisal.base.dao.ClassCourseMapper;
import com.hz.springboot.business.classAppraisal.base.pojo.ClassCourse;
import com.hz.springboot.business.classAppraisal.base.pojo.ClassCourseExample;
import com.hz.springboot.business.classAppraisal.service.ClassCourseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;



 
@Service
@Transactional
public class ClassCourseServiceImpl implements ClassCourseService {
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
