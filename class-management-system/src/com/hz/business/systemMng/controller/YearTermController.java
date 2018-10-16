package com.hz.business.systemMng.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.box.base.page.Page;
import com.box.base.page.PageHelper;
import com.hz.business.base.controller.BaseController;
import com.hz.business.base.model.JsonResult;
import com.hz.business.base.model.SearchParam;
import com.hz.business.basicDataMng.base.pojo.AcademyPO;
import com.hz.business.basicDataMng.service.ClassAcademyService;
import com.hz.business.systemMng.base.pojo.YearTermPO;
import com.hz.business.systemMng.service.YearTermService;


@Controller
@RequestMapping("/systemMng/yearTerm")
public class YearTermController extends BaseController{
	
	@Autowired
	public YearTermService yearTermService;
	
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		return  "systemMng/yearTerm/jsp/index" ;
	}
	
    @RequestMapping("listYearTerm")
    @ResponseBody
    public Map<String,Object> listAccounts(@ModelAttribute("search") SearchParam search, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
   
//        PageHelper.startPage(search.getPageNo(), search.getPageSize());
//        Page<YearTermPO> activitys = (Page<YearTermPO>) yearTermService.yearTermListByUserId(search.getContent());
//        if(activitys.isEmpty()) {
//            return json;
//        }

        List<YearTermPO> activitys = (List<YearTermPO>) yearTermService.yearTermListByUserId(search.getContent());
        json.put("success", true);
        json.put("obj", activitys);
        json.put("curPage", search.getPageNo());
//        json.put("totalPage",  activitys.isEmpty() ? 1 : activitys.getPages());
        json.put("totalPage",  1);
        return json;
    }
    
    
    /**
     * 新增学年学期
     * @param activity
     * @param request
     * @return
     */
    @RequestMapping("/insertYearTerm")
    @ResponseBody
    public JsonResult insertYearTerm(HttpServletRequest request) {
    	yearTermService.insertYearTerm();
    	return  JsonResult.success("学年学期新增成功");
    }
    
    /**
     * 设置为当前学年学期
     * @param activity
     * @param request
     * @return
     */
    @RequestMapping("/setCurrentYear")
    @ResponseBody
    public JsonResult setCurrentYear(String yearTermKey,HttpServletRequest request) {
    	yearTermService.setCurrentYear(yearTermKey);
    	return  JsonResult.success("当前学年学期设置成功");
    }
     
}
