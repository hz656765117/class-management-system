package com.hz.springboot.business.studyMng.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.hz.springboot.base.page.Page;
import com.hz.springboot.base.page.PageHelper;
import com.hz.springboot.base.utils.User;
import com.hz.springboot.business.base.controller.BaseController;
import com.hz.springboot.business.base.model.JsonResult;
import com.hz.springboot.business.base.model.SearchParam;
import com.hz.springboot.business.basicDataMng.base.pojo.StudentPO;
import com.hz.springboot.business.basicDataMng.base.pojo.TeacherPO;
import com.hz.springboot.business.basicDataMng.service.StudentService;
import com.hz.springboot.business.basicDataMng.service.TeacherService;
import com.hz.springboot.business.studyMng.base.pojo.EvaluateOptionPO;
import com.hz.springboot.business.studyMng.base.pojo.EvaluatePO;
import com.hz.springboot.business.studyMng.service.EvalStuOptionsService;
import com.hz.springboot.business.studyMng.service.EvalStuService;
import com.hz.springboot.business.studyMng.service.EvaluateOptionService;
import com.hz.springboot.business.studyMng.service.EvaluateService;
import com.hz.springboot.business.systemMng.base.pojo.YearTermPO;
import com.hz.springboot.business.systemMng.service.YearTermService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping("/studyMng/evaluate")
public class EvaluateController extends BaseController {
	
