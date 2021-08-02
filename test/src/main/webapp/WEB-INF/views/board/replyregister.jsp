<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>


<form class="container" method="post" action="<%=request.getContextPath()%>/board/reply/register">
  <h2>게시글 등록</h2>
   <!-- 답변달기 할 때 자동으로 제목을 문의글과 같이 해주기위해 제목 태그 지움 -->
	<div class="form-group" >
	  <label>내용</label>
	  
  	<textarea class="form-control" name="contents"></textarea>

	</div>
	
	<input type="hidden" name="oriNo" value="${oriNo}">
 	<button class="btn btn-outline-success">등록
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
