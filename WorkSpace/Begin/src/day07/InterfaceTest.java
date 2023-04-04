package day07;


interface MyInter{
	void sub(); //public abstract가 자동으로 붙는다
}///////////////////

interface YourInter {
	String STR="Hi"; //public static final이 자동으로 붙는다
	String bar();
}///////////////////
//인터페이스는 다중상속 가능하며, 상속받을 때는 implements로 받는다
//MyInter,YourInter를 상속받아서 컴파일 에러 없게 만드세요
class MyDemo implements MyInter , YourInter{
	public void sub() {
		System.out.println("sub()~~~");
	}
	public String bar() {
		return "bar()~~";
	}
}

public class InterfaceTest {

	public static void main(String[] args) {
		//MyInter mi=new MyInter(); //[X]
		MyInter mi=new MyDemo();
		//sub(), bar()
		mi.sub();
		System.out.println(((MyDemo)mi).bar());
		
		//YourInter타입의 변수 선언하고 MyDemo객체 생성해서
		//sub(), bar(), STR 출력
		YourInter yi=new MyDemo();
		((MyDemo)yi).sub();
		System.out.println(yi.bar());
		//System.out.println("YourInter.STR : "+yi.STR);
		System.out.println("YourInter.STR : "+YourInter.STR);
		System.out.println("MyDemo.STR : "+MyDemo.STR);
		//MyDemo.STR="Bye~~"; //[X]
	}

}

