package com.hz.business.classAppraisal.base.dao;

import com.hz.business.classAppraisal.base.pojo.StuScore;
import com.hz.business.classAppraisal.base.pojo.StuScoreExample;
import com.hz.business.classAppraisal.base.pojo.StudentCourseScore;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StuScoreMapper {
    int countByExample(StuScoreExample example);

    int deleteByExample(StuScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StuScore record);

    int insertSelective(StuScore record);

    List<StuScore> selectByExample(StuScoreExample example);

    StuScore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StuScore record, @Param("example") StuScoreExample example);

    int updateByExample(@Param("record") StuScore record, @Param("example") StuScoreExample example);

    int updateByPrimaryKeySelective(StuScore record);

    int updateByPrimaryKey(StuScore record);
    
    List<StuScore> listStuScore(Map<String , Object> map );
    
}