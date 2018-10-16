package com.hz.business.studyMng.base.dao;

import com.hz.business.studyMng.base.pojo.ClassBookPO;
import com.hz.business.studyMng.base.pojo.ClassBookPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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