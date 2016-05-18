<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
%>
<!-- saved from url=(0060)http://127.0.0.1/dede/login.php?gotopage=%2Fdede%2Findex.php -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>答疑中心</title>

<link rel="stylesheet" href="css/ask.css" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>

<script type="text/javascript" src="js/jquery.js"></script>


</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">用户</a></li>
    <li><a href="#">留言反馈</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">留言反馈</a></li> 
 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">Hi，<b>同学</b>，欢迎您使用留言反馈功能！</div>


		<table class="tablelist">
			<thead>
			<tr>
				<th>学号<i class="sort"><img src="images/px.gif" /></i></th>
				<th>姓名</th>
				<th>留言内容</th>
				<th>回复信息</th>
				<th>时间</th>
			</tr>
			</thead>
			<tbody>

			<s:forEach items="${requestScope.allMessages}" var="message" varStatus="st">
				<tr>
					<td>${message.studentId}</td>
					<td>${requestScope.students[st.index].name}</td>
					<td>${message.message}</td>
					<td>${message.reply}</td>
					<td>${message.times}</td></tr>
			</s:forEach>

			</tbody>
		</table>


    <br/><br/>
	<form action="/addMessage.action" method="post">
    <ul class="forminfo">

    <li><label>留言内容<b>*</b></label>
    

    <textarea name="message" style="width:700px;height:250px"></textarea>

    </li>
    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认留言"/></li>
    </ul>
	</form>
    </div> 
    
    
    
    
    
    </div>


<div class="kf_qq_r"><a id="isread-text" href="#"></a></div>

<div style="display:none;">
	<div id="simTestContent" class="simScrollCont">
		<div class="mainlist">
			<div class="kf_qq_li">
				<div class="kf_qq_li_left kf_qq_li_1">
				</div>
				<div class="kf_qq_li_right">
					<div class="kf_r_t">
						<span>系统QQ：</span><a class="qyqq" target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=123456&site=qq&menu=yes">在线咨询</a><span style="padding-left:19px;">400电话：4000-0000-00</span></div>
					<div class="kf_r_d">
						系统QQ与400电话采用集中调度，多人值班，受理所有服务咨询</div>
				</div>
			</div>
			<div class="kf_qq_li">
				<div class="kf_qq_li_left kf_qq_li_2">
				</div>
				<div class="kf_qq_li_right">
					<div class="kf_qq_c">
						<ul>
							<li>
							<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=123456&site=qq&menu=yes">
							答疑-刘老师</a></li>
							<li>
							<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=123456&site=qq&menu=yes">
							答疑-赵老师</a></li>
							<li>
							<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=123456&site=qq&menu=yes">
							答疑-宋老师</a></li>
							<li>
							<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=123456&site=qq&menu=yes">
							答疑-张老师</a></li>
							<li>
							<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=12345633&site=qq&menu=yes">
							答疑-王老师</a></li>
							<li>
							<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=12345634&site=qq&menu=yes">
							答疑-高老师</a></li>
							<li>
							<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=12345638&site=qq&menu=yes">
							答疑-李老师</a></li>
							<li>
							<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=12345632&site=qq&menu=yes">
							答疑-何老师</a></li>
						</ul>
					</div>
					<div class="kf_r_d">
						答疑相关，请咨询答疑老师。为避免丢失消息，请尽量添加好友</div>
				</div>
			</div>
			
			
		</div>
	</div>
</div>
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
