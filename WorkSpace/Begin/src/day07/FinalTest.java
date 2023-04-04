package day07;
//final + class : 상속받지 못한다
final class Base{
	int a=10;
}////////////////
class Sub //extends Base
{

}////////////////

class Demo{
	
	//final + 변수 : 값 할당을 못함
	int a=10;
	final static public int b=20; // 상수
	
	void foo() {
		System.out.println("foo()");
	}
	//final + 메서드 : 오버라이드 못함
	final void bar() {
		System.out.println("bar()");
	}
}////////////////

class Child extends Demo{
	public void foo() {
		System.out.println("foo()###");
	}
	/*public void bar() {
		[X]
	}*/

}////////////////

public class FinalTest {

	public static void main(String[] args) {
		//a,b
		Demo dm=new Demo();
		System.out.println(dm.a);
		System.out.println(Demo.b);
		dm.a=100;
//		Demo.b=200 ;//[X]
		System.out.println(dm.a);
	}

}////////////////
