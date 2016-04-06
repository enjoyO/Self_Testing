<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!-- saved from url=(0060)http://127.0.0.1/dede/login.php?gotopage=%2Fdede%2Findex.php -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>学生学习自测平台登录</title>
    <link type="text/css" rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>
    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>


</head>
<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>

<div class="logintop">
    <span>欢迎登录学生学习效果自测平台</span>
    <ul>
        <li><a href="#">首页</a></li>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>
<div class="titlelogo"><img src="images/loginlogo.png"></div>
<div class="pagewrap">
    <div class="main">
        <div class="header"></div>
        <div class="content">
            <div class="con_left"></div>
            <div class="con_right">
                <div class="con_r_top"><a class="left"
                                          style="color: rgb(153, 153, 153); border-bottom-width: 2px; border-bottom-style: solid; border-bottom-color: rgb(222, 222, 222);">管理登录</a>
                    <a class="right"
                       style="color: rgb(51, 51, 51); border-bottom-width: 2px; border-bottom-style: solid; border-bottom-color: #3C95C8;">学生登录</a>
                </div>
                <ul>
                    <li class="con_r_left" style="display: none;">
                        <form id="login_admin" method="post" action="main (管理员).jsp">
                            <div class="user">
                                <div><span class="user-icon"></span>
                                    <input type="text" name="id_2" placeholder="　输入帐号" value="">
                                </div>

                                <div><span class="mima-icon"></span>
                                    <input type="password" name="password_2" placeholder="　输入密码" value="">
                                </div>

                                <div><span class="yzmz-icon"></span>
                                    <input type="text" name="code_2" placeholder="　验证码" value="" style=" width:150px;">　　
                                    <!--   这里是验证码的相关路径 -->

                                    <img style="cursor: pointer; margin-top:8px;" src="images/pass1.jpg">


                                </div>

                            </div>
                            <br>
                            <button id="sub_2" type="button">登 录</button>
                        </form>
                    </li>


                    <li class="con_r_right" style="display: block;">
                        <form id="login_stu" method="post" action="main（学生）.jsp">
                            <div class="user">
                                <div><span class="user-icon"></span>
                                    <input type="text" name="id_1" placeholder="　输入学号" value="">
                                </div>

                                <div><span class="mima-icon"></span>
                                    <input type="password" name="password_1" placeholder="　输入密码" value="">
                                </div>

                                <div><span class="yzmz-icon"></span>
                                    <input type="text" name="code_1" placeholder="  验证码" style=" width:150px;">　　
                                    <!--   这里是验证码的相关路径，自行更换   -->

                                    <img style="cursor: pointer; margin-top:8px;" src="images/pass2.jpg">


                                </div>

                            </div>
                            <br>
                            <button type="button" id="sub_1">登 录</button>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="loginbm">版权所有 2016 仅供学生学习效果自测，勿用于任何商业用途</div>
</body>
<script>
    $(function(){
        $("#sub_1").click(function(){
            var a = $("input[name='id_1']").val();
            var b = $("input[name='password_1']").val();
            var c = $("input[name='code_1']").val();
            if(a==""){
                alert("请输入学号！");
                return;
            }
            if(b==""){
                alert("请输入密码！")
                return;
            }
            if(c==""){
                alert("请输入验证码！");
                return;
            }
            if(c!=="XVceyy"){
                alert("验证码不正确！");
                return;
            }
            $.post("/login.action",{id:a,password:b},function(data,textStatus){
                if(data=="wrong"){
                    alert("密码错误！");
                    return;
                }else{
                    $("#login_stu").submit();
                }
            });
        });

        $("#sub_2").click(function(){
            var a = $("input[name='id_2']").val();
            var b = $("input[name='password_2']").val();
            var c = $("input[name='code_2']").val();
            if(a==""){
                alert("请输入学号！");
                return;
            }
            if(b==""){
                alert("请输入密码！")
                return;
            }
            if(c==""){
                alert("请输入验证码！");
                return;
            }
            if(c!=="RPSB"){
                alert("验证码不正确！");
                return;
            }
            $.post("/loginTeacher.action",{username:a,password:b},function(data,textStatus){
                if(data=="wrong"){
                    alert("密码错误！");
                    return;
                }else{
                    $("#login_admin").submit();
                }
            });
        });
    })
</script>
</html>