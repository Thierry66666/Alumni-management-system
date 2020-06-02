<%--
  Created by IntelliJ IDEA.
  User: 11206
  Date: 2020/6/1
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统主页</title>
</head>
<body>
当前用户：${USER_SESSION.username}
<a href="${pageContext.request.contextPath}/logout">退出</a>
</body>
</html>
