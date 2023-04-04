package my.com;
import java.util.*;
/*
 * [1] 구직자 클래스 구성해보기
 * 		- 속성 : 3개 이상
 * 		- 메서드 : 2개 이상
 */
public class JobSeeker {
	int salary;
	int age;
	String name;
	String field;

	Scanner sc = new Scanner(System.in);
	
	public void input() {
		System.out.print("이 름 : ");
		name=sc.nextLine();
		System.out.print("나 이 : ");
		age = sc.nextInt();
		sc.skip("\n"); //엔터값 건너뛰기 window : \r\n , mac : \n
		System.out.print("희망 분야 : ");
		field = sc.nextLine();
		System.out.print("희망 급여 : ");
		salary = sc.nextInt();
		
	}
	public String introduce() {
		String intro = "----자기소개----\n";
		intro+="이  름 : "+name+"\n";
		intro += "나  이 : "+age+"\n";
		intro += "지원 분야 : "+field+"\n";
		intro += "희망 급여 : "+salary+"\n";
		return intro;
	}
	public String projects(String[] arr) {
		String str = "참여한 프로젝트 목록 ...\n";
		if(arr.length==0) return "없음";
		
		for(int i=0;i<arr.length;i++) {
			str += arr[i]+"\n";
		}
		return str;
	}
}
