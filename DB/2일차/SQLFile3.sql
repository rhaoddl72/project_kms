select * from professor;


insert into professor values("p2002140001","q123","680505-2234567","q123","논개","기계");
insert into professor values("p2000160001","w123","600505-1234567","w123","홍길동","컴퓨터");
insert into professor values("p2000160002","e123","650505-1234567","e123","임꺽정","컴퓨터");
insert into professor values("p2000135001","r123","700505-2234567","r123","유관순","화학");
insert into professor values("p2001135001","t123","701205-1234567","t123","이순신","화학");


insert into class values("2021ABC001","네트워크",20,3,"수1,수2,수3","p2000160002");
insert into class values("2021ABC002","파이썬",20,2,"목4,목5","p2000160002");
insert into class values("2021MSC001","컴퓨터개론",20,2,"월1,화1","p2000160001");
insert into class values("2021MSC002","자바",40,3,"월2,월3,화2,화3","p2000160001");
insert into class values("2021MSC003","화학기초",40,3,"화1,화2","p2001135001");
insert into class values("2021MSC004","응용화학",30,3,"금1,금2","p2000135001");
insert into class values("2021MSC005","기계기초",40,3,"월5,월6","p2002140001");



insert into student values("2020135001","qwe123","011010-4567890","qwe123","라마","화학");
insert into student values("2020135002","abc789","010527-4567891","abc789","라마가","화학");
insert into student values("2020140001","qwe789","010527-4567892","abc789","박씨","기계");
insert into student values("2020160001","abc123","010527-3456789","abc123","가나","컴퓨터");
insert into student values("2020160002","abc124","010528-3456789","abc124","가다","컴퓨터");
insert into student values("2020160003","abc","010527-4567890","abc","나다","컴퓨터");



select * from professor;
select * from class;
select * from student;
select * from course;


-- 학과가 컴퓨터인 교수님 수 확인
select pr_pw, pr_name, count(*) from professor where pr_name = '컴퓨터';
select pr_pw, pr_name, count(*) from professor where pr_name = '컴퓨터' group by pr_name;

-- p2002140001인 교수님의 강의하는 강의 리스트 확인
select * from class where cl_pr_num = 'p2002140001';

-- 학점이 2학점 이상인 강의리스트 확인
select * from class where cl_point >= 2;

-- 월요일에 수업하는 강의 리스트 확인
select * from class where cl_schedule like '%월%';

-- 2020학번 학생들을 확인
select * from student where st_num like '2020%';

-- 2020135001 학생이 2021MSC004 강의를 수강했을 때 사용해야 하는 쿼리문
insert into course values(1,"2020135001","2021MSC004");

-- 2020135001 학번 학생이 수강한 강의 수 확인
select count(*) as '수강한 강의 수' from  course where co_st_num = "2020135001";

-- 2020135001 학번 학생이 2021년도에 수강한 강의 수 확인
select count(*) as '수강한 강의 수' from  course where co_cl_code like '2021%';
