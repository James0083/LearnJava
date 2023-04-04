package day02;

import java.util.Scanner;

public class IfTest3 {

	public static void main(String[] args) {
		/*[2]
		가격과 나이를 입력받아 20세 미만이면 10%를 할인하여 가격을 알려주세요

		price=10000
		age=18
		가격은 9000원 입니다
		*/
		Scanner sc = new Scanner(System.in);
		System.out.println("가격을 입력하세요 : ");
		int price = sc.nextInt();
		System.out.println("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		if(age<20) {
			System.out.printf("가격은 %d원 입니다\n", (int)(price*0.9));
//			System.out.println("가격은 "+(int)(price*0.9)+"원 입니다");
		}
		else {
			System.out.printf("가격은 %d원 입니다", price);
//			System.out.println("가격은 "+price+"원 입니다");
		}
		
		
		/*[3]
		 * 0~9999 사이의 정수를 입력받아서 입력받은 정수가 몇 자리인지 알려주세요.
			 15 --->2  
			 123--->3  
			 7777-->4
		 */
		System.out.println("*******************");
		System.out.println("0~9999사이의 정수를 입력하세요 =>");
		int num = sc.nextInt();
		if(num<0 || num>9999) {
			System.out.println("0~9999사이의 정수를 입력해야해요");
			return;
		} else {
			int nl;
			// 1)
//			nl = String.valueOf(num).length();
			
			// 2)
			nl = 0;
			int num1 = num;
			while(num1 > 0) {
				num1 /=10;
				nl +=1;
			}
			
			// 3) 
			/*
			if(num / 1000 >0) {
				nl = 4;
			}
			else if(num/100>0) {
				nl = 3;
			}
			else if(num/10>0) {
				nl = 2;
			}
			else {
				nl = 1;
			}
			 */
			System.out.println(num+"--->"+nl);
		}
	}

}
