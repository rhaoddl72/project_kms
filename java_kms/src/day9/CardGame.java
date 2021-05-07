package day9;

public class CardGame {
	
	public static void main(String[] args) {
		/*
		 *  포커 게임 : 실제 포커 게임은 모양과 숫자를 다 고려해야 하지만 여기에선 숫자만 고려, 카드는 7장
		 *  		  카드는 1~13이 4개씩(하트,다이아,세잎,스페이스) 총 52개
		 *  - 포커 : 같은 숫자가 4개  //위부터 가장 큰점수라 맨위에꺼 확인하면 아래꺼 확인 필요x 밑에도 마찬가지
		 *  - 풀하우스 : 같은 숫자가 3개, 같은 숫자가 2개(트리플1+페어1 또는 트리플1+투페어 또는 트리플2)
		 *  - 스트레이트 : 연속된 숫자가 5개 이상
		 *  - 트리플 : 같은 숫자가 3개
		 *  - 투 페어 : 같은 숫자가 2개씩 2개
		 *  - 페어 : 같은 숫자가 2개
		 *  - 탑 : 위의 모든 조건이 없는 경우 가장 큰 수
		 *  
		 * 
		 * 배열에 같은 숫자 3개가 있으면 있는 숫자들을 배열에 저장하여 알려주는 코드를 작성하세요.
		 *  
		 * */
		
		/*int[] arr = new int[] {1,1,1,1,2,2,2,4,4,4};
		int[] triple = new int[2];
		int cnt = 1;
		int res = 0; //숫자 3개가 몇개인지 개수 출력
		int num = 0; //같은 숫자 3개일 때 해당 숫자*/
		
		//주말 과제
		//카드가 주어지면 해당 카드의 가장 큰 등급을 출력하는 코드를 작성
		//아래와 같이 풀하우스, 트리플, 페어로 판별 가능한 경우
		//풀하우스 하나만 출력
		//아래는 '1풀하우스입니다'라고 출력
		int card[] = new int[] {1,2,2,2,4,5,8};
		
		System.out.println("포커 : " + poker(card));
		
		System.out.println("트리플 : " + triple(card));
		
		System.out.println("원페어 : " + onePair(card));
		
		System.out.print("투페어 : ");
		int[] res = twoPair(card);
		if(res == null) {
			System.out.println(0);
		}else {
			for(int tmp : res) {
				System.out.println(tmp + " ");
			}
		}
				
		System.out.println(fullHouse(card) + "풀하우스");
		
		System.out.println(straight(card) + "스트레이트");
		
		
		
		
		
		
		/*for(int i = 0; i<arr.length-1; i++) {
			
			if(arr[i] == arr[i+1]) {
				cnt+=1;
				num = arr[i];
				
			}else {
				
			if(cnt==3) {
				triple[res] = num;
				res+=1;
			}
				cnt = 1;
			}
			
		}
		
		
		
		if(cnt==3) {
			triple[res] = num;
			res += 1;
			
		}
		if(res == 0) {
			
			System.out.println("트리플 없음");
		}else {
			
			for(int i = 0; i<res; i++) {
				System.out.println(triple[i]+" ");
			}
			System.out.println();
			
		}*/
		
		
		
	}
	
	
	/* 포커를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능 : 배열이 주어지면 배열에 포커가 있는지 확인하여 있으면 해당 숫자를 없으면 0을 알려주는 메소드
	 * 매개변수 :	int card[]
	 * 			
	 * 			
	 * 리턴타입 : int
	 * 메소드명 : poker
	 */
	
	public static int poker(int card[]) {
		int cnt = 1;
		int res = 0;
		
		for(int i = 0; i<card.length-1; i++) {
			if(card[i] == card[i+1]) {
				cnt+=1;
				if(cnt == 4) {
					return card[i];
				}
				
				
			}else {
				
				cnt = 1;
				}
			}
		
		return 0; //리턴은 메소드를 빠져나가기 때문에 여기에 도달하기 전에 메소드 종료
		
	}
	
	
	
	/* 트리플을 확인할 수 있는 메소드를 정리해보세요.
	 * 기능 : 배열이 주어지면 배열에 트리플이 있는지 확인하여 있으면 해당 숫자를 없으면 0을 알려주는 메소드
	 * 매개변수 :	int card[]
	 * 			
	 * 			
	 * 리턴타입 : int[]
	 * 메소드명 : tripleList
	 */
	
	public static int[] tripleList(int[] card) {
		
		int cnt = 1;
		int res = 0;
		int num = 0;
		int[] triple = new int[2];
		
		for(int i =0; i<card.length-1; i++) {
			if(card[i] == card[i+1]) {
				cnt+=1;
				num = card[i];
				
			}else {
				if(cnt == 3){
					triple[res] = num;
					res+=1;
				}
				cnt = 1;
			}
			
		}
		
		if(cnt == 3) {
			triple[res] = num;
			res+=1;
		}
		if(res == 0) {
			return null;
		}
		else if(res == 2) {
			return triple;
		}
		else {  //트리플이 1개일 때 배열 크기도 1개로 바꿔서 보내줌
			int[] tmp = new int[1];
			tmp[0] = triple[0];
			return tmp;
		}
	}
	
	
	
