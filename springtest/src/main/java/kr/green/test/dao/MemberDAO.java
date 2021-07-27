package kr.green.test.dao;
 
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.MemberVO;
 
public interface MemberDAO {

	void insertMember(@Param("user")MemberVO user);

	MemberVO getMember(@Param("id")String id);

	int updateMember(@Param("user")MemberVO updateUser);

	void keepLogin(@Param("id")String id, @Param("session_id")String session_id, @Param("session_limit")Date session_limit);

	MemberVO getMemberSession(@Param("session_id")String session_id);

	
    
	

}
