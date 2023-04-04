package day03;

public class WhileTest1 {
	
	//main
	public static void main(String[] args) {
		/* 	변수 선언 및 초기화식
		 * 	while(조건식){
		 * 		실행문;
		 * 		증감식;
		 *  }
		 */
		int i=1;
		while(i<5){
			System.out.println("Hello "+i);
			i++;
		}
		
		// 감소식 	Java10	Java7	Java4	Java1
		int j=10;
		while(j>0) {
			System.out.println("Java "+j);
			j-=3;
		}
		
//		for(;;) {
//			System.out.println("무한루프 돕니다 @@@");
//		}
	}

}
