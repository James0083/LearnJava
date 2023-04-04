package day03;

import javax.security.auth.kerberos.KerberosCredMessage;

/* 배열
 * - 하나의 변수에 인덱스번호를 붙여 여러개의 데이터를 저장할 수 있도록 하는 자료구조
 * - 고정크기
 * - 동종의 데이터만 저장 가능하다
 * 
 * */
public class ArrayTest1 {

	public static void main(String[] args) {
		// [1] 배열 선언
		int [] a; // 1차원 배열 선언
		int b[]; // 1차원 배열 선언
		
		// [2] 메모리 할당
		a = new int[3];//배열의 크기 : 3
		b = new int[1];//배열의 크기 : 1
		
		// [3] 초기화
		a[0]=10;
		a[1]=20;
		a[2]=30;
		
		System.out.printf("a[0]=%d%n", a[0]);
		System.out.printf("a[1]=%d%n", a[1]);
		System.out.printf("a[2]=%d%n", a[2]);
		
		System.out.printf("b[0]=%d%n", b[0]);
		// 초기값을 부여하지 않았다면 디폴트값이 저장되어 있다.
		b[0]=100;
		System.out.printf("b[0]=%d%n", b[0]);
		//b[1]=200; //error발생
		System.out.println("a.length : "+a.length);
		System.out.println("b.length : "+b.length);
		
		//[1][2]: 선언과 동시에 메모리 할당
		// [3] : 초기화
		
		double d[] = new double[4];
		d[0] = 12.45;
		d[1] = 'A';
		d[2] = 50e-3;
		d[3] = .123f;
		
		//for루프 이용해서 d에 저장된 값을 모두 출력하세요
		for(int i=0;i<d.length;i++) {
//			System.out.println(d[i]);
			System.out.printf("d[%d] = %.3f%n", i, d[i]);
			
		}
		
		// [1][2][3]: 선언과 동시에 메모리 할당 및 초기화
		// JavaScript : var arr=[1,2,3,4]
		// Java
		char[] ch = {'J','a','v','a', 66};
		
		for(int i=0;i<ch.length;i++) {
			System.out.printf("%c", ch[i]);
		}
		System.out.println();
		
		//[1] float타입의 배열 요소를 받아들이는
		//			배열을 선언하고 크기는 3만큼 잡는다.
		//			인덱스0에는 -16.1을 넣어주고,
		//			인덱스1에는 200.1
		//			인덱스 2에는 30E-7의 값을 넣어주자.
	 	// 반복문 이용해 저장된 값을 출력하세요
		float[] fl = {16.1f, 200.1f, 30E-7f};
		for(int i=0;i<fl.length;i++) {
			System.out.println(fl[i]);
		}
		
		System.out.println("******************");
		//확장 for루프 (for each루프)
		// 	for(변수:자료구조){
		// 		실행문;
		// 	}
		for(float a1:fl) { //a1에는 배열에 저장된 요소값들이 전달된다.
			System.out.println(a1);
		}
		
		System.out.println();
		//[2] String 을 저장할 배열을 생성하고 해당 배열에 문자열 3개 저장하세요
		//	for루프 이용해 저장된 값을 출력하되 모두 대문자로 바꿔서 출력하세요

//		String[] str = {"abc", "efgh", "ijklmnop"};
		String[] str = new String[3];
		System.out.println(str[0]); //null
		
		//초기화
		str[0] = "Good Afternoon~";
		str[1] = new String("Allo");
		str[2] = "Nice to Meet You!!";
		
//		for(int i=0;i<fl.length;i++) {
//			System.out.println(str[i].toUpperCase());
//		}
		
		for(String st:str) {
			System.out.println(st.toUpperCase()); // .toLowerCase()
		}
	}

}
