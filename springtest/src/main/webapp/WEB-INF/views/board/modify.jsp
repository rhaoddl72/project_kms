<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

$(function(){

	$(document).on('click','.del-btn',function(){

			var str = '<input type="file" class="form-control mb-2" name="files">';

			$(this).parent().remove();
			$('.file-box').append(str);
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
	<div class="form-group file-box">
	  <label>첨부파일</label>
	  <c:forEach items="${fileList}" var="file">
	 <div class="form-control mb-2">
	 <span>${file.ori_name}</span>
	 <input type="hidden" value="${file.num}" name="fileNums">
	 <button type="button" class="btn btn-outline-danger del-btn">x</button>
	 </div>
	 </c:forEach>
	 <c:forEach begin="1" end="${3 - fileList.size()}">
	 <input type="file" class="form-control mb-2" name="files">
	 </c:forEach>
	</div>
	<!-- type을 hidden으로 해서 안보이게 num을 넘겨준다. -->
	<input type="hidden" value="${board.num}" name="num">
 	<button type="submit" class="btn btn-outline-success">수정</button>
 	<a href="<%=request.getContextPath()%>/board/list" class="mr-2"><button type="button" class="btn btn-outline-success">목록</button></a>
</form>

</body>
</html>
