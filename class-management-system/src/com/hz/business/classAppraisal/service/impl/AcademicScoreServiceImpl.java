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
import com.hz.business.classAppraisal.base.dao.StuScoreMapper;
import com.hz.business.classAppraisal.base.dao.StudentCourseScoreMapper;
import com.hz.business.classAppraisal.base.pojo.ClassCommittee;
import com.hz.business.classAppraisal.base.pojo.ClassCommitteeExample;
import com.hz.business.classAppraisal.base.pojo.ClassCommitteeExample.Criteria;
import com.hz.business.classAppraisal.base.pojo.PrizeApply;
import com.hz.business.classAppraisal.base.pojo.PrizeApplyExample;
import com.hz.business.classAppraisal.base.pojo.StuScore;
import com.hz.business.classAppraisal.base.pojo.StuScoreExample;
import com.hz.business.classAppraisal.base.pojo.StudentCourseScore;
import com.hz.business.classAppraisal.base.pojo.StudentCourseScoreExample;
import com.hz.business.classAppraisal.service.AcademicScoreService;
import com.hz.business.classAppraisal.service.ClassCommitteeService;
import com.hz.business.classAppraisal.service.PrizeApplyService;
import com.hz.business.classAppraisal.service.StudentScoreService;

 
@Service
@Transactional
public class AcademicScoreServiceImpl implements AcademicScoreService{
    @Autowired
    private StuScoreMapper stuScoreMapper;

    
    @Autowired
    private ClassCourseMapper classCourseMapper;


	@Override
	public StuScore insert(StuScore record) {
		record.setCreateTime(new Date());
		stuScoreMapper.insert(record);
		return record;
	}


	@Override
	public boolean delete(String ids) {
 
		return true;
	}


	@Override
	public List<StuScore> listByYearIdOrderByAcademicDesc(String yearId) {
		StuScoreExample example = new StuScoreExample();
		if (StringUtils.isNotBlank(yearId)) {
			example.createCriteria().andYearIdEqualTo(yearId);
		}
		example.setOrderByClause("academic_score desc");
		return stuScoreMapper.selectByExample(example);
	}


	@Override
	public StuScore update(StuScore record) {
		stuScoreMapper.updateByPrimaryKeySelective(record);
		return record;
	}


	@Override
	public StuScore getByYearIdAndPersonId(String yearId, String personId) {
		StuScoreExample example = new StuScoreExample();
		example.createCriteria().andYearIdEqualTo(yearId).andPersonIdEqualTo(personId);
		example.setOrderByClause("academic_score desc");
		List<StuScore>  list = stuScoreMapper.selectByExample(example);
		return (list != null && list.size() > 0) ? list.get(0) : new StuScore() ;
	}


	@Override
	public StuScore getById(Integer id) {
		return stuScoreMapper.selectByPrimaryKey(id);
	}


	@Override
	public List<StuScore> listStuScore(Map<String, Object> map) {
		return stuScoreMapper.listStuScore(map);
	}
 
	
	

    
}
