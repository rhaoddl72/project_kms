<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>


<div class="container">
	<table class="table">
	    <thead>
		      <tr>
		        <th>번호</th>
		        <th>제목</th>
		        <th>작성자</th>
		        <th>작성일</th>
		        <th>조회수</th>
		      </tr>
		    </thead>
		    <tbody>
		    <c:forEach items="${list}" var="board" varStatus="status">
		      <tr>
		      <!-- 공지사항과 일반 게시판 순서를 따로 표현해주기 위한것 -->
		        <td>${pm.totalCount - status.index - pm.criteria.pageStart}</td>
		        <td>
		        	<a href="<%=request.getContextPath()%>/board${type}/detail?num=${board.num}">
		        		<c:if test="${board.groupOrd != 0}"> ☞ 답변 : </c:if>
		        		${board.title}
		        	</a>
		        </td>
		        <td>${board.writer}</td>
		        <td>${board.dateTime}</td>
		        <td>${board.views}</td>
		      </tr>
		    </c:forEach>
	    </tbody>
  </table>
	     <ul class="pagination justify-content-center">
	     
	    	<c:if test="${pm.prev}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board${type}/list?page=${pm.startPage-1}">이전</a></li>
	    </c:if>
	    
	    <c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="index">
	    	<c:choose>
	    		<c:when test="${pm.criteria.page == index }">
					<li class="page-item active"><a class="page-link" href="<%=request.getContextPath()%>/board${type}/list?page=${index}">${index}</a></li>	    		
	    		</c:when>
	    		<c:otherwise>
	    			<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board${type}/list?page=${index}">${index}</a></li>	
	    		</c:otherwise>
	    	</c:choose>
	    </c:forEach>
	    
	    <c:if test="${pm.next}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board${type}/list?page=${pm.endPage+1}">다음</a></li>
	    </c:if>
	    
  		</ul>
 <c:if test="${user != null}">
<!-- 타입이 공지이고 관리자이거나 타입이 공지사항이 아니면 글쓰기 버튼이 보여야함 -->
	<c:if test="${(type eq '/notice' && (user.authority eq 'ADMIN' || 
	user.authority eq 'SUPER ADMIN')) || (type ne '/notice')}">
		<a href="<%=request.getContextPath()%>/board${type}/register">
			<button class="btn btn-outline-success">글쓰기</button>
		</a>
	</c:if>
</c:if>
</div>
</body>
</html>
