<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>用户登录测试</h3>
<form method="post" action="${pageContext.request.contextPath}/user/loginCheck">
<div class="info" style="color:red">${exception.message}&nbsp;</div>
     用户名：<input name = "userName" type="text" /><br/>
     密码：<input name = "password" type="password" ><br/>
     
     <input type="submit" id="button" value="登录">&nbsp;<input type="reset" value="重置">
</form>
</body>
</html>