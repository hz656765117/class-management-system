package com.hz.springboot.business.service;


public interface TestService {


    /**
     * @author huangzhuo
     * @date 2018/11/5 15:28
     * @description: 检查该渠道在当前时间是否允许弹框
     * @param channel 渠道
     */
    boolean checkNeedPopup(String channel);



}
