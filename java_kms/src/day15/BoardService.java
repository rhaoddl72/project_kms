package day15;

public interface BoardService {

	/*
	 * 기능 : 게시글을 등록하는 메소드
	 * 		 게시글 제목, 내용, 작성자, 작성일이 주어지면 게시글을 등록하는 메소드
	 * 매개변수 : 게시글 제목, 내용, 작성자, 작성일 => 게시글 정보 => Board board
	 * 리턴타입 : void
	 * 메소드명 : insert
	 * */
	
	void insert(Board board);
	
	
	/*
	 * 기능 : 게시글을 삭제하는 메소드
	 * 		 게시글 번호가 주어지면 해당 게시글 번호를 삭제한 후 삭제 여부를 알려주는 메소드
	 * 매개변수 : 삭제할 게시글 번호 => int num
	 * 리턴타입 : boolean
	 * 메소드명 : delete
	 * */
	
	boolean delete(int num);
	
	
	
	/*
	 * 기능 : 게시글을 수정하는 메소드
	 * 		 수정할 게시글 번호가 주어지면 해당 게시글의 수정 내용을 입력받고 수정 여부를 알려주는 메소드
	 * 매개변수 : Board board
	 * 리턴타입 : void
	 * 메소드명 : update
	 * */
	
	void update(Board board);
	
	
	/*
	 * 기능 : 게시글 번호가 주어지면 게시글을 전달하는 메소드
	 * 		 (제목, 내용, 작성자, 작성일)을 알려주는 메소드
	 * 매개변수 : 전달할 게시글 번호 => int num
	 * 리턴타입 : 게시글 정보 => Board
	 * 메소드명 : getBoard
	 * */
	
	Board getBoard(int num);
	
	/*
	 * 기능 : 게시글 리스트를 가져오는 메소드
	 * 		 입력되어있는 전체 게시글을 출력시키는 기능
	 * 매개변수 : 없음
	 * 리턴타입 : 게시글 정보들 => Board[]
	 * 메소드명 : List
	 * */
	
	Board[] List();
	
	
	/*기능: 검색어가 들어간 게시글 리스트를 가져오는 메소드
	 *매개변수: String search
	 *리턴타입: Board
	 *메소드명: SearchList
	 *위에 List와 메소드명이 같지만 매개변수가 다른 오버로딩을 해주면 된다.
	 **/
	Board[] List(String search);
}

class Board{
	int num;
	String title, contents, writer, registerDate;	
}
