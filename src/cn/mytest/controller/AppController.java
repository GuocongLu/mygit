package cn.mytest.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.mytest.service.AppinfoService;
import cn.mytest.util.Page;

@Controller
@RequestMapping(value="/app")
public class AppController {

	 @Resource
	 private AppinfoService appinfoService;
	 private Page page = new Page();
	 
	 @RequestMapping(value="/appQuery")
	 public String appQuery(@RequestParam(value="appDescribe",required=false)String appDescribe,
			 @RequestParam(value="curPage",required=false)String curPage,HttpSession session,Model model) throws Exception{
		 page.setTotalCount(appinfoService.getAppCount(appDescribe));
		 page.setCurPage(Integer.parseInt(curPage));
		 model.addAttribute("appinfoList",  appinfoService.getAppInfoList(appDescribe, page.getCurPage(), page.getPageSize()));
		 model.addAttribute("page",page);
		 model.addAttribute("appDescribe", appDescribe);
		 model.addAttribute("user", session.getAttribute("userSession"));
		 return "/main";
	 }
}
