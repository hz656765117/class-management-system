package com.hz.business.classAppraisal.service;

import java.util.List;
import java.util.Map;

import com.hz.business.classAppraisal.base.pojo.PrizeApply;

 
public interface PrizeApplyService {
	 
	PrizeApply insertPrizeApply(PrizeApply prizeApply);
	 
	List<PrizeApply> prizeApplyListByAuditId(String auditId );
	
	boolean delPrizeApply(String ids);
	
	boolean updatePrizeApply(PrizeApply prizeApply);
	
	PrizeApply getPrizeApplyById(Integer id);
	
	List<PrizeApply> listApplyList(Map<String , Object> map );
	
	 
}
