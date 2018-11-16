package com.hz.springboot.business.classAppraisal.base.dao;


import com.hz.springboot.business.classAppraisal.base.pojo.PrizeAwards;
import com.hz.springboot.business.classAppraisal.base.pojo.PrizeAwardsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrizeAwardsMapper {
    int countByExample(PrizeAwardsExample example);

    int deleteByExample(PrizeAwardsExample example);

    int deleteByPrimaryKey(Integer prizeId);

    int insert(PrizeAwards record);

    int insertSelective(PrizeAwards record);

    List<PrizeAwards> selectByExample(PrizeAwardsExample example);

    PrizeAwards selectByPrimaryKey(Integer prizeId);

    int updateByExampleSelective(@Param("record") PrizeAwards record, @Param("example") PrizeAwardsExample example);

    int updateByExample(@Param("record") PrizeAwards record, @Param("example") PrizeAwardsExample example);

    int updateByPrimaryKeySelective(PrizeAwards record);

    int updateByPrimaryKey(PrizeAwards record);
}