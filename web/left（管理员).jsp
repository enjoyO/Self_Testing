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
<title>管理控制</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>管理员登录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>用户管理
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="/getAllStudents.action" target="rightFrame">用户信息</a><i></i></li>
        <li><cite></cite><a href="/getAllAnswer.action" target="rightFrame">用户成绩</a><i></i></li>
        </ul>    
    </dd>
    
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>自测管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="/getAllSubject.action" target="rightFrame">自测课程</a><i></i></li>
        <li><cite></cite><a href="/getAllPapers.action" target="rightFrame">自测试卷</a><i></i></li>
        <li><cite></cite><a href="/toPaperMan.action" target="rightFrame">自测试题</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="images/leftico02.png" /></span>留言管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="/getAllMessages.action" target="rightFrame">留言信息</a><i></i></li>
    </ul>
    
    </dd>   
    
    </dl>
    
</body>
</html>
