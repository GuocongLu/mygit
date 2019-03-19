package cn.mytest.dao;

import org.apache.ibatis.annotations.Param;
import cn.mytest.pojo.Users;

public interface UserMapper {

	//用户登录验证
	public Users findUserByUserName(@Param("userName")String userName);
	
	
	
}