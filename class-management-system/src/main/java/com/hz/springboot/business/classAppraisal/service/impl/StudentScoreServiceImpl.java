package com.hz.springboot.business.classAppraisal.service.impl;

import com.hz.springboot.base.utils.common.BoxConvertUtils;
import com.hz.springboot.business.classAppraisal.base.dao.ClassCourseMapper;
import com.hz.springboot.business.classAppraisal.base.dao.StudentCourseScoreMapper;
import com.hz.springboot.business.classAppraisal.base.pojo.StudentCourseScore;
import com.hz.springboot.business.classAppraisal.base.pojo.StudentCourseScoreExample;
import com.hz.springboot.business.classAppraisal.service.StudentScoreService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;



 
@Service
@Transactional
public class StudentScoreServiceImpl implements StudentScoreService {
    @Autowired
    private StudentCourseScoreMapper studentCourseScoreMapper;

    
    @Autowired
    private ClassCourseMapper classCourseMapper;


	@Override
	public StudentCourseScore insert(StudentCourseScore record) {
		record.setCreateTime(new Date());
		record.setDeleteFlag(0);
		studentCourseScoreMapper.insert(record);
		return record;
	}


	@Override
	public boolean delete(String ids) {
		if ( StringUtils.isBlank(ids) ) {
			return false ;
		}
		List<Integer> list = BoxConvertUtils.convert(ids, ",", Integer.class);
		StudentCourseScoreExample example = new StudentCourseScoreExample();
		example.createCriteria().andIdIn(list);
		StudentCourseScore record = new StudentCourseScore();
		record.setDeleteFlag(1);
		studentCourseScoreMapper.updateByExampleSelective(record, example);
		return true;
	}


	@Override
	public List<StudentCourseScore> list(Map<String, Object> map) {
		return studentCourseScoreMapper.listStudentCourseScore(map);
	}
 

//	@Override
//	public boolean delClassCommittee(String ids) {
//		if ( StringUtils.isBlank(ids) ) {
//			return false ;
//		}
//		List<Integer> list = BoxConvertUtils.convert(ids, ",", Integer.class);
//		ClassCommitteeExample example = new ClassCommitteeExample();
//		example.createCriteria().andIdIn(list);
//		ClassCommittee record = new ClassCommittee();
//		record.setDeleteFlag(1);
//		classCommitteeMapper.updateByExampleSelective(record, example);
//		return true;
//	}
//
//	  
//
// 
//
//	@Override
//	public ClassCommittee insertClassCommittee(ClassCommittee record) {
//		record.setCreateTime(new Date());
//		record.setDeleteFlag(0);
//		classCommitteeMapper.insert(record);
//		return record;
//	}
//
// 
//
//
//
//
//	@Override
//	public List<ClassCommittee> listClassCommittee(Map<String, Object> map) {
//		return classCommitteeMapper.listClassCommittee(map);
//	}

	 

	
	

    
}
