create database if not exists cinema;

use cinema;

CREATE TABLE if not exists `movie` (
	`mo_num`	int	NOT NULL,
	`mo_title`	varchar(50)	NOT NULL,
	`mo_contents`	longtext NOT NULL,
	`mo_director`	varchar(100) NOT NULL,
	`mo_main_actor`	longtext NOT NULL,
	`mo_sub_actor`	longtext NULL,
	`mo_opening_date`	date NULL,
	`mo_genre`	varchar(100) NOT NULL,
	`mo_runtime`	int	NOT NULL,
	`mo_rating`	int	NOT NULL,
    primary key(mo_num)
);


CREATE TABLE if not exists `theater` (
	`th_branch`	varchar(50)	NOT NULL,
	`th_address`	varchar(50)	NULL,
	`th_transport`	longtext	NULL,
    primary key(th_branch)
);


CREATE TABLE if not exists `screen_room` (
	`sr_num`	int	NOT NULL,
	`sr_th_branch`	varchar(50)	NOT NULL,
	`sr_name`	varchar(10)	NOT NULL,
	`sr_personnel`	int	NOT NULL default 0,
	`sr_location`	varchar(50)	NOT NULL,
    primary key(sr_num),
    foreign key(sr_th_branch) references theater(th_branch)
);



CREATE TABLE `seat` (
	`se_num`	int	NOT NULL,
	`se_sr_num`	int	NOT NULL,
	`se_name`	varchar(3)	NOT NULL,
    primary key(se_num),
    foreign key(se_sr_num) references screen_room(sr_num)
);


CREATE TABLE `screen` (
	`sc_num`	int	NOT NULL,
	`sc_mo_num`	int	NOT NULL,
	`sc_start_time`	char(5)	NOT NULL,
	`sc_end_time`	char(5)	NOT NULL,
	`sc_date`	VARCHAR(255)	NOT NULL,
	`sc_sr_num`	int	NOT NULL,
	`sc_type`	varchar(10)	NOT NULL default '2D',
    primary key(sc_num),
    foreign key(sc_mo_num) references movie(mo_num),
    foreign key(sc_sr_num) references screen_room(sr_num)
);


CREATE TABLE `member` (
	`me_id`	varchar(20)	NOT NULL,
	`me_name`	varchar(50)	NOT NULL,
	`me_level`	varchar(10)	NOT NULL default 'bronze',
	`me_point`	int	NOT NULL default '0',
    primary key(me_id)
);


CREATE TABLE `ticket` (
	`ti_num`	int	NOT NULL,
	`ti_personnel`	int	NOT NULL default 1,
    primary key(ti_num)
);



CREATE TABLE `reservation` (
	`re_num`	int	NOT NULL,
	`re_me_id`	varchar(20)	NOT NULL,
	`re_sc_num`	int	NOT NULL,
	`re_se_num`	int	NOT NULL,
	`re_price`	int	NOT NULL default 0,
	`re_ti_num`	int	NOT NULL,
    primary key(re_num),
    foreign key(re_me_id) references `member`(me_id),
    foreign key(re_sc_num) references screen(sc_num),
    foreign key(re_se_num) references seat(se_num),
    foreign key(re_ti_num) references ticket(ti_num)
);

-- 영화 정보
insert into movie(mo_num, mo_title, mo_contents, mo_director, mo_main_actor, mo_opening_date, mo_genre, mo_runtime, mo_rating) values(1, '컨저링 3 - 악마가 시켰다', '모든 것은 악마가 시켰다 1981년...', '마이클 차베즈', '베라 파미가, 패트릭 윌슨, 줄리안 할리아드', '2021-06-03', '호러,미스터리', 112, 19);

-- 영화관 정보
insert into theater values('cgv청주성안길', '충청북도 청주시 상당구 북문로 1가 170-1','교통안내 버스 이용시 -사직사거리 방향: 30-2, 50-2, 105, 105-1... -도청 방향 : 11-1, 30-1, 50-1...'); 

-- 영화정보 확인하는 쿼리문 - 컨저링 3
select * from movie where mo_title like concat('%', '컨저링 3', '%');
select * from movie where mo_title like '%컨저링 3%';

