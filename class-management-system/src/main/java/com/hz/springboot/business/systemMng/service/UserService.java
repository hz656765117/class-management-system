package com.hz.springboot.business.systemMng.service;

import com.hz.springboot.business.systemMng.base.pojo.UserPO;

import java.util.List;




public interface UserService {
	 
	String insertUserInfo(UserPO po);
	 
	List<UserPO> selectListByContent(String content);
	
	boolean delUserInfo(String ids);
	
	boolean updatePassword(String userKey, String password);

	UserPO selectUserPO(String userName, String password, String type);
	
}
