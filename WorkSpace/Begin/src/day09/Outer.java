package day09;
/* 이너클래스
 * [1] 이너 멤버 클래스
 * 		<1> 	static 이너 클래스
 * 		<2> non-static 이너 클래스
 * [2] 이너 로컬 클래스
 * 
 */
public class Outer {
		   int a = 10; // 인스턴스 변수 
	static int b = 20; // 클래스 변수
	
	public void test() {
		System.out.println("----test()-----");
		Outer.Inner in = this.new Inner();
		System.out.println("in.c = "+in.c);
		in.sub();
		
		Inner in2 = new Inner();
		System.out.println("in2.c = "+in2.c);
		in2.sub();
	}
	
	
	
	class Inner{//Inner member - [2] non-static
		int c = 30;
		public void sub() {
			System.out.println("sub()*****");
		}
	}//Inner////////////
	static class SInner{//Inner Member - [1] Static
		int d = 40;
		static int e = 50;
		void foo() {
			System.out.println("foo()@@@");
		}
		static void bar() {
			System.out.println("bar()###");
		}
	}//SInner////////////
}
