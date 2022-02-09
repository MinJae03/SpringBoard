<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="${pageContext.request.contextPath}/resources/css/boardstyle.css"
	rel="stylesheet" type="text/css">
	<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h1>게시판 글 목록</h1>
	<div>
		<form id="boardForm" name="boardForm" method="post">
			<table>
				<thead>
					<tr>
						<th>게시글 번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성/수정일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="result" items="${list}" varStatus="status">
						<tr>
							<td>
								<fmt:formatNumber type="number" maxFractionDigits="0"  value="${result.num}"/>
								<!--<c:out value="${result.num}" />-->
							</td>
							<td><a href='#' onClick='fn_view(${result.code})'><c:out
										value="${result.title }" /></a></td>
							<td><c:out value="${result.writer }" /></td>
							<td>
								<fmt:formatDate value="${result.reg_datetime }" pattern="yyyy년 MM월 dd일 K시 m분"/>
								<%-- <c:out value="${result.reg_datetime }" /> --%>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div>
				<a href='#' onClick='fn_write()' class='writebtn'>글쓰기</a>
				<a href='/member/list.do' class='writebtn'>회원목록</a>
			</div>
		<ul class="btn-group pagination">
		    <c:if test="${pageMaker.prev }">
		    	<li>
		        	<a href='<c:url value="/board/boardList.do?page=${pageMaker.startPage-1 }"/>'>이전</a>
		    	</li>
		    </c:if>
		    <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
			    <li>
			        <a href='<c:url value="/board/boardList.do?page=${pageNum }"/>'><i class="fa">${pageNum }</i></a>
			    </li>
		    </c:forEach>
			    <c:if test="${pageMaker.next && pageMaker.endPage >0 }">
			    <li>
			        <a href='<c:url value="/board/boardList.do?page=${pageMaker.endPage+1 }"/>'>다음</a>
			    </li>
	    	</c:if>
		</ul>
		</form>
		<script>
//글쓰기
function fn_write(){
    
    var form = document.getElementById("boardForm");
    
    form.action = "<c:url value='/board/writeForm.do'/>";
    form.submit();
    
}
 
//글조회
function fn_view(code){
    
    var form = document.getElementById("boardForm");
    var url = "<c:url value='/board/viewContent.do'/>";
    url = url + "?code=" + code;
    
    form.action = url;    
    form.submit(); 
}
</script>
	</div>
</body>
</html>
