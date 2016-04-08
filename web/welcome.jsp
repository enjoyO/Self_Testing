<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="">
    <script type="text/javascript" src=""></script>
</head>
<body>
<script>
    $(function(){
        if(${sessionScope.student.name eq null}){
            window.location.href="login.jsp";
        }
    })
</script>
<div style="font-family: 'Microsoft YaHei';">
    <h2>欢迎页面</h2>
</div>
</body>
</html>
