package com.hz.business.studyMng.service;

import java.util.List;
import java.util.Map;

import com.hz.business.studyMng.base.pojo.SchedulePO;

 
public interface ScheduleService {
	 
	 
	List<SchedulePO> selectListByClassKey(String classkey );

	SchedulePO selectPOByClassKeyAndWO(String classKey, Integer weekSeq, Integer orderSeq);

	void insertSchedulee(SchedulePO po);

	void updateSchedule(SchedulePO po);
	
	 
}
