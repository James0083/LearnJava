package day06;
// 하나의 파일에 여러개의 클래스를 만드는 것이 가능하다..
// 하지만 public을 붙일 수 있는 class는 파일명과 이름이 같은 클래스 1개 뿐이다

/* 부모 클래스 : Super class, Base class
 * 상속받을 때는 extends를 이용한다.
 * 자바는 단일상속이다.
 * 
 * Method Override : 부모로 부터 상속받은 메서드를 재정의해서 구현하는 것
 * [1] 메서드 이름은 부모와 동일하게
 * [2] 매개변수도 부모와 동일하게
 * [3] 반환타입도 동일하게
 * [4] 접근지정자는 부모와 동일하거나 더 넓은 범위를 지정해야 함 
 * [5] Exception은 부모와 동일하거나 더 구체적인 예외 (자식예외)를 발생시킬 수 있다.
 */

class Human{ // extends Objects
	String name; //has a
	int height;
	
	public String showInfo() {
		return "이 름 : "+name+"\n키  : "+height;
	}
	
}////////////////
//자식 클래스 : Sub class, Derived class
//"is a"관계가 성립되어야 상속 가능
//Superman is a Human 
class Superman extends Human{ // 
	int power;
	public Superman() {
		this("슈퍼맨",180,100);
	}
	public Superman(String n, int h, int p) {
		name=n;
		height=h;
		power=p;
	}
	
	//오버라이딩 - 메서드 헤더는 부모와 동일. 몸체는 다르게 구성하는것
	@Override
	public String showInfo() {
//		return "이 름 : "+name+"\n키  : "+height+"\n초능력 : "+power;
		return super.showInfo()+"\n초능력 : "+power;
	}

	//오버로딩-Overloading
	public String showInfo(String title) {
		String str = title+"\n";
//		str+=  "이 름 : "+name+"\n키  : "+height+"\n스피드 : "+speed;
		str+=this.showInfo();
		return str;
	}
	//오버로딩 1개 더 해보기(실습)
	public void showInfo(int pw) {
		System.out.println(">>초능력 충전: "+pw+"<<");
		this.power+=pw;
		System.out.println(this.showInfo());
	}
	
}////////////////
class Aquaman extends Human{
	double speed;
	
	public Aquaman() {
		this("아무개", 155, 44);
	}
	public Aquaman(String name, int height, double speed) {
		this.name=name;
		this.height=height;
		this.speed=speed;
	}

	//showInfo() 오버라이드 하세요(실습)
	@Override //annotation
	public String showInfo() {
//		return "이 름 : "+name+"\n키  : "+height+"\n스피드 : "+speed;
		return super.showInfo()+"\n스피드 : "+speed;
	}
	//showInfo()를 오버로드 하세요(실습)
	public void showInfo(String title, double sp) {
		System.out.println(title);
		System.out.println(this.showInfo());
		System.out.println(">>스피드 충전 : "+sp);
		speed+=sp;
		System.out.println("스피드 : "+speed);
	}
	
}////////////////

public class Inheritance {

	public static void main(String[] args) {
		Human h1=new Human();
		h1.name="홍길동";
		h1.height=166;
		System.out.println(h1.showInfo());
		System.out.println("---------------");
		
		Superman s1=new Superman();
		s1.name="이슈퍼";
		s1.height=177;
		s1.power=300;
		System.out.println(s1.showInfo());
		System.out.println(s1.showInfo("##슈퍼맨 정보###"));
		s1.showInfo(50);
		
		System.out.println("---------------");
		
		// [1] Aquaman이 Human을 상속받는다
		// [2] 생성자 구성하기 - 2개
		// [3] Aquaman객체 생성해서 showInfo()호출하기
		Aquaman a1=new Aquaman();
		System.out.println(a1.showInfo());
		System.out.println("---------------");
		
		Aquaman a2=new Aquaman("인어공주", 160, 80);
		System.out.println(a2.showInfo());
		System.out.println("---------------");
		
		a1.showInfo("@@아쿠아맨 정보@@@", 50);
	}

}/////////////////////
