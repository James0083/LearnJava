package day01;

public class Primitive1 {
	public static void main(String[] args) {
		// 저장 : (mac) Commend + s
		// 실행 : (mac) Commend + Shift + F11
		// 디버그 : (mac) Commend + F11
		//주석처리/해제: (mac) Commend + /
		//커서 라인 삭제: (mac) Commend + D
		System.out.println("1. 기본 자료형(정수형)----------------------");
		
		// 정수형 :byte < short < int [*] < long
		byte bt1 = -128; // -128~127사이값 저장 가
		byte bt2 = 127;
		System.out.println("bt1 = "+ bt1);
		System.out.println("bt2 = "+ bt2);
		
		short bt3 = 128; // short(2byte) : -2^15 ~ 2^15-1
		System.out.println("bt3 = "+ bt3);
		short st1 = 25000;
		System.out.println("st1 = "+ st1);
		
		int it1 = 5000000; // int(4byte=32bit) -2^31 ~ 2^31-1
		System.out.println("it1 = "+ it1);
		
		long ln1 = 40; // long(8byte=64bit) -2^63 ~ 2^63-1
		long ln2 = 40L; // 뒤에 접미사 L, l을 붙인다.
		System.out.printf("ln1 = %d%n", ln1);
		System.out.printf("ln2 = %d%n", ln2);
		
		int i = 1000000000; // 0이 9개
		// 정수를 먼저 int로 잡은 뒤 long 변수에 넣는다.
		long j = 10000000000L; // 0이 10개  int형의 최대값: 2147483547
		// 뒤에 접미사 L이나 l을 붙이면 int 범위에 벗어나는 수도 long에 넣을 수 있다.
		System.out.println("i = "+ i);
		System.out.println("j = "+ j);
		// Ctrl+Alt+방향키 아래 : 현재 커러내용을 복붙함
		
		int a1 = 010; //8진수의 정수. 8진수는 앞에 0을 붙인다(접두어:0)
		int a2 = 0x1ac;
		System.out.println("a1 = "+ a1);
		System.out.println("a2 = "+ a2);
		
	}
}