	/* 트리플을 기능을 하도록  메소드를 정리해보세요.
	 * 기능 : 배열이 주어지면 배열에 트리플이 있는지 확인하여 있으면 해당 숫자를 없으면 0을 알려주는 메소드
	 * 매개변수 :	int card[]
	 * 			
	 * 			
	 * 리턴타입 : int
	 * 메소드명 : triple
	 */
	
	public static int triple(int card[]) {
		
		
		int[] res = tripleList(card);
		
		if(res == null || res.length == 2) {
			return 0;
		}
		return res[0];
	}
	
	
	
	/* 페어를 확인할 수 있는  메소드를 정리해보세요.
	 * 기능 : 배열이 주어지면 배열에 페어가 있는지 확인하여 있으면 해당 숫자를 없으면 null을 알려주는 메소드
	 * 매개변수 :	int[] card
	 * 			
	 * 			
	 * 리턴타입 : int[]
	 * 메소드명 : pairList
	 */
	
	public static int[] pairList(int[] card) {
		
		int cnt = 1;
		int res = 0;
		int num = 0;
		int pair[] = new int[3];
		
		for(int i =0; i<card.length-1; i++) {
			if(card[i] == card[i+1]) {
				cnt+=1;
				num = card[i];
				
			}else {
				if(cnt == 2){
					pair[res] = num;
					res+=1;
				}
				cnt = 1;
			}
			
		}
		
		if(cnt == 2) {
			pair[res] = num;
			res+=1;
		}
		if(res == 0) {
			return null;
		}
		else if(res < 3) { //트리플은 1개, 2개일때도 구분해줘야해서 반복문 사용필요
			int[] tmpArr = new int[res];
			for(int i = 0; i<res; i++) {
				tmpArr[i] = pair[i];
			}
			return tmpArr;
		}
		
		return pair;
	}

	
	
	/* 원페어를 확인할 수 있는  메소드를 정리해보세요.
	 * 기능 : 배열이 주어지면 배열에 페어가 1개인지 확인하여 있으면 해당 숫자를 없으면 null을 알려주는 메소드
	 * 매개변수 :	int[] card
	 * 			
	 * 			
	 * 리턴타입 : int
	 * 메소드명 : onePair
	 */
	
	public static int onePair(int[] card) {
		
		int[] res = pairList(card);
		
		if(res != null && res.length == 1) {
			return res[0];
		}
		return 0;
	}
	
	
	
	
	/* 투페어를 확인할 수 있는  메소드를 정리해보세요.
	 * 기능 : 배열이 주어지면 배열에 페어가 2개 있는지 확인하여 있으면 해당 숫자를 없으면 null을 알려주는 메소드
	 * 매개변수 :	int[] card
	 * 			
	 * 			
	 * 리턴타입 : int[]
	 * 메소드명 : twoPair
	 */
	
	public static int[] twoPair(int[] card) {
		
		int[] res = pairList(card);
		
		if(res == null || res.length == 1) {
			return null;
		}
		return res;
	}
	
	
	/* 풀하우스를 확인할 수 있는  메소드를 정리해보세요.
	 * 기능 : 배열이 주어지면 배열에 트리플과 페어가 있는지 확인하여 있으면 해당 숫자를 없으면 null을 알려주는 메소드
	 *     		2 2 2 3 3 4 5 => 2풀하우스
	 *          2 2 2 9 9 9 10 => 9풀하우스 숫자가 큰게 풀하우스 앞에 붙는다. 게임에서 같은 숫자의 풀 하우스는 나올 수 없다. 상대방 9풀하우스(x)
	 * 매개변수 :	int[] card
	 * 			
	 * 			
	 * 리턴타입 : int
	 * 메소드명 : FullHouse
	 */
	
	public static int fullHouse(int[] card) {
		
		int[] triple = tripleList(card);
		
		
		//트리플이 없으면 풀하우스가 될 수 없기에 0을 리턴
		if(triple == null) {
			return 0;
		}
		// 트리플이 2개인지 체크(풀하우스)
		if(triple.length == 2) {
			if(triple[0] > triple[1]) {
				return triple[0];
			}
			return triple[1]; // 더 큰 숫자를 보내주게 처리함
		}
			
			// 트리플이 2개가 아니면
			// 트리플이 1개 페어가 1개 이상일때(풀하우스) //트리플과 페어리스트로 활용가능
		int[] pair = pairList(card);
		
		if(pair != null){
			return triple[0];
			
		}
			
			return 0;
		
		
		
		
	}

	
	
	/* 스트레이트를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능 : 배열이 주어지면 배열에 값이 순서대로 있는지 확인하여 있으면 해당 숫자 중 가장 큰 숫자를 알려주고 없으면 0을 알려주는 메소드
	 *     		
	 *          
	 * 매개변수 :	int[] card
	 * 			
	 * 			
	 * 리턴타입 : int
	 * 메소드명 : straight
	 */
	
	public static int straight(int[] card) {
		
		int cnt = 1;
		int num = 0;
		
		
		for(int i = 0; i<card.length-1; i++) {
			
			if(card[i] == card[i+1]) { //숫자가 같은경우는 스트레이트로 안치고 건너뛴다.
				continue;
			}
			
			if(card[i]+1 == card[i+1]) {
				cnt+=1;
				num = card[i+1];
				
			}
			else {
				if(cnt >= 5) {
					return num;
				}
				cnt = 1;
			}
		}
		// 스트레이트가 마지막 숫자를 포함할 때
		if(cnt >= 5) {
			return num;
		}
		return 0;
	}
}
