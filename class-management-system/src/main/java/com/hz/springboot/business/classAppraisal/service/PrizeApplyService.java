package com.hz.springboot.business.classAppraisal.service;

import com.hz.springboot.business.classAppraisal.base.pojo.PrizeApply;

import java.util.List;
import java.util.Map;



 
public interface PrizeApplyService {
	 
	PrizeApply insertPrizeApply(PrizeApply prizeApply);
	 
	List<PrizeApply> prizeApplyListByAuditId(String auditId);
	
	boolean delPrizeApply(String ids);
	
	boolean updatePrizeApply(PrizeApply prizeApply);
	
	PrizeApply getPrizeApplyById(Integer id);
	
	List<PrizeApply> listApplyList(Map<String, Object> map);
	
	 
}
