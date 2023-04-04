package my.com;

import java.util.Scanner;

public class Company {

	String name; //회사명
	int year; //설립연도 0
	String field;	// 모집 분야
	int number;		// 모집 인원
	
	Scanner sc = new Scanner(System.in);
	
	public void input() {
		System.out.print(" 회사명 : ");
		name=sc.nextLine();
		System.out.print("설립연도 : ");
		year = sc.nextInt();
		sc.skip("\n"); //엔터값 건너뛰기 window : \r\n , mac : \n
		System.out.print("모집 분야 : ");
		field = sc.nextLine();
		System.out.print("모집 인원 : ");
		number = sc.nextInt();
		
	}
	
	public String recruitment() {		// 모집 공고
		String recruit = "----<모집 공고>----\n";
		recruit += " 회사명 : "+name+"\n";
		recruit += "설립연도 : "+year+"년\n";
		recruit += "모집 분야 : "+field+"\n";
		recruit += "모집 인원 : "+number+"명\n";
		
		return recruit;
	}
	
	
	
}
