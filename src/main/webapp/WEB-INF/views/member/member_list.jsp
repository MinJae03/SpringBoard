<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
<%@ include file="../include/header.jsp" %>
<link
	href="${pageContext.request.contextPath}/resources/css/member_liststyle.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="../include/menu.jsp" %>
    <h2>회원 목록</h2>
    <table border="1" width="700px">
    <tbody>
    	<tr>
            <th>아이디</th>
            <th>이름</th>
            <th>이메일</th>
        </tr>
        <c:forEach var="row" items="${list}">
        <tr>
            <td>${row.userId}</td>
            <td>${row.userName}</td>
            <td>${row.userEmail}</td>
        </tr>
        </c:forEach>
    </tbody>
    </table>
    <a href='/board/boardList.do' class='writebtn'>게시판</a>
</body>
</html>
