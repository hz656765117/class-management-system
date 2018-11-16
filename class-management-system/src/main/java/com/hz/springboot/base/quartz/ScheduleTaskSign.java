package com.hz.springboot.base.quartz;

import com.hz.springboot.base.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Configuration
//@Component // 此注解必加
//@EnableScheduling // 此注解必加
public class ScheduleTaskSign {
    private static ScheduleTaskSign ourInstance = new ScheduleTaskSign();

    public static ScheduleTaskSign getInstance() {
        return ourInstance;
    }

    private ScheduleTaskSign() {
    }
    private static final Logger LOGGER =  LoggerFactory.getLogger(ScheduleTaskSign.class);
    public void sayHello(){
        LOGGER.info("Hello world, i'm the king of the world!!!");
        String res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=c9981905-01e0-4524-90bf-52195b150985");

        //WOWEALTH_JSESSIONID=c9981905-01e0-4524-90bf-52195b150985    沃钱包
        //WOWEALTH_JSESSIONID=f24c40b8-582e-4bc7-bf85-7f14f97020f2    沃百富

        LOGGER.info(res);
    }

}
