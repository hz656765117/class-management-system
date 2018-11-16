package com.hz.springboot.business.classMoney.base.dao;


import com.hz.springboot.business.classMoney.base.pojo.ClassMoney;
import com.hz.springboot.business.classMoney.base.pojo.ClassMoneyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassMoneyMapper {
    int countByExample(ClassMoneyExample example);

    int deleteByExample(ClassMoneyExample example);

    int deleteByPrimaryKey(String classMoneyKey);

    int insert(ClassMoney record);

    int insertSelective(ClassMoney record);

    List<ClassMoney> selectByExample(ClassMoneyExample example);
    
    List<ClassMoney> selectListByExample(ClassMoneyExample example);

    ClassMoney selectByPrimaryKey(String classMoneyKey);

    int updateByExampleSelective(@Param("record") ClassMoney record, @Param("example") ClassMoneyExample example);

    int updateByExample(@Param("record") ClassMoney record, @Param("example") ClassMoneyExample example);

    int updateByPrimaryKeySelective(ClassMoney record);

    int updateByPrimaryKey(ClassMoney record);
}