	@Autowired
	public EvaluateService evaluateService;
	@Autowired
	public EvaluateOptionService evaluateOptionService;
	@Autowired
	public YearTermService yearTermService;
	@Autowired
	public TeacherService teacherService;
	@Autowired
	public StudentService studentService;
	@Autowired
	public EvalStuService evalStuService;
	@Autowired
	public EvalStuOptionsService evalStuOptionsService;
	
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		return  "studyMng/evaluate/jsp/index" ;
	}
	
    @RequestMapping("listevaluateMng")
    @ResponseBody
    public Map<String,Object> listAccounts(@ModelAttribute("search") SearchParam search, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
   
//        PageHelper.startPage(search.getPageNo(), search.getPageSize());
//        Page<EvaluatePO> activitys = (Page<EvaluatePO>) evaluateService.selectListByUserId(search.getContent());
//        if(activitys.isEmpty()) {
//            return json;
//        }
        List<EvaluatePO> activitys=evaluateService.selectListByUserId(search.getContent());
        json.put("success", true);
        json.put("obj", activitys);
        json.put("curPage", search.getPageNo());
//        json.put("totalPage",  activitys.isEmpty() ? 1 : activitys.getPages());
        json.put("totalPage",  activitys.isEmpty() ? 1 : activitys.size());
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
    @RequestMapping("/toCreateEvaluate")
	public String toCreateEvaluate(String evaluateKey,HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
    	List<EvaluateOptionPO> list=new ArrayList<EvaluateOptionPO>();
    	//获取信息
    	EvaluatePO evaluatePO=evaluateService.getEvaluateById(evaluateKey);
    	if(evaluatePO==null){
    		evaluatePO=new EvaluatePO();
    		evaluatePO.setEvaluateKey(UUID.randomUUID().toString());
    		YearTermPO yearTermPO = yearTermService.getYearTermById();
    		evaluatePO.setYearTermKey(yearTermPO.getYearTermKey());
    	}else{
    		list=evaluateOptionService.selectListByUserId(evaluateKey);
    	}
    	model.addAttribute("evaluatePO", evaluatePO);
    	model.addAttribute("list", list );
    	return  "studyMng/evaluate/jsp/createEvaluate" ;
	}
    /**
     * 删除信息
     * @param keyArr
     * @param request
     * @return
     */
    @RequestMapping("deleteEvaluate")
    @ResponseBody
    public JsonResult deleteEvaluate(String[] keyArr, HttpServletRequest request) {
    	String ids = StringUtils.join(keyArr, ",");
    	evaluateService.deleteInfoById(ids);
        return JsonResult.success("教材信息删除成功");
    }
    
    /**
     * 插入信息
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
	@RequestMapping("/insertEvaluate")
    @ResponseBody
    public JsonResult insertActivity(String poStr,String optionListStr, HttpServletRequest request) {
        Map<String,Object> map=(Map<String, Object>) JSONUtils.parse(poStr);
        List<Map<String,Object>> list=(List<Map<String, Object>>) JSONUtils.parse(optionListStr);
        evaluateService.insertEvaluatePO(map);
        evaluateOptionService.insertEvaluateOptionsPO(list);
        return JsonResult.success("教学评价新增成功", "");
    }
    
    /**
     * 学生评教首页
     * @param request
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/stuIndex")
	public String tostuIndex(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		return  "studyMng/evaluate/jsp/stuIndex" ;
	}
    
    /**
     * 获取当前学生评教列表数据
     * @param request
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/toCreateStuTeacher")
	public String toCreateStuTeacher(String evaluateKey,String teacherKey,String studentKey,HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
    	//获取信息
    	EvaluatePO evaluatePO=evaluateService.getEvaluateById(evaluateKey);
    	List<EvaluateOptionPO> list=evaluateOptionService.selectListByUserId(evaluateKey);
    	TeacherPO teacherPO = teacherService.getTeacherById(teacherKey);
    	model.addAttribute("evaluatePO", evaluatePO);
    	model.addAttribute("list", list);
    	model.addAttribute("teacherPO", teacherPO);
    	model.addAttribute("studentKey", studentKey);
    	return  "studyMng/evaluate/jsp/setStuTeacher" ;
	}
	
    /**
     * 插入学生评教信息
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
	@RequestMapping("/insertStuEval")
    @ResponseBody
    public JsonResult insertStuEval(String eavlStuStr,String stuOptionStr, HttpServletRequest request) {
        Map<String,Object> map=(Map<String, Object>) JSONUtils.parse(eavlStuStr);
        List<Map<String,Object>> list=(List<Map<String, Object>>) JSONUtils.parse(stuOptionStr);
        String evalStuKey=UUID.randomUUID().toString();
        evalStuService.insertEvaluatePO(map, evalStuKey);
        evalStuOptionsService.insertEvalStuOptionsPO(list, evalStuKey);
        return JsonResult.success("学社评教完成", "");
    }
    
    /**
     * 学生评教首页
     * @param request
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/teaIndex")
	public String toteaIndex(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		return  "studyMng/evaluate/jsp/teaIndex" ;
	}
    
    /**
     * 获取教师评教列表数据
     * @param request
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/toTeacherEval")
	public String toTeacherEval(String evaluateKey,String teacherKey,String studentKey,HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
    	//获取信息
    	EvaluatePO evaluatePO=evaluateService.getEvaluateById(evaluateKey);
    	List<EvaluateOptionPO> list=evaluateOptionService.selectStuOptionAndScore(evaluateKey,studentKey,teacherKey);
    	StudentPO studentPO = studentService.getStudentById(studentKey);
    	model.addAttribute("evaluatePO", evaluatePO);
    	model.addAttribute("list", list);
    	model.addAttribute("studentPO", studentPO);
    	return  "studyMng/evaluate/jsp/showTeacherEval" ;
	}
	
    /**
     * 学生展示评教活动
     * @param search
     * @param request
     * @return
     */
    @RequestMapping("listStuEval")
    @ResponseBody
    public Map<String,Object> listStuEval(@ModelAttribute("search") SearchParam search, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
   
        String studentKey= User.getUserKey(request);
        PageHelper.startPage(search.getPageNo(), search.getPageSize());
        Page<EvaluatePO> activitys = (Page<EvaluatePO>) evaluateService.selectStuEvalList(search.getContent(),studentKey);
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
     * 教师展示评教结果
     * @param search
     * @param request
     * @return
     */
    @RequestMapping("listTeaEval")
    @ResponseBody
    public Map<String,Object> listTeaEval(@ModelAttribute("search") SearchParam search, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
   
        PageHelper.startPage(search.getPageNo(), search.getPageSize());
        Page<EvaluatePO> activitys = (Page<EvaluatePO>) evaluateService.selectTeaEvalList(search.getContent());
        if(activitys.isEmpty()) {
            return json;
        }
        json.put("success", true);
        json.put("obj", activitys);
        json.put("curPage", search.getPageNo());
        json.put("totalPage",  activitys.isEmpty() ? 1 : activitys.getPages());
        return json;
    }
}
