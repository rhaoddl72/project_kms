package day7;

import java.util.Scanner;



public class Lotto {
	
	public static void main(String[] args) {
		/*
		 * 사용자 번호를 랜덤(로또번호 자동생성)으로 생성하고 , 당첨 번호를 입력하면 당첨
		 * 등수를 출력하는 코드를 작성하세요.
		 * 
		 * 사용자 번호 : 1~45사이의 수, 중복되지 않음, 6개
		 * 당첨 번호 : 1~45사이의 수, 중복되지 않음, 6개 + 1개(보너스)
		 * 1등 : 당첨번호 6개 일치
		 * 2등 : 당첨번호 5개 + 보너스 번호 일치
		 * 3등 : 당첨번호 5개 일치
		 * 4등 : 당첨번호 4개 일치
		 * 5등 : 당첨번호 3개 일치
		 * 꽝 : 당첨번호 2개 이하
		 * 
		 * 
		 * 1. 로또 구매(자동 생성)
		 * 2. 당첨번호 확인
		 * 3. 등수 확인
		 * */
		
		
		//자동생성 번호를 만듬
		int[] user = new int[6];
		int min = 1, max = 45;
		init(user, min, max);
		
		for(int tmp : user) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		
		//당첨번호를 입력
		int[] lotto = new int[6];
		int bonus;
		Scanner sc = new Scanner(System.in);
		System.out.println("당첨번호 6개를 입력하세요. : ");
		for(int i = 0; i<lotto.length; i++) {
			lotto[i] = sc.nextInt();
		}
		System.out.println("보너스 번호를 입력하세요 : ");
		bonus = sc.nextInt();
		sc.close();
		//당첨 등수 확인
		printRank(user, lotto, bonus);
		
	}
	
	
	
	
	
	
	public static boolean contains(int[]arr, int count, int num) {
		for(int i = 0; i < count ; i += 1 ) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public static void init(int []arr, int min, int max) {
		int cnt = 0;//저장된 숫자의 개수
		while(cnt < arr.length) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			//배열 arr에 있는 값들을 cnt개를 r과 비교
			if(!contains(arr, cnt, r)) {
				arr[cnt] = r;
				cnt += 1;
			}
		}
	}
	
	/* 기능	  : 두 배열이 주어지면 두 배열에서 같은 숫자가 몇개인지 알려주는 메소드
	 * 매개변수 : 두 배열 => int[] arr1, int[] arr2
	 * 리턴타입 : 같은 숫자의 개수 => 정수 => int
	 * 메소드명 : getSameCount
	 * */
	
	public static int getSameCount(int[] arr1 , int[] arr2) {
		int  cnt = 0; // 몇개나 일치하는지 알려줄 변수
		
		for(int tmp : arr1) {
			if(contains(arr2, arr2.length, tmp)) {
				cnt += 1;
			}
		}
		return cnt;
	}
	
	
	/* 기능	  : 자동 생성번호와 당첨번호, 보너스번호가 주어지면 몇등인지 알려주는 메소드
	 *  		단, 꽝은 0등으로 표현
	 * 매개변수 : 자동생성번호, 당첨번호, 보너스 번호
	 * 			=> int[] user, int[] lotto, int bonus
	 * 리턴타입 : 당첨 등수 = > 정수 => int
	 * 메소드명 : rank
	 * */
	
	public static int rank(int[] user, int[] lotto, int bonus) {
		int res = 0; // 등수
		//int count = getSameCount(user, lotto); // 이렇게 해줘도 됨
		switch (getSameCount(user, lotto)) {
		case 6: {
			
			res = 1;
			break;
		}
		case 5: {
			if(contains(user, user.length, bonus)) {
				
				res = 2;
			}
			else {
				res = 3;
			}
			//res = contains(user, user.length, bonus) ? 2 : 3; 위에 if문을 이런식으로 가능
			break;
		}
		case 4: {
			
			res = 4;
			break;
		}
		case 3: {
			
			res = 5;
			break;
		}

		}
		return res;
	}
	
	
	/* 기능	  : 자동생성 번호와 당첨번호, 보너스가 주어지면 당첨 등수를 출력하는 메소드
	 * 매개변수 : int[] user, int[] rotto , int bonus 
	 * 리턴타입 : void
	 * 메소드명 : printRank
	 * */
	public static void printRank(int[] user, int[] rotto , int bonus) {
		
		int rank = rank(user, rotto, bonus);
		
		switch (rank) {
		case 1,2,3,4,5: {
			
			System.out.println(rank + "등입니다.");
			break;
		}
		default : {
			System.out.println("꽝입니다.");
		}
		
	}
	
	}

}
