package com.hz.business.systemMng.base.dao;

import com.hz.business.systemMng.base.pojo.UserPO;
import com.hz.business.systemMng.base.pojo.UserPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPOMapper {
    int countByExample(UserPOExample example);

    int deleteByExample(UserPOExample example);

    int deleteByPrimaryKey(String userKey);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    List<UserPO> selectByExample(UserPOExample example);
    
    List<UserPO> selectAllInfoByExample(UserPOExample example);

    UserPO selectByPrimaryKey(String userKey);

    int updateByExampleSelective(@Param("record") UserPO record, @Param("example") UserPOExample example);

    int updateByExample(@Param("record") UserPO record, @Param("example") UserPOExample example);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);
}