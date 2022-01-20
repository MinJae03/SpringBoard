<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Home</title>
<%@ include file="../include/header.jsp" %>
<link
	href="${pageContext.request.contextPath}/resources/css/homestyle.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="../include/menu.jsp" %>
    <c:if test="${msg == 'success'}">
    <h2>${sessionScope.userName}(${sessionScope.userId})님 환영합니다.</h2>
    </c:if>
    <a href="${path}/board/boardList.do" class="board">게시판으로 이동</a>
</body>
</html>