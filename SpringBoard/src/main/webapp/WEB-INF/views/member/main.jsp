<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:import url="/WEB-INF/views/layout/header.jsp"/>

<script type="text/javascript">

$(document).ready(function() {
	
})

</script>

<div class="container">

<h1>Main 메인</h1>
<hr>

<div>

<c:choose>

	<c:when test="${empty login }">
	<a href="/member/login">로그인</a> | <a href="/member/join">회원가입</a>
	</c:when>
	
	<c:when test="${login eq true }">
	<a href="/member/logout">로그아웃</a>
	</c:when>
	
</c:choose>

	<hr>
	<a href="/board/list">게시판</a>
	
</div>

</div> <!-- .container end -->


<c:import url="/WEB-INF/views/layout/footer.jsp"/>

    