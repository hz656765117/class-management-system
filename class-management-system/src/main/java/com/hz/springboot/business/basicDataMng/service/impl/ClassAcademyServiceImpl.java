package com.hz.springboot.business.basicDataMng.service.impl;

import com.hz.springboot.base.utils.common.BoxConvertUtils;
import com.hz.springboot.business.basicDataMng.base.dao.AcademyPOMapper;
import com.hz.springboot.business.basicDataMng.base.pojo.AcademyPO;
import com.hz.springboot.business.basicDataMng.base.pojo.AcademyPOExample;
import com.hz.springboot.business.basicDataMng.service.ClassAcademyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;



 
@Service
@Transactional
public class ClassAcademyServiceImpl implements ClassAcademyService {
    @Autowired
    private AcademyPOMapper academyPOMapper;

	 

	@Override
	public AcademyPO insertAcademy(AcademyPO activity) {
		activity.setCreateDate(new Date());
		academyPOMapper.insertSelective(activity);
		return activity;
	}

	@Override
	public List<AcademyPO> academyListByUserId(String academyName) {
		AcademyPOExample example = new AcademyPOExample();
		//创建方法，添加搜索条件
		example.createCriteria().andListLikeTo(academyName);
		List<AcademyPO>  activitys = academyPOMapper.selectByExample(example);
		return activitys;
	}

	@Override
	public boolean delClassAcademy(String ids) {
		if ( StringUtils.isBlank(ids) ) {
			return false ;
		}
		List<String> list = BoxConvertUtils.convert(ids, ",", String.class);
		for (String key : list) {
			academyPOMapper.deleteByPrimaryKey(key);
		}
		return true;
	}

	@Override
	public boolean updateClassAcademy(AcademyPO classActivity) {
		classActivity.setCreateDate(new Date());
		academyPOMapper.updateByPrimaryKeySelective(classActivity);
		return true;
	}

	@Override
	public AcademyPO getAcademyById(String id) {
		return academyPOMapper.selectByPrimaryKey(id);
	}
	
	

    
}
