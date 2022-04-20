<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:import url="/WEB-INF/views/layout/header.jsp"/>

<div class="container">

<h1>Main 메인</h1>
<hr>

<a href="/member/login"><button>로그인</button></a>
<a href="/member/logout"><button>로그아웃</button></a>
<a href="/member/join"><button>회원가입</button></a>
<a href="/board/list"><button>게시판</button></a>

</div>


<c:import url="/WEB-INF/views/layout/footer.jsp"/>

    