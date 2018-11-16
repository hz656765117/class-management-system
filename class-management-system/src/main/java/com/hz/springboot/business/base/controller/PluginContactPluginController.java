package com.hz.springboot.business.base.controller;


import com.hz.springboot.base.page.Page;
import com.hz.springboot.base.page.PageHelper;
import com.hz.springboot.base.page.Paginator;
import com.hz.springboot.business.basicDataMng.base.pojo.ClassPO;
import com.hz.springboot.business.basicDataMng.base.pojo.StudentPO;
import com.hz.springboot.business.basicDataMng.service.ClassService;
import com.hz.springboot.business.basicDataMng.service.StudentService;
import com.hz.springboot.business.base.model.Department;
import com.hz.springboot.business.base.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"plugin/contactPlugin", "contactPlugin"})
public class PluginContactPluginController extends BaseController {
	
	@Autowired
	public ClassService classService;
 
	@Autowired
	public StudentService studentService;
	
	
	/**
	 * 搜索部门与人员 过滤app可见范围
	 */
/*	@RequestMapping("search/group")
	@ResponseBody
	public JsonResult searchGroup(@RequestParam String search, @RequestParam AppId appid,
								  @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
								  @RequestParam(value = "pageSize", required = false, defaultValue = "50") Integer pageSize,
								  @RequestParam(value = "departEnable", required = false, defaultValue = "false") boolean departEnable,
								  @RequestParam(value = "tagEnable", required = false, defaultValue = "false") boolean tagEnable,
								  @RequestParam(value = "personEnable", required = false, defaultValue = "true") boolean personEnable) {

		Map<String, Object> obj = new HashMap<String, Object>();
		if (personEnable) {
			PageList<Person> personPage = contactApi.searchPersonByAppId(this.getCompanyId(), search, appid.getAppId(), Paginator.of(page, pageSize));
			obj.put("personPage", personPage);
		}

		if (page == 1) {
			if (departEnable) {
				List<Department> departments = contactApi.searchDepartByAppId(this.getCompanyId(), search, appid.getAppId());
				obj.put("departments", departments);
			}
		}

		return JsonResult.success(obj);
	}*/

	/**
	 * 兼容ZTREE  调用同一个request请求
	 *
	 * @param appid
	 * @param parent
	 * @return
	 */
	@RequestMapping(value = "listClass")
	@ResponseBody
	public JsonResult listDepart(@RequestParam(value = "pid", required = false, defaultValue = "0") Integer parent) {
		if (parent == 0) {
			return listRootDepartment();
		} else {
			return listDepartmentByParent(parent);
		}
	}

	@RequestMapping(value = "listRootDepartment")
	@ResponseBody
	public JsonResult listRootDepartment() {
		List<Department> departments = new ArrayList<Department>();
		Department dept = new Department();
		dept.setId("1");
		dept.setParentId(0);
		dept.setName("浙江中医药大学");
		departments.add(dept);
		return JsonResult.success(departments);
	}

	/**
	 * 根据父部门ID 获取子部门
	 */
	@RequestMapping(value = "listDepartmentByParent")
	@ResponseBody
	public JsonResult listDepartmentByParent(@RequestParam("parent") Integer parent) {
		List<ClassPO>  classes = classService.listAllClass();
		List<Department> departments = new ArrayList<Department>();
		Department dept = null;
		if ( classes != null && classes.size() > 0 ) {
			for (ClassPO classPo : classes) {
				dept = new Department();
				dept.setId(classPo.getClassKey());
				dept.setParentId(parent);
				dept.setName(classPo.getClassName());
				dept.setIsLeaf(true);
				departments.add(dept);
			}
			
		}
		return JsonResult.success(departments);
	}

	@RequestMapping(value = "listPersonByClass")
	@ResponseBody
	public JsonResult listPersonByDepartment(@RequestParam(value = "classId", required = false) String classId,
											 Paginator p, HttpServletRequest request) {
		PageHelper.startPage(p.getPage(), p.getPageSize());
        Page<StudentPO> students = (Page<StudentPO>) studentService.studentListByClassId(classId);
		 
		return JsonResult.success(students);
	}

	

}
