package day12;

public class initializeTest {
	
	public static void main(String[] args) {
		TestA ta = new TestA();
		System.out.println(ta.getNum());
		System.out.println(TestA.getRes());
	}
}

/*객체 변수 초기화 순서
 * 1. 변수 선언시 기본값으로 초기화
 *    - num는 0으로 초기화
 *    
 * 2. 명시적 초기화
 *    - num는 1로 초기화
 *    
 * 3. 초기화 블록
 *   - {
 *       중괄호 열고 닫고로 되어있다.
 *     }
 *   
 * 4. 생성자 초기화
 *   - num는 2로 초기화
 *   
 *   -기본값이 아닌 값들은 생성자에서 초기화하자(제일 마지막으로 생성자에서 초기화하기때문에)
 *   
 *   클래스 변수
 *   1. 변수 선언시 기본값으로 초기화
 *      -res를 0으로 초기화
 *   2. 명시적 초기화
 *      -res를 10으로 초기화
 *   3. 초기화 블록
 *   
 *   - 클래스변수는 명시적으로 초기화가 제일 무난하다.
 *  */

class TestA{
	
	private int num = 1; //객체변수 명시적 초기화
	private static int res = 10; //클래스변수 명시적 초기화
	
	//초기화 블록 : 객체변수
	{
		
		num = 3;
	}
	
	//초기화 블록 : 클래스변수
	static {
		res = 20;
	}
	
	public TestA() {
		num = 2; //생성자 초기화
	}
	
	public int getNum() {
		return num;
	}
	
	public static int getRes() {
		return res;
	}
}
