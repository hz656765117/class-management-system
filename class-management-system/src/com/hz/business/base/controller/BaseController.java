package com.hz.business.base.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.google.gson.Gson;
import com.hz.base.utils.User;
import com.hz.business.systemMng.base.pojo.UserPO;


public class BaseController {
	protected String webPath;
	protected HttpServletResponse response;
	protected UserPO user;
//	protected User user1;
	
	

	
	
	/**
	 * 所有的子类方法执行之前都要先执行此方法，子类方法不需要在model此方法中的参数
	 */
	@ModelAttribute
	public void init(ModelMap model,HttpServletRequest request,HttpServletResponse response) {
//		UserPO user = new UserPO();
//		user.setUserKey("");
//		user.setPassword("1234");
//		user.setUserName("11301440144");
//		user.setType("3");
//	//	request.getSession().setAttribute("user", user);  //暂时代替登录功能
//		
//		UserPO user1 = new UserPO();
//		user1.setUserKey("");
//		user1.setPassword("1234");
//		user1.setUserName("2014001");
//		user1.setType("2");
		
		model.addAttribute("user", (UserPO) request.getSession().getAttribute("user"));
		this.user = (UserPO) request.getSession().getAttribute("user");
		this.response = response;
		model.addAttribute("webPath", getWebPath(request));
		
		System.out.println(request.getCharacterEncoding());
		
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		System.out.println(time.format(new Date()) + "======="+ request.getRequestURL().toString());
		System.out.println(request.getMethod());
		
	}
	
	public String getWebPath(HttpServletRequest request){
		String path = request.getContextPath(); 
		String basePath = request.getScheme() + "://" 
		+ request.getServerName() + ":" + request.getServerPort() 
		+ path + "/"; 
		return basePath;
	}
	
 
	/**
	 * 搜索对象
	 *
	 * @param binder
	 */
	@InitBinder("search")
	public void initSearchBinder(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("search.");
	}

	public String getWebPath() {
		return webPath;
	}

	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

 
	
	public boolean responseObj(Object obj){
		response.setContentType("text/json;charset=UTF-8");  
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(new Gson().toJson(obj));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	
	
}
