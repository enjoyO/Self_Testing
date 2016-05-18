<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
%>
<!-- saved from url=(0060)http://127.0.0.1/dede/login.php?gotopage=%2Fdede%2Findex.php -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>
        
    
            
    <div class="topright">    
    <ul>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="/quit.action" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
        <c:if test="${sessionScope.student.name eq null}">
            <span><c:out value="${sessionScope.admin.username}"/> </span>
        </c:if>
        <c:if test="${sessionScope.admin.username eq null}">
            <span><c:out value="${sessionScope.student.name}"/> </span>
        </c:if>
    </div>    
    
    </div>
</body>
</html>
