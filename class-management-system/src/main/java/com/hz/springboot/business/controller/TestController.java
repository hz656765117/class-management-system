package com.hz.springboot.business.controller;

import com.hz.springboot.base.utils.HttpUtil;
import com.hz.springboot.base.utils.UrlUtil;
import com.hz.springboot.business.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    private final TestService testService;


    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }


    @RequestMapping("test")
    @ResponseBody
    public String getSomething() {
//        boolean homepage_popup_true = testService.checkNeedPopup("homepage_popup_true");
//        LOGGER.info(homepage_popup_true+"");
        LOGGER.debug("debugdebugdebugtest1111123434");
        LOGGER.info("infoinfoinfotest1111123434");
        LOGGER.error("errorerrorerrortest1111123434");
        LOGGER.warn("warnwarnwarntest1warnwarn111123434");

        return  "sql  query    jenkins 部署";
    }


    @RequestMapping("test1")
    public String getSomething1() {
        LOGGER.debug("aaaaaaaaaaadebugdebugdebugtest1111123434");
        LOGGER.info("aaaaaaaaaaaaaaaaaaainfoinfoinfotest1111123434");
        LOGGER.error("aaaaaaaaaaaaaaaaerrorerrorerrortest1111123434");
        LOGGER.warn("aaaaaaaaaaaaaawarnwarnwarntest1warnwarn111123434");

        return "test111";
    }

    @RequestMapping({"test2"})
    public String getSomething2() {
        LOGGER.debug("BBBBBBBBBBBBBBaaaaaaaaaaadebugdebugdebugtest1111123434");
        LOGGER.info("BBBBBBBBBBBBBBBaaaaaaaaaaaaaaaaaaainfoinfoinfotest1111123434");
        LOGGER.error("BBBBBBBBBBBaaaaaaaaaaaaaaaaerrorerrorerrortest1111123434");
        LOGGER.warn("BBBBBBBBBBBBaaaaaaaaaaaaaawarnwarnwarntest1warnwarn111123434");
        return "test112221";
    }


    @RequestMapping({"test3"})
    public String getSomething3() {
        LOGGER.debug("ccccccccccccBBBBBBBBBBBBBBaaaaaaaaaaadebugdebugdebugtest1111123434");
        LOGGER.info("cccccccccccBBBBBBBBBBBBBBBaaaaaaaaaaaaaaaaaaainfoinfoinfotest1111123434");
        LOGGER.error("ccccccccccccBBBBBBBBBBBaaaaaaaaaaaaaaaaerrorerrorerrortest1111123434");
        LOGGER.warn("ccccccccccBBBBBBBBBBBBaaaaaaaaaaaaaawarnwarnwarntest1warnwarn111123434");
        return "test112221cccccccccccc";
    }


    @RequestMapping({"test4"})
    public String getSomething4() {
        LOGGER.debug("4444444444444ccccccBBBBBBBBBBBBBBaaaaaaaaaaadebugdebugdebugtest1111123434");
        LOGGER.info("444444444444cccccccccccBBBBBBBBBBBBBBBaaaaaaaaaaaaaaaaaaainfoinfoinfotest1111123434");
        LOGGER.error("4444444444444444ccccccccccccBBBBBBBBBBBaaaaaaaaaaaaaaaaerrorerrorerrortest1111123434");
        LOGGER.warn("444444444444444ccccccccccBBBBBBBBBBBBaaaaaaaaaaaaaawarnwarnwarntest1warnwarn111123434");
        return "dddddddtest112221cccccccccccc";
    }


    @RequestMapping({"testt"})
    public String getSomething5() {
        LOGGER.debug("4444444444444ccccccBBBBBBBBBBBBBBaaaaaaaaaaadebugdebugdebugtest1111123434");
        LOGGER.info("444444444444cccccccccccBBBBBBBBBBBBBBBaaaaaaaaaaaaaaaaaaainfoinfoinfotest1111123434");
        LOGGER.error("4444444444444444ccccccccccccBBBBBBBBBBBaaaaaaaaaaaaaaaaerrorerrorerrortest1111123434");
        LOGGER.warn("444444444444444ccccccccccBBBBBBBBBBBBaaaaaaaaaaaaaawarnwarnwarntest1warnwarn111123434");
        return "dddddddasssssssssssssssssssssssssssstest112221cccccccccccc";
    }



    @RequestMapping("/login")
    public String welcome(){

        return "index";

    }



//    @RequestMapping("/open/api/weather/{city}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8")
//
//    public String getSomethingSS(HttpServletRequest request, @PathVariable String city) {
//        LOGGER.info(city);
//
//
//
//        return "dddddddasssssssssssssssssssssssssssstest112221cccccccccccc";
//    }


    @CrossOrigin
    @RequestMapping(value = "/open/api/weather/{city}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String updateAllSwitch(HttpServletRequest request, HttpServletResponse response, @PathVariable String city) {
        LOGGER.info(city);
        String parm = UrlUtil.getURLEncoderString(city);
        LOGGER.info(parm);
        String apiUrl = String.format("http://www.sojson.com/open/api/weather/json.shtml?city=%s", parm);
        String result = HttpUtil.get(apiUrl, null);
        LOGGER.info(result);
        return result;
    }

//    @RequestMapping(value = "/open/api/weather/{city}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
//    @ResponseBody
//    public String weather(HttpServletRequest request, HttpServletResponse response, @PathVariable String city) {
//        LOGGER.info(city);
//        String parm = UrlUtil.getURLEncoderString(city);
//        LOGGER.info(parm);
//        String apiUrl = String.format("http://www.sojson.com/open/api/weather/json.shtml?city=%s",parm);
//        String result = HttpUtil.get(apiUrl,null);
//        LOGGER.info(result);
//        return result;
//    }


//
//
//    public static void main(String[] args) throws Exception{
//        String city = UrlUtil.getURLEncoderString("北京");
//
//
//        System.out.println(city);
//
//        String apiUrl = String.format("http://www.sojson.com/open/api/weather/json.shtml?city=%s",city);
//
////        apiUrl = "http://www.sojson.com/open/api/weather/json.shtml?city=长沙";
//        System.out.println(apiUrl);
//        String result = HttpUtil.get(apiUrl,null);
////        String sCurrentLine = "";
////        String sTotalString = "";
////        try {
////            URL l_url = new URL(apiUrl);
////            HttpURLConnection l_connection = (HttpURLConnection) l_url.openConnection();
////            l_connection.connect();
////            InputStream l_urlStream;
////            l_urlStream = l_connection.getInputStream();
////            BufferedReader l_reader = new BufferedReader(new InputStreamReader(
////                    l_urlStream, "utf-8"));
////            // sCurrentLine = l_reader.readLine();
////            while ((sCurrentLine = l_reader.readLine()) != null) {
////                sTotalString += sCurrentLine + "\r\n";
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//        System.out.println(result);
//
//
//    }


}
