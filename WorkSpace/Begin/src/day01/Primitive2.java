package day01;

public class Primitive2 {
	// main()메서드 구성하기
	public static void main(String[] args) {
		// float < double
		// float : 단정밀도. 소수점 이하 7자리
		// double : 배정밀도. 소수점 이하 15~16자리[디폴트]
		float ft1 = 10.1234f;
		// float형일 경우 부동 소수점일 경우반드시 접미사 f, F를 붙인다. 그렇지 않으면 double로 인식한다
		float ft2 = 800; // promotion(자동변환): 작은 유형에서 큰 유형으로 자동으로 형변환이 일어난다
		
		System.out.printf("ft1 = %f%n", ft1);
		System.out.printf("ft2 = %f%n", ft2);
		
		float ft3 = .789f;
		System.out.printf("ft3 = %f%n", ft3);
		
		double db1 = 123.456789;
		double db2 = 789.123456d;
		System.out.println("db1 = "+db1);
		System.out.println("db2 = "+db2);
		
		// 과학적 지수 표기방법 : E
		// 과학적 지수 표기방법은 무조건 double로 형을 잡기 때문에 float에 넣으려면 형변환을 해주어야 한다
		double db3 = 3e-2; // 3*10^-2
		double db4 = 3e+2; // 3*10^2
		System.out.println("db3 = "+db3);
		System.out.println("db4 = "+db4);
		
		// float 타입 변수 선언하고 900e7 값을 할당한 후 출력하세요
		float ft4 = 900E7f;
		System.out.printf("ft4 = %f%n", ft4);
		// 과학적 지수 표기방법은 무조건 double로 형을 잡기 때문에 float에 넣으려면 형변환을 해주어야 한다
		
		// promotion : byte < short < int < long < float < double
		byte b = 50;
		float c =1.2f;
		// 변수를 선언해서 b*c의 값을 저장하세요
		float result = b*c;
		double result2 = b*c;
		System.out.println("result = "+result);
		System.out.println("result2 = "+result2);
	}
}
