package com.hz.springboot.business.classActivity.base.dao;



import com.hz.springboot.business.classActivity.base.pojo.ClassActivity;
import com.hz.springboot.business.classActivity.base.pojo.ClassActivityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ClassActivityMapper {
    int countByExample(ClassActivityExample example);

	int deleteByExample(ClassActivityExample example);

	int deleteByPrimaryKey(Integer activityKey);

	int insert(ClassActivity record);

	int insertSelective(ClassActivity record);

	List<ClassActivity> selectByExample(ClassActivityExample example);

	ClassActivity selectByPrimaryKey(Integer activityKey);

	int updateByExampleSelective(@Param("record") ClassActivity record,
                                 @Param("example") ClassActivityExample example);

	int updateByExample(@Param("record") ClassActivity record,
                        @Param("example") ClassActivityExample example);

	int updateByPrimaryKeySelective(ClassActivity record);

	int updateByPrimaryKey(ClassActivity record);


	List<ClassActivity> listClassActivity(Map<String, Object> map);
}