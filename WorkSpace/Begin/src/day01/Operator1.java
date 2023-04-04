package day01;

public class Operator1 {
	public static void print(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print("1. 단항연산자(부호연산자, 증감연산자, 비트별 not연산자(~), 논리부정연산자(!)");
		print("부호연산자(+,-) ---------------");
		// +,-	부호 연산
		byte a = 5;
		byte b = -7;
		print("+a : "+(+a));
		print("-b : "+(-b));
		
		print("증감연산자(++,--) ---------------");
		
		int c = 8;
		long d = 6;
		c++;
		d--;
		print("c : "+c); // 9
		print("d : "+d); // 5
		++c;
		--d;
		print("c : "+c); // 10
		print("d : "+d); // 4
		
		float e=5.6f;
		double f=8.4;
		print("e : "+ ++e); // 6.6
		print("f : "+ --f); // 7.4
		
		print("e : "+ e++); // 6.6
		print("f : "+ f--); // 7.4
		print("-----------");
		print("e : "+ e); // 7.6
		print("f : "+ f); // 6.4
		
		print("비트별 not연산자(~) --------------");
		int m=42;
		print("m : "+m);
		print("~m : "+ ~m);
		/*		42를 비트로 바꾸어서 연산해야 함
		 * 		~ : 0은 1로, 1은 0으로 비트반전을 한다
		 * 
		 *    42 : 00000000 00000000 00000000 00101010
		 *  ~ 42 : 11111111 11111111 11111111 11010101
		 *  ==> 이 값을 10진수로 바꾼다
		 *  
		 *  1) -1*2^31 + 1*2^30 + 1*2^29 + ...
		 *  
		 *  2) -1*2^6 + 2^4 + 2^2 + 1 = -64+16+4+1  =  -64 + 21
		 *     ( ~ 42 : -------- -------- -------- -1010101 )
		 *  
		 *  3) -(42 + 1) = -43
		 */
			// 부호 비트 : 0 => 양수, 1 => 음수
		
		int x=0xfffffff1;
		//  x : 1111 1111 1111 1111 1111 1111 1111 0001
		// ~x : 0000 0000 0000 0000 0000 0000 0000 1110
		print(" x : "+x);	// -15
		print("~x : "+~x);	// 14
	}

}
