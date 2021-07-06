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
	<title>로그인</title>
</head>
<body>


<!-- c:forEach를 쓰려면 저 위에 taglib가 필요하다.(prefix="c"가 c:이다) -->
<!-- 서버에서의 반복문을 편하게 쓸 수 있다. -->
<!-- items에는 서버에서 보낸 리스트를 연결하고, var에는 리스트에서 하나 꺼낸 객체의 이름을 지정한다. -->
<c:forEach items="${list}" var = "board">
<!-- vo를 이용하여 멤버변수명을 쓰면 해당 멤버 변수를 부르는 것이 아니라 해당 멤버 변수의 getter를 부르는 것이다. -->
<!-- board.num을 호출하지만 board.get(num)을 호출하는 것이다. vo멤버변수는 private이라 쓸 수 없다. -->
	${board.num } : ${board.title } : ${board.views } : ${board.writer } : ${board.registered } <br>
</c:forEach>

<!-- 부트스트랩에서 가져옴 -->
<div class="container">
  <h2>게시판</h2>
            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>조회수</th>
        <th>작성자</th>
        <th>등록일</th>
      </tr>
    </thead>
    <tbody>
	    <c:forEach items="${list}" var="board">
	      <tr>
	        <td>${board.num }</td>
	        <td>${board.title }</td>
	        <td>${board.writer }</td>
	        <td>${board.registered }</td>
	        <td>${board.views }</td>
	      </tr>
	     </c:forEach> 
    </tbody>
  </table>
</div>

</body>
</html>
