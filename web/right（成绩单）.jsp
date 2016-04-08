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
<title>成绩单</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click1").click(function(){
  $(".tip1").fadeIn(200);
  });
  
  
  $(".tiptop a").click(function(){
  $(".tip1").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip1").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip1").fadeOut(100);
});

});



$(document).ready(function(){
  $(".click2").click(function(){
  $(".tip2").fadeIn(200);
  });
  
  
  $(".tiptop a").click(function(){
  $(".tip2").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip2").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip2").fadeOut(100);
});

});

  


$(document).ready(function(){
  $(".click3").click(function(){
  $(".tip3").fadeIn(200);
  });
  
  
  $(".tiptop a").click(function(){
  $(".tip3").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip3").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip3").fadeOut(100);
});

});

$(document).ready(function(){
  $(".click4").click(function(){
  $(".tip4").fadeIn(200);
  });
  
  
  $(".tiptop a").click(function(){
  $(".tip4").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip4").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip4").fadeOut(100);
});

});
</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">用户管理</a></li>
    <li><a href="#">用户成绩</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click4"><span><img src="images/t05.png" /></span>查询</li>
        </ul>
        

    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th></th>
        <th>学号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>姓名</th>
        <th>试卷</th>
        <th>成绩</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${requestScope.answers}" var="answer" varStatus="st">
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>${answer.studentId}</td>
        <td>${requestScope.students[st.index].name}</td>
        <td>${requestScope.papers[st.index].testName}</td>
        <td>${answer.score}</td>
        </tr>
        </c:forEach>

        </tbody>
    </table>

    
    </div>
    <form action="/findByStuId.action" method="post">
    <div class="tip4">
        <div class="tiptop"><span>查询成绩</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <div class="kuang"> 学号：<input type="text" class="inputborder1" name="stuId" placeholder="　输入学号" value=""></div>
        </div>
        </div>
        
        <div class="tipbtn">
        <input type="submit"  class="sure" value="确定" />&nbsp;
        <input type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    </form>
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    <script>
        $(function(){
            if(${sessionScope.student.name eq null}){
                window.location.href="login.jsp";
            }
        })
    </script>
</body>

</html>
