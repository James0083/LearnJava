package day03;

import java.util.Scanner;

public class Quiz3 {

	public static void startGame() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~100사이의 정수를 입력하세요");
		//컴퓨터가 랜덤한 정수값을 1<= r <=100 사이의 임의의 정수를 발생시킨다.
		//이 값을 맞추는 게임
		//단 게임시도횟수가 7번을 초과하면 "실패!!" 게임 종료
		int num = (int)(Math.random()*100)+1;
		
		for(int i=0;i<7;i++) {
			int a = sc.nextInt();
			if(a==num) {
				System.out.println("정답입니다~!");
				return;
			}
			else if(a<num) {
				System.out.println(a+"보다 큰 값입니다");
			}
			else {
				System.out.println(a+"보다 작은 값입니다");
			}
		}
		System.out.println("실패!!");
		
		//강사----------------
		int cnt = 1;
		int com = (int)(Math.random()*100)+1;
		while(cnt<=7) {
			int user=sc.nextInt();
			if(com==user) {
				System.out.println("정답입니다.^^ 시도횟수 : "+cnt);
				return;
			}
			else if(com>user) {
				System.out.println(user+"값 보다 더 큰 값입니다 시도횟수 : "+cnt);
			}
			else {

				System.out.println(user+"값 보다 더 작 값입니다 시도횟수 : "+cnt);
			}
			cnt++;
		}//while---
		System.out.println("Game Over!! 시도횟수 초과했어요");
		
	}
	public static void main(String[] args) {
		Quiz3.startGame();
	}

}
