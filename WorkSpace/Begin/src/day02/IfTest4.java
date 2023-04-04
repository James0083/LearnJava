package day02;

import javax.swing.JOptionPane;

public class IfTest4 {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("0~9, 또는 알파벳 또는 기타문자 1개 입력하세요");
		// (javascript) let str = prompt("0~9, 또는 알파벳 또는 기타문자 1개 입력하세요")
		System.out.println("str : "+str);
		//String클래스의 메서드
		//public char charAt(int index):특정 index위치의 문자를 1개 추출하여 반환하는 메서드
		//"Hello"
		
//		System.out.println("Hello".charAt(1));
		
		//입력한 값의 첫번째 문자 1개 0~9사이의 값이면 "숫자입니다"
		//"A~Z" or "a~z" 이면 "알파벳입니다"
		//그 외 문자이면 "기타 문자 입니다"를 출력하세요
		if(str==null) {
			System.out.println("0~9, 또는 알파벳 또는 기타문자 1개 입력해야 해요");
			return;
		}
		
		char p = str.charAt(0);
		System.out.println(p);
		if(p>='0' && p<='9') { // '0'=48, '9'=57
			System.out.println("숫자입니다");
		}
		else if ((p>='A'&& p<='Z') || (p>='a' && p<='z')) {
			System.out.println("알파벳입니다");
		}
		else {
			System.out.println("기타 문자 입니다");
		}
		
		/* 2)
		char i = str.charAt(0);
		if ((i-'0'>=0)&&(i-'0'<10)) 
			System.out.println("숫자입니다");
		else if((i>64 && i<91)|| (i>96 && i<123)) 
			System.out.println("알파벳 입니다");
		else 
			System.out.println("기타 문자입니다.");
		*/
		System.out.println("----------------");
		
		
		//java.lang.Character클래스의 메서드를 이용해서 이 문제를 풀어봅시다.
		/*   기본자료형		Wrapper 클래스
		 * ----------------------------------
		 * 	byte			Byte
		 *  short			Short
		 *  char			Character
		 *  int				Integer
		 *  long			Long
		 *  float			Float
		 *  double			Double
		 *  boolean			Boolean
		 *  ----------------------------------
		 * 
		 * */
		// static boolean	isAlphabetic(int codePoint) : 알파벳(한글, 영어)여부 판별
		// static boolean	isDigit(char ch) : 숫자여부 판별
		// static boolean	isLowerCase(char ch) : 알파벳 소문자면 true
		// static boolean	isUpperCase(char ch) : 알파벳 대문자면 true
		if(Character.isAlphabetic(p)) {
			System.out.println("글자입니다");
		}
		
		if(Character.isLowerCase(p) || Character.isUpperCase(p)) {
			System.out.println("알파벳입니다");
		}
		else if(Character.isDigit(p)) {
			System.out.println("숫자입니다");
		}
		else {
			System.out.println("기타 문자입니다.");
		}
		
	}

}
