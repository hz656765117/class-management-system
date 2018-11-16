package com.hz.springboot.business.studyMng.base.dao;


import com.hz.springboot.business.studyMng.base.pojo.EvalStuPO;
import com.hz.springboot.business.studyMng.base.pojo.EvalStuPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvalStuPOMapper {
    int countByExample(EvalStuPOExample example);

    int deleteByExample(EvalStuPOExample example);

    int insert(EvalStuPO record);

    int insertSelective(EvalStuPO record);

    List<EvalStuPO> selectByExample(EvalStuPOExample example);

    int updateByExampleSelective(@Param("record") EvalStuPO record, @Param("example") EvalStuPOExample example);

    int updateByExample(@Param("record") EvalStuPO record, @Param("example") EvalStuPOExample example);
}