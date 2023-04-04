package day03;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		System.out.println("정수를 입력하세요");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();

		// 입력받은 값을 뒤집어서 출력하세요
		// 그리고 각각의 숫자값들의 합계를 구해 출력하세요
/*
		int sum =0;
		while(num>0) {
			int i =num%10;
			System.out.print(i+" ");
			num /= 10;
			sum += i;
		}
		System.out.println("\nsum : "+sum);
*/
		
		System.out.println("*********************");
		String numStr = String.valueOf(num);
		System.out.println(numStr);
		System.out.println("numStr.length() : "+numStr.length());
		int sum =0;
		for(int i=numStr.length()-1; i>=0;i--) {
			char ch=numStr.charAt(i);
			int c = ch-'0';
			System.out.print(c+" ");
			sum+=c;
		}
		System.out.println("\nsum : "+sum);
		
	}

}
