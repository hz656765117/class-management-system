package com.hz.springboot.business.basicDataMng.service;

import com.hz.springboot.business.basicDataMng.base.pojo.ClassPO;

import java.util.List;




 
public interface ClassService {
	 
	ClassPO insertClass(ClassPO classPO);
	 
	List<ClassPO> classListByUserId(String className);
	
	boolean delClassInfo(String ids);
	
	boolean updateClassInfo(ClassPO classPO);
	
	ClassPO getClassById(String classKey);

	List<ClassPO> classListByMajorKey(String majorKey);
	
	/**
	 * 查询所有的班级
	 * @return
	 */
	List<ClassPO> listAllClass();

	List<ClassPO> selectClassMoneyList(String content);
}
