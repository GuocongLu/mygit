package cn.mytest.service;

import cn.mytest.pojo.Users;

public interface UserService {

	public Users findUserByUserName(String userName ,String password) throws Exception;
}
