/*
정규화
- 데이터베이스를 효율적으로 관리하기 위해 데이터 중복을 제거하면서 무결성을 유지하기위한 기법
  (테이블을 쪼갠다)

제 1 정규화 : 속성의 값이 원자값을 갖도록 테이블을 분해

제 2 정규화 : 완전 함수 종속을 만족하도록 테이블을 분해
	        기본키의 부분집합으로 속성을 검색하면 안된다.
            
제 3 정규화 : 이행 종속을 제거하도록 테이블을 분해
			=> 이행 종속이란?
            A -> B, B -> C, A -> C가 성립
            
반 정규화 : 정규화로 테이블이 너무 많아서 검색할 때 너무 많은 join이 필요한 경우 활용
		  반정규화를 활용하여 테이블에 속성을 추가
*/

use music;




/*반 정규화 이전*/
/* 소녀시대가 부른 노래를 검색할 때 필요한 쿼리문 */
select so_title from singer 
join sing 
on si_num =  sn_si_num
join `source`
on so_num = sn_so_num
where si_name = '소녀시대';

-- 반정규화를 위한 sing에 가수이름 속성 추가
ALTER TABLE `music`.`sing` 
ADD COLUMN `sn_si_name` VARCHAR(50) NOT NULL AFTER `sn_featuring`;

/*반 정규화 이후 join이 줄었다.*/
/* 소녀시대가 부른 노래를 검색할 때 필요한 쿼리문 */
select so_title from sing 
join `source`
on so_num = sn_so_num
where si_name = '소녀시대';


/*반 정규화 이전 쿼리문*/
/*소녀시대의 3집앨범의 수록곡을 확인하기 위한 쿼리문 */

select so_title from singer 
join sing 
on si_num =  sn_si_num
join `source`
on so_num = sn_so_num
join `list`
on li_so_num = so_num 
join album
on al_num = li_al_num
where si_name = '소녀시대' and al_title like '%3집%';

/*반 정규화를 위한 list에 가수이름 속성 추가*/
ALTER TABLE `music`.`list` 
ADD COLUMN `li_si_name` VARCHAR(50) NOT NULL AFTER `li_main`;


/*정규화 이후 쿼리문*/
/*singer,sing을 join할 필요 없어짐*/
/*소녀시대의 3집앨범의 수록곡을 확인하기 위한 쿼리문 */

select so_title from `source` 
join `list`
on li_so_num = so_num 
join album
on al_num = li_al_num
where si_name = '소녀시대' and al_title like '%3집%';









 