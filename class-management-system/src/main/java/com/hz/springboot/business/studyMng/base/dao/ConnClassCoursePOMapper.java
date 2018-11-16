package com.hz.springboot.business.studyMng.base.dao;


import com.hz.springboot.business.studyMng.base.pojo.ConnClassCoursePO;
import com.hz.springboot.business.studyMng.base.pojo.ConnClassCoursePOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ConnClassCoursePOMapper {
    int countByExample(ConnClassCoursePOExample example);

    int deleteByExample(ConnClassCoursePOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConnClassCoursePO record);

    int insertSelective(ConnClassCoursePO record);

    List<ConnClassCoursePO> selectByExample(ConnClassCoursePOExample example);

    ConnClassCoursePO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConnClassCoursePO record, @Param("example") ConnClassCoursePOExample example);

    int updateByExample(@Param("record") ConnClassCoursePO record, @Param("example") ConnClassCoursePOExample example);

    int updateByPrimaryKeySelective(ConnClassCoursePO record);

    int updateByPrimaryKey(ConnClassCoursePO record);
    
    List<ConnClassCoursePO> selectByClassKey(String classKey);
    
    List<ConnClassCoursePO> selectListByKey(Map<String, Object> map);
}