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
	href="${pageContext.request.contextPath}/resources/css/writeFormstyle.css"
	rel="stylesheet" type="text/css">
</head>
    
<body>
<%@ include file="../include/menu.jsp" %>
<div>
    <form id="writeForm" name="writeForm" method="post">
        <div>
            <h2>글쓰기</h2>
            <div>
                <table>
                    <tr>
                        <th>제목</th>
                        <td><input style="width: 500px" type="text" id="title" name="title" /></td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td><textarea style="width: 500px" rows="10" cols="10" id="content" name="content"></textarea></td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td><input style="width: 500px" type="text" id="writer" name="writer" value="${sessionScope.userName}" readonly/></td>
                    </tr>
                </table>
                <div>
                    <a href='#' onClick='fn_addtoBoard()' class="btn">글 등록</a>
                    <a href='#' onClick='fn_cancel()' class="btn">목록</a>
                </div>
            </div>
        </div>
    </form>
<script>
//글쓰기
function fn_addtoBoard(){
    var title=$("#title").val();
    var content=$("#content").val();
    if(title==""){
    	alert("제목을 입력하세요");
    }else if(content==""){
    	alert("내용을 입력하세요")
    }else{
    	var form = document.getElementById("writeForm");
        
        form.action = "<c:url value='/board/write.do'/>";
        form.submit();
    }
    
    
}
 
//목록
function fn_cancel(){
    
    var form = document.getElementById("writeForm");
    
    form.action = "<c:url value='/board/boardList.do'/>";
    form.submit();
    
}
</script>
</div>
</body>
</html>