package my.com;
//기본적인 application의 기능 : CRUD
/* Create 	: 데이터 등록
 * Read		: 데이터 조회
 * Update	: 데이터 수정
 * Delete	: 데이터 삭제
 */
import java.util.*;

public class JobKoreaApp {
	Scanner sc = new Scanner(System.in);
	JobSeeker[] arr = new JobSeeker[3];
	int count = 0;
	Company[] arrc = new Company[5];
	int count_c = 0;
	
	public void menu() {
		System.out.println("------JobKoreaApp v1.1------");
		System.out.println(" 1. 구직자 등록");
		System.out.println(" 2. 회 사 등록");
		System.out.println(" 3. 구직자 정보 출력");
		System.out.println(" 4. 회 사 정보 출력");
		System.out.println(" 9. 종  료");
		System.out.println("----------------------------");
		System.out.println(" 메뉴 번호를 선택하세요 =>");
		System.out.println("----------------------------");
		
	}
	
	/** 구직자 정보를 입력받아 배열에 저장하는 메서드*/
	public void registerJobSeeker() {
		if(count>=arr.length) {
			System.out.println("등록 마감!! [현재 등록인원 "+count+"명]");
			return;
		}
		//JobSeeker객체 생성하기
		JobSeeker js1 = new JobSeeker();
		//input()호출하기
		js1.input();
		String info = js1.introduce();
		System.out.println(info);
		System.out.println(">>위 정보를 등록할까요? [1.yes 2.no]");
		//arr에 저장하기
		int no = sc.nextInt();
		if(no==1) {
			arr[count++] = js1;
			System.out.println("등록 완료!! 현재 등록 인원: "+count+"명");
		}else {
			System.out.println("등록을 취소하였습니다!!");
		}
	}
	/** 등록된 모든 구직자 정보를 배열 arr에서 꺼내서 출력하는 메서드 */
	public void printJobSeeker() {
		System.out.println("***총 "+count+"명의 구직자***");
		
		for(JobSeeker js:arr) {
			if(js != null) {
				System.out.println(js.introduce());
			}
		}
	}
	
	public void registerCompany() {
		if(count_c>=arrc.length) {
			System.out.println("등록 마감!! [현재 등록인원 "+count_c+"명]");
			return;
		}
		//JobSeeker객체 생성하기
		Company cpny = new Company();
		//input()호출하기
		cpny.input();
		String info = cpny.recruitment();
		System.out.println(info);
		System.out.println(">>위 정보를 등록할까요? [1.yes 2.no]");
		//arrc에 저장하기
		int no = sc.nextInt();
		if(no==1) {
			arrc[count_c++] = cpny;
			System.out.println("등록 완료!! 현재 등록 인원: "+count_c+"명");
		}else {
			System.out.println("등록을 취소하였습니다!!");
		}
	}
	
	public void printCompany() {
		System.out.println("***총 "+count_c+"개의 모집공고***");
		
		for(Company cpny:arrc) {
			if(cpny != null) {
				System.out.println(cpny.recruitment());
			}
		}
	}
	
	public static void main(String[] args) {
		//반복문 돌면서 menu보여주고 입력받기
		JobKoreaApp app = new JobKoreaApp();
		while(true) {
			app.menu();
			int num= app.sc.nextInt();
			if(num==9) {
				System.out.println("Bye Bye~~");
				break;
			}
			if(num<1||num>4) {
				System.out.println("메뉴에 없는 번호에요. 다시 입력하세요.");
				continue;
			}
			
			switch (num) {
			case 1: //구직자 등록
				app.registerJobSeeker();
				break;
			case 2: //회사 등록
				app.registerCompany();
				break;
			case 3: // 등록한 모든 구직자 정보 출력
				app.printJobSeeker();
				break;
			case 4: // 모든 회사 정보 출력
				app.printCompany();
				break;
			}
		}//while ---
	}

}
