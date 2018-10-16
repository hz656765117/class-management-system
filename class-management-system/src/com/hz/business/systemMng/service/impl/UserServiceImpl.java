package com.hz.business.systemMng.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.base.utils.common.BoxConvertUtils;
import com.hz.business.systemMng.base.dao.UserPOMapper;
import com.hz.business.systemMng.base.pojo.UserPO;
import com.hz.business.systemMng.base.pojo.UserPOExample;
import com.hz.business.systemMng.service.UserService;

 
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserPOMapper mapper;

	@Override
	public String insertUserInfo(UserPO po) {
		//项判断用户是否存在
		UserPOExample example = new UserPOExample();
		//创建方法，添加搜索条件
		example.createCriteria().andUserNameEqualTo(po.getUserName());
		List<UserPO>  list = mapper.selectAllInfoByExample(example);
		if(list!=null && list.size()>0){
			return "0";
		}
		po.setUserKey(UUID.randomUUID().toString());
		mapper.insert(po);
		return "1";
	}

	@Override
	public List<UserPO> selectListByContent(String content) {
		UserPOExample example = new UserPOExample();
		//创建方法，添加搜索条件
//		example.createCriteria().andListLikeTo(academyName);
		List<UserPO>  list = mapper.selectAllInfoByExample(example);
		return list;
	}

	@Override
	public boolean delUserInfo(String ids) {
		if ( StringUtils.isBlank(ids) ) {
			return false ;
		}
		List<String> list = BoxConvertUtils.convert(ids, ",", String.class);
		for (String key : list) {
			mapper.deleteByPrimaryKey(key);
		}
		return true;
	}

	@Override
	public boolean updatePassword(String userKey, String password) {
		UserPO po = mapper.selectByPrimaryKey(userKey);
		po.setPassword(password);
		mapper.updateByPrimaryKey(po);
		return true;
	}

	@Override
	public UserPO selectUserPO(String userName, String password, String type) {
		UserPOExample example = new UserPOExample();
		//创建方法，添加搜索条件
		example.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password).andTypeEqualTo(type);
		List<UserPO>  list = mapper.selectAllInfoByExample(example);
		if(list==null || list.size()<=0){
			return null;
		}
		return list.get(0);
	}
}
