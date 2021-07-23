<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<!-- 모듈화를 위해 추가 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/reply.js"></script>


<style type="text/css">
.recommend-btn{
	font-size: 30px;
}

 .fa-thumbs-down{
 	transform : rotatey(180deg);
 }
 
</style>
</head>
<body>


<div class="container">
  <h2>게시판</h2>
    <div class="form-group" >
	  <label>제목</label>
	  <!--제목에 쌍따옴표 들어가면 화면에서 출력이 안돼서 value에 cout사용 -->
	  <input type="text" class="form-control" name="title" value="<c:out value="${board.title}"/>" readonly>
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
		<a href="#" class="recommend-btn up">
		<c:choose>
			<c:when test="${recommend != null && recommend.state == 1}"><i class="fas fa-thumbs-up"></i></c:when>
			<c:otherwise><i class="far fa-thumbs-up"></i></c:otherwise>
		</c:choose>
		</a>
		<a href="#" class="recommend-btn down">
		<c:choose>
			<c:when test="${recommend != null && recommend.state == -1}"><i class="fas fa-thumbs-down"></i></c:when>
			<c:otherwise><i class="far fa-thumbs-down"></i></c:otherwise>
		</c:choose>
		</a>
	</div>
	<div class="form-group" >
	  <label>내용</label>
	  <div class="form-control" style="height: auto">${board.contents}</div>
	</div>
	<c:if test="${fileList.size() != 0}">
	<div class="form-group">
		<label>첨부파일</label>
	<c:forEach items="${fileList}" var="file">
		<a href="<%=request.getContextPath()%>/board/download?fileName=${file.name}" class="form-control mb-2">${file.ori_name}</a>
	</c:forEach>
	</div>
	</c:if>
	<div class="reply form-group">
		<label>댓글</label>
		<div class="contents">
			<div class="reply-list form-group">
			</div>
			<ul class="pagination justify-content-center">
				
			</ul>
			<div class="reply-box form-group">
				<textarea class="reply-input form-control mb-2" ></textarea>
				<button type="button" class="reply-btn btn btn-outline-success">등록</button>
			</div>
		</div>
	</div>
	<!-- form태그가 띄어쓰기가 되버려서 div태그로 감싸줘서 붙여줌(부트스트랩의 input-group사용) -->
	<!-- class=mr-2는 부트스트랩의 margin-right이고 값을 -2해주는거다. -->
	<div class="input-group">
	<a href="<%=request.getContextPath()%>/board/list" class="mr-2"><button class="btn btn-outline-success">목록</button></a>
	
	<!-- 게시글이 없는 게시글일 때 수정 삭제 버튼 안보이게 하기 -->
	<!-- eq는 ==(같다)랑 같은 의미다. -->
	<c:if test="${board != null && user.id eq board.writer}">
	<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}" class="mr-2"><button class="btn btn-outline-success">수정</button></a>
	<!-- 삭제버튼을 post로 해야하기때문에(url에서 못고치게하려고) a태그 지워준다.(post는 form태그에서만 가능) -->
	<form action="<%=request.getContextPath()%>/board/delete" method="post" class="mr-2" enctype="multipart/form-data">
	<input type="hidden" value="${board.num}" name="num">
	<button class="btn btn-outline-success">삭제</button>
	</form>
	</c:if>
	
 	</div>
</div>
<!-- 삭제할 때 메세지창 띄어주기 -->
<script type="text/javascript">
	//전역 변수
	//게시글 번호
	var rp_bd_num = '${board.num}';
	//프로젝트명
	var contextPath = '<%=request.getContextPath()%>';	
	//아이디
	var id = '${user.id}';
	
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
	
	$(function() {
		$('.recommend-btn').click(function(e) {
			e.preventDefault();
			var board = ${board.num};
			var state = $(this).hasClass('up') ? 1 : -1;
			$.ajax({
				type: 'get',
				url : '<%=request.getContextPath()%>/board/recommend/' + board + '/' + state,
				success : function(res, status, xhr){
					// i는 태그를 말한다.
					$('.recommend-btn i').removeClass('fas').addClass('far');
					if(res == 'UP'){
						alert("해당 게시글을 추천했습니다.");
						$('.recommend-btn.up i').addClass('fas');
					}else if (res == 'DOWN') {
						alert("해당 게시글을 비추천했습니다.");
						$('.recommend-btn.down i').addClass('fas');
					}else if(res == "GUEST"){
						alert('추천을 하려면 로그인을 하세요.');
					}else if(res == "CANCEL"){
						if(state == 1){
							alert('추천을 취소했습니다.');
						}
						else{
							alert('비추천을 취소했습니다.');
						}
					}
						
				},
				error : function(xhr, status, e){
					
				}
			})
		})
	})
	
	$(function() {
		
		replyService.list(contextPath,rp_bd_num, 1,id);
		
		$('.reply-btn').click(function(){
			var rp_bd_num = '${board.num}';
			var rp_me_id = '${user.id}';
			var rp_content = $('.reply-input').val();
			// 왼쪽은 속성명, 오른쪽은 변수
			if(rp_me_id == ''){
				alert("로그인 하세요.");
				return;
			}
			var data = {
					'rp_bd_num' : rp_bd_num, 
					'rp_me_id'  : rp_me_id, 
					'rp_content': rp_content}
			
			
			
			// reply.js로 data랑 contextPath 보내주기
			replyService.insert(contextPath,data);
		})
		
		$(document).on('click','.pagination .page-item', function(){
			var page = $(this).attr('data');
			replyService.list(contextPath,rp_bd_num,page,id);
		})
		
		$(document).on('click','.mod-btn', function(){
			
			var contentObj = $(this).parent().prev().children().last();
			
			var str = '<div class="reply-mod-box form-group">'+
						'<textarea class="reply-input form-control mb-2" >'+contentObj.text()+'</textarea>'+
						'<button type="button" class="reply-mod-btn btn btn-outline-success">등록</button>'+
			    	'</div>';
			
			contentObj.after(str).remove();
			
			$(this).parent().remove();
			
		})
		
	})
	


</script>
</body>

</html>
