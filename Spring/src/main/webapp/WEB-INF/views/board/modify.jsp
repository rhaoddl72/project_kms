<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

$(function() {
	
	$('.del-btn').click(function () {
		var str = '<input type="file" class="form-control" name="file">';
		$(this).parent().remove();
		$('.file-box').append(str)
	})
	
	
})

</script>
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
	  <textarea class="form-control" rows="10" name="contents">${board.contents}</textarea>
	</div>
	<!-- type을 hidden으로 해서 안보이게 num과 조회수를 넘겨준다. -->
	<input type="hidden" value="${board.num}" name="num">
	<input type="hidden" value="${board.views}" name="views">
	
	<c:if test="${file != null}">
	<div class="form-group file-box">
	<label>첨부파일</label>
	<div  class="form-control">${file.ori_name }<button type="button" class="del-btn">x</button></div>
	</div>
	</c:if>
	
	<c:if test="${file == null}">
	<div class="form-group">
	<label>첨부파일</label>
	<input type="file" class="form-control" name="file">
	</div>
	</c:if>
	
	
 	<button type="submit" class="btn btn-outline-success">수정
 	<a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-outline-success">목록</button></a>
 	</button>
</form>

</body>
</html>
