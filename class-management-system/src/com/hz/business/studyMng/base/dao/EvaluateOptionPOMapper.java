package com.hz.business.studyMng.base.dao;

import com.hz.business.studyMng.base.pojo.EvaluateOptionPO;
import com.hz.business.studyMng.base.pojo.EvaluateOptionPOExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EvaluateOptionPOMapper {
    int countByExample(EvaluateOptionPOExample example);

    int deleteByExample(EvaluateOptionPOExample example);

    int insert(EvaluateOptionPO record);

    int insertSelective(EvaluateOptionPO record);

    List<EvaluateOptionPO> selectByExample(EvaluateOptionPOExample example);
    
    List<EvaluateOptionPO> selectOptionScoreList(@Param("record") Map<String,Object> record);

    int updateByExampleSelective(@Param("record") EvaluateOptionPO record, @Param("example") EvaluateOptionPOExample example);

    int updateByExample(@Param("record") EvaluateOptionPO record, @Param("example") EvaluateOptionPOExample example);
}