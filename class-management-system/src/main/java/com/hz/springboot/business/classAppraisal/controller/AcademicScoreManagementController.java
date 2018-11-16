package com.hz.springboot.business.classAppraisal.controller;


import com.hz.springboot.base.page.Page;
import com.hz.springboot.base.page.PageHelper;
import com.hz.springboot.business.base.controller.BaseController;
import com.hz.springboot.business.base.model.JsonResult;
import com.hz.springboot.business.base.model.SearchParam;
import com.hz.springboot.business.basicDataMng.base.pojo.ClassPO;
import com.hz.springboot.business.basicDataMng.base.pojo.StudentPO;
import com.hz.springboot.business.basicDataMng.service.ClassService;
import com.hz.springboot.business.basicDataMng.service.StudentService;
import com.hz.springboot.business.classAppraisal.base.pojo.StuScore;
import com.hz.springboot.business.classAppraisal.base.pojo.StudentCourseScore;
import com.hz.springboot.business.classAppraisal.service.AcademicScoreService;
import com.hz.springboot.business.classAppraisal.service.StudentScoreService;
import com.hz.springboot.business.studyMng.service.CourseService;
import com.hz.springboot.business.systemMng.base.pojo.YearTermPO;
import com.hz.springboot.business.systemMng.service.YearTermService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

 
 

/**
 * 综合测评管理
 * @author huangzhuo
 *
 * @version 创建时间： 2017-4-11 下午9:27:55
 */
@Controller
@RequestMapping("/academicScore")
public class AcademicScoreManagementController extends BaseController {
	
 
	
	@Autowired
	public CourseService courseService;
	
	@Autowired
	public StudentService studentService;
	
	@Autowired
	public StudentScoreService studentScoreService;
	
	@Autowired
	public YearTermService yearTermService;
	
	@Autowired
	public ClassService classService;
	
	@Autowired
	public AcademicScoreService academicScoreService;
 
