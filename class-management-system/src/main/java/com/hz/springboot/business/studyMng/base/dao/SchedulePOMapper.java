package com.hz.springboot.business.studyMng.base.dao;


import com.hz.springboot.business.studyMng.base.pojo.SchedulePO;
import com.hz.springboot.business.studyMng.base.pojo.SchedulePOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SchedulePOMapper {
    int countByExample(SchedulePOExample example);

    int deleteByExample(SchedulePOExample example);

    int deleteByPrimaryKey(String scheduleKey);

    int insert(SchedulePO record);

    int insertSelective(SchedulePO record);

    List<SchedulePO> selectByExample(SchedulePOExample example);

    SchedulePO selectByPrimaryKey(String scheduleKey);

    int updateByExampleSelective(@Param("record") SchedulePO record, @Param("example") SchedulePOExample example);

    int updateByExample(@Param("record") SchedulePO record, @Param("example") SchedulePOExample example);

    int updateByPrimaryKeySelective(SchedulePO record);

    int updateByPrimaryKey(SchedulePO record);
    
    List<SchedulePO> selectListByClassKey(String classKey);
}