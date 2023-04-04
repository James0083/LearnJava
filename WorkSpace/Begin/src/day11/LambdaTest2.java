package day11;

import java.lang.Math;
//추상메서드가 1개인 인터페이스는 함수형 인터페이스로 선언할 수 있다.
//함수형인터페이스에 있는 메서드들은 람다식으로 구현할 수 있다.
@FunctionalInterface
interface MyFunc{
	//매개변수 없고 반환값도 없는 람다식
	void foo();
}//////////////////
@FunctionalInterface
interface YourFunc{
	//매개변수 있는 람다식
	void bar(int a);
}//////////////////
@FunctionalInterface
interface HerFunc{
	//매개변수 있고 반환값도 있는 람다식
	int baz(int x, int y);
}//////////////////

public class LambdaTest2 {

	public static void main(String[] args) {
		//[1]
		MyFunc mf=()->System.out.println("@@@@");
		mf.foo();
		
		//[2]
		YourFunc yf=b->System.out.println(b*5);
		yf.bar(8);
		
		YourFunc yf2=a->System.out.println(a-3);
		yf.bar(8);
		
		//x의 y승값을 반환하는 함수를 람다식으로 구현해보기
		HerFunc hf=(x, y)->(int)Math.pow(x,y);
		
		int z=hf.baz(2, 6);
		System.out.println("2의 6승은: "+z);

	}

}
