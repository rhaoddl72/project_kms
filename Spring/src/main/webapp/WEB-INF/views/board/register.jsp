<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

$(function() {
	
	
	$(document).on('change','input[name=file]',function(){
		
		var val = $(this).val();
		var str = '<input type="file" class="form-control" name="file" data=""/>';
		var length = $('input[name=file]').length;
		var data = $(this).attr('data');
		
		// 
		if(val == ''){
			$(this).remove();
			// $('input[name=file]').last.val() != '' 해주는 이유는 
			if(length == 3 &&  $('input[name=file]').last.val() != '' ){
				$('.files').append(str);
			}
		}
		//input 태그를 추가해야 하는 경우
		// data는 이전값(바뀌기 전 값)
		// 이전 데이터가 선택안된 상태에서 선택 될때만 추가 아니면 추가x
		else{
			if(length < 3 && data == ''){
				$('.files').append(str);
			}
			$(this).attr('data',val);
		}
		
	});
	
})
</script>
</head>
<body>


<form class="container" method="post" action="<%=request.getContextPath()%>/board/register" enctype="multipart/form-data">
  <h2>게시글 등록</h2>
    <div class="form-group" >
	  <label>제목</label>
	  <input type="text" class="form-control" name="title">
	</div>
	<!-- 작성자 항목 지워줌 로그인 기능 구현해서 글쓰기에 작성자 입력은 필요없으니까 -->
	<div class="form-group" >
	  <label>내용</label>
	  <textarea class="form-control" rows="10" name="contents"></textarea>
	</div>
	
	<div class="form-group files">
        <label>파일</label>
        <input type="file" class="form-control" name="file" data=""/>
    </div>
 	<button type="submit" class="btn btn-outline-success">등록
 	</button>
</form>

</body>
</html>
