<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<title>board</title>
</head>
<body>
	<div class = "container">
	<header class="blog-header py-3">
    <div class="row flex-nowrap justify-content-between align-items-center">
      <div class="col-4 pt-1">
        <a class="text-muted" href="#">blog home</a>
      </div>
      <div class="col-4 text-center">
        <a class="blog-header-logo text-dark" href="#">Large</a>
      </div>
      <div class="col-4 d-flex justify-content-end align-items-center">
        <a class="text-muted" href="#">
          <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-3" focusable="false" role="img"><title>Search</title><circle cx="10.5" cy="10.5" r="7.5"></circle><line x1="21" y1="21" x2="15.8" y2="15.8"></line></svg>
        </a>
        <a class="btn btn-sm btn-outline-secondary" href="#">Sign up</a>
      </div>
    </div>
  </header>
  <div class="nav-scroller py-1 mb-2">
    <nav class="nav d-flex justify-content-between">
      <a class="p-2 text-muted" href="#">카</a>
      <a class="p-2 text-muted" href="#">테</a>
      <a class="p-2 text-muted" href="#">고</a>
      <a class="p-2 text-muted" href="#">리</a>
      <a class="p-2 text-muted" href="#">설</a>
      <a class="p-2 text-muted" href="#">정</a>
      <a class="p-2 text-muted" href="#">해</a>
      <a class="p-2 text-muted" href="#">야</a>
      <a class="p-2 text-muted" href="#">되</a>
      <a class="p-2 text-muted" href="#">는</a>
      <a class="p-2 text-muted" href="#">데</a>
    </nav>
  </div>
	<div class = "row mb-2">
		<c:choose>
				<c:when test="${empty postList }" >
					<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>
				</c:when> 
		<c:when test="${!empty postList}">
				<c:forEach var="list" items="${postList}">
		<div class = "col-md-6">
			<div class = "card flex-md-row mb-4 shadow-sm h-md-250">
				<div class = "card-body d-flex flex-column align-items-start">
					<strong class = "d-inline-block mb-2 text-primary">
						category
					</strong>
					<h3 class = "mb-0">
						<a class = "text-dark" href = "#"><c:out value="${list.title}"/></a>
					</h3>
					<div class = "mb-1 text-muted"><c:out value="${list.date}"/></div>
					<p class = "card-text mb-auto">
						<c:out value="${list.content}"/>
					</p>
					<a href = "#">Continue reading</a>
				</div>
			</div>
		</div>
		</c:forEach>
		</c:when>
		</c:choose>
	</div>
	
	</div>
	<footer class="blog-footer">
  <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
  <p>https://getbootstrap.com/docs/4.2/examples/blog/</p>
  <p>
    <a href="#">Back to top</a>
  </p>
</footer>
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
 <script>window.jQuery || document.write('<script src="/docs/4.2/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
 <script src="/docs/4.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-zDnhMsjVZfS3hiP7oCBRmfjkQC4fzxVxFhBx8Hkz2aZX8gEvA/jsP3eXRCvzTofP" crossorigin="anonymous"></script>
</body>

</html>

