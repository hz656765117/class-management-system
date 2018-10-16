package com.hz.business.studyMng.base.dao;

import com.hz.business.studyMng.base.pojo.CoursePO;
import com.hz.business.studyMng.base.pojo.CoursePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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