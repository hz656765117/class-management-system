package com.hz.springboot.business.basicDataMng.service;

import com.hz.springboot.business.basicDataMng.base.pojo.MajorPO;

import java.util.List;



 
public interface ClassMajorService {
	 
	MajorPO insertMajor(MajorPO activity);
	 
	List<MajorPO> majorListByUserId(String najorName);
	
	boolean delClassMajor(String ids);
	
	boolean updateClassMajor(MajorPO classMajor);
	
	MajorPO getMajorById(String majorKey);

	List<MajorPO> majorListByAcademyKey(String academyKey);
	
	 
}
