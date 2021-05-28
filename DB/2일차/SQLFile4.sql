select * from class;
select * from professor;
select * from student;
select * from course;


-- 2020135001 학생의 수강한 강의 제목을 확인하기 위해서 테이블 2개 필요 join (옛날 방식)
select co_st_num as '학번', cl_title as '강의명' from course, class where co_cl_code = cl_code and co_st_num = '2020135001';

-- 교수번호가 p2000135001인 교수님의 강의를 들은 학생명단 (옛날 방식)
select st_name from course, class, student where co_cl_code = cl_code and co_st_num = st_num and cl_pr_num = 'p2000135001';


-- select 속성1,속성2,.. from 테이블1 join 테이블2 on 테이블1.외래키 = 테이블2.기본키;
-- join할 때 두 테이블의 속성명이 겹치지 않는 경우 속성 이름앞에 테이블명을 생략해도 된다.
-- 위에한 2020135001 학번 학생이 수강한 강의명을 확인하는 코드를 join을 이용하여 확인
select course.co_st_num as '학번', class.cl_title as '강의명'  from course 
join class 
on course.co_cl_code = class.cl_code 
where course.co_st_num = "2020135001";



-- 네트워크를 강의하는 교수님의 이름을 확인
select professor.pr_name as '교수명' from class
join professor
on professor.pr_num = class.cl_pr_num
where class.cl_title = '네트워크';