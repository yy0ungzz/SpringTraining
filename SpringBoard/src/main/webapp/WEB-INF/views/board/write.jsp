<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp"/>

<script type="text/javascript">

$(document).ready(function() {
	
	/* 취소 버튼을 누르면 방문 기록 이전으로 이동 */
	$("#btnCancel").click(function() {
		history.go(-1)
	})
	
	$("#btnWrite").click(function() {
		location.href("/board/write")
	})
	
})

</script>

<div class="container">

<h1>글쓰기 입력 폼</h1>
<hr>

<form class="form-horizontal" action="/board/write" method="post" enctype="multipart/form-data">

<div class="form-group">
	<label class="col-sm-3 control-label">제목(title) : </label>
	<div class="col-sm-5">
		<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요.">
	</div>
</div>

<div class="form-group">
	<label class="col-sm-3 control-label">내용(content) : </label>
	<div class="col-sm-5">
		<textarea class="form-control" rows="5" placeholder="내용을 입력하세요" name="content"></textarea>
	</div>
</div>

<label>첨부파일<input type="file" name="file"></label>

<div class="text-center">
	<button class="btn btn-primary" id="btnWrite">작성</button>
	<button class="btn btn-danger" id="btnCancel">취소</button>
</div>

</form>


</div> <!-- .container end -->


<c:import url="/WEB-INF/views/layout/footer.jsp"/>
