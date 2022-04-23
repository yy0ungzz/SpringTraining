<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp"/>

<script type="text/javascript">

$(document).ready(function() {
	
})

</script>

<div class="container">

<h1>게시글 상세내용 (Board Detail View)</h1>
<hr>

${viewBoard }


</div> <!-- .container end -->


<c:import url="/WEB-INF/views/layout/footer.jsp"/>
