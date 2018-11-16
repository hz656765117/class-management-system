package com.hz.springboot.business.basicDataMng.base.dao;


import com.hz.springboot.business.basicDataMng.base.pojo.ClassPO;
import com.hz.springboot.business.basicDataMng.base.pojo.ClassPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassPOMapper {
    int countByExample(ClassPOExample example);

    int deleteByExample(ClassPOExample example);

    int deleteByPrimaryKey(String classKey);

    int insert(ClassPO record);

    int insertSelective(ClassPO record);

    List<ClassPO> selectByExample(ClassPOExample example);

    ClassPO selectByPrimaryKey(String classKey);

    int updateByExampleSelective(@Param("record") ClassPO record, @Param("example") ClassPOExample example);

    int updateByExample(@Param("record") ClassPO record, @Param("example") ClassPOExample example);

    int updateByPrimaryKeySelective(ClassPO record);

    int updateByPrimaryKey(ClassPO record);
    
    List<ClassPO> selectClassMoneyByExample(ClassPOExample example);
}