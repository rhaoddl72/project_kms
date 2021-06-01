

/*bd_is_del에서 default 'N'을 해주면 저기에 'Y'라는 값을 줬을때만 삭제된걸로 처리.*/
create table if not exists board(
	bd_num int auto_increment,
    bd_title varchar(50) not null,
    bd_is_del char(1) not null default 'N',
    primary key(bd_num)
);


insert into board(bd_title) values
('제목1'),('제목2'),('제목3'),('제목4'),('제목5');

select * from board;

-- 1번 게시글 삭제
-- 실제 협업에서는 delete문을 안쓰고 보통 이런식으로 삭제처리를한다.
update board set bd_is_del = 'Y' where bd_num = 1;

-- 삭제되지 않은 게시글 검색
select * from board where bd_is_del = 'N';