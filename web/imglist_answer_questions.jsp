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
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script language="javascript">
        $(function () {
            //导航切换
            $(".imglist li").click(function () {
                $(".imglist li.selected").removeClass("selected")
                $(this).addClass("selected");
            })
        })
    </script>
</head>


<body>
<script>
    $(function(){
        if(${sessionScope.student.name eq null}){
            window.location.href="login.jsp";
        }
    })
</script>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">用户</a></li>
        <li><a href="enter_self_test.jsp">进入自测</a></li>
        <li><a href="#">答题中</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <li class="click"><span><img src="images/t02.png"/></span>在线考试答题：</li>
        </ul>


    </div>


    <ul class="classlist">

        <c:forEach items="${requestScope.questions}" var="question" varStatus="st">
            <li style="float: none;overflow: auto;">
                <div class="lright2" style="font-size: 17px;">
                    <h2><c:out value="${st.index+1}"/>: <c:out value="${question.content}"/></h2>
                    <input type="radio" class="optionsRadios1 ch" value="A"
                           name="optionsRadios+'<c:out value='${st.index+1}'/>'"/>
                    <label>A．<c:out value="${question.optionOne}"/></label>
                    <br/>
                    <input type="radio" class="optionsRadios2 ch" value="B"
                           name="optionsRadios+'<c:out value='${st.index+1}'/>'"/>
                    <label>B．<c:out value="${question.optionTwo}"/></label>
                    <br/>
                    <input type="radio" class="optionsRadios3 ch" value="C"
                           name="optionsRadios+'<c:out value='${st.index+1}'/>'"/>
                    <label>C．<c:out value="${question.optionThree}"/></label>
                    <br/>
                    <input type="radio" class="optionsRadios4 ch" value="D"
                           name="optionsRadios+'<c:out value='${st.index+1}'/>'"/>
                    <label>D．<c:out value="${question.optionFour}"/></label>
                </div>
            </li>
        </c:forEach>
        <input type="hidden" name="studentId" value="1"/>
        <input type="hidden" name="paperId" value="${requestScope.paperId}"/>

    </ul>
    <a class="enter btn">提交</a>
    <div class="clear"></div>


</div>

<script>
    $(".btn").click(function () {
        var a = $("input[name='studentId']").val();
        var b = $("input[name='paperId']").val();
        var c = $(".ch");
        var d = "";
        for (var i = 0; i < c.length; i++) {
            if (c[i].checked) {
                d = d + c[i].value + ",";
            }
        }
        $.post("/addAnswer.action", {studentId: a, paperId: b, studentAnswer: d}, function (data, textStatus) {
            alert("答题成功,您的得分为：" + data);
            window.location.href="/toMainStu.action";
        });
    });
</script>
</body>

</html>
