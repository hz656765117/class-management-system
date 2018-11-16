package com.hz.springboot.business.studyMng.service;

import com.hz.springboot.business.studyMng.base.pojo.SchedulePO;

import java.util.List;



 
public interface ScheduleService {
	 
	 
	List<SchedulePO> selectListByClassKey(String classkey);

	SchedulePO selectPOByClassKeyAndWO(String classKey, Integer weekSeq, Integer orderSeq);

	void insertSchedulee(SchedulePO po);

	void updateSchedule(SchedulePO po);
	
	 
}
