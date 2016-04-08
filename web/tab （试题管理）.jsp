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
<title>试题管理</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>


</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">自测管理</a></li>
    <li><a href="#">自测试题</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab2" >试题添加</a></li>
    <li><a href="#tab1" class="selected">试题管理</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab2" class="tabson">
    
    <div class="formtext">Hi，<b>管理员</b>，欢迎您使用试题添加功能！</div>

    <form action="/addQuestion.action" method="post">
    <ul class="forminfo">
    <li><label>课程</label>
        <select class="dfinput" name="subjectId">

            <c:forEach items="${requestScope.allSubjects}" var="subject">

                <option value="${subject.id}"><c:out value="${subject.className}"/></option>
            </c:forEach>
        </select>
    </li>
    <li><label>题干</label><textarea name="content" class="textinput"></textarea></li>
    <li><label>选项A</label><input name="optionOne" type="text" class="dfinput" /></li>
    <li><label>选项B</label><input name="optionTwo" type="text" class="dfinput" /></li>
    <li><label>选项C</label><input name="optionThree" type="text" class="dfinput" /></li>
    <li><label>选项D</label><input name="optionFour" type="text" class="dfinput" /></li>
    <li><label>正确答案</label>
    <cite>
    <input name="answer" type="radio" value="A" />A&nbsp;&nbsp;&nbsp;&nbsp;
    <input name="answer" type="radio" value="B" />B&nbsp;&nbsp;&nbsp;&nbsp;
    <input name="answer" type="radio" value="C" />C&nbsp;&nbsp;&nbsp;&nbsp;
    <input name="answer" type="radio" value="D" />D&nbsp;&nbsp;&nbsp;&nbsp;
    </cite>
    </li>
    <li><label>&nbsp;</label><input type="submit" class="btn sub" value="确认添加"/></li>
    </ul>
    </form>
    </div>
    
  	<div id="tab1" class="tabson">

    <ul class="classlist">

    <c:forEach items="${requestScope.allPapers}" var="paper">
        <li>
        <span><img src="images/002.jpg" /></span>
        <div class="lright">
        <h2>${paper.testName}</h2>
        <p>${paper.totalQuestion}<br />时间：${paper.times}<br /></p>
        <a href="/getAllQuestions.action?paperId=${paper.id}" class="enter">进入试卷</a>
        </div>
        </li>
    </c:forEach>

    </ul>

    
    
    
    
    <div class="clear"></div>
   
    
    </div>  
       
	</div> 
    

    
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    
    
    
    
    </div>


</body>

</html>
