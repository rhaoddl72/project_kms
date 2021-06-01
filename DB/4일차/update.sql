use portal;

select * from class;
select * from course;
select * from professor;
select * from student;

/*워크벤치에서는 안정성을 위해 업데이트에 조건절이 없는 경우 업데이트 못하게함 commend line에서는 가능
   edit - preferences - sql editor - safe updates 체크 해제하면 워크벤치도 가능*/
update professor
	set
    pr_pw = 'abc123';