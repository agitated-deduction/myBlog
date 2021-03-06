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
	padding-top:80px;
}
.post_title{
font-weight: 700;
font-size:22pt;
margin: 10pt;
}
.post_writer{
font-size:10pt;
margin-right:10pt;}
.post_date{
font-size: 10pt;}
.post_content{
margin: 20pt;}
</style>
</head>
<body>
<article>
	<div class="container" role="main">
		<h2>POST</h2>

			<div class="bg-white rounded shadow-sm">
				<div class="post_title"><c:out value="${post.title}"/></div>

				<div class="post_info_box">

					<span class="post_writer"><c:out value="${post.writer}"/></span><span class="post_date"><c:out value="${post.date}"/></span>

				</div>
				<div class="post_content">${post.content}</div>
			</div>

			<div style="margin-top : 20px">
				<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
				<input type="button" class="btn btn-sm btn-primary" id="btnDelete" value = "삭제">
				<!-- 목록 버튼 클릭시 홈 말고 뒤로 -->
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>

			</div>

		</div>

		

	</article>
</body>
<script>
$(function(){
	$(document).on('click', '#btnUpdate', function(e){
		e.preventDefault();
		//${post.writer} == ${uid}???
		//var url = "${contextPath}/"+${uid}+"/post?"+"num="+${post.idx}+"&mode=edit";
		var url = "${contextPath}/${post.writer}/newpost?idx="+${post.idx}+"&mode=edit";
		
		location.href = url;
	});
	$(document).on('click', '#btnDelete', function(e){
		e.preventDefault();
		$.ajax({
			url:'${contextPath}/${post.writer}/${post.idx}',
			type: 'DELETE',
			success:function(result){
				if(result == 'success')
					location.href = "${contextPath}/board";
				else
					alert("삭제 실패 다시 시도해주세요");
					
			},
			error: function(result){
				console.log("err");
			}
		});
	});

	
	$(document).on('click', '#btnList', function(e){
		e.preventDefault();

		location.href="${contextPath}/board";
	});
});
</script>
</html>