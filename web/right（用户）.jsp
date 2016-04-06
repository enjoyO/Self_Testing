<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!-- saved from url=(0060)http://127.0.0.1/dede/login.php?gotopage=%2Fdede%2Findex.php -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $(".click1").click(function () {
                $(".tip1").fadeIn(200);
            });


            $(".tiptop a").click(function () {
                $(".tip1").fadeOut(200);
            });

            $(".sure").click(function () {
                $(".tip1").fadeOut(100);
            });

            $(".cancel").click(function () {
                $(".tip1").fadeOut(100);
            });

        });


        $(document).ready(function () {
            $(".click2").click(function () {
                $(".tip2").fadeIn(200);
            });


            $(".tiptop a").click(function () {
                $(".tip2").fadeOut(200);
            });

            $(".sure").click(function () {
                $(".tip2").fadeOut(100);
            });

            $(".cancel").click(function () {
                $(".tip2").fadeOut(100);
            });

        });


        $(document).ready(function () {
            $(".click3").click(function () {
                $(".tip3").fadeIn(200);
            });


            $(".tiptop a").click(function () {
                $(".tip3").fadeOut(200);
            });

            $(".sure").click(function () {
                $(".tip3").fadeOut(100);
            });

            $(".cancel").click(function () {
                $(".tip3").fadeOut(100);
            });

        });
        $(document).ready(function () {
            $(".click4").click(function () {
                $(".tip4").fadeIn(200);
            });


            $(".tiptop a").click(function () {
                $(".tip4").fadeOut(200);
            });

            $(".sure").click(function () {
                $(".tip4").fadeOut(100);
            });

            $(".cancel").click(function () {
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
        <li><a href="#">用户信息</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <li class="click1"><span><img src="images/t01.png"/></span>添加</li>
            <li class="click3"><span><img src="images/t03.png"/></span>删除</li>
            <li class="click4"><span><img src="images/t05.png"/></span>查询</li>
        </ul>


    </div>


    <table class="tablelist">
        <thead>
        <tr>
            <th></th>
            <th>学号<i class="sort"><img src="images/px.gif"/></i></th>
            <th>姓名</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${requestScope.allStudents}" var="student">
            <tr>
                <td><input name="dels" class="dels" type="checkbox" value="${student.id}"/></td>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><a href="#" class="tablelink modify" value="${student.id},${student.password},${student.name}"><span
                        class="click2">修改</span></a> <a class="tablelink del" value="${student.id}"><span
                        class="click3" style="cursor: pointer">删除</span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <script>
        $(function () {
            $(".modify").click(function () {
                var a = $(this).attr("value");
                var b = a.split(",");
                var id = b[0];
                var password = b[1];
                var name = b[2];
                $(".mod_id").attr("value", id);
                $(".mod_pa").attr("value", password);
                $(".mod_na").attr("value", name);
            });
            $(".del").click(function () {
                var a = $(this).attr("value");
                $(this).parents("tr").hide(500);
                $.post("/deleteStudent.action", {id: a}, function (data, textStatus) {
                });
            });
            $(".click3").click(function () {
                var a = $("input[type='checkbox']");
                var b = "";
                for (var i = 0; i < a.length; i++) {
                    if(a[i].checked){
                        b += a[i].value + ",";
                        $(a[i]).parents("tr").hide(400);
                    }
                }
                $.post("/deleteStudents.action",{ids:b},function(data,textStatus){
                });
            });
        })
    </script>
    <div class="tip1">
        <div class="tiptop"><span>添加用户</span><a></a></div>

        <form action="/addStudent.action" method="post">
            <div class="tipinfo">
                <span><img src="images/ticon.png"/></span>
                <div class="tipright">
                    <div class="kuang"> 学号：<input type="text" class="inputborder1" name="id" placeholder="　输入学号"/>
                    </div>
                    <div class="kuang"> 密码：<input type="text" class="inputborder1" name="password" placeholder="　输入密码"/></div>
                    <div class="kuang"> 姓名：<input type="text" class="inputborder1" name="name" placeholder="　输入姓名" value=""/>
                    </div>
                </div>
            </div>
            <div class="tipbtn">
                <input type="submit" class="sure" value="确定"/>&nbsp;
                <input type="button" class="cancel" value="取消"/>
            </div>
        </form>
    </div>


</div>

<div class="tip2">
    <div class="tiptop"><span>修改用户</span><a></a></div>
    <form action="/updateStudent.action" method="post">
        <div class="tipinfo">
                <span>
                    <img src="images/ticon.png"/>
                </span>
            <div class="tipright">
                <div class="kuang"> 学号：<input type="text" class="inputborder1 mod_id" name="id" value=""></div>
                <div class="kuang"> 密码：<input type="text" class="inputborder1 mod_pa" name="password" value=""></div>
                <div class="kuang"> 姓名：<input type="text" class="inputborder1 mod_na" name="name" value=""></div>
            </div>
        </div>
        <div class="tipbtn">
            <input type="submit" class="sure" value="确定"/>&nbsp;
            <input name="" type="button" class="cancel" value="取消"/>
        </div>
    </form>

</div>


</div>

</div>
<div class="tip4">
    <div class="tiptop"><span>查询用户</span><a></a></div>

    <form action="/findByIdAndName.action" method="post">
        <div class="tipinfo">
            <span><img src="images/ticon.png"/></span>
            <div class="tipright">
                <div class="kuang"> 学号：<input type="text" class="inputborder1" name="id" placeholder="　输入学号"></div>
                <div class="kuang"> 姓名：<input type="text" class="inputborder1" name="name" placeholder="　输入姓名"></div>

            </div>
        </div>

        <div class="tipbtn">
            <input type="submit" class="sure" value="确定"/>&nbsp;
            <input type="button" class="cancel" value="取消"/>
        </div>
    </form>
</div>


</div>


<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>
