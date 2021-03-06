<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- include file = "/WEB_INF/views/common/header.jsp" -->
    <%@include file = "../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 

<title>회원가입</title>
<style>
body{
	padding-top:80px;
}
</style>
</head>
<body>
	<div class = "container">
		<h2>JOIN</h2>
		
		<form name = "form" id = "form" action = "${contextPath}/member/join" method = "post">
			<div class = "mb-3">
				<label for = "id">아이디</label>
				<input type = "text" class = "form-control" name = "id" id = "id"/>
			</div>
			
			<div class="mb-3">
					<label for="pwd">비밀번호</label>
					<input type="password" class="form-control" name="pwd" id="pwd" />
				</div>
			<div class = "mb-3">
				<label for = "name">이름</label>
				<input type = "text" class = "form-control" name = "name" id = "name"/>
			</div>
			<div class = "mb-3">
				<label for = "email">이메일</label>
				<input type = "email" class = "form-control" name = "email" id = "email"/>
			</div>

				
			<div >
				<button type="button" class="btn btn-sm btn-primary" id="btnJoin">가입</button>
			</div>


		</form>
	</div>
	
</body>
<script>
$(function(){
	
	$(document).on('click', '#btnJoin', function(e){
		e.preventDefault();
		//var test = $('input[name=lock]').val();
		//alert(test);
		$("#form").submit();
	});

	
	
});
</script>
</html>