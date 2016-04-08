<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!-- saved from url=(0060)http://127.0.0.1/dede/login.php?gotopage=%2Fdede%2Findex.php -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>课程</title>
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
    <li><a href="#">自测管理</a></li>
    <li><a href="#">自测课程</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click1"><span><img src="images/t01.png" /></span>添加</li>
        <li class="click4"><span><img src="images/t05.png" /></span>查询</li>
        </ul>
        

    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th></th>
        <th>课程<i class="sort"><img src="images/px.gif" /></i></th>
        <th>授课老师</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.allSubjects}" var="subject">
                <tr>
                <td><input name="" type="checkbox" value="" /></td>
                <td>${subject.className}</td>
                <td>${subject.teacher}</td>
                <td><a href="#" class="tablelink modify" value="${subject.id},${subject.className},${subject.teacher}"><span class="click2">修改</span></a>      <a href="#" class="tablelink del" value="${subject.id}"><span class="click3">删除</span></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <script>
        $(function(){
            $(".modify").click(function(){
                var a = $(this).attr("value");
                var b = a.split(",");
                $(".mod_id").attr("value",b[0]);
                $(".mod_name").attr("value",b[1]);
                $(".mod_teacher").attr("value",b[2]);
            });
            $(".del").click(function(){
                $(this).parents("tr").hide(400);
                var a = $(this).attr("value");
                $.post("/deleteSubject.action",{id:a},function(data,textStatus){
                });
            });
        })
    </script>

    <form action="/addSubject.action" method="post"/>

        <div class="tip1">
            <div class="tiptop"><span>添加课程</span><a></a></div>

          <div class="tipinfo">
            <span><img src="images/ticon.png" /></span>
            <div class="tipright">
            <div class="kuang"> 课程：<input type="text" class="inputborder1" name="className" placeholder="　输入课程"></div>
            <div class="kuang"> 老师：<input type="text" class="inputborder1" name="teacher" placeholder="　输入授课老师"></div>
            </div>
            </div>

            <div class="tipbtn">
            <input name="" type="submit"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
            </div>
        </div>
    </form>
    
    
    
    </div>
        <div class="tip2">
        <div class="tiptop"><span>修改课程</span><a></a></div>

      <form method="post" action="/updateSubject.action">
          <div class="tipinfo">
            <span><img src="images/ticon.png" /></span>
            <div class="tipright">
            <div class="kuang"> 课程：<input type="text" name="className" class="inputborder1 mod_name"  value=""></div>
            <div class="kuang"> 老师：<input type="text" name="teacher" class="inputborder1 mod_teacher" value=""></div>
            <input type="hidden" name="id" class="mod_id" value="">
            </div>
            </div>

            <div class="tipbtn">
            <input type="submit"  class="sure" value="确定" />&nbsp;
            <input type="button"  class="cancel" value="取消" />
          </div>
      </form>
    </div>
    
    
    
    
    </div>

    </div>
    <form action="/findSubjects.action" method="post">
    <div class="tip4">
        <div class="tiptop"><span>查询课程</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <div class="kuang"> 课程：<input type="text" class="inputborder1" name="name" placeholder="　输入课程"/></div>
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

</body>

</html>
