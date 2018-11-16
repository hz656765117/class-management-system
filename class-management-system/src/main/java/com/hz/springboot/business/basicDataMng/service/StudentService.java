package com.hz.springboot.business.basicDataMng.service;

import com.hz.springboot.business.basicDataMng.base.pojo.StudentPO;

import java.util.List;




 
public interface StudentService {
	 
	StudentPO insertClass(StudentPO po);
	 
	List<StudentPO> studentListByUserId(String className);
	
	boolean delStudentInfo(String ids);
	
	boolean updateStudentInfo(StudentPO po);
	
	StudentPO getStudentById(String studentKey);

	StudentPO getStudentByStuKey(String studentKey);
	
	/**
	 * 根据班级id查询该班级所有的学生
	 * @param classId
	 * @return
	 */
	List<StudentPO> studentListByClassId(String classId);
	
	List<StudentPO> ListAllstudent();
}
