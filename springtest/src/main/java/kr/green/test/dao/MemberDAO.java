package kr.green.test.dao;
 
import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.MemberVO;
 
public interface MemberDAO {

	void insertMember(@Param("user")MemberVO user);

	MemberVO getMember(@Param("id")String id);

	int updateMember(@Param("user")MemberVO updateUser);

	
    
	

}
