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
<title>进入考试</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">用户</a></li>
    <li><a href="#">进入自测</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li><span><img src="images/t04.png" /></span>进入自测</li>
        </ul>
        
        
       
    </div>
    
    
    
    <ul class="classlist">

    <c:forEach items="${requestScope.allPapers}" var="paper">
        <li>
        <span><img src="images/001.jpg" /></span>
        <div class="lright">
        <h2><c:out value="${paper.testName}"/></h2>
        <p>时间：<c:out value="${paper.times}"/><br />总题数：<c:out value="${paper.totalQuestion}"/><br /></p>
        <a href="/getPaper.action?paperId=${paper.id}" class="enter">进入自测</a>
        </div>
        </li>
    </c:forEach>

    </ul>
    
    <div class="clear"></div>
    </div>

    <script>
        $(function(){
            if(${sessionScope.student.name eq null}){
                window.location.href="login.jsp";
            }
        })
    </script>
    

</body>

</html>
