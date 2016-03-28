<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商家答题测试</title>
    <link rel="stylesheet" href="css/store.css">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/base.css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <style>
        #add-mes {
            width: 300px;
            margin-left: 400px;
            font-size: 20px;
            margin-top: 500px;
        }

        #lar-text a {
            width: 200px;
            height: 200px;
            font-size: 20px;
            padding-top: 30px;
            color: red;
        }

        #container {
            margin: 0 auto;
            width: 1000px;
            height: 1000px;
            border: 2px solid #824040;
            overflow: auto;

        }

        #con-control {
            text-align: center;
        }

        #test {
            width: 800px;
            height: auto;
            margin-top: 50px;
            margin-left: 100px;
        }
    </style>
</head>
<body>
<div id="container">
    <h2 id="con-control">商家答题测试</h2>
    <form method="post" action="">
        <div id="test">
             <c:forEach items="${requestScope.questions}" var="question" varStatus="st">
                <div class="st">
                    <h4>问题<c:out value="${st.index+1}"/> :<c:out value="${question.content}"/></h4><br>
                    <label class="radio">
                        <input type="radio" name="optionsRadios+'<c:out value='${st.index+1}'/>'" class="optionsRadios1 ch" value="A"><c:out value="${question.optionOne}"/>
                    </label>
                    <label class="radio">
                        <input type="radio" name="optionsRadios+'<c:out value='${st.index+1}'/>'" class="optionsRadios2 ch" value="B"><c:out value="${question.optionTwo}"/>
                    </label>
                    <label class="radio">
                        <input type="radio" name="optionsRadios+'<c:out value='${st.index+1}'/>'" class="optionsRadios3 ch" value="C"><c:out value="${question.optionThree}"/>
                    </label>
                    <label class="radio">
                        <input type="radio" name="optionsRadios+'<c:out value='${st.index+1}'/>'" class="optionsRadios4 ch" value="D"><c:out value="${question.optionFour}"/>
                    </label>
                </div>
             </c:forEach>
        </div>
        <input type="hidden" name="studentId" value="1"/>
        <input type="hidden" name="paperId" value="1"/>
    <div id="add-mes">
        <button class="btn" type="button">提交</button>
        <p>进入到下一步</p><br>
        <h3>请点击</h3><br>
        <div id="lar-text">
            <a href="choose-module.html">开店请选择模板</a>
        </div>
    </div>
    </form>
</div>
<script>
    $(function(){
        $(".btn").click(function(){
            var a = $("input[name='studentId']").val();
            var b = $("input[name='paperId']").val();
            var c = $(".ch");
            var d="";
            for(var i = 0;i < c.length ; i++){
                if(c[i].checked){
                  d = d + c[i].value + "," ;
                }
            }
            $.post("/addAnswer.action",{studentId:a,paperId:b,studentAnswer:d},function(data,textStatus){
                alert("答题成功,您的得分为："+data);
            });
        });
    })
</script>
</body>
<html>
