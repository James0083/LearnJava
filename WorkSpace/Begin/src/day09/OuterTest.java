package day09;

public class OuterTest {

	public static void main(String[] args) {
		//[1] Outer클래스의 변수 a, b값을 출력하세요
		Outer o = new Outer();
		System.out.println("o.a = "+o.a);
		System.out.println("Outer.b = "+Outer.b);
		
		//[2] Outer.Inner클래스의 변수 c값 출력, sub()호출 
		Outer.Inner oi = o.new Inner();
		System.out.println("oi.c = "+oi.c);
		oi.sub();
		
		Outer.Inner oi2 = new Outer().new Inner();
		System.out.println("oi2.c = "+oi2.c);
		
		//[3] Outer.SInner클래스의 d,e, foo(), bar() 호출
		Outer.SInner os = new Outer.SInner();
		System.out.println("os.d = "+os.d);
		System.out.println("Outer.SInner.e = "+Outer.SInner.e);
		os.foo();
		Outer.SInner.bar();

		o.test();
		
	}

}
