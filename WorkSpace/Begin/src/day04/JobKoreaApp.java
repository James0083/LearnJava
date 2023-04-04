package day04;
/*
 * [1] 구직자 클래스 구성해보기
 * 		- 속성 : 3개 이상
 * 		- 메서드 : 2개 이상
 * [2] 회사 클래스 구성해보기
 * 		- 속성 : 3개 이상
 * 		- 메서드 : 2개 이상
 */
public class JobKoreaApp {

	public static void main(String[] args) {
		// 구직자 객체 2개 생성해서 속성값 주고 메서드 호출하기
		JobSeeker js1 = new JobSeeker();
//		js1.age = 30;
//		js1.name = "홍길동";
//		js1.field = "마케팅";
//		js1.salary = 3000;
//		System.out.println( js1.introduce());
//		System.out.println(js1.projects(args));

		js1.name = "김시현";
		js1.age = 25;
		js1.field = "웹개발자";
		js1.salary = 5000;
		String intro = js1.introduce();
		System.out.println(intro);
		
		String[] profiles = {"학사관리 프로젝트 2년", "금융 프로젝트 3년"};
		String str = js1.projects(profiles);
		System.out.println(str);
		
		
		JobSeeker js2 = new JobSeeker();
		js2.name = "이길동";
		js2.age = 26;
		js2.field = "퍼블리셔";
		js2.salary = 4000;
		System.out.println(js2.introduce());
		
		String[] profiles2 = {"공공부문 프로젝트 1년"};
		System.out.println(js2.projects(profiles2));
		// 회사 객체 2개 생성해서 속성값 주고 메서드 호출하기
		
	}

}