	/**
	 * 跳转到综合测评管理列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model  ) throws IOException{
    	List<YearTermPO>  years = yearTermService.yearTermListByUserId(null);
    	List<ClassPO> classes = classService.listAllClass();
    	model.addAttribute("years", years);
    	model.addAttribute("classes", classes);
		return  "academicScore/jsp/index" ;
	}
	
	
	@RequestMapping("setAcademicScore")
    @ResponseBody
    public Map<String,Object> setAcademicScore1(@ModelAttribute("search") SearchParam search  , HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
    	boolean flag = false;
    	
        flag =  setAcademicScore();
        
        json.put("success",flag);
        return json;
    }
	
	@Transactional
	public boolean setAcademicScore(){
		YearTermPO  curYear = yearTermService.getYearTermById(); 
        List<StudentPO> allStudents = studentService.ListAllstudent();
        for ( StudentPO stu : allStudents) {
        	StuScore stuScore = academicScoreService.getByYearIdAndPersonId(curYear.getYearTermKey(), stu.getStudentKey());
        	Map<String, Object> map = new HashMap<String ,Object>();
            map.put("studentId", stu.getStudentKey());
            map.put("yearId", curYear.getYearTermKey());
            List<StudentCourseScore>  curYearStuScore = studentScoreService.list(map);
            Double stuAllScore = 0.0;
            Double sportsScore = 0.0;
            boolean haveSports = false ;
            for ( StudentCourseScore curScore : curYearStuScore) {
            	if ( curScore.getCourseName().contains("体育") ) {//如果课程为体育  放到体育成绩里
            		sportsScore = curScore.getScore();
            		haveSports = true;
            	}else {
            		stuAllScore = stuAllScore + curScore.getScore() ;
            	}
            }
            stuScore.setSportsScore(sportsScore);
            Double academicScore = 0.0;
            if (stuAllScore > 0) {
            	int courseSize = haveSports ? curYearStuScore.size() -1 : curYearStuScore.size(); //如果课程内包含体课  则计算平均分时排除体育库
            	academicScore = (stuAllScore /courseSize) * 0.7;
            }
            stuScore.setAcademicScore(academicScore);
            stuScore.setPersonId(stu.getStudentKey());
            stuScore.setYearId(curYear.getYearTermKey());
            stuScore.setClassId(stu.getClassKey());
            
            if (stuScore.getId() != null) {
            	academicScoreService.update(stuScore);
            }else {
            	academicScoreService.insert(stuScore);
            }
            
        }
        
        List<StuScore>  list = academicScoreService.listByYearIdOrderByAcademicDesc(curYear.getYearTermKey());
        
        for (  int i = 0 ; i < list.size(); i++) {
        	StuScore curStuScore = list.get(i);
        	curStuScore.setAcademicScoreSeq(i+1);
        	academicScoreService.update(curStuScore);
        }
		return true;
	}
	
	
	 
    @RequestMapping("listAcademicScores")
    @ResponseBody
    public Map<String,Object> listAcademicScores(@ModelAttribute("search") SearchParam search  , HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
        YearTermPO  curYear = yearTermService.getYearTermById(); 
        
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("yearId", curYear.getYearTermKey());
        
        if(  StringUtils.isNotBlank(search.getClassId()) && !"0".equals(search.getClassId())){
        	map.put("classId", search.getClassId());
        }
        
        PageHelper.startPage(search.getPageNo(), search.getPageSize());
//        Page<StuScore>  list = (Page<StuScore>)  academicScoreService.listByYearIdOrderByAcademicDesc(curYear.getYearTermKey());
        Page<StuScore> list = (Page<StuScore>)  academicScoreService.listStuScore(map);
        if(list.isEmpty()) {
            return json;
        }
        
        json.put("success", true);
        json.put("obj", list);
        json.put("curPage", search.getPageNo());
        json.put("totalPage",  list.isEmpty() ? 1 : list.getPages());
        return json;
    }
 
    
    @RequestMapping("updateNotAcademicScore")
    @ResponseBody
    public Map<String,Object> updateNotAcademicScore(@ModelAttribute("search") SearchParam search  ,Integer id, Double notAScore, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
    	
    	StuScore  stuScore =academicScoreService.getById(id);
    	stuScore.setNotAcademicScore(notAScore);
    	stuScore.setTotalScore(stuScore.getAcademicScore()+notAScore);
    	
    	academicScoreService.update(stuScore);
        json.put("success",true);
        return json;
    }
    
 
    @RequestMapping("/toUpdateNotAcademicScore")
	public String toUpdateNotAcademicScore(HttpServletRequest request ,HttpServletResponse response,Model model,Integer id,String personId) throws IOException{
        YearTermPO  curYear = yearTermService.getYearTermById(); 
    	
    	 Map<String,Object> map = new HashMap<String,Object>();
    	 map.put("id", id);
//         map.put("studentId", personId);
         List<StuScore>  list =    academicScoreService.listStuScore(map);
    	
        model.addAttribute("stuScore", ( list != null && list.size() > 0) ? list.get(0) : new StuScore()) ;
    	
//    	model.addAttribute("curYear", curYear);
    	return  "academicScore/jsp/updateStuScore" ;
	}
    
 
    
 
    @RequestMapping("insertStudentScore")
    @ResponseBody
    public JsonResult insertStudentScore(StudentCourseScore studentCourseScore, HttpServletRequest request) {
    	if(studentCourseScore.getScore() > 100 || studentCourseScore.getScore() < 0){
    		 return JsonResult.failure("分数只能是0-100的整数");
    	}
    	StudentPO  student = studentService.getStudentById(studentCourseScore.getStudentId());
    	studentCourseScore.setClassId(student.getClassKey());
    	studentScoreService.insert(studentCourseScore);
        return JsonResult.success("新增成功", studentCourseScore);
    }
    
    
    @RequestMapping("deleteStudentScore")
    @ResponseBody
    public JsonResult deleteStudentScore(Integer[] keyArr, HttpServletRequest request) {
    	String ids = StringUtils.join(keyArr, ",");
    	studentScoreService.delete(ids);
        return JsonResult.success(true);
    }
	
     
}
