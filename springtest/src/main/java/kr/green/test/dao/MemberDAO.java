package kr.green.test.dao;
 
import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.MemberVO;
 
public interface MemberDAO {

	void insertMember(@Param("user")MemberVO user);

	
    
	

}
