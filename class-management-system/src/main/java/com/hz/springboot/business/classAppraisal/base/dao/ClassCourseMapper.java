package com.hz.springboot.business.classAppraisal.base.dao;


import com.hz.springboot.business.classAppraisal.base.pojo.ClassCourse;
import com.hz.springboot.business.classAppraisal.base.pojo.ClassCourseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    
    
    List<ClassCourse> listStudentCourse(Map<String, Object> map);
}