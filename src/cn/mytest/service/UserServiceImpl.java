package cn.mytest.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mytest.dao.UserMapper;
import cn.mytest.pojo.Users;

@Service
public class UserServiceImpl implements UserService {
	
    @Resource
    private UserMapper userMapper;

	@Override
	public Users findUserByUserName(String userName,String password) throws Exception {
        Users user = userMapper.findUserByUserName(userName);
        if(password != null && password != ""){
        	if(user != null && user.getPassword().equals(password)){
            	return user;
            }
        }else{
        	if(user != null){
        		return user;
        	}
        }
        
		return null;
	}
    
	

}
