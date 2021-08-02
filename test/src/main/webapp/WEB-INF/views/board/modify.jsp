<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>


<form class="container" method="post" action="<%=request.getContextPath()%>/board/modify" enctype="multipart/form-data">
  <h2>게시글 수정</h2>
    <div class="form-group" >
	  <label>제목</label>
	  <input type="text" class="form-control" name="title" value="${board.title}">
	</div>
	<div class="form-group" >
	  <label>작성자</label>
	  <input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
	</div>
	<div class="form-group" >
	  <label>내용</label>
	  <textarea class="form-control" id="summernote" name="contents"></textarea>
	</div>
	<div class="form-group file-box">
	  <label>첨부파일</label>
	</div>
	<!-- type을 hidden으로 해서 안보이게 num을 넘겨준다. -->
	<input type="hidden" value="${board.num}" name="num">
 	<button type="submit" class="btn btn-outline-success">수정</button>
 	<a href="<%=request.getContextPath()%>/board/list" class="mr-2"><button type="button" class="btn btn-outline-success">목록</button></a>
</form>

</body>
</html>
