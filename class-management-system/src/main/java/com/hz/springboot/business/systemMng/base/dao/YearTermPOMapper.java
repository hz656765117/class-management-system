package com.hz.springboot.business.systemMng.base.dao;


import com.hz.springboot.business.systemMng.base.pojo.YearTermPO;
import com.hz.springboot.business.systemMng.base.pojo.YearTermPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface YearTermPOMapper {
    int countByExample(YearTermPOExample example);

    int deleteByExample(YearTermPOExample example);

    int deleteByPrimaryKey(String yearTermKey);

    int insert(YearTermPO record);

    int insertSelective(YearTermPO record);

    List<YearTermPO> selectByExample(YearTermPOExample example);

    YearTermPO selectByPrimaryKey(String yearTermKey);

    int updateByExampleSelective(@Param("record") YearTermPO record, @Param("example") YearTermPOExample example);

    int updateByExample(@Param("record") YearTermPO record, @Param("example") YearTermPOExample example);

    int updateByPrimaryKeySelective(YearTermPO record);

    int updateByPrimaryKey(YearTermPO record);
    
    int updateNotCurrent();
}