package com.hz.springboot.business.basicDataMng.base.dao;


import com.hz.springboot.business.basicDataMng.base.pojo.MajorPO;
import com.hz.springboot.business.basicDataMng.base.pojo.MajorPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MajorPOMapper {
    int countByExample(MajorPOExample example);

    int deleteByExample(MajorPOExample example);

    int deleteByPrimaryKey(String majorKey);

    int insert(MajorPO record);

    int insertSelective(MajorPO record);

    List<MajorPO> selectByExample(MajorPOExample example);

    MajorPO selectByPrimaryKey(String majorKey);

    int updateByExampleSelective(@Param("record") MajorPO record, @Param("example") MajorPOExample example);

    int updateByExample(@Param("record") MajorPO record, @Param("example") MajorPOExample example);

    int updateByPrimaryKeySelective(MajorPO record);

    int updateByPrimaryKey(MajorPO record);
}