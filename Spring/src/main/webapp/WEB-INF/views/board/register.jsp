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
	<title>게시글 등록</title>
</head>
<body>


<form class="container" method="post" action="<%=request.getContextPath()%>/board/register" enctype="multipart/form-data">
  <h2>게시글 등록</h2>
    <div class="form-group" >
	  <label>제목</label>
	  <input type="text" class="form-control" name="title">
	</div>
	<!-- 작성자 항목 지워줌 로그인 기능 구현해서 글쓰기에 작성자 입력은 필요없으니까 -->
	<div class="form-group" >
	  <label>내용</label>
	  <textarea class="form-control" rows="10" name="contents"></textarea>
	</div>
	<div class="form-group">
        <label>파일</label>
        <input type="file" class="form-control" name="file"/>
    </div>
 	<button type="submit" class="btn btn-outline-success">등록
 	</button>
</form>

</body>
</html>
