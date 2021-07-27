<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

<div class="container">
	<h1>로그인</h1>
	<div class="form-group">
	  <input type="text" class="form-control" name="id" placeholder="아이디를 입력하세요.">
	</div>
	<button class="find-pw-btn btn btn-outline-success col-12">비밀번호 찾기</button>
	<div class="wait-box"></div>	
</div>

<script type="text/javascript">

	$(function() {
		$('.find-pw-btn').click(function() {
			var id = $('[name=id]').val();
			$('.wait-box').text('전송중입니다. 알림창이 나타날때까지 기다려주세요.')
			$.ajax({
				type : 'get',
				url : '<%=request.getContextPath()%>/find/pw/' + id,
				success : function(res) {
					$('.wait-box').text('')
					if(res == 'SUCCESS'){
						alert('새 비밀번호가 메일로 전송됐습니다.')
					}else{
						alert('가입되지 않은 이용자입니다.')
					}
				}
			})
		})
	})

</script>
</body>
</html>
