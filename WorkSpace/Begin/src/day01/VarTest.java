package day01;
// VarTest.java
public class VarTest {

    int global = 100; // 인스턴스 변수
    static int global2 = 200; // 클래스 변수 (전역변수)

    public static void main(String[] args) {
        // 변수(variable, field, property)
        // 변수 선언 : 자료형 변수명;
        int num1; // 변수선언
        num1 = 10; // 변수 초기화

        int num2 = 8; // 지역변수
        System.out.printf("num1 = %d, num2 = %d%n", num1, num2);

        // global2를 출력
        System.out.printf("global2 = %d%n",global2);
        System.out.printf("global2 = %d%n",VarTest.global2);

        // 정수형 변수 a, b 2개를 선언하고 각자 값을 할당한 뒤에 
        // printf() 이용해서 덧셈식과 곱셈식을 각각 출력하세요
        // +,-,*,/,%
        int a = 5, b = 3;
        System.out.printf("%d + %d = %d\n", a, b, a+b);
        System.out.printf("%d - %d = %d\n", a, b, a-b);
        /* 변수 명명 규칙
         * 1) 명사형, 소문자, 카멜 표기법
         * 2) 숫자로 시작해서는 안된다. 영문자, 한글, 한자
         * 3) 특수문자 사용불가 (예외 : $, _)
         * 4) 예약어는 사용 불가
         */

        //  int 1a = 10; // [X]
        int wordCount = 5;
        int word_count = 6;
        int 가1 = 10;
        int $$$ = 90;
        int _weight = 55;
        int class_ = 7;
    }
}
