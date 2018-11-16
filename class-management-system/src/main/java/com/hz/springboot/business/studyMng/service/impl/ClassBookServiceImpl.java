package com.hz.springboot.business.studyMng.service.impl;

import com.hz.springboot.base.utils.common.BoxConvertUtils;
import com.hz.springboot.business.studyMng.base.dao.ClassBookPOMapper;
import com.hz.springboot.business.studyMng.base.pojo.ClassBookPO;
import com.hz.springboot.business.studyMng.base.pojo.ClassBookPOExample;
import com.hz.springboot.business.studyMng.service.ClassBookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;



 
@Service
@Transactional
public class ClassBookServiceImpl implements ClassBookService {
    @Autowired
    private ClassBookPOMapper classBookPOMapper;

	@Override
	public ClassBookPO insertAcademy(ClassBookPO po) {
		po.setClassBookKey(UUID.randomUUID().toString());
		classBookPOMapper.insertSelective(po);
		return po;
	}

	@Override
	public List<ClassBookPO> selectListByUserId(String bookName) {
		ClassBookPOExample example = new ClassBookPOExample();
		//创建方法，添加搜索条件
//		example.createCriteria().andListLikeTo(bookName);
		List<ClassBookPO>  list = classBookPOMapper.selectByExample(example);
		return list;
	}

	@Override
	public boolean delClassClassBook(String ids) {
		if ( StringUtils.isBlank(ids) ) {
			return false ;
		}
		List<String> list = BoxConvertUtils.convert(ids, ",", String.class);
		for (String key : list) {
			classBookPOMapper.deleteByPrimaryKey(key);
		}
		return true;
	}

	@Override
	public boolean updateClassBook(ClassBookPO po) {
		classBookPOMapper.updateByPrimaryKeySelective(po);
		return true;
	}

	@Override
	public ClassBookPO getClassBookById(String id) {
		return classBookPOMapper.selectByPrimaryKey(id);
	}
}
