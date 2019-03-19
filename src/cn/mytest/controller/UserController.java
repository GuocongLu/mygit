package cn.mytest.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.mytest.pojo.Users;
import cn.mytest.service.AppinfoService;
import cn.mytest.service.UserService;
import cn.mytest.util.Constant;
import cn.mytest.util.Page;

@Controller
@RequestMapping(value="/user")
public class UserController {
    @Resource
    private UserService userServcie;
    @Resource
	private AppinfoService appinfoService;
    private Page page = new Page();
    
    //用户登录验证
    @RequestMapping(value="/loginCheck")
    public String loginCheck(@RequestParam(value="userName")String userName,
    		                 @RequestParam(value="password")String password,HttpSession session,Model model) throws Exception{
    	 Users user = userServcie.findUserByUserName(userName, null);
    	 if(user != null){
    		if(user.getPassword().equals(password)){
    			 session.setAttribute(Constant.USER_SESSION, user);
    			 page.setTotalCount(appinfoService.getAppCount(null));
    			 page.setCurPage(1);
    			 model.addAttribute("page", page);
    			 model.addAttribute("appinfoList",appinfoService.getAppInfoList(null, 1, page.getPageSize()));
    			 model.addAttribute("user", user);
    			 return "/main";
    		}else{
    			throw new RuntimeException("密码错误!");
    		}
    	}else{
    		throw new RuntimeException("用户名不存在!");
    	}
    }
	 
}
