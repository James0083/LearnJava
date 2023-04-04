package day03;

import java.util.*;

public class Quiz4 {

	public static void showMenu() {
		String str = "------수도요금 계산기 v1.1------\n";
		str += "1. 가정용 (liter당 50원)\n";
		str += "2. 사업용 (liter당 45원)\n";
		str += "3. 공업용 (liter당 30원)\n";
		str += "9. 종 료\n";
		str += "----------------------------\n";
		str += "메뉴 번호를 입력하세요 =>\n";
		str += "----------------------------";
		System.out.println(str);
	}

	public static void main(String[] args) {
		// 무한반복 돌면서 수도요금을 계산하는 프로그램을 구성하세요
		// switch ~case문 활용해서 수도요금 계산하기
		// output
		// 1. 선택한 메뉴번호
		// 2. 사용한 수도량
		// 3. 수도요금
		// 4. 세 금 (수도요금의 5%)
		// 5. 총수도요금(수도요금+세금)
//
//		while (true) {
//			Scanner sc = new Scanner(System.in);
//			Quiz4.showMenu();
//			int menu = sc.nextInt();
//			if (menu == 9) {
//				System.out.println("-------프로그램을 종료합니다.-------");
//				return;
//			}
//			System.out.println(">> 사용량을 입력하세요(L) =>");
//			int liter = sc.nextInt();
//			System.out.println("----------------------------");
//			
//			int price = 0;
//			String menu_str = "";
//			switch (menu) {
//			case 1:
//				price = liter * 50;
//				menu_str = "가정용";
//				break;
//			case 2:
//				price = liter * 45;
//				menu_str = "사업용";
//				break;
//			case 3:
//				price = liter * 30;
//				menu_str = "공업용";
//				break;
//			default:
//				continue;
//			}
//
//			int tax = (int) (price * 0.05);
//			int total = price + tax;
//
//			String str = "----------------------------\n";
//			str += "메뉴번호 : %d (%s)\n";
//			str += "사 용 량 : %d liter\n";
//			str += "수도요금 : %d원\n";
//			str += "세  금 : %d원\n";
//			str += "총수도요금 : %d원\n";
//			str += "----------------------------\n";
//			System.out.printf(str, menu, menu_str, liter, price, tax, total);
//		}
//		
		
		// 강사코드----------------
		Scanner sc = new Scanner(System.in);
		for(;;) {
			Quiz4.showMenu();
			int num=sc.nextInt();
			if(num==9) {
				System.out.println("Bye Bye~~");
				//break;
				System.exit(0);//시스템 종료. 0: 정상종료,  음수값: 에러발생시 종
			}
			//유효성 체크 
			if(num<1||num>3) {
				System.out.println("메뉴에 없는 번호에요. 다시 입력하세요");
				continue;
			}
			System.out.println("수도 사용량을 입력하세요=>");
			int use=sc.nextInt();
			//System.out.println("수도 요금 계산예정...");
			String str="";
			int price = 1;
			switch (num) {
			case 1:
				price = 50;
				str="가정용 ";
				break;
			case 2:
				price = 45;
				str="상업용 ";
			case 3:
				price = 30;
				str="공업용 ";
			default:
				break;
			}//switch ---
			//수도요금
			int fee = use*price;
			int tax=(int)(fee*0.05);
			str += "단가: "+price+"원";
			System.out.println("-------------------");
			System.out.println("메뉴번호 : "+num+" ("+str+")");
			System.out.println("사 용 량 : "+use+"liter");
			System.out.println("수도요금 : "+fee+"원");
			System.out.println("세   금 : "+tax+"원");
			System.out.println("총수도요금 : "+(fee+tax)+"원");
			
		}

	}
}
