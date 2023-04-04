package day03;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요=>");
		String str=sc.nextLine();
		System.out.println("str : "+str);
		
		// 입력한 값이 숫자가맞는지 여부를 체크해서
		
		// 숫자가 아니면 "숫자가 아니에요 다시 입력하세요"
		
		// 숫자가 맞다면 해당 숫자의 2진수값을 출력하세요
		// Hint) java.lang.Integer 클래스의 toBinaryString() 메서드를 이용
		//  public static String	toBinaryString(int i)
		
		for(int i=0;i<str.length();i++) {
			if(!Character.isDigit(str.charAt(i))) {
//			if(str.charAt(i)>='0' && str.charAt(i)<='9') {
				System.out.println("숫자가 아니에요 다시 입력하세요");
				str=sc.nextLine();
//				return;
			}
		}
		sc.close();
		int num = Integer.parseInt(str);
		System.out.println(str+"의 2진수"+Integer.toBinaryString(num));
		System.out.printf("%s의 8진수 : 0%s%n",str, Integer.toOctalString(num));
		System.out.printf("%s의 16진수 : 0x%s%n",str, Integer.toHexString(num));
	}

}
