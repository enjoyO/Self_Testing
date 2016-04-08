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
    <title>计组试题</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/select.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $(".click5").click(function () {
                $(".tip5").fadeIn(200);
            });


            $(".tiptop a").click(function () {
                $(".tip5").fadeOut(200);
            });

            $(".sure").click(function () {
                $(".tip5").fadeOut(100);
            });

            $(".cancel").click(function () {
                $(".tip5").fadeOut(100);
            });

        });


        $(document).ready(function () {
            $(".click6").click(function () {
                $(".tip6").fadeIn(200);
            });


            $(".tiptop a").click(function () {
                $(".tip6").fadeOut(200);
            });

            $(".sure").click(function () {
                $(".tip6").fadeOut(100);
            });

            $(".cancel").click(function () {
                $(".tip6").fadeOut(100);
            });

        });


    </script>
</head>

<body>
<input type="hidden" class="pId" value="${requestScope.paperId}"/>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">自测管理</a></li>
        <li><a href="/toPaperMan.action">自测试题</a></li>
        <li><a href="#">计算机组成原理期中试题</a></li>
    </ul>
</div>


<ul class="classlist">
    <c:forEach items="${requestScope.allQuestions}" var="question" varStatus="st">
        <li style="float: none;overflow: auto;">
            <div class="lright2" style="font-size: 17px;">
                <h2><input class="test" type="checkbox" value="${question.id}"/><c:out value="${st.index+1}"/>:<c:out
                        value="${question.content}"/></h2>
                <input type="radio" name="answer"/>
                <label>A．<c:out value="${question.optionOne}"/></label>
                <br/>
                <input type="radio" name="answer"/>
                <label>B．<c:out value="${question.optionTwo}"/></label>
                <br/>
                <input type="radio" name="answer"/>
                <label>C．<c:out value="${question.optionThree}"/></label>
                <br/>
                <input type="hidden" class="num" value="${requestScope.pa.totalQuestion}"/>
                <input type="hidden" class="ques" value="${requestScope.pa.questionId}">
                <input type="radio" name="answer"/>
                <label>D．<c:out value="${question.optionFour}"/></label>
                <p><a href="#" class="modify"
                      value="${question.id},${question.content},${question.optionOne},${question.optionTwo},${question.optionThree},${question.optionFour},${question.answer}"><span
                        class="click5">修改</span></a> <a href="#" value="${question.id}" class="del"><span
                        class="click6">删除</span></a></p>
            </div>
        </li>
    </c:forEach>
</ul>

<div class="clear">
    <a href="/toPaperMan.action" class="enter ssub">确认发布</a>
</div>
<script>
    $(function () {
        var ques = $(".ques").val();
        var quesId = ques.split(",");
        var t = $(".test");
        for (var i = 0; i < quesId.length; i++) {
            for (var j = 0; j < t.length; j++) {
                if (t[j].value == quesId[i]) {
                    t[j].checked = true;
                }
            }
        }

        $(".ssub").click(function () {
            var a = $(".test:checked");
            var b = "";
            for (var i = 0; i < a.length; i++) {
                b = b + a[i].value + ",";
            }
            var c = $(".pId").val();
            var d = $(".num").val();
            if (a.length != d) {
                alert("请选择正确的题数(" + d + ")！");
                return false;
            }
            $.post("/updatePaper.action", {id: c, questionId: b}, function (data, textStatus) {
            });
        });
    });
</script>

</div>

<div class="tip5">
    <div class="tiptop"><span>修改试题</span><a></a></div>

    <form action="/updateQuestion.action" method="post">
        <div class="tipinfo">
            <div class="tipright">
                <div class="kuang"> 题干：<textarea name="content" class="textinput mod_content" value=""></textarea></div>
                <div class="kuang"> 选项A：<input type="text" class="inputborder1 mod_a" name="optionOne" value=""></div>
                <div class="kuang"> 选项B：<input type="text" class="inputborder1 mod_b" name="optionTwo" value=""></div>
                <div class="kuang"> 选项C：<input type="text" class="inputborder1 mod_c" name="optionThree" value=""></div>
                <div class="kuang"> 选项D：<input type="text" class="inputborder1 mod_d" name="optionFour" value=""></div>
                <li><label>正确答案</label>
                    <cite>
                        <input name="answer" class="mod_an" type="radio" value="A"/>A&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="answer" class="mod_an" type="radio" value="B"/>B&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="answer" class="mod_an" type="radio" value="C"/>C&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="answer" class="mod_an" type="radio" value="D"/>D&nbsp;&nbsp;&nbsp;&nbsp;
                    </cite>
                </li>
            </div>
        </div>
        <script>
            $(function () {
                $(".modify").click(function () {
                    var a = $(this).attr("value");
                    var b = a.split(",");
                    $(".mod_id").attr("value", b[0]);
                    $(".mod_content").attr("value", b[1]);
                    $(".mod_a").attr("value", b[2]);
                    $(".mod_b").attr("value", b[3]);
                    $(".mod_c").attr("value", b[4]);
                    $(".mod_d").attr("value", b[5]);
                    var c = b[6];
                    var d = $(".mod_an");
                    for (var i = 0; i < d.length; i++) {
                        if (d[i].value == c) {
                            d[i].checked = true;
                        }
                    }
                });
                $(".del").click(function () {
                    $(this).parents("li").hide(400);
                    var a = $(this).attr("value");
                    $.post("/deleteQuestion.action", {id: a}, function (data, textStatus) {

                    });
                });
            })
        </script>
        <div class="tipbtn2">
            <input type="hidden" class="mod_id" name="id" value=""/>
            <input name="" type="submit" class="sure" value="确定"/>&nbsp;
            <input name="" type="button" class="cancel" value="取消"/>
        </div>
    </form>
</div>


</div>


</div>

<script type="text/javascript">
    $("#usual1 ul").idTabs();
</script>

<script type="text/javascript">
    $(function () {
        $('.tablelist tbody tr:odd').addClass('odd');
    })
</script>


</div>


</body>

</html>
