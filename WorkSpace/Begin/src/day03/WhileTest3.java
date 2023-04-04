package day03;

import javax.swing.JOptionPane;

public class WhileTest3 {

	public static void main(String[] args) {
		// [1] JOptionPane으로 "구구단 몇단을 출력할까요?"
		System.out.println("1. ----------------");
		String str = JOptionPane.showInputDialog("구구단 몇단을 출력할까요?");
		int n = Integer.parseInt(str);
		System.out.println(n+"단");
		int i=1;
		while(i<10) {
			System.out.println(n+"x"+i+"="+(n*i));
			i++;
		}// -----------
		
		// 강사
//		String str = JOptionPane.showInputDialog("구구단 몇단을 출력할까요?");
		if(str==null) return;
		int dan = Integer.parseInt(str.trim());
		
		i = 1;
		while(i<10) {
			System.out.printf("%d x %d = %d%n", dan, i, dan*i);
			i++;
		}
		// 강사 end--------------
		
		System.out.println("2. ----------------");
		// [2] 구구단 전체를 아래와 같은 형태로 출력하세요 =>중첩 while or do~while
		/*
		 * 2x1=2	3x1=3	....		9x1=9
		 * 2x2=4	3x2=6				9x2=18
		 * ...
		 * 2x9=18
		 * */
		
		int n2 = 2;
		int j = 1;
		while(j<10) {
			// int n2 = 2;
			while(n2<10) {
				System.out.print(n2+"x"+j+"="+(n2*j)+"\t");
				n2++;
			}
			System.out.println();
			j++;
			n2=2;
		}
		
		
	}

}
