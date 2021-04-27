package day2;

public class IncreaseDecreaseOperator {
	
	
	
	
	public static void main(String[] args) {
		int num1 = 10, num2 = 10;
		System.out.println("num1  =  "+num1+", num2  =  " + num2);
		System.out.println("++num1  =  "+ ++num1 + ", num2  =  " + num2++);
		System.out.println("num1  =  "+num1+", num2  =  " + num2);
		num1++;
		++num1;
		System.out.println(num1);
		
		
		
		num1 = 10;
		num2 = 10;
		System.out.println("num1  =  "+num1+", num2  =  " + num2);
		num1++; //동작 부분이 없기에 ++이 앞에 오든 뒤에 오든 그냥 +시켜버린다. 위에는 println이라는 동작이 실행되었기에 구분이되었다.
		System.out.println("++num1  =  "+ num1 + ", num2  =  " + num2);
		++num2;
		System.out.println("num1  =  "+num1+", num2  =  " + num2);
	}

}
