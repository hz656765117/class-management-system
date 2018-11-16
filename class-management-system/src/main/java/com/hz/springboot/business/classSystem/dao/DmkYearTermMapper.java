package com.hz.springboot.business.classSystem.dao;

import com.hz.springboot.business.classSystem.pojo.DmkYearTerm;
import com.hz.springboot.business.classSystem.pojo.DmkYearTermExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DmkYearTermMapper {
    int countByExample(DmkYearTermExample example);

    int deleteByExample(DmkYearTermExample example);

    int deleteByPrimaryKey(String yearTermKey);

    int insert(DmkYearTerm record);

    int insertSelective(DmkYearTerm record);

    List<DmkYearTerm> selectByExample(DmkYearTermExample example);

    DmkYearTerm selectByPrimaryKey(String yearTermKey);

    int updateByExampleSelective(@Param("record") DmkYearTerm record, @Param("example") DmkYearTermExample example);

    int updateByExample(@Param("record") DmkYearTerm record, @Param("example") DmkYearTermExample example);

    int updateByPrimaryKeySelective(DmkYearTerm record);

    int updateByPrimaryKey(DmkYearTerm record);
}