package day11;

public class MethodTest {
	
	public static void main(String[] args) {
		
		int res = sum(1,2);
		int a = 'a';
		System.out.println(res);
		//System.out.println(print()); 실수1
		//int num = print(); 실수2
		int[] arr = new int[] {1,2,3,4,5};
		System.out.println(sum2(arr));
		System.out.println(sum3(1,2,3));
		System.out.println(sum3(1,2,3,4,5));
	}
	
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	public static void print() {
		System.out.println("Hello");
	}
	
	public static int sum2(int[] arr) {
		if(arr == null) {
			return 0;
		}
		int res = 0;
		for(int tmp : arr) {
			res += tmp;
		}
		return res;
	}
	
	public static int sum3(int ...arr) { //매개변수의 개수가 정해져있지 않을 때 이런식으로 가능
		int res = 0;
		for(int tmp:arr) {
			res += tmp;
		}
		return res;
	}

}
