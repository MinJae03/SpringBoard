<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인페이지</title>
<%@ include file="../include/header.jsp"%>
<script>
	$(document).ready(function() {//login.jsp의 로딩(html부분)이 끝나고 밑의 해당 코드들을 실행준비 시킨다(동작 순서를 본문 내용 뒤로 이동시킨다)
		$("#btnLogin").click(function() {//btnLogin의 id를 가지는 버튼이 눌리면 아래 내용을 실행한다
			// 태크.val() : 태그에 입력된 값
			// 태크.val("값") : 태그의 값을 변경 
			var userId = $("#userId").val();//userId 변수에 userId의 id를 가지는 값을 가져와 저장한다
			var userPw = $("#userPw").val();//userPw 변수에 userPw의 id를 가지는 값을 가져와 저장한다
			if (userId == "") {
				alert("아이디를 입력하세요.");
				$("#userId").focus(); // 입력포커스 이동
				return; // 함수 종료
			}
			if (userPw == "") {
				alert("비밀번호를 입력하세요.");
				$("#userPw").focus();
				return;
			}//위에서부터 실행->if 두 개 거치며 id, pw는 입력이 된 상태라는 것을 확인
			// 폼 내부의 데이터를 전송할 주소
			document.form1.action = "${path}/member/loginCheck.do"
			// 제출
			document.form1.submit();//form1의 내용을 action에서 지정한 url로 제출한다
		});
	});
</script>
<link
	href="${pageContext.request.contextPath}/resources/css/loginstyle.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>로그인</h2>
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td>아이디</td>
				<td><input name="userId" id="userId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPw" id="userPw"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a type="button" id="btnLogin"
					class="btn">로그인</a> <a href="${path}/member/write.do" class="btn">회원가입</a>
			<tr>
				<td>
					<div></div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
