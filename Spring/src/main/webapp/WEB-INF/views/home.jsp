<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>메인</title>
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 부트스트랩 이용 home꾸며주기 -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">메인</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시글</a>
    </li>
    

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        회원
      </a>
      <div class="dropdown-menu">
      <!-- user가 null이면 로그인창 회원가입창 보여주고 아니면 안보여주기 -->
      <c:if test="${user == null}">
        <a class="dropdown-item" href="<%=request.getContextPath()%>/signin">로그인</a>
        <a class="dropdown-item" href="<%=request.getContextPath()%>/signup">회원가입</a>
       </c:if>
       <c:if test="${user != null}">
        <a class="dropdown-item" href="<%=request.getContextPath()%>/member/mypage">마이 페이지</a>
         <a class="dropdown-item" href="<%=request.getContextPath()%>/signout">로그아웃</a>
       </c:if>
      </div>
    </li>
  </ul>
</nav>
</body>
</html>
