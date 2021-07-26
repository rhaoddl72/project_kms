<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>메인</title>

</head>
<body>
	<div class="container">
	<div class="form-group">
		<input type="text" class="form-control" placeholder="email" name="email">
	</div>
		
	<button type="button" id="findIdBtn" class="btn btn-outline-success">아이디 찾기</button>
	</div>
	
	
	<script type="text/javascript">
	
	$(function() {
		$('#findIdBtn').click(function() {
			var email = $('[name=email]').val();
			$.ajax({
				type : 'post',
				url : '<%=request.getContextPath()%>/find/id',
				data : {email : email},
				success : function(res) {
						alert('가입된 아이디를 메일로 전송했습니다.');
						
					
				}
			})
		})
	})
	
	</script>	

</body>
</html>
