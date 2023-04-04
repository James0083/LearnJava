package day01;
// 1. 패키지 선언문 : package 패키지명;
// package my.com
// 2. import문 : import 패키지명.클래스명;
// import java.lang.System;
// import java.lang.String;
//java.lang패키지는 import문을 생략해도 컴파일러가 자동으로 import함

// import java.util.Date;
// import java.util.UUID;
import java.util.*;

// YourDemo.java
public class YourDemo {
    public static void main(String[] args) {
        System.out.println("----YourDemo---------");
        Date d=new Date(); // java.util패키지에 있음 -> import 하지 않으면 에러남
        System.out.println(d);
        UUID uid=UUID.randomUUID();
        System.out.println(uid);

        //출력 서식 %지시자
		/* %d : 정수형식으로 출력
		 * %f : 소수점 형식으로 출력
		 * %s : 문자열 형식으로 출력
		 * %b : boolean형식으로 출력
		 * %n : 줄바꿈
		 * */

         System.out.printf("제 이름은 %s이고 제 나이는 %d세 입니다 %n", "김철수", 22);
         System.out.printf("제 평균 성적은 %f입니다\n", 95.3333333);

         double avg=95.5555555;
         double avg2 = (Math.round(avg*100))/100.0;
        //  double avg3 = avg2/100;
         System.out.println(avg2);

         System.out.printf("평균성적: %.2f\n", 95.555555);

         System.out.printf("%d%n", 1);
         System.out.printf("%5d%n", 1); // 5자리를 차지하고 1을 출력
         System.out.printf("%5d\n", 10); // 5자리를 차지하고 10을 출력
         System.out.printf("%5d\n", 100); // 5자리를 차지하고 100을 출력

        //  -를 사용하면 왼쪽 정렬이 된다
         System.out.printf("%-5d%n", 1); // 5자리를 차지하고 1을 출력
         System.out.printf("%-5d\n", 10); // 5자리를 차지하고 10을 출력
         System.out.printf("%-5d\n", 100); // 5자리를 차지하고 100을 출력

         System.out.printf("%05d\n", 100); // 5자리를 차지하고 100을 출력, 앞에 남은 공간을 0으로 채움

    }
}
