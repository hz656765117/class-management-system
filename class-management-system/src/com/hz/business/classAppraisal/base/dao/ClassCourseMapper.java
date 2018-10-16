package com.hz.business.classAppraisal.base.dao;

import com.hz.business.classAppraisal.base.pojo.ClassCourse;
import com.hz.business.classAppraisal.base.pojo.ClassCourseExample;
import com.hz.business.classAppraisal.base.pojo.StuScore;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ClassCourseMapper {
    int countByExample(ClassCourseExample example);

    int deleteByExample(ClassCourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassCourse record);

    int insertSelective(ClassCourse record);

    List<ClassCourse> selectByExample(ClassCourseExample example);

    ClassCourse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassCourse record, @Param("example") ClassCourseExample example);

    int updateByExample(@Param("record") ClassCourse record, @Param("example") ClassCourseExample example);

    int updateByPrimaryKeySelective(ClassCourse record);

    int updateByPrimaryKey(ClassCourse record);
    
    
    List<ClassCourse> listStudentCourse(Map<String , Object> map );
}