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
        if($(list+ ' ' + listItem).first()){
        var width =  $(list+ ' ' + listItem).first().width();
        $(list+ ' ' + listItem).first().animate({'margin-left':'-'+width},animateTime,function(){
            $(this).detach().appendTo(list).removeAttr('style');
        });
        }
    },intervalTime)
    return id;
}