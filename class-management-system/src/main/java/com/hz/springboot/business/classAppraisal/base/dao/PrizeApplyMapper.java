package com.hz.springboot.business.classAppraisal.base.dao;


import com.hz.springboot.business.classAppraisal.base.pojo.PrizeApply;
import com.hz.springboot.business.classAppraisal.base.pojo.PrizeApplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PrizeApplyMapper {
    int countByExample(PrizeApplyExample example);

    int deleteByExample(PrizeApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PrizeApply record);

    int insertSelective(PrizeApply record);

    List<PrizeApply> selectByExample(PrizeApplyExample example);

    PrizeApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrizeApply record, @Param("example") PrizeApplyExample example);

    int updateByExample(@Param("record") PrizeApply record, @Param("example") PrizeApplyExample example);

    int updateByPrimaryKeySelective(PrizeApply record);

    int updateByPrimaryKey(PrizeApply record);
    
    /**
     * 根据学生或者老师查出奖学金申请
     * @param map
     * @return
     */
    List<PrizeApply> listPrizeApply(Map<String, Object> map);
}