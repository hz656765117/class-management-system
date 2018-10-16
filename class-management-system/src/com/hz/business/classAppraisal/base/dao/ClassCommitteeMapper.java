package com.hz.business.classAppraisal.base.dao;

import com.hz.business.classAppraisal.base.pojo.ClassCommittee;
import com.hz.business.classAppraisal.base.pojo.ClassCommitteeExample;
import com.hz.business.classAppraisal.base.pojo.PrizeApply;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ClassCommitteeMapper {


	int countByExample(ClassCommitteeExample example);

    int deleteByExample(ClassCommitteeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassCommittee record);

    int insertSelective(ClassCommittee record);

    List<ClassCommittee> selectByExample(ClassCommitteeExample example);

    ClassCommittee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassCommittee record, @Param("example") ClassCommitteeExample example);

    int updateByExample(@Param("record") ClassCommittee record, @Param("example") ClassCommitteeExample example);

    int updateByPrimaryKeySelective(ClassCommittee record);

    int updateByPrimaryKey(ClassCommittee record);
    
    List<ClassCommittee> listClassCommittee(Map<String , Object> map );
}