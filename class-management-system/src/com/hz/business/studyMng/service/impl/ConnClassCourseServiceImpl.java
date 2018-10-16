package com.hz.business.studyMng.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.base.utils.common.BoxConvertUtils;
import com.hz.business.studyMng.base.dao.ConnClassCoursePOMapper;
import com.hz.business.studyMng.base.pojo.ConnClassCoursePO;
import com.hz.business.studyMng.base.pojo.ConnClassCoursePOExample;
import com.hz.business.studyMng.base.pojo.CoursePO;
import com.hz.business.studyMng.base.pojo.CoursePOExample;
import com.hz.business.studyMng.service.ConnClassCourseService;

@Service
@Transactional
public class ConnClassCourseServiceImpl implements ConnClassCourseService {

	 @Autowired
	 private ConnClassCoursePOMapper mapper;

	@Override
	public List<ConnClassCoursePO> selectListByClassKey(String classkey) {
		return mapper.selectByClassKey(classkey);
	}

	@Override
	public ConnClassCoursePO insertCourse(ConnClassCoursePO po) {
		po.setDeleteFlag(0);
		po.setCreateTime(new Date());
		mapper.insertSelective(po);
		return po;
	}

	@Override
	public List<ConnClassCoursePO> selectClassCourseList(Map<String,Object> map) {
		List<ConnClassCoursePO>  list = mapper.selectListByKey(map);
		return list;
	}

	@Override
	public boolean delClassCourse(String ids) {
		if ( StringUtils.isBlank(ids) ) {
			return false ;
		}
		List<Integer> list = BoxConvertUtils.convert(ids, ",", Integer.class);
		
		ConnClassCoursePOExample example = new ConnClassCoursePOExample();
		example.createCriteria().andDeleteFlagEqualTo(0).andIdIn(list);
		ConnClassCoursePO record = new ConnClassCoursePO();
		record.setDeleteFlag(1);
		mapper.updateByExampleSelective(record, example);
		return true;
	}

}
