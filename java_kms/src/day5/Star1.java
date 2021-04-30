package day5;

public class Star1 {
	
	public static void main(String[] args) {
		
		
		
		int i, k;
		
		for(k=1;k<=5;k++) {
			for(i=1;i<=5;i++) {
				
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		System.out.println("==============================");
		
		for(k=1;k<=5;k++) {
			for(i=1;i<=k;i++) {
				
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		System.out.println("==============================");
		
		for(k=1;k<=5;k++) {
			 
			for(i=1;i<=4;i++) {
				
				System.out.print(" "); //앞에 공백 연달아 만들어줌
			}
			
			for(i=1;i<=4;i++) {
				
				System.out.print("*");
			}
			
			System.out.println();
			
		}
		
		System.out.println("==============================");
		
		for(k=1;k<=5;k++) {
			 
			for(i=5;i>=k;i--) {
				
				System.out.print(" ");			}
			
			for(i=1;i<=k;i++) {
				
				System.out.print("*");
			}
			
			for(i=2;i<=k;i++) {
				
				System.out.print("*");
			}
			
			System.out.println();
			
		}
		
		System.out.println("==============================");
		
		for(k=1;k<=5;k++) {
			 
			for(i=1;i<=5 - k;i++) {
				
				System.out.print(" ");			
				}

			
			for(i=1;i<=k;i++) {
				
				System.out.print("*");
			}
			
						
			System.out.println();
			
			
		}
		
		System.out.println("==============================");
		
		for(k=1;k<=5;k++) {
			 
			for(i=5;i>=k;i--) {
				
				System.out.print(" ");			}
			
			for(i=1;i<=k;i++) {
				
				System.out.print("*");
			}
			
			
			
			System.out.println();
			
		}
		
		System.out.println("==============================");
		
		for(k=1;k<=5;k++) {
			 
			for(i=3;i>=k;i--) {
				
				System.out.print("*");			}
			
			for(i=1;i<=k;i++) {
				
				System.out.print(" ");
			}
			
			for(i=5;i>=k;i--) {
				
				System.out.print("*");			}
			
			
			
			
			
			System.out.println();
			
		}
		
		
		
	}

}
