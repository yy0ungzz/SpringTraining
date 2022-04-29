<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp"/>

<!-- 스마트 에디터 2 로드 -->
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	
	function submitContents(elClickedObj) {
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", [])
	}
	
	try {
		elClickedObj.form.submit();
	} catch (e) {}
	
	/* 취소 버튼을 누르면 방문 기록 이전으로 이동 */
	$("#btnCancel").click(function() {
		history.go(-1)
	})
	
	$("#btnWrite").click(function() {
		submitContents($("#btnWrite"))
		
		location.href("/board/write")
	})
	
})

</script>

<div class="container">

<h1>글쓰기 입력 폼</h1>
<hr>

<form class="form-horizontal" action="/board/write" method="post" enctype="multipart/form-data">

<div class="form-group">
	<label for="writer">작성자(nick)</label>
	<input type="text" class="form-control" id="writer" name="${nick }" readonly="readonly">
</div>

<div class="form-group">
	<label for="title">제목(title)</label>
	<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요.">
</div>

<div class="form-group">
	<label for="content">본문</label>
	<textarea rows="10" style="width: 100%;" id="content" name="contetn"></textarea>
</div>

<div class="form-group">
	<label>첨부파일<input type="file" name="file"></label>
</div>

<div class="text-center">
	<button class="btn btn-primary" id="btnWrite">작성</button>
	<input type="reset" id="reset" class="btn" value="작성글 초기화">
	<button class="btn btn-danger" id="btnCancel">취소</button>
</div>

</form>

<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors
	, elPlaceHolder: "content"
	, sSkinURI: "/resources/se2/SmartEditor2Skin.html"
	, fCreator: "createSEditor2"
})
</script>


</div> <!-- .container end -->


<c:import url="/WEB-INF/views/layout/footer.jsp"/>
