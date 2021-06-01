/*트리거 & 프로시저

프로시저
사용자가 만든 함수로 호출하여 사용

트리거
데이터가 추가, 수정, 삭제가 일어나는 경우 미리 지정된
작업이 자동으로 실행됨

트리거 문법
delimiter 기호
create trigger 트리거명 [before | after] [insert | update | delete] 
on 테이블명
for each row
begin
	코드작성;
end 기호
delimiter;
*/


/*
portal class 수강신청 인원 카운트하는 트리거사용
*/
use portal;
select * from class;
select * from course;
select * from student;

-- 수강신청 인원 카운트 해주는 컬럼
ALTER TABLE `portal`.`class` 
ADD COLUMN `cl_now_count` INT NOT NULL DEFAULT 0 AFTER `cl_pr_num`;

-- 2021MSC004에 1명 수강신청 등록
UPDATE `portal`.`class` SET `cl_now_count` = '1' WHERE (`cl_code` = '2021MSC004');

use portal;
drop trigger if exists insert_class; -- insert_class라는 이름의 트리거있으면 삭제해줌

-- 트리거 생성
delimiter //
create trigger insert_class after insert on course 
for each row 
begin
	update class
		set cl_now_count = cl_now_count + 1
        where cl_code = new.co_cl_code; -- new가 새로운 행을 생성한다는 의미
end //
delimiter ;
 
 -- 트리거 작동하는지 확인
INSERT INTO `portal`.`course` (`co_st_num`, `co_cl_code`) VALUES ('2020160001', '2021MSC004');
select * from class;
-- 현재 만든 트리거 확인
show triggers;




use test;
/*
주문 테이블에 주문내역이 추가되면 제품 테이블의 재고량이 변하는 트리거 작성
*/

-- 트리거 생성
delimiter //
create trigger insert_order after insert on `주문` 
for each row 
begin
	update 제품
		set 재고량 = 재고량 - new.수량 -- 주문된 수량
        where 제품번호 = new.주문제품; -- new가 새로운 행(데이터,속성)을 생성한다는 의미
end //
delimiter ;

select * from 주문;

show triggers;


-- 트리거 실행문에서 조건문 사용해 보기

drop trigger if exists insert_class; -- insert_class라는 이름의 트리거있으면 삭제해줌

-- 트리거 생성
delimiter //
create trigger insert_test after insert on 제품 
for each row 
begin

	declare _amount int default 0;
    declare _state varchar(10) default '';
    set _amount = 10;
	set _amount = (select count(*) from 주문);
    
    if _amount > 10 than
		set _state = '많다';
	elseif _amount > 5 than
		set _state = '적절';
    else
		set _state = '적음';
	end if;
end //
delimiter ;



/*

프로시저
drop procedure if exists 프로시저명;
delimiter 기호
create procedure 프로시저명(

{in | out} 변수명1,
{in | out} 변수명2,
….
)
begin
	구현;
end 기호
delimiter ;


*/


-- test테이블의 주문 프로시저
drop procedure if exists addOrder;
delimiter //
create procedure addOrder(

in _id varchar(20),
in _product char(3),
in _amount  int,
in _address varchar(30),
in _date varchar(20)
)
begin
	declare _count int default 0;
    declare _order_num char(3);

    set _count = (select count(*) from 주문) + 1; -- set은 ()필요 
	set _order_num = concat('o', _count); -- concat은 여러 문자열을 하나의 문자열로 합쳐준다.
    
    insert into `주문` values(_order_num, _id, _product, _amount, _address, _date);
    select * from `주문`;
end //
delimiter ;

call addOrder('apple','p01',15,'충북 청주시','2021-06-01');




