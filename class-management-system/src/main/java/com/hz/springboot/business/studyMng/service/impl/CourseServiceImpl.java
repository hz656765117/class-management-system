package com.hz.springboot.business.studyMng.service.impl;

import com.hz.springboot.base.utils.common.BoxConvertUtils;
import com.hz.springboot.business.studyMng.base.dao.CoursePOMapper;
import com.hz.springboot.business.studyMng.base.pojo.CoursePO;
import com.hz.springboot.business.studyMng.base.pojo.CoursePOExample;
import com.hz.springboot.business.studyMng.service.CourseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;



 
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CoursePOMapper mapper;

	@Override
	public CoursePO insertCourse(CoursePO po) {
		po.setDeleteFlag(0);
		po.setCreateTime(new Date());
		mapper.insertSelective(po);
		return po;
	}

	@Override
	public List<CoursePO> selectCourseList(String content) {
		CoursePOExample example = new CoursePOExample();
		example.createCriteria().andDeleteFlagEqualTo(0).andNameLike(content);
		example.setOrderByClause("create_time desc");
		List<CoursePO>  list = mapper.selectByExample(example);
		return list;
	}

	@Override
	public boolean delCourse(String ids) {
		if ( StringUtils.isBlank(ids) ) {
			return false ;
		}
		List<Integer> list = BoxConvertUtils.convert(ids, ",", Integer.class);
		
		CoursePOExample example = new CoursePOExample();
		example.createCriteria().andDeleteFlagEqualTo(0).andIdIn(list);
		CoursePO record = new CoursePO();
		record.setDeleteFlag(1);
		mapper.updateByExampleSelective(record, example);
		return true;
	}

	@Override
	public boolean updateCourse(CoursePO po) {
		mapper.updateByPrimaryKeySelective(po);
		return true;
	}

	@Override
	public CoursePO getCourseById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
	

    
}
