package day05;

public class Aquaman {
	String name;
	int height;
	double speed;
	//생성자 오버로딩 하기 2개 이상 만들기
	// 생성자를 하나도 구성하지 않으면 컴파일러가 디폴트 생성자를 제공한다
	// 하지만 생성자를 구성하게 되면 컴파일러가 제공하던 기본 생성자는 사라진다
//	public Aquaman() {
//		name="아쿠아";
//		height=165;
//		speed=3.0;
//	}
//	public Aquaman(String name) {
//		this.name=name;
//		height=165;
//		speed=3.5;
//	}
	public Aquaman(String n, int h, double s) {
		name=n;
		height=h;
		speed=s;
	}
	public Aquaman(String n, int h) {
		name = n;
		height=h;
		speed=56.12;
	}
	public String showInfo() {
		String str="---아쿠아맨 정보---\n";
		str += "이 름 : "+name+"\n키 : "+height+"\n스피드 : "+speed;
		return str;
	}
}
