package com.hz.springboot.business.classAppraisal.service.impl;

import com.hz.springboot.base.utils.common.BoxConvertUtils;
import com.hz.springboot.business.classAppraisal.base.dao.PrizeApplyMapper;
import com.hz.springboot.business.classAppraisal.base.pojo.PrizeApply;
import com.hz.springboot.business.classAppraisal.base.pojo.PrizeApplyExample;
import com.hz.springboot.business.classAppraisal.service.PrizeApplyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


 
@Service
@Transactional
public class PrizeApplyServiceImpl implements PrizeApplyService {
    @Autowired
    private PrizeApplyMapper prizeApplyMapper;

	@Override
	public PrizeApply insertPrizeApply(PrizeApply prizeApply) {
		prizeApply.setCreateTime(new Date());
		prizeApply.setDeleteFlag(0);
		prizeApply.setStatus("0");
		prizeApplyMapper.insertSelective(prizeApply);
		return prizeApply;
	}

	@Override
	public List<PrizeApply> prizeApplyListByAuditId(String auditId) {
		PrizeApplyExample example = new PrizeApplyExample();
		example.createCriteria().andDeleteFlagEqualTo(0).andTeacherIdEqualTo(auditId);
		return prizeApplyMapper.selectByExample(example);
	}

	@Override
	public boolean delPrizeApply(String ids) {
		if ( StringUtils.isBlank(ids) ) {
			return false ;
		}
		List<Integer> list = BoxConvertUtils.convert(ids, ",", Integer.class);
		PrizeApplyExample example = new PrizeApplyExample();
		example.createCriteria().andDeleteFlagEqualTo(0).andIdIn(list);
		PrizeApply prizeApply = new PrizeApply();
		prizeApply.setDeleteFlag(1);
		prizeApplyMapper.updateByExampleSelective(prizeApply, example);
		return true;
	}

	@Override
	public boolean updatePrizeApply(PrizeApply prizeApply) {
		prizeApply.setAuditDatetime(new Date());
		prizeApplyMapper.updateByPrimaryKeySelective(prizeApply);
		return true;
	}

	@Override
	public PrizeApply getPrizeApplyById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrizeApply> listApplyList(Map<String, Object> map) {
		return prizeApplyMapper.listPrizeApply(map);
	}

	 

	
	

    
}
