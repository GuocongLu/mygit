package cn.mytest.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.mytest.pojo.Users;
import cn.mytest.util.Constant;



public class SysIntercepter extends HandlerInterceptorAdapter{
	 private Logger logger=Logger.getLogger(SysIntercepter.class);
	    @Override
		public boolean preHandle(HttpServletRequest request,
				HttpServletResponse response, Object handler) throws Exception {
	    	   logger.debug("执行preHandle方法");
	           HttpSession session=request.getSession();
	           if(request.getRequestURI().indexOf("login") > -1){
	        	       return true;
	           }
	           Users duser= (Users)session.getAttribute(Constant.USER_SESSION);
	           if(null == duser){
	        	       response.sendRedirect(request.getContextPath()+"/403.jsp");
	        	       return false;
	           }else if(duser!=null&&request.getRequestURI().indexOf("main")>-1){
		        	   response.sendRedirect(request.getContextPath()+"/403.jsp");
		           	   return false;  
	           } 
	           return true;
		}
}
