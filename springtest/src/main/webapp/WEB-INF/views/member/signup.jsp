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
<script type="text/javascript">
// 정규 표현식 검사 간단하게
	$(function{
		$('form').submit(function() {
			var id = $('[name=id]').val();
			var pw = $('[name=pw]').val();
			var pw2 = $('[name=pw2]').val();
			var name = $('[name=name]').val();
			var email = $('[name=email]').val();
			if(id.trim() == ''){
				alert('아이디를 입력하세요.');
				return false;
			}
			if(pw.trim() == ''){
				alert('비밀번호를 입력하세요.');
				return false;
			}
			if(pw != pw2){
				alert('비밀번호가 일치하지 않습니다.');
				return false;
			}
			if(name.trim() == ''){
				alert('이름을 입력하세요.');
				return false;
			}
			if(email.trim() == ''){
				alert('이메일을 입력하세요.');
				return false;
			}
		})
	})
</script>
</body>
</html>