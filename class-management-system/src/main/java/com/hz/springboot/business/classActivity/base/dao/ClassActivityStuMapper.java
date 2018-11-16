package com.hz.springboot.business.classActivity.base.dao;


import com.hz.springboot.business.classActivity.base.pojo.ClassActivityStu;
import com.hz.springboot.business.classActivity.base.pojo.ClassActivityStuExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface ClassActivityStuMapper {
    int countByExample(ClassActivityStuExample example);

    int deleteByExample(ClassActivityStuExample example);

    int deleteByPrimaryKey(Integer activityStuKey);

    int insert(ClassActivityStu record);

    int insertSelective(ClassActivityStu record);

    List<ClassActivityStu> selectByExample(ClassActivityStuExample example);

    ClassActivityStu selectByPrimaryKey(Integer activityStuKey);

    int updateByExampleSelective(@Param("record") ClassActivityStu record, @Param("example") ClassActivityStuExample example);

    int updateByExample(@Param("record") ClassActivityStu record, @Param("example") ClassActivityStuExample example);

    int updateByPrimaryKeySelective(ClassActivityStu record);

    int updateByPrimaryKey(ClassActivityStu record);
}