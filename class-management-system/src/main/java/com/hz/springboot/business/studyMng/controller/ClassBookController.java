package com.hz.springboot.business.studyMng.controller;

import com.hz.springboot.base.utils.User;
import com.hz.springboot.business.base.controller.BaseController;
import com.hz.springboot.business.base.model.JsonResult;
import com.hz.springboot.business.base.model.SearchParam;
import com.hz.springboot.business.studyMng.base.pojo.ClassBookPO;
import com.hz.springboot.business.studyMng.service.ClassBookService;
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
@RequestMapping("/studyMng/classBook")
public class ClassBookController extends BaseController {

    @Autowired
    public ClassBookService classBookService;
	
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		model.addAttribute("type", User.getUserType(request));
		return  "studyMng/classBook/jsp/index" ;
	}
	
    @RequestMapping("listClassBookMng")
    @ResponseBody
    public Map<String,Object> listAccounts(@ModelAttribute("search") SearchParam search, HttpServletRequest request) {
    	Map<String,Object> json = new HashMap<>();
        json.put("success", false);
   
//        PageHelper.startPage(search.getPageNo(), search.getPageSize());
//        Page<ClassBookPO> activitys = (Page<ClassBookPO>) classBookService.selectListByUserId(search.getContent());
//        if(activitys.isEmpty()) {
//            return json;
//        }

        List<ClassBookPO> activitys = (List<ClassBookPO>) classBookService.selectListByUserId(search.getContent());
        json.put("success", true);
        json.put("obj", activitys);
        json.put("curPage", search.getPageNo());
//        json.put("totalPage",  activitys.isEmpty() ? 1 : activitys.getPages());
        json.put("totalPage", 1);
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
    @RequestMapping("/toCreateClassBook")
	public String toCreateClassBook(HttpServletRequest request ,HttpServletResponse response,Model model) throws IOException{
		return  "studyMng/classBook/jsp/createClassBook" ;
	}
    
    /**
     * 插入信息
     * @param request
     * @return
     */
    @RequestMapping("/insertBook")
    @ResponseBody
    public JsonResult insertActivity(ClassBookPO po, HttpServletRequest request) {
        classBookService.insertAcademy(po);
        return JsonResult.success("教材新增成功", po);
    }
    
    /**
     * 获取修改面板
     * @param request
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/toUpdateBook")
	public String toupdateActivity(HttpServletRequest request,String classBookKey ,HttpServletResponse response,Model model) throws IOException{
    	ClassBookPO classBook = classBookService.getClassBookById(classBookKey);
    	model.addAttribute("classBook", classBook);
    	return  "studyMng/classBook/jsp/createClassBook" ;
	}
    
    /**
     * 保存修改信息
     * @param request
     * @return
     */
    @RequestMapping("updateBook")
    @ResponseBody
    public JsonResult updateActivity(ClassBookPO po, HttpServletRequest request) {
        classBookService.updateClassBook(po);
        return JsonResult.success("教材修改成功", po);
    }
	
    /**
     * 删除信息
     * @param keyArr
     * @param request
     * @return
     */
    @RequestMapping("deleteBook")
    @ResponseBody
    public JsonResult deleteActivity(String[] keyArr, HttpServletRequest request) {
    	String ids = StringUtils.join(keyArr, ",");
    	classBookService.delClassClassBook(ids);
        return JsonResult.success("教材信息删除成功");
    }
	
     
}
