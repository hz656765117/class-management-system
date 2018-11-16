package com.hz.springboot.business.systemMng.service.impl;

import com.hz.springboot.business.systemMng.base.dao.YearTermPOMapper;
import com.hz.springboot.business.systemMng.base.pojo.YearTermPO;
import com.hz.springboot.business.systemMng.base.pojo.YearTermPOExample;
import com.hz.springboot.business.systemMng.service.YearTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


 
@Service
@Transactional
public class YearTermServiceImpl implements YearTermService {
    @Autowired
    private YearTermPOMapper yearTermPOMapper;

	@Override
	public void insertYearTerm() {
		YearTermPOExample example = new YearTermPOExample();
		example.setOrderByClause("year_term_key desc");
		List<YearTermPO>  list = yearTermPOMapper.selectByExample(example);
		String year="",term="";
		if(list!=null && list.size()>0){
			YearTermPO po=list.get(0);
			String yearTermId=po.getYearTermKey();
			year=yearTermId.split("-")[0];
			term=yearTermId.split("-")[2];
		}else{
			year="2014";
			term="02";
		}
		YearTermPO nowPO=new YearTermPO();
		nowPO.setFlag(0);
		if("01".equals(term)){
			String nowYear=(Integer.parseInt(year))+"-"+(Integer.parseInt(year)+1);
			nowPO.setYearTermKey(nowYear+"-02");
			nowPO.setYearTermName(nowYear+"学年第二学期");
			nowPO.setYearKey(nowYear);
			nowPO.setYearName(nowYear+"学年");
		}else{
			String nowYear=(Integer.parseInt(year)+1)+"-"+(Integer.parseInt(year)+2);
			nowPO.setYearTermKey(nowYear+"-01");
			nowPO.setYearTermName(nowYear+"学年第一学期");
			nowPO.setYearKey(nowYear);
			nowPO.setYearName(nowYear+"学年");
		}
		yearTermPOMapper.insert(nowPO);
	}

	@Override
	public List<YearTermPO> yearTermListByUserId(String userId) {
		YearTermPOExample example = new YearTermPOExample();
		//创建方法，添加搜索条件
//		example.createCriteria().andListLikeTo(academyName);
		List<YearTermPO>  activitys = yearTermPOMapper.selectByExample(example);
		return activitys;
	}

	@Override
	public void setCurrentYear(String yearTermKey) {
		yearTermPOMapper.updateNotCurrent();
		YearTermPO po = yearTermPOMapper.selectByPrimaryKey(yearTermKey);
		po.setFlag(1);
		yearTermPOMapper.updateByPrimaryKey(po);
	}

	@Override
	public YearTermPO getYearTermById() {
		YearTermPOExample example = new YearTermPOExample();
		example.createCriteria().andFlagEqualTo(1);
		List<YearTermPO> list = yearTermPOMapper.selectByExample(example);
		if(list==null || list.size()<=0){
			return null;
		}
		return list.get(0);
	}
    
}
