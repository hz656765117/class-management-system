package com.hz.springboot.business.basicDataMng.controller;

import com.hz.springboot.business.base.controller.BaseController;
import com.hz.springboot.business.base.model.JsonResult;
import com.hz.springboot.business.base.model.SearchParam;
import com.hz.springboot.business.basicDataMng.base.pojo.AcademyPO;
import com.hz.springboot.business.basicDataMng.base.pojo.ClassPO;
import com.hz.springboot.business.basicDataMng.base.pojo.MajorPO;
import com.hz.springboot.business.basicDataMng.base.pojo.StudentPO;
import com.hz.springboot.business.basicDataMng.service.ClassAcademyService;
import com.hz.springboot.business.basicDataMng.service.ClassMajorService;
import com.hz.springboot.business.basicDataMng.service.ClassService;
import com.hz.springboot.business.basicDataMng.service.StudentService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
@RequestMapping("/basicDataMng/studentMng")
public class StudentMngController extends BaseController {
	
	@Autowired
	public ClassAcademyService classAcademyService;
	@Autowired
	public ClassMajorService classMajorService;
	@Autowired
	public ClassService classService;
	@Autowired
	public StudentService studentService;
	
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		return  "basicDataMng/studentMng/jsp/index" ;
	}
	
    @RequestMapping("listStudentMng")
    @ResponseBody
    public Map<String,Object> listAccounts(@ModelAttribute("search") SearchParam search, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
   
//        PageHelper.startPage(search.getPageNo(), search.getPageSize());
//        Page<StudentPO> activitys = (Page<StudentPO>) studentService.studentListByUserId(search.getContent());
//        if(activitys.isEmpty()) {
//            return json;
//        }

        List<StudentPO> activitys = (List<StudentPO>) studentService.studentListByUserId(search.getContent());
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
    @RequestMapping("/toCreateStudent")
	public String toCreateActivity(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
    	List<AcademyPO> list=classAcademyService.academyListByUserId(null);
		model.addAttribute("academyList", list);
    	return  "basicDataMng/studentMng/jsp/createStudent" ;
	}
    
    /**
     * 插入信息
     * @param request
     * @return
     */
    @RequestMapping("/insertStudent")
    @ResponseBody
    public JsonResult insertStudent(StudentPO studentPO, HttpServletRequest request) {
        studentService.insertClass(studentPO);
        return JsonResult.success("信息新增成功", studentPO);
    }
    
    /**
     * 获取修改面板
     * @param request
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/toUpdateStudent")
	public String toUpdateStudent(HttpServletRequest request,String studentKey ,HttpServletResponse response,Model model) throws IOException{
    	List<AcademyPO> list=classAcademyService.academyListByUserId(null);
    	StudentPO studentPO = studentService.getStudentByStuKey(studentKey);
    	model.addAttribute("academyList", list);
    	model.addAttribute("student", studentPO);
    	return  "basicDataMng/studentMng/jsp/createStudent" ;
	}
    
    /**
     * 保存修改信息
     * @param request
     * @return
     */
    @RequestMapping("updateStudent")
    @ResponseBody
    public JsonResult updateActivity(StudentPO studentPO, HttpServletRequest request) {
        studentService.updateStudentInfo(studentPO);
        return JsonResult.success("学生信息修改成功", studentPO);
    }
	
    /**
     * 删除信息
     * @param keyArr
     * @param request
     * @return
     */
    @RequestMapping("deleteStudent")
    @ResponseBody
    public JsonResult deleteActivity(String[] keyArr, HttpServletRequest request) {
    	String ids = StringUtils.join(keyArr, ",");
    	studentService.delStudentInfo(ids);
        return JsonResult.success("学生信息删除成功");
    }
	
    
    /**
     * 根据学院主键获取专业信息
     * @param request
     * @return
     */
    @RequestMapping("majorList")
    @ResponseBody
    public JsonResult majorList(String academyKey, HttpServletRequest request) {
    	List<MajorPO> list=classMajorService.majorListByAcademyKey(academyKey);
        return JsonResult.success(list);
    }
    /**
     * 根据专业主键获取班级信息
     * @param request
     * @return
     */
    @RequestMapping("classList")
    @ResponseBody
    public JsonResult classList(String majorKey, HttpServletRequest request) {
    	List<ClassPO> list=classService.classListByMajorKey(majorKey);
        return JsonResult.success(list);
    }
}
