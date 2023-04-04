package day02;

public class ForTest1 {
	public static void main(String[] args) {
		/*
		 * for(변수선언 및 초기화;조건식;증감식){ 실행문; }
		 */
		for (int i = 1; i < 4; i++) {
			System.out.println("Hello " + i);
		}
		// System.out.println("i : "+i); //[X] // i의 scope는 for블럭 안까지만
		int j = 5;
		for (; j > 0; j -= 2) {
			System.out.println("Java " + j);
		}
		// j의 scope는? main()메서드 블럭이 끝날 때 까지 살아있다.
		System.out.println("j: " + j);

//		int i = 10;
		
		System.out.println("1. -------------");
		// [1] 1~100까지 정수를 다음과 같은 식으로
		//		계산한 수식과 결과값을 출력하세요
		//		1 + (-2) + 3+(-4)+5 +(-6) ....+(-100) = 결과값
		int sum = 0;
		for(int n=1;n<=100;n++) {
			if (n%2!=0) {
				System.out.print(n);
				sum += n;
			}
			else {
				System.out.printf("(%d)", -n);
				sum -= n;
			}
			
			if(n==100) System.out.print(" = ");
			else System.out.print(" + ");
		}
		System.out.println(sum);
		
		/* 강사코드
		int d = 1;
		sum = 0;
		for (int i=0;i<101;i++, d=-d) {
			sum += i*d;
			if(i<100) {
				System.out.print(i*d+" + ");
			}
			else {
				System.out.print(i*d+" = ");
			}
		}
		System.out.println(sum);
		*/
		
		
		System.out.println("2. -------------");
		// [2] 알파벳 대문자A,B...Z 를 for루프 이용해 출력하기
		for(char c = 'A'; c<='Z';c++) {
			System.out.print(c+" ");
//			System.out.printf("%c ",c); //강사코드 
		}
		
		System.out.println("\n3. -------------");
		//[3] 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10) 의 총 합계값을 출력하세요
		int sum2 = 0;
		int r = 0;
		for (int t=1;t<=10;t++) {
//			for(int k=t;k>0;k--) {
//				sum2 += k;
//			}
			r += t;
			sum2 += r;
		}
		System.out.println(sum2);
	}

}
