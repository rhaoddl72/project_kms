var id;
$(function(){
 
    
    // 오른쪽 두번째 컨텐츠 롤링 기능
    id = rollingLeft('.right2 .view-box .contents-box','li',800,1500);
 
    $('.right2').hover(function(){
        clearInterval(id);
    },function(){
        id = rollingLeft('.right2 .view-box .contents-box','li',800,1500);
    });
 
    //오른쪽 두번쨰 컨텐츠 다음 버튼
    $('.right2 .btn-box .next-btn').click(function(){
        if(!$('.right2 .contents-box li').first().is(':animated')){
        var width = $('.right2 .contents-box li').first().width();
        $('.right2 .contents-box li').first().animate({'margin-left': -width+'px'},800,function(){
            $(this).detach().appendTo('.right2 .contents-box').removeAttr('style');
        });
        }
    });
 
    // 오른쪽 두번째 컨텐츠 이전 버튼
    $('.right2 .btn-box .prev-btn').click(function(){
        if(!$('.right2 .contents-box li').first().is(':animated')){
        var width = $('.right2 .contents-box li').last().width();
        $('.right2 .contents-box li').last().detach().prependTo('.right2 .contents-box').
        css('margin-left',-width+'px').animate({'margin-left': 0},800);
        }
    });

});
 
    
        // 기본 메뉴
        var oriMenu = ['사전','뉴스','증권','부동산','지도','VIBE','책','웹툰'];
        // 저장으로 최종 확정된 개인 선택 메뉴
        var selMenu = [];
        // 메뉴설정에서 선택한 메뉴
        var tmpMenu = [];
        
        var oriHref = ['https://dict.naver.com/'];
        var selHref = [];
        var tmpHref = [];
 
       $(function(){
           //메뉴 더보기 버튼 클릭
           $('.menu .more-btn').click(function(){
               $('.box3 .menu-box').show();
               $('.box3 .menu .menu-btn-box').show();
               $('.box3 .menu .fold-btn').show();
               $(this).hide();
           })
 
           //접기 버튼 클릭
           $('.menu .fold-btn').click(function(){
 
            //접기 / 더보기 버튼
            $(this).hide();
            $('.box3 .menu .more-btn').show();
 
 
            //메뉴박스 숨기기
            $('.box3 .menu-box').hide();
            $('.box3 .menu-box .menu-box1').show(); //메뉴 링크된 메뉴를 보여주고
            $('.box3 .menu-box2').addClass('display-none'); //메뉴 체크박스로 된 메뉴를 가림
            
            $('.box3 .menu .menu-btn-box').hide();//메뉴 버튼박스
            $('.box3 .menu .menu-btn-box .btn-box1').show(); //서비스 전체보기, 메뉴설정 버튼을 보여주고
            $('.box3 .menu .menu-btn-box .btn-box2').hide(); // 초기화 저장 버튼 감춤
 
            //검은 메뉴 출력
            //set은 매개변수로 href 넣어줘야한다. 링크가 필요하기때문에
            setMenuBox(selMenu, oriMenu, selHref, oriHref);
            //임시로 선택해준 체크박스들을 지워준다.
            tmpMenu = [];
            tmpHref = [];
            //접기버튼 누르면 체크박스 해제
            initCheckbox(selMenu);
 
           })
 
 
           //메뉴 설정 버튼 클릭
           $('.box3 .set-btn').click(function(){
 
               $('.box3 .menu-box1').hide();
               $('.box3 .menu-box2').removeClass('display-none');
               $('.box3 .btn-box2').show();
               $('.box3 .btn-box1').hide();
 
               
               initMenuBox(selMenu);
               tmpMenu = selMenu.slice(0);
               tmpHref = selHref.slice(0);
               
               
               //  내가만든 코드
               //    $('.black-menu-list .list-item.input-box').show();
               
               //var str = '<input type="text" class="menu-text">'
            //    $('.box3 .menu.container .black-menu-list li').empty().filter('.box3 .menu.container .black-menu-list .list-item.input-box').append(str);
               
           })
 
           // 체크박스를 클릭 시 이벤트
           $('.menu-list input[type=checkbox]').click(function(){
                var value = $(this).val();
                var state = $(this).prop('checked');
                //var index = selMenu.indexOf(value);
                var href = $(this).attr('data-target');
 
                /*
                //선택한 항목이 있으면(체크를 해제하면)
                if(index >= 0){
                    selMenu.splice(index,1); //splice는 배열 1개 잘라내기
                }
                //선택한 항목이 없으면(체크하면)
                else{
                    
                        selMenu.push(value);
                        initMenuBox(selMenu);
                        $('.input-box.selected').removeClass('input-box');
 
                    //  $('.input-box.selected').removeClass('input-box selected').next().addClass('selected');
                     
                }*/
 
                //state가 true면 배열에 추가
                if(state){
                    if(tmpMenu.length == 4){
                        //!state는 false랑 같다.
                        $(this).prop('checked', !state);
                        alert('최대 4개');
                        return;
                    }
                    tmpMenu.push(value);
                    tmpHref.push(href);
 
                }
                //false면 배열에서 삭제
                else{
 
                    var index = tmpMenu.indexOf(value);
                    tmpMenu.splice(index,1);
                    tmpHref.splice(index,1);
                }
                initMenuBox(tmpMenu);
            });
 
            // 저장버튼 클릭 시 이벤트
            $('.btn-box2 .save-btn').click(function(){
                   
                    selMenu = tmpMenu.slice(0);
                    selHref = tmpHref.slice(0);
    
                    //setMenuBox(selMenu);
 
                    //이런식으로 가능하다.
                    //fold-btn 기능 사용
                    $('.menu .fold-btn').click();
 
            })
 
            // 초기화버튼 클릭 시 이벤트
            $('.btn-box2 .init-btn').click(function(){
                alert('초기 설정으로 돌아갑니다.');
 
                //arr = selMenu.splice(0);
                //setMenuBox(arr);
 
                selMenu = [];
                selHref = [];
 
                $('.menu .fold-btn').click();
 
                
            })
 
          
            
 
 
 
 
       })
       /*
       메뉴 설정을 눌렀을 때 검은 메뉴창에 메뉴를 선택할 수 있는 박스를
       보여주도록 화면을 구성하는 함수로, 선택된 메뉴가 있으면 글자가,
       아니면 박스가 보여지고 최대 4개가 보여진다.
       */
       function initMenuBox(arr){
 
           $('.black-menu-list .list-item').each(function(index){
               // remove안해주면 앞에서 했던 작업이 남아있어서 remove필요
               $(this).removeClass('input-box selected display-none');
               $(this).find('a').attr('href','#');
                if(index >= 4){
                    // 4번째 이후부터는 생겨도 안보이게 감춰준다.
                    $(this).addClass('display-none');
                }
                // 선택된 메뉴를 화면에 미리 출력해준다.
                else if(arr.length > index){
                    // 각각의 번지에 맞는 텍스를 출력해준다.
                    $(this).find('a').text(arr[index]);
                }
                //남은 부분을 검은색 빈 박스로 변경
                else{
                    $(this).find('a').text('');
                    $(this).addClass('input-box');
                    if(index == arr.length){
                        $(this).addClass('selected');
                    }
                }
           })
       }
 
       /*
       선택된 메뉴에 따라 검은색 메뉴를 보여주는 부분
       선택된 메뉴가 없으면 기본메뉴를 화면에 보여준다.
       */
       function setMenuBox(selArr, oriArr, selhref, orihref){
        
           //선택된 메뉴가 있으면 선택된 메뉴를 화면에 출력하고, 선택된 메뉴가 없으면 미리 지정된 메뉴를 출력
           //하기 위해 arr를 상황에 따라 선정
           var arr = selArr.length == 0 ? oriArr : selArr;
           var hrefArr = selHref.length == 0 ? oriHref : selHref;
            $('.black-menu-list .list-item').each(function(index){
                //display-none을 제거하고 아래로 넘어가야한다.
                $(this).removeClass('display-none');
                //메뉴를 보여줘야 하기 때문에 메뉴 선택할 때 사용된 박스를 제거
                $(this).removeClass('selected input-box');
                if(index < arr.length){
                    $(this).find('a').text(arr[index]);
                    $(this).find('a').attr('href',hrefArr[index]);
                }
                else{
                    //배열의 개수를 넘는 애들은 안보이게 감춰줌
                    $(this).addClass('display-none');
                }
            })
        }
        /*
        메뉴 설정에서 선택된 메뉴에 따라 체크박스 체크 여부가 결정되게 하는 함수
        */
        function initCheckbox(arr){
            $('.menu-list input[type=checkbox]').each(function(){
                var value = $(this).val();
 
                //선택된 메뉴에 값이 있으면
                if(arr.indexOf(value) >= 0){
                    $(this).prop('checked', true);
                }
                //선택된 메뉴에 값이 없으면
                else{
                    $(this).prop('checked', false);
                }
            })
        }
 
 

