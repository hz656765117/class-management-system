package com.hz.business.studyMng.base.dao;

import com.hz.business.studyMng.base.pojo.EvaluatePO;
import com.hz.business.studyMng.base.pojo.EvaluatePOExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EvaluatePOMapper {
    int countByExample(EvaluatePOExample example);

    int deleteByExample(EvaluatePOExample example);

    int insert(EvaluatePO record);

    int insertSelective(EvaluatePO record);

    List<EvaluatePO> selectByExample(EvaluatePOExample example);

    int updateByExampleSelective(@Param("record") EvaluatePO record, @Param("example") EvaluatePOExample example);

    int updateByExample(@Param("record") EvaluatePO record, @Param("example") EvaluatePOExample example);
    
    List<EvaluatePO> selectList();

	List<EvaluatePO> selectStuEvalList(@Param("params") Map<String, Object> params);

	List<EvaluatePO> selectTeaEvalList(@Param("params") Map<String, Object> params);
}