package com.hz.springboot.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WechatController {

    @RequestMapping("/welcome")
    public ModelAndView welcome(){
        ModelAndView mav = new ModelAndView("/index.jsp");
        return mav;
    }

}
