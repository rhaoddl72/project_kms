
create database fruit_shop2;

use fruit_shop2;


CREATE TABLE `fruit` (
	`fr_name`	varchar(15)	NOT NULL,
	`fr_price`	int	not NULL default 0,
	`fr_unit`	varchar(10)	not NULL default 'box',
	`fr_amount`	int	not NULL default 0,
    primary key(fr_name)
);

CREATE TABLE `trade` (
	`tr_num`	int	NOT NULL,
	`tr_amount`	int	not NULL default 0,
	`tr_type`	varchar(4)  not	NULL default 'sell' ,
	`tr_price`	int	not NULL default 0,
	`tr_date`	datetime not NULL default current_timestamp, -- current_timestamp는 데이터베이스에 등록시간을 자동으로 입력 date일때 불가 datetime일때만 가능
	`tr_fr_name`	varchar(15)	NOT NULL,
    primary key(tr_num),
    foreign key(tr_fr_name) references fruit(fr_name)
);
select * from fruit;
select * from trade;

-- 사과가 입고되기 위해서 fruit 테이블에 사과정보가 등록되어 있어야 한다.
insert into fruit values('사과',10000,'box',0); -- 사과 정보 등록

-- 사과 100상자가 입고되었다. 상자당 가격은 10000원
-- trade table에 insert 후 , fruit 테이블에 재고량을 update
insert into trade(tr_num,tr_amount,tr_type,tr_price,tr_fr_name) values(1,100,'buy',1000000,'사과');
update fruit set fr_amount = fr_amount + 100 where fr_name = '사과';



-- 손님이 사과 1상자를 상자당 20000원에 구매를 했다.
-- trade 테이블 insert, fruit 테이블 update
insert into trade(tr_num, tr_amount, tr_type, tr_price, tr_fr_name) values(2, 1, 'sell', 20000,'사과');
update fruit set fr_amount = fr_amount - 1 where fr_name = '사과';



-- 오늘 과일 판매액을 확인
select sum(tr_price) as '판매액' from trade 
	where tr_type = 'sell' and tr_date like '2021-06-02%';


/*
(case when 사용법
case when 조건1 then 반환값
when 조건2 then 반환값
else 반환값 end) as 속성명

*/

-- 총매출액 구하기
select
	sum(case when tr_type = 'buy' then -tr_price
    else tr_price end) as '총매출액'
    from trade;

-- 트리거 생성
/*
과일을 입고하거나 판매하면 재고량이 입고/판매량에 맞춰
변하는 트리거를 생성
*/
drop trigger if exists insert_trade;
delimiter //
create trigger insert_trade after insert on trade 
for each row
begin
	if new.tr_type = 'buy' then
update fruit set fr_amount = fr_amount + new.tr_amount where fr_name = new.tr_fr_name;
else
update fruit set fr_amount = fr_amount - new.tr_amount where fr_name = new.tr_fr_name;
end if;
end //
delimiter ;

insert into trade(tr_num,tr_amount,tr_type,tr_price,tr_fr_name) values(3,10,'sell',1000000,'사과');



-- 프로시저 생성
/*
입고될 때 없는 과일이 입고되는 경우 fruit 테이블에 새로운
과일을 추가하는 프로시저
*/
drop procedure if exists insert_buy;
delimiter //
create procedure insert_buy(

in _name varchar(15),
in _amount int,
in _price int, -- 구매가격
in _sell_price int -- 판매가격

)
begin
	declare _count int default 0; -- 구매하려는 과일이 있는지 없는지 확인
	declare _num int;
    set _count = (select count(*) from fruit where fr_name = _name); -- 기본키이기때문에 1(해당과일존재)또는 0(해당과일없음)이 나온다.
    
    -- 해당 과일이 없으면 fruit테이블에 과일을 추가(이 때, 판매가격 설정) 해당 과일이 있으면 추가 작업 필요없음
    if _count = 0 then
		
		insert into fruit(fr_name, fr_price)
			values(_name, _sell_price);
	end if;
    -- 해당 과일이 있으면 trade 테이블에 구매 내역 추가
    set _num = (select max(tr_num) from trade) + 1;
    insert into trade(tr_num,tr_amount,tr_type,tr_price,tr_fr_name) values(_num, _amount, 'buy', _price, _name);
end //
delimiter ;

call insert_buy('포도', '100', 500000, 10000);
select * from fruit;


