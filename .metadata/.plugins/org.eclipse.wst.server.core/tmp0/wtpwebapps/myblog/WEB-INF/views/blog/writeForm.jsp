<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- include file = "/WEB_INF/views/common/header.jsp" -->
    <%@include file = "../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<style>
body{
	padding-top:90px;
}</style>
</head>
<body>
	<div class = "container">
		<h2>WRITE POST</h2>
		<form name = "form" id = "form" method = "post" action= "${contextPath}/${uid}/post">
			<div class = "mb-3">
				<label for = "title">제목</label>
				<input type = "text" class = "form-control" name = "title" id = "title" placeholder = "제목">
			</div>
			
			<div class="mb-3">
					<label for="writer">작성자</label>
					<input type="text" class="form-control" name="writer" id="writer" placeholder="작성자; 로그인 기능 구현 후 삭제">
				</div>

				<div class="mb-3">
					<label for="content">내용</label>
					<textarea class="form-control" rows="5" name="content" id="content" placeholder="내용을 입력해 주세요" ></textarea>
				</div>
			<!-- 공개여부 -->
			<div class="d-block my-3">
          <div class="custom-control custom-radio">
            <input id="lock" name="lock" type="radio" class="custom-control-input" checked required>
            <label class="custom-control-label" for="credit">공개</label>
          </div>
          <div class="custom-control custom-radio">
            <input id="lock" name="lock" type="radio" class="custom-control-input" required>
            <label class="custom-control-label" for="debit">비공개</label>
          </div>
        </div>
			<div >
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>


		</form>
	</div>
	
</body>
<script>
$(function(){
	$(document).on('click', '#btnSave', function(e){
		e.preventDefault();
		$("#form").submit();
	});

	
	$(document).on('click', '#btnList', function(e){
		e.preventDefault();

		location.href="${contextPath}/board";
	});
});
</script>
</html>