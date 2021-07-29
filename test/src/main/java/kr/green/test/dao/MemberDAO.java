package kr.green.test.dao;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.MemberVO;

public interface MemberDAO {

	void insertMember(MemberVO user);

	MemberVO selectUser(String id);

	void keepLogin(@Param("id")String id, @Param("session_id")String session_id, @Param("session_limit")Date session_limit);

	MemberVO selectUserBySeesion(String session_id);

	ArrayList<MemberVO> selectUserList(@Param("authority")String authority);

	void updateUser(MemberVO dbUser);

}
