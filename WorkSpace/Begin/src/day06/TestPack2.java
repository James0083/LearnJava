package day06;
//my.jar 라이브러리를 참조해서 그 안에 있는 Son1, Son2클래스를 사용해보자
//Begin 프로젝트를 선택 > 오른마우스 > Build Path > Configure Build Path > Librearies > Classpath > Add External Libraries > my.jar를 추가
//
//또는
//제어판>시스템>고급>환경변수>classpath에 아래 경로를 추가한다
//.;C:\myjava\my.jar

import linux.java.*;
import windows.java.*;

public class TestPack2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Son1 s1=new Son1();
		s1.go();
		
		Son2 s2=new Son2();
		s2.go();
	}

}
