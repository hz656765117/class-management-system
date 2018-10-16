package com.hz.business.classAppraisal.base.dao;

import com.hz.business.classAppraisal.base.pojo.ClassCommittee;
import com.hz.business.classAppraisal.base.pojo.StudentCourseScore;
import com.hz.business.classAppraisal.base.pojo.StudentCourseScoreExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StudentCourseScoreMapper {
    int countByExample(StudentCourseScoreExample example);

	int deleteByExample(StudentCourseScoreExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(StudentCourseScore record);

	int insertSelective(StudentCourseScore record);

	List<StudentCourseScore> selectByExample(StudentCourseScoreExample example);

	StudentCourseScore selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") StudentCourseScore record,
			@Param("example") StudentCourseScoreExample example);

	int updateByExample(@Param("record") StudentCourseScore record,
			@Param("example") StudentCourseScoreExample example);

	int updateByPrimaryKeySelective(StudentCourseScore record);

	int updateByPrimaryKey(StudentCourseScore record);

    
    List<StudentCourseScore> listStudentCourseScore(Map<String , Object> map );
}