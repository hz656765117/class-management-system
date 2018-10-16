package com.hz.business.studyMng.service;

import java.util.List;

import com.hz.business.basicDataMng.base.pojo.AcademyPO;
import com.hz.business.studyMng.base.pojo.ClassBookPO;

 
public interface ClassBookService {
	 
	ClassBookPO insertAcademy(ClassBookPO po);
	 
	List<ClassBookPO> selectListByUserId(String bookName );
	
	boolean delClassClassBook(String ids);
	
	boolean updateClassBook(ClassBookPO po);
	
	ClassBookPO getClassBookById(String id);
}
