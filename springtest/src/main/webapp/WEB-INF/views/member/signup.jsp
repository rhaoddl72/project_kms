<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.error{
		color: red;
	}
</style>
</head>
<body>
<form class = "container" method = "post" action = "<%=request.getContextPath()%>/signup">
	<h1>회원가입</h1>
	<div class="form-group" >
	  <label>id:</label>
	  <input type="text" class="form-control" name="id">
	</div>
	<button type="button" id="idCheck" class="input-group-oppend btn btn-outline-success">아이디 중복 확인</button>
	<div class="form-group">
	  <label>Password:</label>
	  <input type="password" class="form-control" name="pw" id="pw">
	</div>
	<div class="form-group">
	  <label>Password confirm:</label>
	  <input type="password" class="form-control" name="pw2">
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

	$(function(){
		
		$("#idCheck").click(function() {
			var id = $('[name=id]').val();
			if(id == ''){
				alert('아이디를 입력하세요.');
				return;
			}
			$.ajax({
				type : 'get',
				url : '<%=request.getContextPath()%>/member/idCheck/' + id,
				success : function(result, status, xhr) {
					
					if(result == "true")
						alert("사용 가능한 아이디입니다.");
					else{
						alert("사용 불가능한 아이디입니다.");
					}
				},
				error : function(xhr, status, e) {
					console.log('에러발생');
				}
			})
		})
		
		 
	})
</script>
</body>
</html>