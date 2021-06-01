-- 오른쪽 테이블인 제품 테이블을 기준으로 join해서 주문에서 없는 값이라도 제품에 있으면 출력시켜 주문 테이블에서 null값이 출력된다.
select * from 주문
	right join 제품
    on 주문제품 = 제품번호;


-- 주문과 제품 테이블에서 그냥 join은 inner join이면서, left join에 해당
select * from 주문
	left join 제품
    on 주문제품 = 제품번호;
/*
select * from A left join B on A.속성 = B.속성; 는
select * from B right join A on A.속성 = B.속성; 와 같다.
*/    


-- outer join은 모든 부분을 나타낸다.
select * from 주문
	right outer join 제품
    on 주문제품 = 제품번호;

    
    