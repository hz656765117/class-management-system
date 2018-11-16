package com.hz.springboot.business.classActivity.service;

import com.hz.springboot.business.classActivity.base.pojo.ClassActivity;

import java.util.List;
import java.util.Map;


 
public interface ClassActivityService {
	 
	ClassActivity insertActivity(ClassActivity activity);
	 
	List<ClassActivity> activityListByUserId(String userId);
	
	boolean delClassActivity(String ids);
	
	boolean updateClassActivity(ClassActivity classActivity);
	
	ClassActivity getActivityById(Integer id);
	
	List<ClassActivity> listactivityList(Map<String, Object> map);
	
	 
}
