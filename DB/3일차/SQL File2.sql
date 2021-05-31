/* 소녀시대가 부른 노래를 검색할 때 필요한 쿼리문 */
select si_name, so_title from singer 
join sing 
on si_num =  sn_si_num
join `source`
on so_num = sn_so_num
where si_name = '소녀시대';

/* 소녀시대의 멤버들을 검색하기 위한 쿼리문 */
select ar_name from artist
join member
on ar_num = me_ar_num
join singer
on si_num = me_si_num
where si_name = '소녀시대';

/*소녀시대의 3집앨범의 수록곡을 확인하기 위한 쿼리문 */
select si_name, so_title from singer 
join sing 
on si_num =  sn_si_num
join `source`
on so_num = sn_so_num
join `list`
on li_so_num = so_num 
join album
on al_num = li_al_num
where si_name = '소녀시대' and al_title = '%3집%';

/*join 할 때  from 테이블명에서 where절 줘서 검색 시간 단축하기 */
select so_title from (select * from singer where si_name = '소녀시대') as singer_search 
join sing 
on si_num =  sn_si_num
join `source`
on so_num = sn_so_num
join `list`
on li_so_num = so_num 
join album
on al_num = li_al_num
where al_title = '%3집%';

/*노래 제목이 거짓말이 들어간 노래를 확인하는 쿼리문 */
select so_title from `source` where so_title like '%거짓말%';

/* 노래제목 또는 가사에 '거짓말'이 포함된 노래를 확인하는 쿼리문 */
select so_title from `source` where so_title like '%거짓말%' or so_lyric like '%거짓말%';

/* sm소속 아티스트 목록을 확인하는 쿼리문 */
select * from artist where ar_agency = 'sm';

/* 태연이 활동한 그룹들을 확인하는 쿼리문*/
select si_name from singer join `member`
on si_num = me_si_num
join artist
on ar_num = me_ar_num
where ar_name like '%태연%';

/* 가수 태연이 피처링한 노래들을 확인하는 쿼리문 */
select so_title from singer
join sing
on si_num = sn_si_num
join `source`
on sn_so_num = so_num
where si_name like '%태연%' and sn_featuring = 'y';

/* 소녀시대의 메인 타이틀곡들을 확인하는 쿼리문 */
select so_title from (select * from singer where si_name = '소녀시대') as singer_search 
join sing 
on si_num =  sn_si_num
join `source`
on so_num = sn_so_num
join `list`
on li_so_num = so_num 
join album
on al_num = li_al_num
where li_main = 'y';

 