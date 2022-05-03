<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp"/>

<script type="text/javascript">

$(document).ready(function() {
	$("#btnWrite").click(function() {
		location.href = "/board/write"
	})
})

</script>

<style type="text/css">

table {
	table-layout: fixed;
}

table, th {
	text-align: center;
}

td: nth-child(2){
	text-align: left;
}

</style>


<div class="container">

<h1>Board List 게시판 리스트</h1>
<hr>

<table class="table table-striped table-hover">

<thead>
	<tr>
		<th style="width: 10%;">글번호</th>
		<th style="width: 45%;">제목</th>
		<th style="width: 20%;">작성자</th>
		<th style="width: 10%;">조회수</th>
		<th style="width: 15%;">작성일</th>
	</tr>
</thead>


<tbody>
	<c:forEach var="board" items="${list }">
		<tr>
			<td>${board.boardNo }</td>
			<td><a href="/board/view?boardNo=${board.boardNo }">${board.title }</a></td>
			<td>${board.writerNick }</td>
			<td>${board.hit }</td>
			<td><fmt:formatDate value="${board.writeDate }" pattern="yy-MM-dd HH:mm:ss"/></td>
		</tr>
	</c:forEach>
</tbody>

</table>


<span class="pull-left"><button id="btnWrite">글쓰기</button></span>
<!-- total 게시글 보여주는 태그 -->
<span class="pull-right">total : ${paging.totalCount }</span>
<div class="clearfix"></div>

<!-- 페이징 jsp -->
<c:import url="/WEB-INF/views/layout/paging.jsp"/>

</div> <!-- .container end -->

<c:import url="/WEB-INF/views/layout/footer.jsp"/>