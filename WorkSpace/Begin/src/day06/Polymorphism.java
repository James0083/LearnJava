package day06;

public class Polymorphism {
	public static void main(String[] args) {
		Human h1=new Human();
		h1.name="홍길동";
		h1.height=166;
		System.out.println(h1.showInfo());
		
		Superman s1=new Superman();
		String str = s1.showInfo("***슈퍼맨 정보***");
		System.out.println(str);
		
		Aquaman a1 = new Aquaman("고등어", 100, 78.3);
		a1.showInfo("***아쿠아맨 정보***", 0);
		
		/////////////////////////////
		//다형성
		/*부모와 자식의 상속관계를 맺을 경우
		 * 부모타입의 변수를 선언하고 자식의 객체를 생성하는 것이 가능하다.
		 * 그러나 그 참조 변수로 참조할 수 있는 범위는 제한이 있다.
		 * */
		Human hs = new Superman("최슈퍼맨",165,700);
		System.out.println("hs.name = "+hs.name);
		System.out.println("hs.height = "+hs.height);
//		System.out.println("hs.power = "+hs.power); //[X]
		// [1] 부모타입의 변수로는 자식이 갖는 고유한 변수나 메서드에는 접근할 수 없다
		// [2] 부모로부터 물려받은 변수나 메서드는 접근 가능하다
		// [3] 자식클래스에 오버라이딩한 메서드가 있을 경우에는 그 오버라이딩한 메서드를 우선 호출한다
		System.out.println(hs.showInfo());
		
		System.out.println("s1.power = "+s1.power);
		
		//System.out.println(hs.showInfo("###슈퍼맨 정보###")); //[X] 접근불
		System.out.println(((Superman)hs).power);
		System.out.println(((Superman)hs).showInfo("###슈퍼맨 정보###"));
		
		//Human타입으로 변수 선언하고 Aquaman객체 생성하기
			//이름, 키, 스피드
			//showInfo()호출해보기
		Human ha = new Aquaman("갈치", 70, 20);
//		ha.name = "아쿠아";
//		ha.height = 165;
//		((Aquaman)ha).speed=45.3;
		System.out.println(ha.showInfo());
		((Aquaman)ha).showInfo();
		
		//[2] h1,s1,a1,hs,ha 들을 저장할 배열을 선언하고 메모리 할당한 뒤 저장하세요
		//반복문 이용해서 배열에 저장된 객체들을 꺼내서 정보를 출력하세요(실습)
		Human arr[] = {h1,s1,a1,hs,ha};
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("************");
			System.out.println(arr[i].showInfo());
		}
		
		//instanceof 연산자 이용해서 적절히 형변환하여 타이틀과 정보를 출력하세요(실습)
		for(Human hm:arr) {
			if(hm instanceof Superman) {
				System.out.println(((Superman)hm).showInfo("$$$슈퍼맨 정보$$$"));
			}
			else if(hm instanceof Aquaman) {
//				System.out.println("%%%아쿠아맨 정보%%%");
//				System.out.println(((Aquaman)hm).showInfo());
				((Aquaman)hm).showInfo("$$$아쿠아맨 정보$$$", 0);
			}
			else {
				System.out.println(hm.showInfo());
			}
		}
		
	}
}
