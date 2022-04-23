<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp"/>

<script type="text/javascript">

$(document).ready(function() {
	
	$("#btnList").click(function() {
		location.href = "/board/list"
	})
	$("#btnUpdate").click(function() {
		location.href = "/board/update?boardNo=${viewBoard.boardNo}"
	})
	$("#btnDelete").click(function() {
		location.href = "/board/delete?boardNo=${viewBoard.boardNo}"
	})
	
})

</script>

<div class="container">

<h1>게시글 상세내용 (Board Detail View)</h1>
<hr>

<table class="table table-bordered">

<tr>
	<td class="info">글번호</td><td colspan="3">${viewBoard.boardNo }</td>
</tr>

<tr>
	<td class="info">아이디</td><td>${viewBoard.writerId }</td>
	<td class="info">닉네임</td><td>${viewBoard.writerNick }</td>
</tr>

<tr>
	<td class="info">조회수</td><td>${viewBoard.hit }</td>
	<td class="info">작성날짜</td><td><fmt:formatDate value="${viewBoard.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
</tr>

<tr>
	<td class="info" colspan="4">상세 내용</td>
</tr>

<tr>
	<td colspan="4">${viewBoard.content }</td>
</tr>

</table>

<div class="text-center">
	<button class="btn btn-default" id="btnList">목록</button>
	<button class="btn btn-primary" id="btnUpdate">수정</button>
	<button class="btn btn-danger" id="btnDelete">삭제</button>
</div>



</div> <!-- .container end -->


<c:import url="/WEB-INF/views/layout/footer.jsp"/>
