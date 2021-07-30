<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

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
	  
  	<textarea class="form-control" name="contents"></textarea>

	</div>
	
	<div class="form-group">
        <label>파일</label>
        <input type="file" class="form-control" name="fileList">
        <input type="file" class="form-control" name="fileList">
        <input type="file" class="form-control" name="fileList">
    </div>
 	<button type="submit" class="btn btn-outline-success">등록
 	</button>
</form>
<script type="text/javascript">
	$(function() {
		$('form').submit(function() {
			return true;
		})
	})

</script>

</body>
</html>
