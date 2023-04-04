package day01;
// Hello.java
// 원시코드 ===> 컴파일 (Hello.class => 바이트코드) ==> 인터프리터가 해석 실행 ==> output
// 클래스명과 파일명은 같아야함 (대소문자도 같아야 함)

public class Hello{
    // 1. 단문 주석
    /* 2. 복문 주석 */
    /** 3. 문서화 주석 : javadoc을 이용해서 api문서를 만들 때 사용 */

    public static void main(String[] args){
        System.out.println("Hello world~~");
        // 문자열은 반드시 ""로 감싸야 한다.
        System.out.println("안녕하세요~ 반갑습니다!!");

    }
}