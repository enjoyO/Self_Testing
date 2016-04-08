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
    
    <li>
    <span><img src="images/001.jpg" /></span>
    <div class="lright">
    <h2>计算机组成原理</h2>
    <p>课程数：共35章<br />已完成：7章<br />自测中：6章</p>
    <a href="imglist1（答题）.jsp" class="enter">进入自测</a>
    </div>
    </li>
    
    <li>
    <span><img src="images/001.jpg" /></span>
    <div class="lright">
    <h2>模拟电子技术</h2>
    <p>课程数：共35章<br />已完成：7章<br />自测中：6章</p>
    <a class="enter">进入自测</a>
    </div>
    </li>
    
    <li>
    <span><img src="images/001.jpg" /></span>
    <div class="lright">
    <h2>数据结构</h2>
    <p>课程数：共35章<br />已完成：7章<br />自测中：6章</p>
    <a class="enter">进入自测</a>
    </div>
    </li>
    
    <li>
    <span><img src="images/001.jpg" /></span>
    <div class="lright">
    <h2>java</h2>
    <p>课程数：共35章<br />已完成：7章<br />自测中：6章</p>
    <a class="enter">进入自测</a>
    </div>
    </li>
    
    <li>
    <span><img src="images/001.jpg" /></span>
    <div class="lright">
    <h2>计算机网络</h2>
    <p>课程数：共35章<br />已完成：7章<br />自测中：6章</p>
    <a class="enter">进入自测</a>
    </div>
    </li>
    
    <li>
    <span><img src="images/001.jpg" /></span>
    <div class="lright">
    <h2>数字逻辑</h2>
    <p>课程数：共35章<br />已完成：7章<br />自测中：6章</p>
    <a class="enter">进入自测</a>
    </div>
    </li>
    
   
    
    </ul>
    
    <div class="clear"></div>
   
    <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
   
    

</body>

</html>
