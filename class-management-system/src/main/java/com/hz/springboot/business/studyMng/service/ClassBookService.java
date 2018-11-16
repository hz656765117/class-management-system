package com.hz.springboot.business.studyMng.service;

import com.hz.springboot.business.studyMng.base.pojo.ClassBookPO;

import java.util.List;



 
public interface ClassBookService {
	 
	ClassBookPO insertAcademy(ClassBookPO po);
	 
	List<ClassBookPO> selectListByUserId(String bookName);
	
	boolean delClassClassBook(String ids);
	
	boolean updateClassBook(ClassBookPO po);
	
	ClassBookPO getClassBookById(String id);
}
