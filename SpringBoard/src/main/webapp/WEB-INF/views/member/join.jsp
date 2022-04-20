<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp"/>

<div class="container">

<h1>Join 회원가입</h1>
<hr>

	<form action="/member/joinProc" method="post">
	
	<label for="id">ID(아이디) : <input type="text" name="id" id="id"></label><br>
	<label for="pw">PW(비밀번호) : <input type="text" name="pw" id="pw"></label><br>
	<label for="nick">NICKNAME(닉네임) : <input type="text" name="nick" id="nick"></label><br><br>
	
	<button>회원가입</button>
	
	</form>

</div>

<c:import url="/WEB-INF/views/layout/footer.jsp"/>