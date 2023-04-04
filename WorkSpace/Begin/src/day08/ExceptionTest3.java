package day08;
//for 루프 안에서 예외 처리하기
public class ExceptionTest3 {
	public static void main(String[] args) {
		
		for(int i=1;i<=5;i++) {
			try {
				int a=50/(i-3);
				System.out.printf("a: %d%n", a);
			}catch (ArithmeticException e) { //Exception : 모든 예외 잡음
				System.out.println("0으로 나눌 수 없어요!!");
			}
		}//for---
		System.out.println("The End~~~");
	}//main-----
}///////////////
