package kr.green.test.service;

import java.util.ArrayList;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.MemberVO;
import kr.green.test.vo.ReplyVO;

public interface ReplyService {

	String insertReply(ReplyVO reply, MemberVO user);

	ArrayList<ReplyVO> getReplyList(int rp_bd_num, Criteria cri);

	int getTotalCount(int rp_bd_num);

}
