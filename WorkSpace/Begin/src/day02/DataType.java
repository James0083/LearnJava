package day02;
/* 변수 선언된 위치에 따른 변수 유형
 * [1] 멤버변수 
 * 		<1> non-static변수 : 인스턴스 변수 	"객체명.변수" 식으로 접근한다.
 * 		<2> static 변수 	  : 클래스 변수	"클래스명.변수" 식으로 접근한다.
 * [2] 지역변수
 * 	
 */

public class DataType {
	
		   byte b; // 멤버변수(member variable) - 인스턴스 변수
	static byte c; //멤버변수 - 클래스 변수
		   short s;
		   char ch;
		   int i;
		   long l;
	static float f;
		   double d;
		   boolean bool;
	static String str; // 참조형 null
		   Object obj; // 참조형 null
	
	public static void main(String[] args) {
		int k=5; // 지역변수 (local variable)
		
		System.out.println("DataType : "+DataType.c);	//static변수 출력
		// System.out.println(b); [X]
		
		//객체 생성
		DataType dt = new DataType(); // dt : 객체명
		System.out.println("dt.b : "+ dt.b);	//non-static변수 출
		
		System.out.println("k : "+k);	//지역변수 출력
		// s, ch, i, l, f, d, bool, str값을 출력하세요
		System.out.println(dt.s);
		System.out.println(dt.ch);
		System.out.println(dt.i);
		System.out.println(dt.l);
		System.out.println(DataType.f);
		System.out.println(dt.d);
		System.out.println(dt.bool);
		System.out.println(DataType.str);
		System.out.println(dt.obj);
		
	}

}
