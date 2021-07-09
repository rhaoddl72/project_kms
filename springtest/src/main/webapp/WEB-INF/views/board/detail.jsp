<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<title>상세 게시글</title>
</head>
<body>


<div class="container">
  <h2>게시판</h2>
    <div class="form-group" >
	  <label>제목</label>
	  <input type="text" class="form-control" name="title" value="${board.title}" readonly>
	</div>
	<div class="form-group" >
	  <label>작성자</label>
	  <input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
	</div>
	<div class="form-group" >
	  <label>작성일</label>
	  <input type="text" class="form-control" name="registered" value="${board.registeredDate}" readonly>
	 
	</div>
	<div class="form-group" >
	  <label>조회수</label>
	  <input type="text" class="form-control" name="views" value="${board.views}" readonly>
	</div>
	<div class="form-group" >
	  <label>내용</label>
	  <textarea class="form-control" name="contents" rows="10" readonly>${board.contents}</textarea>
	</div>
	<!-- form태그가 띄어쓰기가 되버려서 div태그로 감싸줘서 붙여줌(부트스트랩의 input-group사용) -->
	<!-- class=mr-2는 부트스트랩의 margin-right이고 값을 -2해주는거다. -->
	<div class="input-group">
	<a href="<%=request.getContextPath()%>/board/list" class="mr-2"><button class="btn btn-outline-success">목록</button></a>
	
	<!-- 게시글이 없는 게시글일 때 수정 삭제 버튼 안보이게 하기 -->
	<c:if test="${board != null}">
	<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}" class="mr-2"><button class="btn btn-outline-success">수정</button></a>
	<!-- 삭제버튼을 post로 해야하기때문에(url에서 못고치게하려고) a태그 지워준다.(post는 form태그에서만 가능) -->
	<form action="<%=request.getContextPath()%>/board/delete" method="post" class="mr-2">
	<input type="hidden" value="${board.num}" name="num">
	<button class="btn btn-outline-success">삭제</button>
	</form>
	</c:if>
	
 	</div>
</div>
<!-- 삭제할 때 메세지창 띄어주기 -->
<script type="text/javascript">
	$(function() {
		var msg = '${msg}';
		printMsg(msg);
		//url을 뒤로가기했을 때(새로고침x 이전정보를 불러온다.) 알림창이 안뜨게해준다. 
		history.replaceState({},null,null);
	})
	
	function printMsg(msg) {
		if(msg ==''|| history.state){
			return;
		}
		alert(msg);
	}
</script>
</body>

</html>
