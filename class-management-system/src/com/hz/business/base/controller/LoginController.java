package com.hz.business.base.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hz.base.utils.User;
import com.hz.business.base.controller.BaseController;
import com.hz.business.systemMng.base.pojo.UserPO;
import com.hz.business.systemMng.service.UserService;


@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	@Autowired
	public UserService userService;
	
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		return  "login" ;
	}
	
	@RequestMapping("/in") 
    @ResponseBody
    public Map<String,Object> in(HttpServletRequest request,Model model){
		Map<String,Object> json = new HashMap<>();
        json.put("success", false);
    	String userName = request.getParameter("userName");
    	String password = request.getParameter("password");
    	String type = request.getParameter("type");
    	UserPO userPO=userService.selectUserPO(userName,password,type);
    	if(userPO!=null){
    		json.put("success", true);
    		User.saveUserInfo(request, userPO);
    	}
    	return json; 
    }
	
	@RequestMapping("/logOut")
	public void logOut(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/login/index.do");
	}
	
	
}
