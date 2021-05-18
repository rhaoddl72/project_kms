package day16;

import day15.ArraryIndexOutOfBoundsExceptionTest;

public class TryTest6 {

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		
		int res = setData2(arr, 0, 10);
		
		if(res == -1) { //예외 처리 아니여도 예외 처리가 가능하긴하다.
			System.out.println("번지가 잘못");
		}else if(res == 0) {
			System.out.println("배열 생성 안됨");
		}else {
			System.out.println("데이터 저장 성공");
		}
		
		
		try {
			
			setData(arr, 2, 8);
			int num = getData(arr, 2);
			
			System.out.println(num);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
		
	}
	
	/*
	 * 기능 : 정수형 배열 index 번지에 있는 값을 data로 설정하는 메소드
	 * 매개변수: 정수형 배열 => int[] arr , 해당 번지 => int index , 값 =?> int data
	 * 리턴타입: void
	 * 메소드명: setData
	 * */
	
	public static void setData(int[] arr, int index, int data) {
		
		
		if(arr == null) {
			throw new NullPointerException("배열이 생성되지 않았습니다.");
		} 
		if(index < 0 || index >= arr.length) {
			
			throw new ArrayIndexOutOfBoundsException(index +"번지는 "+arr.length + "개짜리 배열에서 유효하지 않은 배열의 번지입니다.");
		}
		
			
			arr[index] = data;
				
				
		
		
	}
	
	
	

	public static int setData2(int []arr, int index, int data) {
		if(arr == null) {
			return 0;
		}
		if(index < 0 || index >= arr.length) {
			return -1;
		}
		arr[index] = data;
		return 1;
	}
	
	
	
	/*
	 * 기능 : 정수형 배열에 index 번지에 있는 값을 가져오는 메소드
	 * 매개변수: int[] arr, int index
	 * 리턴타입: int 
	 * 메소드명: getData
	 * */
	public static int getData(int[] arr, int index) throws NullPointerException, ArrayIndexOutOfBoundsException { //throws생략가능 부모인 RuntimeException만 써도됨
		
		
		if(arr == null) {
			throw new NullPointerException("배열이 생성되지 않았습니다.");
		} 
		if(index < 0 || index >= arr.length) {
			
			throw new ArrayIndexOutOfBoundsException(index +"번지는 "+arr.length + "개짜리 배열에서 유효하지 않은 배열의 번지입니다.");
		}
				
				return arr[index];
			
			
		
	}
}
