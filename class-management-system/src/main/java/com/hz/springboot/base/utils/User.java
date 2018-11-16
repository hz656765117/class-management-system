package com.hz.springboot.base.utils;


import com.hz.springboot.business.systemMng.base.pojo.UserPO;

import javax.servlet.http.HttpServletRequest;

public class User {
	
	/**
	 * 用户的主键,对应表jwxt_user的user_key字段
	 * @param request
	 * @return
	 */
	public static String getUserId(HttpServletRequest request){
		UserPO po=(UserPO) request.getSession().getAttribute("user");
		return po.getUserKey();
	}
	
	/**
	 * 用户的登录账号,对应表jwxt_user的user_name字段
	 * @param request
	 * @return
	 */
	public static String getUserKey(HttpServletRequest request){
		UserPO po=(UserPO) request.getSession().getAttribute("user");
		return po.getUserName();
	}
	
	/**
	 * 获取身份类型：1：管理员，2：教师，3：学生,对应表jwxt_user的type字段
	 * @param request
	 * @return
	 */
	public static String getUserType(HttpServletRequest request){
		UserPO po=(UserPO) request.getSession().getAttribute("user");
		return po.getType();
	}
	
	public static String getUserName(HttpServletRequest request){
		UserPO po=(UserPO) request.getSession().getAttribute("user");
		if("1".equals(po.getType())){
			return "管理员";
		}else if("2".equals(po.getType())){
			return po.getTeacherName();
		}else{
			return po.getStudentName();
		}
	}
	
	public static void saveUserInfo(HttpServletRequest request, UserPO po){
		request.getSession().setAttribute("user", po);
	}
	
	public static UserPO getUser(HttpServletRequest request){
		return (UserPO) request.getSession().getAttribute("user");
	}
	
	
}
