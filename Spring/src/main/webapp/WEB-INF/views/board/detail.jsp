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

<c:if test="${board != null}">
<div class="container">
  <h2>게시판</h2>
    <div class="form-group" >
	  <label>제목</label>
	  <input type="text" class="form-control" value="${board.title}" readonly>
	</div>
	<div class="form-group" >
	  <label>작성자</label>
	  <input type="text" class="form-control" value="${board.writer}" readonly>
	</div>
	<div class="form-group" >
	  <label>작성일</label>
	  <input type="text" class="form-control" value="${board.registeredDate}" readonly>
	  <!-- 멤버변수 처럼 registeredDate를 썻지만 이렇게 쓰면 자동으로 getter형식으로 
	       ${board.getRegisteredDate()}이런식으로 호출한다. -->
	</div>
	<div class="form-group" >
	  <label>조회수</label>
	  <input type="text" class="form-control" value="${board.views}" readonly>
	</div>
	<div class="form-group" >
	  <label>내용</label>
	  <!-- 쌍태그에는 value값을 가운데에 넣어준다. -->
	  <textarea class="form-control" readonly>${board.contents}</textarea>
	</div>
	<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}"><button class="btn btn-outline-success">수정</button></a>
	<a href="<%=request.getContextPath()%>/board/delete?num=${board.num}"><button class="btn btn-outline-success">삭제</button></a>
	<a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-outline-success">목록</button></a>
	
 
</div>
</c:if>
<c:if test="${board == null}">
<div class="container">
	<h1>삭제되거나 존재하지 않은 게시물입니다.</h1>
	<a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-outline-success">목록</button></a>
</div>
</c:if>
</body>

</html>
