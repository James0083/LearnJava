package day01;
/* Reference Type (참조형)
 *  [1] 클래스형
 *  [2] 인터페이스형
 *  [3] 배열
 *  - 참조형은 반드시 new 연산자로 객체를 생성해서 사용해야 한다.
 *    다만 예외는 있다. String의 경우 자주 사용하기 때문에
 *    기본자료형처럼 문자열값(literal)을 직접 할당하도록 하고 있다.
 *    Integer, Float, Double,Character
 * */
import java.util.Date;

public class Reference {
	// main
	public static void main(String[] args) {
		Date d = new Date();
		//d : 참조변수(reference type)
		System.out.println(d);
		
		String str = new String("Hello");	//heap영역에 저장
		String str2 = "Java";				// literal 저장영역에 저장
		
		System.out.println("str : "+str);
		System.out.println("str2 : "+str2);
		
		// String의 경우 + 연산자를 이용하면 문자열 결합이 일어난다
		System.out.println(str + str2);
		
		int m=20;
		int n=30;
		System.out.println(m+n+"<=합");
		System.out.println("합=>"+m+n);
	}
}
