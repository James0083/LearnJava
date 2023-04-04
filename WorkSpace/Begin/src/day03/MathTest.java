package day03;

public class MathTest {

	public static void main(String[] args) {
		// java.lang.Math클래스
		// public static final double PI : 원주율(상수)  "클래스.변수"(static)
		
		/*java.lang.Math클래스의 주요 메서드
		 * 
		 *   static final double	PI :원주율 (상수)  "클래스명.변수"
		 *   
		 *   static int	abs(int a): 절대값을 반환
		 *   static double	floor(double a): 내림값을 반환
		 *   static double	ceil(double a): 올림값을 반환
		 *   
		 *   //round() : 반올림
			 * static long	round(double a)
			 * static int	round(float a)
			 * 
		 * 	 //random() : 0.0<= r <1.0 사이의 임의의 실수를 발생시켜 반환한다
		 * 		static double	random()
		 * */
		System.out.println(Math.PI);
		
		//-153의 절대값을 구하세요
		int x = Math.abs(-153);
		System.out.println(x);
		
		//12.456의 반올림값을 구해 출력하세요
		long y = Math.round(12.456);
		System.out.println(y);
		int z = Math.round(12.456f);
		System.out.println(z);
		
		//소수점 이하 2자리까지 반올림해서 출력하세요
		double num = 12.456;
		double k = Math.round(num*100)/100.0; //1245.6 반올림하면 1246, double로 나눠야 강제형변환(promotion)일어남 
		System.out.println("k : "+k);
		System.out.printf("k : %.2f%n", k);
		
		//103.0001의 올림값과 내림값을 각각 출력하세요
		double a = 103.0001;
		System.out.printf("%f의 올림값 : %f, 내림값 : %f%n", 103.0001, Math.ceil(a), Math.floor(a));
		System.out.printf("%f의 올림값 : %d, 내림값 : %d%n", 103.0001, (int)Math.ceil(a), (int)Math.floor(a));
		
		for(int i=0;i<3;i++) {
			double r = Math.random();
			System.out.println("r : "+r);
		}
		// random() : 0.0 <= r <1.0 사이의 임의의 실수를 발생시켜 반환함
		/*
		[문제1] 0<= v2 <10 사이의 임의의 정수를 발생시키세요.		
		[문제2] 5<= v3 <15 사이의 임의의 정수를 발생시키세요.				
		*/
		// [1]
//		int v2 = (int)Math.round(Math.random()*10);
		int v2 = (int)(Math.random()*10);
		System.out.println("v2 : "+v2);
		// [2]
		int v3 = (int)(Math.random()*10+5);
		System.out.println("v3 : "+v3);
		
		//int r = (int)(Math.random()*범위 + 시작수)
		
		// [1] 75 <= r2 < 123 사이의 임의의 정수를 출력하세요
		int r2 = (int)(Math.random()*48 + 75);
		System.out.println(r2);
		
		//[2] 랜덤한 알파벳 대문자 한자를 출력하세요
		char Al = (char)(Math.random()*26 +65);
//		System.out.println((int)'Z'+" - "+(int)'A');
		System.out.println(Al);
		
		//[3] 아래와 같은 형태로 랜덤한 알파벳을 출력하세요
				/*		E W Q R P
						U I Z W X
						M O G H A

						중첩 반복문 활용
				 * 
				 * */
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				char c = (char)(Math.random()*26 +'A');
				System.out.printf("%c\t", c);
			}
			System.out.println();
		}
	}

}
