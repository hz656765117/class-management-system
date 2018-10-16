package com.hz.business.classAppraisal.controller;

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
import com.hz.business.basicDataMng.base.pojo.TeacherPO;
import com.hz.business.basicDataMng.service.TeacherService;
import com.hz.business.classActivity.base.pojo.ClassActivity;
import com.hz.business.classActivity.service.ClassActivityService;
import com.hz.business.classAppraisal.base.dao.PrizeAwardsMapper;
import com.hz.business.classAppraisal.base.pojo.PrizeApply;
import com.hz.business.classAppraisal.base.pojo.PrizeAwards;
import com.hz.business.classAppraisal.base.pojo.PrizeAwardsExample;
import com.hz.business.classAppraisal.service.PrizeApplyService;


 /**
  * 班级课程管理controller类
  * @author huangzhuo
  *
  * @version 创建时间： 2017-4-15 下午10:47:09
  */
@Controller
@RequestMapping("/classCourse")
public class ClassCourseManagementController extends BaseController{
	
	@Autowired
	public PrizeApplyService prizeApplyService;
	
	
	@Autowired
	public PrizeAwardsMapper prizeAwardsMapper;
	
	
	@Autowired
	public TeacherService teacherService;
	
 
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model,Integer type ) throws IOException{
		model.addAttribute("type", type);
		return  "classCourse/jsp/index" ;
	}
	
	/**
	 * 异步加载老师奖学金列表数据
	 * @param search
	 * @param request
	 * @return
	 */
    @RequestMapping("listPrizeApplys")
    @ResponseBody
    public Map<String,Object> listPrizeApplys(@ModelAttribute("search") SearchParam search,Integer type , HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
        String userId = "2014001";
        
        PageHelper.startPage(search.getPageNo(), search.getPageSize());
//        Page<PrizeApply> prizeApplys = (Page<PrizeApply>) prizeApplyService.prizeApplyListByAuditId(userId);
        Map<String, Object> map = new HashMap<String ,Object>();
        if ( "2".equals(user.getType()) ) {  //老师查由自己审核的 管理员查所有的
        	map.put("teacherId", user.getUserName());
        } else if ("3".equals(user.getType())) { //学生查自己申请的
        	map.put("studentId", user.getUserName());
        }
        
        map.put("type", type);
        Page<PrizeApply> prizeApplys = (Page<PrizeApply>) prizeApplyService.listApplyList(map);
        if(prizeApplys.isEmpty()) {
            return json;
        }
        
        json.put("success", true);
        json.put("obj", prizeApplys);
        json.put("curPage", search.getPageNo());
        json.put("totalPage",  prizeApplys.isEmpty() ? 1 : prizeApplys.getPages());
        return json;
    }
    
    /**
     * 学生奖学金申请列表
     * @param request
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/toStudentPrizeApplyList")
	public String toStudentPrizeApplyList(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
	 
		return  "classCourse/jsp/studentPrizeApplyList" ;
	}
    
    /**
     * 异步加载学生奖学金列表数据 
     * @param search
     * @param request
     * @return
     */
    @RequestMapping("listStudentPrizeApplys")
    @ResponseBody
    public Map<String,Object> listStudentPrizeApplys(@ModelAttribute("search") SearchParam search, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
        
        PageHelper.startPage(search.getPageNo(), search.getPageSize());
//        Page<PrizeApply> prizeApplys = (Page<PrizeApply>) prizeApplyService.prizeApplyListByAuditId(userId);
        Map<String, Object> map = new HashMap<String ,Object>();
        map.put("studentId", user.getUserName());
      //  map.put("type", value);
        Page<PrizeApply> prizeApplys = (Page<PrizeApply>) prizeApplyService.listApplyList(map);
        if(prizeApplys.isEmpty()) {
            return json;
        }
        
        json.put("success", true);
        json.put("obj", prizeApplys);
        json.put("curPage", search.getPageNo());
        json.put("totalPage",  prizeApplys.isEmpty() ? 1 : prizeApplys.getPages());
        return json;
    }
    
    
    @RequestMapping("/toPrizeApply")
	public String toCreateActivity(HttpServletRequest request ,HttpServletResponse response,Model model,Integer type) throws IOException{
    	List<TeacherPO> teachers = teacherService.listAllTeacher();
    	PrizeAwardsExample example  = new PrizeAwardsExample();
    	example.createCriteria().andDeleteFlagEqualTo(0).andTypeEqualTo(type+"");
    	List<PrizeAwards>  prizeAwards = prizeAwardsMapper.selectByExample(example);
    	model.addAttribute("teachers", teachers);
    	model.addAttribute("prizeAwards", prizeAwards);
    	model.addAttribute("type", type);
    	return  "classCourse/jsp/createPrizeApply" ;
	}
    
    @RequestMapping("insertPrizeApply")
    @ResponseBody
    public JsonResult insertActivity(PrizeApply prizeApply, HttpServletRequest request) {
    	prizeApply.setStudentId(user.getUserName());
    	prizeApplyService.insertPrizeApply(prizeApply);
        return JsonResult.success("奖学金申请新增成功", prizeApply);
    }
    
    @RequestMapping("/toUpdatePrizeApply")
	public String toUpdatePrizeApply(HttpServletRequest request,Integer id ,HttpServletResponse response,Model model,Integer type) throws IOException{
	Map<String, Object> map = new HashMap<String ,Object>();
	map.put("id", id);
	List<PrizeApply> prizeApplys =  prizeApplyService.listApplyList(map);
	model.addAttribute("type", type);
	if ( prizeApplys != null && prizeApplys.size() > 0 ) {
		model.addAttribute("prizeApply", prizeApplys.get(0));
	}else{
		model.addAttribute("prizeApply", null);
	}
    	return  "classCourse/jsp/updatePrizeApply" ;
	}
    
    @RequestMapping("/toShowPrizeApply")
	public String toShowPrizeApply(HttpServletRequest request,Integer id ,HttpServletResponse response,Model model) throws IOException{
//    	ClassActivity activity = classActivityService.getActivityById(id);
//    	model.addAttribute("activity", activity);
    	return  "classCourse/jsp/createPrizeApply" ;
	}
    
    
    @RequestMapping("updatePrizeApply")
    @ResponseBody
    public JsonResult updateActivity(PrizeApply prizeApply, HttpServletRequest request) {
    	prizeApplyService.updatePrizeApply(prizeApply);
        return JsonResult.success("修改成功");
    }
	
    @RequestMapping("deletePrizeApply")
    @ResponseBody
    public JsonResult deleteActivity(Integer[] keyArr, HttpServletRequest request) {
    	String ids = StringUtils.join(keyArr, ",");
    	prizeApplyService.delPrizeApply(ids);
        return JsonResult.success(true);
    }
	
     
}
