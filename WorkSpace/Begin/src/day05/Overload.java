package day05;

public class Overload {

	public static void main(String[] args) {
		// 슈퍼맨 객체 3개 생성후 showInfo()로 출력하기
		Superman s1 = new Superman();
		String str=s1.showInfo();
		System.out.println(str);
		
		Superman s2 = new Superman("최슈퍼");
		System.out.println(s2.showInfo());
		
		Superman s3 = new Superman("장슈퍼", 177, 500);
		System.out.println(s3.showInfo());

		//아쿠아맨 객체 2개 생성후 showInfo()
//		Aquaman a1 = new Aquaman();
		Aquaman a1 = new Aquaman("고등어", 150, 78.12);
		System.out.println(a1.showInfo());
		
		Aquaman a2 = new Aquaman("갈치", 170);
		System.out.println(a2.showInfo());
		
		//슈퍼맨을 저장할 배열을 생성하고 저장한 뒤 반복문돌려 정보 출력하기
		Superman arrSup[] = {s1, s2, s3};
		System.out.println("******************");
		for(int i=0;i<arrSup.length;i++) {
			System.out.println(arrSup[i].showInfo());
		}
		
		//슈퍼맨과 아쿠아맨을 모두 저장할 배열을 생성하고 
		//반복문 돌려서 showInfo()호출하기
		//부모타입[] 변수 = {자식객체들...};
		Object []arrObj = {a1, a2, s1, s2, s3};
		Aquaman am=(Aquaman)arrObj[0];
//		자식-작은 자료형 = (자식유형)Object유형(부모-큰자료형)
		System.out.println(am.showInfo());
		// instanceof 연산자
		//참조변수 instanceof 클래스명 : 변수가 클래스의 객체면 true를 반환,
		// 			그렇지 않으면 false를 반환한다
		for(int i=0;i<arrObj.length;i++) {
			//String info = arrObj[i].showInfo(); // [X]
			if(arrObj[i] instanceof Aquaman) {
				Aquaman aman=(Aquaman)arrObj[i];
				System.out.println(aman.showInfo());
			}
			else {
				//슈퍼맨 객체
				Superman sman=(Superman)arrObj[i];
				System.out.println(sman.showInfo());
			}
		}
	}

}
