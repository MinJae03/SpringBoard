<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../include/header.jsp" %>
<link
	href="${pageContext.request.contextPath}/resources/css/viewFormstyle.css"
	rel="stylesheet" type="text/css">
</head>

<body>
	<%@ include file="../include/menu.jsp" %>
	<div>
		<form id="viewForm" name="viewForm" method="post">
			<div>
				<h2>글쓰기</h2>
				<div>
					<table>
						<tr>
							<th>제목</th>
							<c:choose>
								<c:when test="${sessionScope.userName==result.writer}">
									<td><input style="width: 500px" type="text" id="title"
									name="title" value="${result.title }" /></td>
								</c:when>
								<c:when test="${sessionScope.userName!=result.writer}">
									<td><input style="width: 500px" type="text" id="title"
									name="title" value="${result.title }" readonly/></td>
								</c:when>
							</c:choose>
						</tr>
						<tr>
							<th>내용</th>
							<c:choose>
								<c:when test="${sessionScope.userName==result.writer}">
									<td><textarea style="width: 500px" rows="10" cols="10"
									id="content" name="content"><c:out
										value="${result.content }" /></textarea></td>
								</c:when>
								<c:when test="${sessionScope.userName!=result.writer}">
									<td><textarea readonly style="width: 500px" rows="10" cols="10"
										id="content" name="content"><c:out
											value="${result.content }"/></textarea></td>
								</c:when>
							</c:choose>
						</tr>
						<tr>
							<th>작성자</th>
							<td><input style="width: 500px" type="text" id="writer"
								name="writer" value="${result.writer }" readonly/></td>
						</tr>
					</table>
					<div>
						<c:if test="${sessionScope.userName==result.writer}">
							<a href='#' onClick='fn_update()' class="btn">수정</a> 
						</c:if>
						<a href='#' onClick='fn_cancel()' class="btn">목록</a>
					</div>	
				</div>
			</div>
			<input type='hidden' id='code' name='code' value='${result.code }' />
		</form>
		<script>
			//목록
			function fn_cancel() {

				var form = document.getElementById("viewForm");

				form.action = "<c:url value='/board/boardList.do'/>";
				form.submit();

			}

			//수정
			function fn_update() {

				var form = document.getElementById("viewForm");

				form.action = "<c:url value='/board/updateboard.do'/>";
				form.submit();
			}

			//답변
			function fn_relay() {

				var form = document.getElementById("viewForm");

				form.action = "<c:url value='/board/relayForm.do'/>";
				form.submit();

			}
		</script>
	</div>
</body>
</html>