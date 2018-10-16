package com.hz.business.classActivity.service;

import java.util.List;
import java.util.Map;

import com.hz.business.classActivity.base.pojo.ClassActivity;

 
public interface ClassActivityService {
	 
	ClassActivity insertActivity(ClassActivity activity);
	 
	List<ClassActivity> activityListByUserId(String userId );
	
	boolean delClassActivity(String ids);
	
	boolean updateClassActivity(ClassActivity classActivity);
	
	ClassActivity getActivityById(Integer id);
	
	List<ClassActivity> listactivityList(Map<String , Object> map);
	
	 
}
