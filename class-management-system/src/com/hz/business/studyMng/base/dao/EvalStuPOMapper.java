package com.hz.business.studyMng.base.dao;

import com.hz.business.studyMng.base.pojo.EvalStuPO;
import com.hz.business.studyMng.base.pojo.EvalStuPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvalStuPOMapper {
    int countByExample(EvalStuPOExample example);

    int deleteByExample(EvalStuPOExample example);

    int insert(EvalStuPO record);

    int insertSelective(EvalStuPO record);

    List<EvalStuPO> selectByExample(EvalStuPOExample example);

    int updateByExampleSelective(@Param("record") EvalStuPO record, @Param("example") EvalStuPOExample example);

    int updateByExample(@Param("record") EvalStuPO record, @Param("example") EvalStuPOExample example);
}