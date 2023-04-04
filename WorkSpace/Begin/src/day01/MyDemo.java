package day01;
// MyDemo.java
// MyDemo 클래스를 구성하고 main()메소드를 구성해보기
public class MyDemo {
    // main() : 프로그램 시작점이자 끝점
    // public static : modifier (지정자, 제한자 한정자)
    // void : 반환값이 없다
    // main : 메서드 이름 (동사형, 소문자)
    // String[] : 문자열 유형의 배열타입
    // asdf : 매개변수명
    public static void main(String asdf[]) {
        System.out.println("-----MyDemo Start-----");
        System.out.println("asdf[0]: "+asdf[0]); // 명령줄 인수
        // cmd/terminal 에서
        // java MyDemo Hello Java Bye
        System.out.println("asdf[1]: "+asdf[1]); 
        System.out.println("asdf[2]: "+asdf[2]); 

        System.out.println("-----MyDemo End-------");
    }// main()-----------------------
}// class////////////////////////////
