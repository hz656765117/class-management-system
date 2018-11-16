package com.hz.springboot.business.classActivity.service.impl;

import com.hz.springboot.base.utils.common.BoxConvertUtils;
import com.hz.springboot.business.classActivity.base.dao.ClassActivityMapper;
import com.hz.springboot.business.classActivity.base.dao.ClassActivityStuMapper;
import com.hz.springboot.business.classActivity.base.pojo.ClassActivity;
import com.hz.springboot.business.classActivity.base.pojo.ClassActivityExample;
import com.hz.springboot.business.classActivity.service.ClassActivityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;



 
@Service
@Transactional
public class ClassActivityServiceImpl implements ClassActivityService {
    @Autowired
    private ClassActivityMapper classActivityMapper;
    @Autowired
    private ClassActivityStuMapper classActivityStuMapper;
	 

	@Override
	public ClassActivity insertActivity(ClassActivity activity) {
		activity.setDeleteFlag(0);
		activity.setCreateTime(new Date());
		classActivityMapper.insertSelective(activity);
		
//		List<String> personList = null;
//		if (  StringUtils.isNotBlank(activity.getPersons())) {
//			personList = BoxConvertUtils.convert(activity.getPersons(), ",", String.class);
//			
//			for ( String person : personList) {
//				ClassActivityStu stu = new ClassActivityStu();
//				stu.setActivityKey(activity.getActivityKey()+"");
//				stu.setCreateTime(new Date());
//				stu.setDeleteFlag(0);
//				stu.setStudentKey(person);
//				classActivityStuMapper.insertSelective(stu);
//			}
//			
//		}
		
		return activity;
	}

	@Override
	public List<ClassActivity> activityListByUserId(String userId) {
		ClassActivityExample example = new ClassActivityExample();
		ClassActivityExample.Criteria criteria = example.createCriteria();
		criteria.andDeleteFlagEqualTo(0);
		if (StringUtils.isNotBlank(userId)) {
			//criteria.andActivityKeyIn(values);
		}
		example.setOrderByClause("create_time desc");
		List<ClassActivity>  activitys = classActivityMapper.selectByExample(example);
		return activitys;
	}

	@Override
	public boolean delClassActivity(String ids) {
		if ( StringUtils.isBlank(ids) ) {
			return false ;
		}
		List<Integer> list = BoxConvertUtils.convert(ids, ",", Integer.class);
		
		ClassActivityExample example = new ClassActivityExample();
		example.createCriteria().andDeleteFlagEqualTo(0).andActivityKeyIn(list);
		
		ClassActivity record = new ClassActivity();
		record.setDeleteFlag(1);
		
		classActivityMapper.updateByExampleSelective(record, example);
		return true;
	}

	@Override
	public boolean updateClassActivity(ClassActivity classActivity) {
		classActivity.setUpdateTime(new Date());
		classActivityMapper.updateByPrimaryKeySelective(classActivity);
		return true;
	}

	@Override
	public ClassActivity getActivityById(Integer id) {
		return classActivityMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ClassActivity> listactivityList(Map<String, Object> map) {
		return classActivityMapper.listClassActivity(map);
	}
	
	
	
	

    
}
