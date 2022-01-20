<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원등록 페이지</title>
<%@ include file="../include/header.jsp" %>
<link href="${pageContext.request.contextPath}/resources/css/member_writestyle.css"
	rel="stylesheet" type="text/css">
	<%@ include file="../include/menu.jsp" %>
</head>
<body>

    <h2>회원가입</h2>
    <form name="form1" method="post" action="${path}/member/insert.do">
        <table border="1" width="400px">
            <tr>
                <td>아이디</td>
                <td><input name="userId"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="userPw"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input name="userName"></td>
            </tr>
            <tr>
                <td>이메일주소</td>
                <td><input name="userEmail"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="확인" class="btn">
                    <input type="reset" value="전체재입력" class="btn">
                    <a href="${path}/member/login.do"><input type="button" value="뒤로가기" class="btn"></a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>