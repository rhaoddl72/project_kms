
//롤링이라는 메소드 만들기
// 바텀은 따로 연습해보기
function rolling(direction, list, listItem, margin, animateTime, intervalTime){
    var id;

    //소문자랑 비교해준다??
    if(direction.toLowerCase() == 'left') {
        return rollingLeft(list, listItem, animateTime, intervalTime);
    }
    else if(direction.toLowerCase() == 'right'){
        return rollingRight(list, listItem, animateTime, intervalTime);
    }
    else{
        return rollingTop(list, listItem, margin, animateTime, intervalTime);
    }
 }



function rollingTop(list, listItem, marginTop, animateTime, intervalTime){
    var id = setInterval(function(){
        // list와 listItem 사이에 공백을 넣는 이유는 부모 자식임을 표현하기 위해서
        // css로 보면 .list .listItem{} 이렇게 표현되는거다.
         if(!$(list + ' ' + listItem).first().is(':animated')){
         $(list + ' ' + listItem).first()
         .animate({'margin-top': marginTop + 'px'},animateTime,function(){
             $(this).detach().appendTo(list).removeAttr('style');
         });
         }
     },intervalTime);
     return id;
 }

 // 매개변수를 줄 때 순서가 부모 자식 순서여야한다.(list > listItem)
 function rollingLeft(list, listItem, animateTime, intervalTime){

    var id = setInterval(function(){
        if(!$(list+ ' ' + listItem).first().is(':animated')){
        var width =  $(list+ ' ' + listItem).first().width();
        $(list+ ' ' + listItem).first().animate({'margin-left':'-'+width},animateTime,function(){
            $(this).detach().appendTo(list).removeAttr('style');
        });
        }
    },intervalTime)
    return id;
}

function rollingRight(list, listItem, animateTime, intervalTime){
    var id = setInterval(function(){
        if(!$(list + ' ' + listItem).first().is(':animated')){
        var width = $(list + ' ' + listItem).last().width();
        /*width숫자로 찍혀서 ''없이 그냥- 붙여도 된다.*/
        $(list + ' ' + listItem).last().detach().prependTo(list).css('margin-left',-width+'px')
        .animate({'margin-left':'0px'},animateTime);
        }
    },intervalTime);
    
    return id;
}