<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<form class = "container" method = "post" action = "<%=request.getContextPath()%>/signup">
	<h1>회원가입</h1>
	<div class="form-group" >
	  <label>id:</label>
	  <input type="text" class="form-control" name="id">
	</div>
	<div class="form-group">
	  <label>Password:</label>
	  <input type="password" class="form-control" name="pw">
	</div>
	<div class="form-group">
	  <label>Password confirm:</label>
	  <input type="password" class="form-control" name="pw-confirm">
	</div>
	<div class="form-group">
	  <label>이름:</label>
	  <input type="text" class="form-control" name="name">
	</div>
	<div class="form-group">
	  <label>이메일:</label>
	  <input type="text" class="form-control" name="email">
	</div>
	<div class="form-group">
	  <label>성별:</label>
	  <select class="form-control" name="gender">
	  <option value="M">남성</option>
	  <option value="F">여성</option>
	  </select>
	</div>
	<button class="btn btn-outline-success col-12">회원가입</button>
</form>
</body>
</html>