package com.hz.springboot.business.classSystem.dao;

import com.hz.springboot.business.classSystem.pojo.DmkPrizeCode;
import com.hz.springboot.business.classSystem.pojo.DmkPrizeCodeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DmkPrizeCodeMapper {
    int countByExample(DmkPrizeCodeExample example);

    int deleteByExample(DmkPrizeCodeExample example);

    int deleteByPrimaryKey(String prizeKey);

    int insert(DmkPrizeCode record);

    int insertSelective(DmkPrizeCode record);

    List<DmkPrizeCode> selectByExample(DmkPrizeCodeExample example);

    DmkPrizeCode selectByPrimaryKey(String prizeKey);

    int updateByExampleSelective(@Param("record") DmkPrizeCode record, @Param("example") DmkPrizeCodeExample example);

    int updateByExample(@Param("record") DmkPrizeCode record, @Param("example") DmkPrizeCodeExample example);

    int updateByPrimaryKeySelective(DmkPrizeCode record);

    int updateByPrimaryKey(DmkPrizeCode record);
}