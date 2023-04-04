package day09;

import javax.swing.JFrame;

import day01.Hello;

public class Local {
	String str="@@@"; //멤버변수
	
	void sub(final String args) {
//		String lstr="###"; //지역변수
		final String lstr="###"; //지역변수
		//로컬변수 => 로컬이너클래스에서 사용하려면 final변수여야 한다. 값을 수정할 수 없게끔
		
		System.out.println("str: "+str);
		System.out.println("lstr: "+lstr);
		class LocalInner extends JFrame{ //Local Inner class - [1] 이름 있는 로컬 이너 클래스
			int no=90;
			void bar() {
				System.out.println("----LocalInner's bar()----");
				System.out.println("no : "+no);
				System.out.println("str : "+str);
				System.out.println("lstr : "+lstr);
				//lstr = "값을 변경할게요~"; //변경 불가
				System.out.println("args : "+args);
				
			}
		}///////////////
		
		LocalInner li = new LocalInner();
		li.setSize(200,200);
		li.setVisible(true);
		
		li.bar();
		//LocalInner클래스는 소속된 메서드 내에서만 객체생성 가능함
		//class를 구성한 후에 객체 생성 가능함
		
	}//sub()-----------
	
	void demo() {
		class LocalInner{
			
		}
	}//----------------
	
	
	public static void main(String[] args) {
		//sub()호출하기
		Local lc=new Local();
		lc.sub("Hello");
	}
}
