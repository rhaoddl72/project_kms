select * from 제품;
select * from 고객;
select * from 주문;

/*문제 1
달콤 비스켓과 같은 제조업체에서 제조한 제품의 제품명과 단가를 검색*/ 
 
/*방법1. 제조업체 찾고 제조업체 검색*/
select 제조업체 from 제품 where 제품명 = '달콤비스켓';
select 제품명,단가 from 제품 where 제조업체 = '한빛제과';
 
/*방법2. 서브쿼리를 이용*/
select 제품명,단가 from 제품 
	where 제조업체 = (select 제조업체 from 제품 where 제품명 = '달콤비스켓');
        

/*문제 2
banana 고객이 주문한 제품의 제품명과 제조업체를 검색*/
  
/*방법1. join이용*/
select 제품명, 제조업체 from 제품 join 주문
on 제품번호 = 주문제품
where 주문고객 = 'banana';
  
/*방법2. 서브쿼리를 이용*/
/* =은 0또는1개의 결과일 때 사용 결과가 여러개면 in 사용 */
select 제품명,제조업체 from 제품
	where 제품번호 in (select 주문제품 from 주문 where 주문고객 = 'banana');
    
    
/*문제 3
  banana 고객이 주문하지 않은 제품의 제품명과 제조업체를 검색 */

/*방법1. <>또는 !=을 where절에서 줘서 아닌걸 찾아내는 방법*/  
select distinct 제품명,제조업체 from 제품
	where 제품번호 in (select 주문제품 from 주문 where 주문고객 <> 'banana');  
  
/*방법2. not in 사용*/  
select 제품명,제조업체 from 제품
	where 제품번호 not in (select 주문제품 from 주문 where 주문고객 = 'banana');
    
    
/*문제 4
   대한식품이 제조한 모든 제품의 단가보다 비싼 제품명,단가,제조업체 검색*/
   /*all은 해당하는 정보들을 모두 만족하는 결과를 찾아낸다.*/
select 제품명,단가,제조업체 from 제품
	where 단가 > all (select 단가 from 제품 where 제조업체 = '대한식품');
    
/*문제 5
  2013년 3월 15일에 제품을 주문한 고객의 고객이름을 검색*/
  
  /*방법1. join이용*/
  select 고객이름 from 주문 join 고객
  on 고객아이디 = 주문고객
  where 주문일자 = '2013-03-15';
  
  /*방법2. exists와 서브쿼리 이용*/
  /*exists는 결과와 일치하는 정보를 가져옴(서브쿼리의 조인문느낌?)*/
  select 고객이름 from 고객
	where exists (select * from 주문 where 주문일자 = '2013-03-15' and 주문고객 = 고객아이디);