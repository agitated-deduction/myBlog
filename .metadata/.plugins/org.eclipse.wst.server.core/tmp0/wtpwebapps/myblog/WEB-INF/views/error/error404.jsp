<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- include file = "/WEB_INF/views/common/header.jsp" -->
    <%@include file = "../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>error404</title>
<style>
body{
	padding-top:80px;
}
</style>
</head>
<body>
<div class = "container">
	Not Found
	<br>
	<br>
	<a href = "${contextPath }/">홈으로 돌아가기</a>
</div>

</body>
</html>