-- 컨저링 3의  오늘 (2021-06-03) 상영시간을 확인하는 쿼리문
select sc_start_time from screen join movie
on mo_num = sc_mo_num
 where mo_title like '%컨저링 3%'  and sc_date like '2021-06-03%';
 
 
 -- 컨저링 3의 cgv청주성안길 지점의 상영 정보를 확인하는 쿼리문
 -- table명.* 하면 그 테이블에 해당하는 정보만 보여준다.

-- 방법 1.
select screen.* from screen join screen_room
on sr_num = sc_sr_num
join movie
on sc_mo_num = mo_num
where mo_title like '%컨저링 3%' and sr_th_branch like 'cgv청주성안길';

-- 방법 2.
select screen.* from screen
where sc_mo_num = (select mo_num from movie where mo_title like '%컨저링 3%')
and sc_sr_num = (select sr_num from screen_room where sr_th_branch like 'cgv청주성안길');


-- cgv청주성안길 지점의 1관의 예매 가능한 좌석 정보를 확인하는 쿼리문

-- 방법 1.
select se_name from seat join screen_room
on sr_num = se_sr_num
where sr_name = '1관' and sr_th_branch = 'cgv청주성안길';

-- 방법 2.
select se_name from seat
where se_sr_num = (select sr_num from screen_room where sr_th_branch = 'cgv청주성안길' and sr_name = '1관');


-- cgv청주성안길 지점의 컨저링 3가 오늘 9:00에 있을 때 해당 영화의 선택 가능한 좌석을 확인하는 쿼리문

-- 1. 내가 한 조인
select se_name from seat join screen_room
on se_sr_num = sr_num
join screen
on sr_num = sc_sr_num
join movie
on sc_mo_num = mo_num
join reservation
on se_num = re_se_num
where sr_th_branch = 'cgv청주성안길' and mo_title like '%컨저링 3%' and sc_date = '2021-06-03' and sc_start_time = '09:00';

-- 2. 강사님 버전
select se_name from seat
	where se_sr_num =
    (select sr_num from screen_room join screen on sc_sr_num = sr_num
	 where sr_th_branch like 'cgv청주성안길'
     and sc_start_time like '9:00'
     and sc_date like '2021-06-03%'
     and sc_mo_num = (select mo_num from movie where mo_title like '%컨저링 3%'));




-- 3단계로 쪼개서 완성하기
-- 해당 영화의 상영관시간 번호와 상영관 번호를 확인
-- 해당 영화 예매 내역 중 예약된 좌석 현황
-- 해당 영화의 예매 가능한 좌석 정보를 확인

-- cgv청주성안길 지점에서 오늘 9:00에 시작하는 컨저링3 상영시간번호, 상영관 번호 가져오기 : '상영시간번호' 에 넣어야함
-- 1단계. join 방법 
select sc_num, sc_sr_num from screen_room join screen on sc_sr_num = sr_num
where sr_th_branch like 'cgv청주성안길'
and sc_start_time like '9:00'
and sc_date like '2021-06-03%'
and sc_mo_num = (select mo_num from moive where mo_title like '%컨저링 3%');

-- 1단계. 서브쿼리 방법
select sc_num, sc_sr_num from screen
where sc_sr_num = (select sr_num from screen_room where sr_th_branch like 'cgv청주성안길')
and sc_start_time like '9:00'
and sc_date like '2021-06-03%'
and sc_mo_num = (select mo_num from moive where mo_title like '%컨저링 3%');

-- 2단계
-- 해당 영화 예매 내역 중 예약된 좌석 현황 : '예약된 좌석명' 에 넣어야함
select se_name from seat where se_num in
(select re_se_num from reservation where re_sc_num = ('상영시간번호'));

-- 3단계
-- 해당 영화의 예매 가능한 좌석 정보를 확인
select se_name from seat where se_sr_num = ('상영관 번호')
and se_name not in ('예약된 좌석명');




-- join 이용 abc123 회원이 관람했던 영화 리스트를 확인
select mo_title from movie join screen
on mo_num = sc_mo_num
join reservation
on sc_num = re_sc_num
where re_me_id = 'abc123';

-- 서브쿼리 이용 abc123 회원이 관람했던 영화 리스트를 확인
select mo_title from movie 
where mo_num in (select sc_mo_num from screen
join reservation
on sc_num = re_sc_num
where re_me_id = 'abc123');



