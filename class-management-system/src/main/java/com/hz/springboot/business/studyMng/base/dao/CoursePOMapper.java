package com.hz.springboot.business.studyMng.base.dao;


import com.hz.springboot.business.studyMng.base.pojo.CoursePO;
import com.hz.springboot.business.studyMng.base.pojo.CoursePOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoursePOMapper {
    int countByExample(CoursePOExample example);

    int deleteByExample(CoursePOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoursePO record);

    int insertSelective(CoursePO record);

    List<CoursePO> selectByExample(CoursePOExample example);

    CoursePO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoursePO record, @Param("example") CoursePOExample example);

    int updateByExample(@Param("record") CoursePO record, @Param("example") CoursePOExample example);

    int updateByPrimaryKeySelective(CoursePO record);

    int updateByPrimaryKey(CoursePO record);
}