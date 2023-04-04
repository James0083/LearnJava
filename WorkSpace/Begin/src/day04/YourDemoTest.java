package day04;
/*
 * static 메서드 안에서 접근 가능한 함수
 * 		static 변수 [O], "클래스명.변수", static 메서드 [O]
 * 		인스턴스 변수 [X], 인스턴스 메서드 [X]
 * 			=> 객체를 먼저 생성해서 객체명.변수, 객체명.메서드() 식으로 접근해야함
 * 
 * 	java를 실행하면 JVM이 파일을 불러오면서 static 이 붙은 객체를 먼저 메모리에 올린다. 
 *  인스턴스 객체는 후에 선언될 때 메모리에 올린다. 
 *  따라서 static에서 인스턴스를 호출할 때 객체를 선언하지 않으면 객체가 메모리에 올라오지 않아 호출할 수 없다. 
 */
public class YourDemoTest {

	Boolean z = true;
	static Boolean r = false;

	public static void main(String[] args) {
		// YourDemo를 생성하고
		// str, pi값을 출력하세요
		YourDemo yd = new YourDemo();
		System.out.println("yd.str : " + yd.str);
		System.out.println("yd.pi : " + yd.pi);

		// CMD값도 출력하세요
		System.out.println("YourDemo.CMD : " + YourDemo.CMD);
//		System.out.println("yd.CMD : "+yd.CMD); //가능하지만 경고뜸

		// r값 출력하기
		System.out.println("r : "+YourDemoTest.r);
		System.out.println("r : "+r);

		// z값 출력하기
		YourDemoTest ydt = new YourDemoTest();
		System.out.println("ydt.z : "+ydt.z);
//		System.out.println("z : "+z); // [X]
		
	}

}
