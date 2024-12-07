<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>学生信息管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"> <!-- 引用外部 CSS 文件 -->
</head>
<body>
<div id="maxbox">
    <h3>学生信息管理系统</h3>

    <!-- 显示登录失败的消息 -->
    <c:if test="${not empty msg}">
        <div style="color: red;">${msg}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/login/1" method="post">
        <div class="inputbox">
            <div class="inputText">
                <span class="iconfont icon-mine"></span>
                <input name="name" type="text" placeholder="name" autocomplete="off">
            </div>
            <div class="inputText">
                <span class="iconfont icon-lock"></span>
                <input name="password" type="password" placeholder="Password">
            </div>
            <input class="inputButton" type="submit" value="登录"><br>
            <input class="inputButton" type="button" onclick="register()" value="去注册账户">
        </div>
    </form>
</div>
<script>
    function register() {
        location.href = "${pageContext.request.contextPath}/jsp/register.jsp"
    }
</script>
</body>
</html>
