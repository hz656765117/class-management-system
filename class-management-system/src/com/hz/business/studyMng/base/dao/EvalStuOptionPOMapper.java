package com.hz.business.studyMng.base.dao;

import com.hz.business.studyMng.base.pojo.EvalStuOptionPO;
import com.hz.business.studyMng.base.pojo.EvalStuOptionPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvalStuOptionPOMapper {
    int countByExample(EvalStuOptionPOExample example);

    int deleteByExample(EvalStuOptionPOExample example);

    int insert(EvalStuOptionPO record);

    int insertSelective(EvalStuOptionPO record);

    List<EvalStuOptionPO> selectByExample(EvalStuOptionPOExample example);

    int updateByExampleSelective(@Param("record") EvalStuOptionPO record, @Param("example") EvalStuOptionPOExample example);

    int updateByExample(@Param("record") EvalStuOptionPO record, @Param("example") EvalStuOptionPOExample example);
}