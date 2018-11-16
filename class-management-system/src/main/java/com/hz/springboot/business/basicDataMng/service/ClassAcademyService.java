package com.hz.springboot.business.basicDataMng.service;

import com.hz.springboot.business.basicDataMng.base.pojo.AcademyPO;

import java.util.List;


 
public interface ClassAcademyService {
	 
	AcademyPO insertAcademy(AcademyPO activity);
	 
	List<AcademyPO> academyListByUserId(String userId);
	
	boolean delClassAcademy(String ids);
	
	boolean updateClassAcademy(AcademyPO classActivity);
	
	AcademyPO getAcademyById(String id);
	
	 
}
