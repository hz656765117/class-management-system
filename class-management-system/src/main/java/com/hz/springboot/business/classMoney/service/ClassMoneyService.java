package com.hz.springboot.business.classMoney.service;


import com.hz.springboot.business.classMoney.base.pojo.ClassMoney;
import org.springframework.stereotype.Component;

import java.util.List;




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
