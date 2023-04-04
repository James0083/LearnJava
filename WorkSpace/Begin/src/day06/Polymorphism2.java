package day06;

class Super{//부모 클래스
	int a=10;
	int b=20;
	
	void foo() { // 생략형 접근지정자(default access modiier)
		System.out.println("foo()********");
	}
}////////////////
class Sub extends Super{
	int b=30;
	int c=40;

	@Override
	protected void foo() {
		System.out.println("foo()#######");
	}
}/////////////////

public class Polymorphism2 {

	public static void main(String[] args) {
		//결과 예측하기
		System.out.println("1.------------------");
		Super sp=new Super();
		System.out.println("sp.a: "+sp.a);//10
		System.out.println("sp.b: "+sp.b);//20
		sp.foo(); //"foo()********"
		
		System.out.println("2.------------------");
		Sub sb=new Sub();
		System.out.println("sb.a: "+sb.a);//10
		System.out.println("sb.b: "+sb.b);//30
		System.out.println("sb.c: "+sb.c);//40
		sb.foo(); //"foo()#######"

		System.out.println("3.------------------");
		Super ss=new Sub();
		System.out.println("ss.a: "+ss.a);//10
		System.out.println("ss.b: "+ss.b);//20
//		System.out.println("ss.c: "+ss.c);
		System.out.println("ss.c: "+((Sub)ss).c);//40
		ss.foo(); //"foo()#######"
		
	}

}
