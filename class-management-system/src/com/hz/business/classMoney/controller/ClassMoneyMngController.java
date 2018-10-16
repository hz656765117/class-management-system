package com.hz.business.classMoney.controller;

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
import com.hz.base.utils.User;
import com.hz.business.base.controller.BaseController;
import com.hz.business.base.model.JsonResult;
import com.hz.business.base.model.SearchParam;
import com.hz.business.basicDataMng.base.pojo.AcademyPO;
import com.hz.business.basicDataMng.base.pojo.ClassPO;
import com.hz.business.basicDataMng.base.pojo.StudentPO;
import com.hz.business.basicDataMng.service.ClassAcademyService;
import com.hz.business.basicDataMng.service.ClassService;
import com.hz.business.basicDataMng.service.StudentService;
import com.hz.business.classMoney.base.pojo.ClassMoney;
import com.hz.business.classMoney.service.ClassMoneyService;


@Controller
@RequestMapping("/classMoney")
public class ClassMoneyMngController extends BaseController{
	
	@Autowired
	public ClassMoneyService classMoneyService;
	@Autowired
	public StudentService studentService;
	@Autowired
	public ClassService classService;
	
	/**
	 * 收入和支出页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		model.addAttribute("type", User.getUserType(request));
		return  "classMoney/jsp/index" ;
	}
	
	/**
	 * 如果 是学生 就只查询这个班级的数据，如果是管理员和教师就查询所有的数据
	 * @param search
	 * @param request
	 * @return
	 */
    @RequestMapping("listClassMoney")
    @ResponseBody
    public Map<String,Object> listAccounts(@ModelAttribute("search") SearchParam search, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
        String classKey=null;
        if("3".equals(User.getUserType(request))){
        	 String studentKey=User.getUserKey(request);
             StudentPO stuPO = studentService.getStudentById(studentKey);
             classKey = stuPO.getClassKey();
        }
       
        
        PageHelper.startPage(search.getPageNo(), search.getPageSize());
        Page<ClassMoney> activitys = (Page<ClassMoney>) classMoneyService.classMoneyListByUserId(search.getContent(),classKey);
        if(activitys.isEmpty()) {
            return json;
        }

        json.put("success", true);
        json.put("obj", activitys);
        json.put("curPage", search.getPageNo());
        json.put("totalPage",  activitys.isEmpty() ? 1 : activitys.getPages());
        return json;
    }
    
    /**
     * 获取创建面板
     * @param request
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/toCreateMoney")
	public String toCreateActivity(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
    	List<ClassPO> list=classService.classListByMajorKey(null);
		model.addAttribute("classList", list);
    	return  "classMoney/jsp/createMoney" ;
	}
    
    /**
     * 插入信息
     * @param activity
     * @param request
     * @return
     */
    @RequestMapping("/insertClassMoney")
    @ResponseBody
    public JsonResult insertActivity(ClassMoney po, HttpServletRequest request) {
    	classMoneyService.insertClassMoney(po);
        return JsonResult.success("班费新增成功", po);
    }
    
    /**
     * 获取修改面板
     * @param request
     * @param id
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/toUpdateClassMoney")
	public String toupdateActivity(HttpServletRequest request,String classMoneyKey ,HttpServletResponse response,Model model) throws IOException{
    	ClassMoney classMoney = classMoneyService.getClassMoneyById(classMoneyKey);
    	model.addAttribute("classMoney", classMoney);
//    	 ClassPO classPO=classService.getClassById(classMoney.getClassKey());
//         model.addAttribute("classPO", classPO);
    	List<ClassPO> list=classService.classListByMajorKey(null);
		model.addAttribute("classList", list);
    	return  "classMoney/jsp/createMoney" ;
	}
    
    /**
     * 保存修改信息
     * @param activity
     * @param request
     * @return
     */
    @RequestMapping("updateClassMoney")
    @ResponseBody
    public JsonResult updateActivity(ClassMoney po, HttpServletRequest request) {
    	classMoneyService.updateClassMoney(po);
        return JsonResult.success("班费修改成功", po);
    }
	
    /**
     * 删除信息
     * @param keyArr
     * @param request
     * @return
     */
    @RequestMapping("deleteClassMoney")
    @ResponseBody
    public JsonResult deleteActivity(String keyArr, HttpServletRequest request) {
    	String ids =keyArr;
    	classMoneyService.delClassMoney(ids);
        return JsonResult.success("班费信息删除成功");
    }
    
    
    /**
	 * 班级账单的面板
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/indexClass")
	public String toindexClass(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		return  "classMoney/jsp/indexClass" ;
	}
	
    @RequestMapping("listIndexClassMoney")
    @ResponseBody
    public Map<String,Object> listIndexClassMoney(@ModelAttribute("search") SearchParam search, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
        
//        PageHelper.startPage(search.getPageNo(), search.getPageSize());
//        Page<ClassPO> activitys = (Page<ClassPO>) classService.selectClassMoneyList(search.getContent());
//        if(activitys.isEmpty()) {
//            return json;
//        }
        String classKey=null;
        if("3".equals(User.getUserType(request))){
        	 String studentKey=User.getUserKey(request);
             StudentPO stuPO = studentService.getStudentById(studentKey);
             classKey = stuPO.getClassKey();
        }
        List<ClassPO> activitys = (List<ClassPO>) classService.selectClassMoneyList(search.getContent());
        
        json.put("success", true);
        json.put("obj", activitys);
        json.put("curPage", search.getPageNo());
//        json.put("totalPage",  activitys.isEmpty() ? 1 : activitys.getPages());
        json.put("totalPage",  1);
        return json;
    }
	
     
}
