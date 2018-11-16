package com.hz.springboot.business.studyMng.service.impl;

import com.hz.springboot.business.studyMng.base.dao.SchedulePOMapper;
import com.hz.springboot.business.studyMng.base.pojo.SchedulePO;
import com.hz.springboot.business.studyMng.base.pojo.SchedulePOExample;
import com.hz.springboot.business.studyMng.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;



@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

	 @Autowired
	 private SchedulePOMapper schedulePOMapper;
	
	@Override
	public List<SchedulePO> selectListByClassKey(String classkey) {
		return schedulePOMapper.selectListByClassKey(classkey);
	}

	@Override
	public SchedulePO selectPOByClassKeyAndWO(String classKey, Integer weekSeq, Integer orderSeq) {
		SchedulePOExample example = new SchedulePOExample();
		//创建方法，添加搜索条件
		example.createCriteria().andClassKeyEqualTo(classKey).andWeekSeqEqualTo(weekSeq).andOrderSeqEqualTo(orderSeq);
		List<SchedulePO>  list = schedulePOMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return new SchedulePO();
	}

	@Override
	public void insertSchedulee(SchedulePO po) {
		po.setScheduleKey(UUID.randomUUID().toString());
		schedulePOMapper.insert(po);
	}

	@Override
	public void updateSchedule(SchedulePO po) {
		schedulePOMapper.updateByPrimaryKeySelective(po);
	}

}
