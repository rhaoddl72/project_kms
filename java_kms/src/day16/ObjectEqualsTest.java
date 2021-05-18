package day16;

public class ObjectEqualsTest {

	
	public static void main(String[] args) {
		String str1 = new String("abcd");
		String str2 = str1;
		
		
		System.out.println(str2 == str1);
		System.out.println("두 문자열 주소 비교 : " + (str1 == str2));
		System.out.println("str2 = new String(\"abcd\")");
		
		str2 = new String("abcd");
		System.out.println("두 문자열 주소 비교 :" + (str1 == str2));
		System.out.println("두 문자열 비교 : " + str1.equals(str2));
		
		Num n1 = new Num();
		Num n2 = new Num();
		
		System.out.println("n1과 n2 주소 비교 : " + (n1 == n2)); //객체가 같아도 주소는 다르다
		System.out.println("n1과 n2가 같다 : " + n1.equals(n2));
		n2.setNum(10);
		System.out.println("n1과 n2가 같다 : " + n1.equals(n2));
	}
}



class Num{
	private int num;

	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	/*@Override //Object는 최상위 클래스이다. 그래서 모든 클래스의 매개변수를 가질 수 있다.
	public boolean equals(Object obj) {
		//리턴타입이 boolean이고 매개변수로 클래스 OBJ의 객체를 받는 equals메소드이다.
		//만약 매개변수 obj가 Num클래스의 객체로 타입변환이 가능하지 않다면 false를 리턴 : 다른 클래스와 객체를 비교할 필요가 없어서
		if(!(obj instanceof Num)) {
			
			return false;
		}
		
		//매개변수의 num과 내 num이 같은지 비교
		Num tmp = (Num)obj;
		if(num == tmp.num) {
			return true;
		}
		
		return false;
	}*/
	
	/*@Override
	public int hashCode() {
		return num / 10; //이렇게 만들면 10개씩 그룹화 할 수 있다.
		return num / 20; //이건 20개씩 그룹화한다.
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
	

	@Override
	public boolean equals(Object obj) {
		//주소가 같으면 같은 값을 공유하기 때문에 무조건 true
		if (this == obj) //내 주소 = 매개변수 주소 
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) //instance of랑 비슷한 맥락
			return false;
		Num other = (Num) obj;
		if (num != other.num)
			return false;
		return true;
	}
	
	
	
}

class Test{
	Name name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)) //Name클래스에 equals 안만들어줘서 주소를 비교해버린다.
			return false;
		return true;
	}
	
	
}


class Name{
	String name;
}
