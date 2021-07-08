<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<title>게시글 삭제</title>
</head>
<body>


<form class="container" method="post" action="<%=request.getContextPath()%>/board/modify">
  <h2>게시글 수정</h2>
    <div class="form-group" >
	  <label>제목</label>
	  <input type="text" class="form-control" value="${board.title}">
	</div>
	<div class="form-group" >
	  <label>작성자</label>
	  <input type="text" class="form-control" value="${board.writer}" readonly>
	</div>
	<div class="form-group" >
	  <label>내용</label>
	  <textarea class="form-control" rows="10" name="contents">${board.contents}</textarea>
	</div>
	<!-- type을 hidden으로 해서 안보이게 num과 조회수를 넘겨준다. -->
	<input type="hidden" value="${board.num}" name="num">
	<input type="hidden" value="${board.views}" name="views">
 	<button type="submit" class="btn btn-outline-success">수정
 	</button>
</form>

</body>
</html>
