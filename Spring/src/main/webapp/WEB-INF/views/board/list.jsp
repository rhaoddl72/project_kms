<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>

</head>
<body>
<!-- 부트스트랩에서 가져옴 -->
<div class="container clearfix">
	<h2>게시판</h2>
<!-- 이부분에 action을 안넣어주면 기존 url뒤에 추가로 아래 내용들이 붙어서 원하지 않는결과가 나오므로
  		기존 url을 버려주고 새로운 url추가를 위해 action사용 -->
	<form class="input-group float-right mb-3" action="<%=request.getContextPath()%>/board/list">
		<select class="form-control mr-2" name="type">
			<!-- 아래에 if는 새로고침해도 타입이 유지되게 해준다. -->
			<option value="0" <c:if test="${pm.criteria.type == 0 }">selected</c:if>>전체</option>
			<option value="1" <c:if test="${pm.criteria.type == 1 }">selected</c:if>>제목+내용</option>
			<option value="2" <c:if test="${pm.criteria.type == 2 }">selected</c:if>>작성자</option>
		</select>
		<!-- c:out을 통해 "",''등 특수문자를 검색할 수 있다. -->
		<input type="text" class="form-control mr-2" name="search" value="<c:out value="${pm.criteria.search}"/>">
		<button class="btn btn-outline-primary">검색</button>
	</form>
	<c:if test="${list.size() != 0 }">
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
		  	<!-- items에는 서버에서 보낸 리스트를 연결하고, var에는 리스트에서 하나 꺼낸 객체의 이름을 지정-->
				<c:forEach items="${list}" var="board">
				<!-- vo를 이용하여 멤버변수명을 쓰면 해당 멤버 변수를 부르는 것이 아니라 해당 맴버 변수의 getter를 부르는 것이다 -->
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
		<ul class="pagination justify-content-center">
			<c:if test="${pm.prev}">
				<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}&type=${pm.criteria.type}&search=${pm.criteria.search}">이전</a></li>
			</c:if>
			<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="index">
				<li class="page-item <c:if test="${pm.criteria.page == index }">active</c:if>"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}&type=${pm.criteria.type}&search=${pm.criteria.search}">${index}</a></li>
			</c:forEach>
			
			<c:if test="${pm.next }">
				<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}&type=${pm.criteria.type}&search=${pm.criteria.search}">다음</a></li>
			</c:if>
		</ul>
	</c:if>
	<c:if test="${list.size() == 0 }">
  		<h1>게시글이 없습니다.</h1>
	</c:if>
  	<a href="<%=request.getContextPath()%>/board/register"><button class="btn btn-outline-success">글쓰기</button></a> <br>
  	<img src="<%=request.getContextPath()%>/resources/img/2.jpg">
</div>
</body>
</html>