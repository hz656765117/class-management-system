package com.hz.springboot.business.studyMng.base.dao;


import com.hz.springboot.business.studyMng.base.pojo.ClassBookPO;
import com.hz.springboot.business.studyMng.base.pojo.ClassBookPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassBookPOMapper {
    int countByExample(ClassBookPOExample example);

    int deleteByExample(ClassBookPOExample example);

    int deleteByPrimaryKey(String classBookKey);

    int insert(ClassBookPO record);

    int insertSelective(ClassBookPO record);

    List<ClassBookPO> selectByExample(ClassBookPOExample example);

    ClassBookPO selectByPrimaryKey(String classBookKey);

    int updateByExampleSelective(@Param("record") ClassBookPO record, @Param("example") ClassBookPOExample example);

    int updateByExample(@Param("record") ClassBookPO record, @Param("example") ClassBookPOExample example);

    int updateByPrimaryKeySelective(ClassBookPO record);

    int updateByPrimaryKey(ClassBookPO record);
}