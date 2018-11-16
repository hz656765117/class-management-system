package com.hz.springboot.business.systemMng.service;

import com.hz.springboot.business.systemMng.base.pojo.YearTermPO;

import java.util.List;




 
public interface YearTermService {
	 
	void insertYearTerm();
	 
	List<YearTermPO> yearTermListByUserId(String userId);
	
	void setCurrentYear(String yearTermKey);
	
	YearTermPO getYearTermById();
	 
}
