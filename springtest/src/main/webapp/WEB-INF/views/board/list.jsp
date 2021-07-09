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
	<title>게시판</title>
</head>
<body>


<!-- 부트스트랩에서 가져옴 -->
<div class="container">
  <h2>게시판</h2>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
	    <c:forEach items="${list}" var="board">
	      <tr>
	        <td>${board.num}</td>
	        <td><a href="<%=request.getContextPath()%>/board/detail?num=${board.num}">${board.title}</a></td>
	        <td>${board.writer}</td>
	        <td>${board.registeredDate}</td>
	        <td>${board.views}</td>
	      </tr>
	     </c:forEach> 
    </tbody>
  </table>
  <a href="<%=request.getContextPath()%>/board/register"><button class="btn btn-outline-success">글쓰기</button></a> <br>
  <img src="<%=request.getContextPath()%>/resources/Img/2.jpg">
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
