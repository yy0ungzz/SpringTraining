<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">Spring Training Board List Test</h1>
<hr>

<c:forEach var="board" items="${list }">
	<div>
		<c:out value="${board}"></c:out>
	</div>
</c:forEach>

</body>
</html>