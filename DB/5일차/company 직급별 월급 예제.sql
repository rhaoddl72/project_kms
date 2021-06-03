create database company;

use company;


drop table if exists salary;
CREATE TABLE `salary` (
	`sa_level`	varchar(2) NOT NULL,
	`sa_base_salary` int not NULL default 0,
	`sa_add_salary`	int	not NULL default 0,
	primary key(sa_level)
);


drop table if exists employee;
CREATE TABLE `employee` (
	`em_num`	int	NOT NULL auto_increment,
    `em_name`	varchar(50)	not NULL,
	`em_sa_level` varchar(2) not NULL,
	`em_year`	int	not NULL default 1,
	`em_salary` int not null default 0,
    primary key(em_num),
    foreign key(em_sa_level) references salary(sa_level)
);


CREATE TABLE payments (
	`pa_num`	int	NOT NULL auto_increment,
    `pa_em_num`	int not NULL,
	`pa_date`	datetime default current_timestamp,
	`pa_price`	int	not NULL,
    primary key(pa_num),
    foreign key(pa_em_num) references employee(em_num)
);


insert into salary(sa_level, sa_base_salary, sa_add_salary) values('사원',200,10);
insert into salary(sa_level, sa_base_salary, sa_add_salary) values('대리',220,15);
insert into salary(sa_level, sa_base_salary, sa_add_salary) values('과장',240,20);
insert into salary(sa_level, sa_base_salary, sa_add_salary) values('부장',280,25);
insert into salary(sa_level, sa_base_salary, sa_add_salary) values('전무',300,30);
insert into salary(sa_level, sa_base_salary, sa_add_salary) values('이사',350,35);

insert into employee(em_name, em_sa_level, em_year, em_salary) values('고길동','사원',2,220);


select * from employee;
select * from salary;
select * from payments;





-- 직원이 직급이 변경되는 경우 실행하는 프로시저 생성
-- 트리거는 추가되거나 변경되는 행의 정보를 수정할 수 없어서 사용불가
drop procedure if exists update_level;
delimiter //
create procedure update_level(

in _num int,
in _level varchar(2),
in _year int

)
begin
	-- 해당 사원의 월급을 변경
    declare _base int default 0; -- 기본급
    declare _add int default 0; -- 호봉급
    declare _salary int default 0; -- 월급
    
    -- 기본급 가져오기
    set _base = (select sa_base_salary from salary where sa_level = _level);
    
    -- 호봉급 가져오기
    set _add = (select sa_add_salary from salary where sa_level = _level);
    
    -- 연차에 맞게 호봉급 계산하기
	set _add = _add * _year;
    
    -- 사원의 직급과 연차, 월급 수정
    update employee set
		em_sa_level = _level,
        em_year = _year,
        em_salary = _base + _add
        where em_num = _num;

	
end //
delimiter ;

-- 프로시저 호출
call update_level(1,'과장',1);



-- 사원에게 월급을 지급하는 프로시저를 생성하세요. 월급 지급액은 월급에서 세금 10%를 제외한 금액

drop procedure if exists insert_payments;
delimiter //
create procedure insert_payments(

in _num int -- 사원번호
)
begin
    declare _price int default 0;
    -- 사원의 월급 금액을 가져오기
    set _price = (select em_salary from employee where em_num = _num);
    
    -- 세금 10% 떼기
    set _price = _price * 0.9;
    
    -- payments 테이블에 insert
	insert into payments(pa_em_num, pa_price) values(_num,_price);
    
end //
delimiter ;

call insert_payments(1);