/**
 * 
 */
// 전역변수로 어디서든 쓸 수 있다.
// 이건 즉시 실행 함수이다.(만들자마자 실행)
var replyService = (function(){
	// data랑 contextPath가 detail.jsp에 있으니까 매개변수로 가져오기
	function insert(contextPath, data){
		$.ajax({
				type : 'post',
				url : contextPath+'/reply/ins',
				data : JSON.stringify(data),
				contentType : "application/json; charset=utf-8",
				//success 매개변수 하나만 넣어도 상관없다. 매개변수명도 마음대로다.
				success : function(res) {
					
					if(res == 'OK'){
						
						list(contextPath, data['rp_bd_num'], 1);
						
						//등록창에 있는 댓글 내용 지움
						$('.reply-input').val('');
						alert('댓글이 등록되었습니다.')
					}
				}
				
			})
	}
	function list(contextPath, rp_bd_num, page){
		$.ajax({
			type : 'get',
			url : contextPath + '/reply/list/' + rp_bd_num + '/' + page,
			dataType : 'json',
			success : function(result){
				
				var str = '<hr style="background:red;"/>';
				for(reply of result['replyList']){
					str += 
						'<div>'+
							'<label>'+reply['rp_me_id']+'</label>'+
							'<div class="form-control">'+reply['rp_content']+'</div>'+
						'</div>';
				}
				str += '<hr style="background:red;"/>';
				$('.reply-list').html(str);
				
				var pmStr = '';
				var pm = result['pm'];
				
				if(pm.prev){
					pmStr += '<li class="page-item" data="'+(pm.startPage-1)+'"><a class="page-link" href="#">이전</a></li>';
				}
				 
				for(i=pm.startPage; i<=pm.endPage; i++){
					var active = '';
					if(i == pm.criteria.page)
					pmStr += '<li class="page-item '+active+'" data="'+i+'"><a class="page-link" href="#">'+i+'</a></li>';
					else
					pmStr += '<li class="page-item" data="'+i+'"><a class="page-link" href="#">'+i+'</a></li>'
				}
				
				  
				 if(pm.next){
					pmStr += '<li class="page-item" data="'+(pm.endPage+1)+'"><a class="page-link" href="#">다음</a></li>';
				}
				
				$('.pagination').html(pmStr);
				
			}
		})
	}
	
	//{}객체를 리턴한다.
	return{
		
		name : '서비스',
		insert : insert,
		list : list
		
	}
	
})();