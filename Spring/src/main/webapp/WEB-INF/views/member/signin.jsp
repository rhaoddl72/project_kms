<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

<!--<%=request.getContextPath()%> jsp코드인데 프로젝트 명에 상관없이 동일하게 siginin으로 보낸다.  -->
<form class = "container" method = "post" action = "<%=request.getContextPath()%>/signin">

	<h1>로그인</h1>
	<div class="form-group">
	  <label>아이디:</label>
	  <input type="text" class="form-control" name="id">
	</div>
	<div class="form-group">
	  <label>비밀번호:</label>
	  <input type="password" class="form-control" name="pw">
	</div>
	<button class="btn btn-outline-success col-12">로그인</button>
</form>


</body>
</html>
