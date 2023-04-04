package day08;

//for루프 바깥에서 예외 처리 해보기
public class ExceptionTest2 {
	public static void main(String[] args) {
		try {
			for(int i=1;i<5;i++) {
				int a=50/(i-3);
				System.out.printf("a: %d%n", a);
			}//for---
		}catch (ArithmeticException e) {
			System.out.println("분모가 0이 되었어요. 0으로 나누면 안돼요!");
		}
		System.out.println("The End~~~");
	}// main-----
}///////////////
