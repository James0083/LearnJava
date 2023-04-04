package day01;

// Demo.java(파일명) == 클래스명이 같아야 함(대소문자까지도)
public class Demo {
    // main() 메서드
    public static void main(String[] args) {
        System.out.println("Hi Java");
        System.out.println("안녕 자바");
        // println 는 줄바꿈 함(ln : new line)
        System.out.print("반갑습니다");
        // print 는 줄바꿈 하지 않음
        System.out.println(" 저는 백엔드 개발자 과정의\n홍길동입니다");
        /* escape 문자
         *  \n : 개행문자 (줄바꿈이 일어난다)
         *  \t : 탭 키만큼 띄어쓰기를 한다
         *  \" : 쌍따옴표를 출력
         *  \' : 홑따옴표
         *  \\ : 역슬래쉬(\)를 출력하고자 할 때
         *  \r : 캐리지 리턴. 커서를 맨 앞으로 이동시킨다
         */
        System.out.println("----------------------");
        System.out.println("국어\t영어\t수학");
        System.out.println("----------------------");
        System.out.println("99\t88\t75");
        System.out.println("----------------------");

        /*
         * 김소월 님의 '진달래 꽃'
         * "나보기가 역겨워 가실 때에는 말없이 고이 보내 드리오리다"
         */
        System.out.println("김소월 님의 \'진달래 꽃\'");
        System.out.println("\"나보기가 역겨워 가실 때에는 말없이 고이 보내 드리오리다\"");
        System.out.println("역슬래시 (\\)");
        System.out.println("Hello World\rA");

    }
}
/*
Demo.java(원시코드)
[1] 컴파일(문법체크)
    c:\myjava>javac Demo.java
    ==> Demp.class(byte code) : JVM이 이해할 수 있는 코드
[2] 실행(인터프리터)
    ==>java Demo
    ==>Output
 */