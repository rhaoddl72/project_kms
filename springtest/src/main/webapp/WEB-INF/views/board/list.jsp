<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>


<!-- 부트스트랩에서 가져옴 -->
<div class="container">
  <h2>게시판</h2>
  <form method="get" class="input-group float-right mb-3" action="<%=request.getContextPath()%>/board/list">
		<select class="form-control mr-2" name="type">
			<!-- 아래에 if는 새로고침해도 타입이 유지되게 해준다. -->
			<option value="0" <c:if test="${pm.criteria.type == 0 }">selected</c:if>>전체</option>
			<option value="1" <c:if test="${pm.criteria.type == 1 }">selected</c:if>>제목+내용</option>
			<option value="2" <c:if test="${pm.criteria.type == 2 }">selected</c:if>>작성자</option>
		</select>
		<!-- c:out을 통해 "",''등 특수문자를 검색할 수 있다. -->
		<input type="text" class="form-control mr-2" name="search" value="<c:out value="${pm.criteria.search}"/>">
		<button class="btn btn-outline-dark">검색</button>
	</form>
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
  <ul class="pagination justify-content-center">
			<c:if test="${pm.prev}">
				<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}&type=${pm.criteria.type}&search=<c:out value="${pm.criteria.search}"/>">이전</a></li>
			</c:if>
			<!--  active는 현재 해당 페이지에 색상을 넣어준다. -->
			<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="index">
				<li class="page-item <c:if test="${pm.criteria.page == index }">active</c:if>">
				<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}&type=${pm.criteria.type}&search=<c:out value="${pm.criteria.search}"/>">${index}</a></li>
			</c:forEach>
			
			<c:if test="${pm.next }">
				<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}&type=${pm.criteria.type}&search=<c:out value="${pm.criteria.search}"/>">다음</a></li>
			</c:if>
		</ul>
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
