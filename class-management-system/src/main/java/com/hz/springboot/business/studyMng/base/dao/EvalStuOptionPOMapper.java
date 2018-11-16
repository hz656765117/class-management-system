package com.hz.springboot.business.studyMng.base.dao;


import com.hz.springboot.business.studyMng.base.pojo.EvalStuOptionPO;
import com.hz.springboot.business.studyMng.base.pojo.EvalStuOptionPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvalStuOptionPOMapper {
    int countByExample(EvalStuOptionPOExample example);

    int deleteByExample(EvalStuOptionPOExample example);

    int insert(EvalStuOptionPO record);

    int insertSelective(EvalStuOptionPO record);

    List<EvalStuOptionPO> selectByExample(EvalStuOptionPOExample example);

    int updateByExampleSelective(@Param("record") EvalStuOptionPO record, @Param("example") EvalStuOptionPOExample example);

    int updateByExample(@Param("record") EvalStuOptionPO record, @Param("example") EvalStuOptionPOExample example);
}