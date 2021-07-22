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
	<div class="form-group" >
	  <label>내용</label>
	 <textarea id="summernote" name="contents" placeholder="내용을 입력해주세요."></textarea>
	</div>
	<div class="form-group" >
	  <label>파일</label>
	  <input type="file" class="form-control" name="files">
	  <input type="file" class="form-control" name="files">
	  <input type="file" class="form-control" name="files">
	</div>
	
 	<button type="submit" class="btn btn-outline-success">등록
 	</button>
 	<!-- type을 button으로 안해주면 전송을 해버린다.(form태그 때문에) -->
 	<a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-success">목록</button></a>
</form>
<script type="text/javascript">

$('#summernote').summernote({
    placeholder: 'Hello Bootstrap 4',
    tabsize: 2,
    height: 400
  });


</script>
</body>
</html>
