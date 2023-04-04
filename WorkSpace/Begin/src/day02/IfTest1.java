package day02;

import java.util.Scanner;

public class IfTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// System.in : 키보드 입력을 받으 ㄹ수 있는 입력장치와 연결된 객체
		System.out.println("정수를 입력하세요 =>");
		int num = sc.nextInt(); //사용자가 입력한 정수값을 반환한다
		// float a = sc.nextFloat();double b = sc.nextDouble()
		
		System.out.println("num : "+num);
		
		// [1] 입력받은 값이 짝수면 "Even"을, 홀수면 "Odd"를 출력하세요
		if(num%2==0) {
			System.out.println("Even");
			System.out.println("********");
		}
		else {
			System.out.println("Odd");
			System.out.println("########");
		}
		System.out.println("~~~~The End~~~~");
		
		// [2] 삼항 연산자로 구현해보세요
		String str = (num%2==0)?"짝수\n********":"홀수\n########";
		System.out.println(str);
		
	}

}
