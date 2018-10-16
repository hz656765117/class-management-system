package com.hz.business.classMoney.service;


import java.util.List;

import org.springframework.stereotype.Component;

import com.hz.business.classMoney.base.pojo.ClassMoney;


/**
 * Dao管理类，管理所有的dao
 * @author HZBOX
 * @since 2016-09-24
 */
@Component
public interface ClassMoneyService {

	List<ClassMoney> classMoneyListByUserId(String content, String classKey);

	void insertClassMoney(ClassMoney po);

	ClassMoney getClassMoneyById(String classMoneyKey);

	void updateClassMoney(ClassMoney po);

	boolean delClassMoney(String ids);

	
	
	
	
}
