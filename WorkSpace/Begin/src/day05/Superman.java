package day05;

public class Superman {
	String name;
	int height;
	int power;
	
	public Superman() { // 기본생성자(default constructor)
		this("아무개", 160, 100); //자기자신의 생성자를 호출한다.
//		name="아무개";
//		height=160;
//		power=100;
		/* this()는 생성자 안에서만 호출이 가능하며
		 * 첫번째 줄에 위치해야 한다
		 * super()와는 함께 사용할 수 없다.
		 */
	}
	public Superman(String name) {
		this(name, 165, 200);
//		this.name=name;
//		height=165;
//		power=200;
	}
	public Superman(String n, int h) {
		this(n, h, 300);
//		name = n;
//		height=h;
//		power=300;
	}
	public Superman(String n, int h, int p) { //최종 목적지 = 여기서 초기화 할 예정
		name=n;
		height=h;
		power=p;
	}
	public String showInfo() {
		String str="---슈퍼맨 정보---\n";
		str += "이 름 : "+name+"\n키 : "+height+"\n초능력 : "+power;
		return str;
	}
}
