<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body >
<div style="font-size: 15px;">
        <h3>${user.userName}》》》》欢迎您，登录成功！</h3>
   <form method="post" action="${pageContext.request.contextPath }/app/appQuery">
      <input type="hidden" name="curPage" value="1">
               软件描述：<input type="text" name="appDescribe" value="${appDescribe }">&nbsp;&nbsp;&nbsp;<input type="submit" value="查询"><br/>
     <p></p>
      <table style="font-size:13px;color:black;text-align: center;" border="1px">
              <tr>
                 <th width="20%">软件发行号</th>
                 <th width="20%">APK名称</th>
                 <th width="20%">软件描述</th>
                 <th width="20%">添加日期</th>
                 <th width="20%">修改日期</th>
              </tr>
              <c:forEach var="appinfo" items="${appinfoList }">
                 <tr style="height:40px;border:1px solid #D0D0D0;">
                    <td>${appinfo.appCode }</td>
                    <td>${appinfo.appName }</td>
                    <td>${appinfo.appDescribe }</td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${appinfo.addDate }" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${appinfo.modifyDate }" /></td>
                 </tr>
              </c:forEach>
          </table>  
				<span>共${page.totalCount }条记录&nbsp;&nbsp; ${page.curPage }/${page.totalPageCount }页</span>
				<c:if test="${page.curPage > 1}">
					<a href="javascript:page_nav(document.forms[0],1);">首页</a>
					<a href="javascript:page_nav(document.forms[0],${page.curPage-1});">上一页</a>
				</c:if>
				<c:if test="${page.curPage < page.totalPageCount }">
					<a href="javascript:page_nav(document.forms[0],${page.curPage+1 });">下一页</a>
					<a href="javascript:page_nav(document.forms[0],${page.totalPageCount });">最后一页</a>
				</c:if>  
			
		 <input type="hidden" name="totalpage" id="totalpage" value="${page.totalPageCount }"/>
		 <label>跳转至第</label>
	     <input type="text" name="inputPage" id="inputPage" value="${page.curPage }" />页
	     <button type="button" id="cli" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button> 
   </form>

</div>
</body>
<script src="${pageContext.request.contextPath}/WEB-INF/static/jquery.js"></script>
<script type="text/javascript" >

//点击翻页
function page_nav(form,pageNum){
      form.curPage.value=pageNum;
      form.submit();
}
//输入跳页
function jump_to(form,pageNum){
	  var reg = /^[0-9]+.?[0-9]*$/;
	  if(!reg.test(pageNum)){
		  alert("请输入数字");
	  }else{
		  if(parseInt(pageNum)<1){
	          pageNum=1;
	      }
	      if(pageNum>parseInt(document.getElementById("totalpage").value)){
	         pageNum=parseInt(document.getElementById("totalpage").value);
	      }
	      form.curPage.value=pageNum;
	      form.submit();
	  }
       
}
</script>
</html>
