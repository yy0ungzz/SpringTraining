<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp"/>

<script type="text/javascript">

$(document).ready(function() {
	
	/* 취소 버튼을 누르면 방문기록 이전으로 이동 */
	$("#cancel").click(function() {
		history.go(-1)
	})
	
	/* 페이지 이동 하는 순간 입력폼 아이디칸에 마우스 커서 자동으로 생김*/
	$("#id").focus()
	
})

</script>

<div class="container">

<h1>Login Form 로그인</h1>
<hr>

<form class="form-horizontal" action="/member/login" method="post">

<div class="form-group">
	<label for="id" class="col-sm-3 control-label">ID(아이디) : </label>
	<div class="col-sm-5">
		<input type="text" class="form-control" id="id" name="id" placeholder="아이디 입력">
	</div>
</div>

<div class="form-group">
	<label for="pw" class="col-sm-3 control-label">PW(비밀번호) : </label>
	<div class="col-sm-5">
		<input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호 입력">
	</div>
</div>

<div class="form-group">
	<div class="col-sm-offset-5">
		<button class="btn btn-primary">로그인</button>
		<input type="reset" id="cancel" class="btn btn-danger" value="취소">
	</div>
</div>

</form>

</div> <!-- .container end -->


<c:import url="/WEB-INF/views/layout/footer.jsp"/>
