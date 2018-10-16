package com.hz.business.systemMng.service;

import java.util.List;

import com.hz.business.systemMng.base.pojo.YearTermPO;


 
public interface YearTermService {
	 
	void insertYearTerm();
	 
	List<YearTermPO> yearTermListByUserId(String userId );
	
	void setCurrentYear(String yearTermKey);
	
	YearTermPO getYearTermById();
	 
}
