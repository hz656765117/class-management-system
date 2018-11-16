package com.hz.springboot.business.basicDataMng.service;

import com.hz.springboot.business.basicDataMng.base.pojo.TeacherPO;

import java.util.List;


 
public interface TeacherService {
	 
	TeacherPO insertTeacher(TeacherPO po);
	 
	List<TeacherPO> teacherListByUserId(String teacherKey);
	
	boolean delClassTeacher(String ids);
	
	boolean updateClassTeacher(TeacherPO po);
	
	TeacherPO getTeacherById(String id);
	
	List<TeacherPO> listAllTeacher();
	 
}
