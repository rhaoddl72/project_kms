package day11;

public class Board {
	/*
	 * 게시글에 필요한 멤버변수를 선언하세요.
	 * */
	
	private String title = "", contents = new String(), writer = "", registerDate = "", type = ""; //제목, 내용, 작성자, 등록시간, 게시글 타입
	
	private int num, views, like; // 게시글 번호, 조회수, 좋아요수

	
	//생성자 만들기 내용을 꼭 입력해줘야해서 기본생성자는 쓰이지 않는다.(보통 기본생성자는 필요한 편이다.)
	
	public Board(String title, String contents, String writer, String registerDate, String type, int num) {
	
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.registerDate = registerDate;
		this.type = type;
		this.num = num;
	}
	
	
	/*
	 * 기능 : 게시글 정보 출력하는 메소드
	 * 매개변수 : 내가 알고있는 정보 출력 필요x
	 * 리턴타입 : 출력 => void
	 * 메소드명 : print
	 * */
	
	public void print() {
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("작성자 : " + writer);
		System.out.println("조회수 : " + views);
		System.out.println("좋아요 : " + like);
		System.out.println("작성일 : " + registerDate);
		System.out.println("내용 : " + contents);
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
