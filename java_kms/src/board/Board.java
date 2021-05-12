package board;

import java.util.Scanner;

public class Board {
	/*
	 * 게시글에 필요한 멤버변수를 선언하세요.
	 * */
	Scanner sc = new Scanner(System.in);
	
	private String title = "", contents = new String(), writer = "", registerDate = "", type = ""; //제목, 내용, 작성자, 등록시간, 게시글 타입
	
	private int num, views, like; // 게시글 번호, 조회수, 좋아요수
	
	
	
	int add = 0;
	
	int[] board = new int[add];
	
	
	//생성자 만들기 내용을 꼭 입력해줘야해서 기본생성자는 쓰이지 않는다.(보통 기본생성자는 필요한 편이다.)
	
	
	
	
	public Board(String title, String contents, String writer, String registerDate, String type, int num) {
	
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.registerDate = registerDate;
		this.type = type;
		this.num = num;
	}
	
	
	public Board() {
		super();
	}


	/*
	 * 기능 : 게시글 정보 출력하는 메소드
	 * 매개변수 : 내가 알고있는 정보 출력 필요x
	 * 리턴타입 : 출력 => void
	 * 메소드명 : print
	 * */
	
	public void print() {
		views++; //조회수를 그냥 print로 확인할 때 +1해준다.
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("작성자 : " + writer);
		System.out.println("조회수 : " + views);
		System.out.println("좋아요 : " + like);
		System.out.println("작성일 : " + registerDate);
		System.out.println("내용 : " + contents);
	}
	
	/*
	 * 기능 : 게시글 정보를 요약해서 출력(번호, 제목, 작성자, 작성일, 조회수)하는 기능
	 * 매개변수 : 내가 알고있는 정보 출력 필요x
	 * 리턴타입 : 출력 => void
	 * 메소드명 : summaryPrint
	 * */
	
	public void summaryPrint() {
		
		System.out.print(num + " ");
		System.out.print(title + " ");
		System.out.print(writer + " ");
		System.out.print(registerDate + " ");
		System.out.print(views + " ");
		System.out.println();
	}
	
	
	/*
	 * 기능 : 제목과 내용을 수정하는 메소드
	 * 매개변수 : 수정할 제목, 내용 => String title, String contents
	 * 리턴타입 : 출력 => void
	 * 메소드명 : modify
	 * */
	
	public void modify(String title, String contents) {
		
		this.title = title;
		this.contents = contents;
	}
	
	
	
	/*
	 * 기능 : 게시글 등록
	 * 매개변수 : 내가 알고있는 정보 출력 필요x
	 * 리턴타입 : 출력 => void
	 * 메소드명 : write
	 * */
	public void write(int[] board, int add) {
		
		
		
		for(int i=0; i<=board.length; i++) {
			
			board[0] = 1;
			
			add+=1;
			
			System.out.println("제목을 입력해주세요.");
			title = sc.next();
			
			System.out.println("작성자를 입력해주세요.");
			writer = sc.next();
			
			System.out.println("작성일자를 입력해주세요.");
			registerDate = sc.next();
			
			System.out.println("내용을 입력해주세요.");
			contents = sc.next();
			
			
		}
	}




	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getViews() {
		return views;
	}
	

	public void setViews(int views) {
		this.views = views;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}
	
	
	
	
	

}
