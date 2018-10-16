package com.hz.business.basicDataMng.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.base.utils.common.BoxConvertUtils;
import com.hz.business.basicDataMng.base.dao.StudentPOMapper;
import com.hz.business.basicDataMng.base.pojo.ClassPO;
import com.hz.business.basicDataMng.base.pojo.ClassPOExample;
import com.hz.business.basicDataMng.base.pojo.StudentPO;
import com.hz.business.basicDataMng.base.pojo.StudentPOExample;
import com.hz.business.basicDataMng.service.StudentService;


 
@Service
@Transactional
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentPOMapper studentPOMapper;

	@Override
	public StudentPO insertClass(StudentPO po) {
		studentPOMapper.insert(po);
		return po;
	}

	@Override
	public List<StudentPO> studentListByUserId(String className) {
		StudentPOExample example = new StudentPOExample();
		//创建方法，添加搜索条件
//		example.createCriteria().andClassKeyEqualTo(className);
		List<StudentPO>  list = studentPOMapper.selectByExample(example);
		return list;
	}

	@Override
	public boolean delStudentInfo(String ids) {
		if ( StringUtils.isBlank(ids) ) {
			return false ;
		}
		List<String> list = BoxConvertUtils.convert(ids, ",", String.class);
		for (String key : list) {
			studentPOMapper.deleteByPrimaryKey(key);
		}
		return true;
	}

	@Override
	public boolean updateStudentInfo(StudentPO po) {
		studentPOMapper.updateByPrimaryKeySelective(po);
		return true;
	}

	@Override
	public StudentPO getStudentById(String studentKey) {
		return studentPOMapper.selectByPrimaryKey(studentKey);
	}

	@Override
	public StudentPO getStudentByStuKey(String studentKey) {
		StudentPOExample example = new StudentPOExample();
		//创建方法，添加搜索条件
		example.createCriteria().andStuKeyEqualTo(studentKey);
		List<StudentPO>  list = studentPOMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return new StudentPO();
	}

	@Override
	public List<StudentPO> studentListByClassId(String classId) {
		StudentPOExample example = new StudentPOExample();
		example.createCriteria().andClassKeyEqualTo(classId);
		List<StudentPO>  list = studentPOMapper.selectByClassId(classId); 
		return list;
	}

	@Override
	public List<StudentPO> ListAllstudent() {
		StudentPOExample example = new StudentPOExample();
		//创建方法，添加搜索条件
//		example.createCriteria().andClassKeyEqualTo(className);
		List<StudentPO>  list = studentPOMapper.selectByExample(example);
		return list;
	}
	
	
}
