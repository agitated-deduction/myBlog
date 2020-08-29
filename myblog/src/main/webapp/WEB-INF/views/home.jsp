<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- include file = "/WEB_INF/views/common/header.jsp" -->
    <%@include file = "./common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 

<title>HOME</title>
<style>
body{
	padding-top:80px;
}
</style>
</head>
<body>
<h1>
	Hello world!  
</h1>
<p>GO TO <a href = "${contextPath }/board">BLOG HOME</a></p>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
