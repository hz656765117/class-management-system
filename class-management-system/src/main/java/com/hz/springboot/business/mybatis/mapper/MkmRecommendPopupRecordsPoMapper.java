package com.hz.springboot.business.mybatis.mapper;

import com.hz.springboot.business.pojo.MkmRecommendPopupRecordsPo;
import com.hz.springboot.business.pojo.MkmRecommendPopupRecordsPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MkmRecommendPopupRecordsPoMapper {
    long countByExample(MkmRecommendPopupRecordsPoExample example);

    int deleteByExample(MkmRecommendPopupRecordsPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MkmRecommendPopupRecordsPo record);

    int insertSelective(MkmRecommendPopupRecordsPo record);

    List<MkmRecommendPopupRecordsPo> selectByExample(MkmRecommendPopupRecordsPoExample example);

    MkmRecommendPopupRecordsPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MkmRecommendPopupRecordsPo record, @Param("example") MkmRecommendPopupRecordsPoExample example);

    int updateByExample(@Param("record") MkmRecommendPopupRecordsPo record, @Param("example") MkmRecommendPopupRecordsPoExample example);

    int updateByPrimaryKeySelective(MkmRecommendPopupRecordsPo record);

    int updateByPrimaryKey(MkmRecommendPopupRecordsPo record);
}