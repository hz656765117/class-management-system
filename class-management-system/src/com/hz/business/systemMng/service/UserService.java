package com.hz.business.systemMng.service;

import java.util.List;

import com.hz.business.systemMng.base.pojo.UserPO;

 
public interface UserService {
	 
	String insertUserInfo(UserPO po);
	 
	List<UserPO> selectListByContent(String content );
	
	boolean delUserInfo(String ids);
	
	boolean updatePassword(String userKey,String password);

	UserPO selectUserPO(String userName, String password, String type);
	
}
