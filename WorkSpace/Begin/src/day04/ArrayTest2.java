package day04;

public class ArrayTest2 {
	public static void main(String[] args) {
		// [문제1] String 유형을 저장하는 이차원 배열을 선언하고 생성, 초기화하세요
		//  반복문 이용해서 출력하되 모두 소문자로 바꿔 출력하세요
		String s = "JavaScript";
		String[]str[]= {{"Java","CSS"},{new String("HTML"),s}};
		
		String[][] arr = new String[2][3];
		arr[0][0] = "Backend";
		arr[0][1] = "Developer";
		arr[0][2] = new String("~~");
		
		arr[1] = new String[] {"Good","Job","!!"};
		
		for(String[] sarr: str) {
			for (String sr : sarr) {
				System.out.println(sr.toLowerCase());
			}
		}
		System.out.println("---------------");
		
		for(String[] sarr:arr) {
			for (String sr : sarr) {
				if(sr!=null) {
					System.out.println(sr);
				}
			}
		}
		/* [문제2] 2차원 배열에 다음의 값을 저장하되,
		  for루프를 이용해 저장하자.
		  그런 뒤, 저장된 값들을 출력해봅시다.
		  1 0 0 0 0
		  0 1 0 0 0
		  0 0 1 0 0
		  0 0 0 1 0
		  0 0 0 0 1
		 */
		int [][]iarr = new int[5][5];
		for(int i=0;i<iarr.length;i++) {
			for (int j=0;j<iarr[i].length;j++) {
				iarr[i][j]= (i==j)?1:0;
				System.out.print(iarr[i][j]+" ");
			}
			System.out.println();
		}
		
		/* [문제3] 아래 선언된 변수들의 자료형을 맞춰봅시다.
		 * 
		 * (1)   int i, j[]          :	i:정수형 변수, j:1차원 배열(정수)
		 * (2)   int[] i, j[], k;    :	i:1차원 배열, j:2차원 배열, k:1차원 배열
		 * (3)   int i, []j[], k[];  :	i:정수형 변수, j:2차원 배열, k:1차원 배열
		 * (4)   int [][]i, j[];   	 :	i:2차원 배열, j:3차원 배열
		 * 
		 * */
		
		
	}
}
