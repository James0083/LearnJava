package day04;

public class MyDemoTest {

	public static void main(String[] args) {
		//MyDemo 객체 1개 생성하기 => 기본생성자
		//x, y값 출력하기
		MyDemo md1 = new MyDemo();
		System.out.println("md1.x : "+md1.x);
		System.out.println("md1.y : "+md1.y);
		
		//MyDemo 객체 1개 생성하기 => 인자생성자
		MyDemo md2 = new MyDemo(55,45.67);
		System.out.println("md2.x : "+md2.x);
		System.out.println("md2.y : "+md2.y);
		
	}

}
