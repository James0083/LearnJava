package windows.java;
//Son2.java
import linux.java.Parent;
//javac -d . Son2.java 
//java windows.java.Son2

//jar cvf my.jar  최상위패키지
//jar cvf my.jar linux

//cvf - c : 생성(create)  / v : 압축  /  f : 파일생성이름

public class Son2 extends Parent{
    public void go(){
        System.out.printf("publicVar=%d%n", publicVar);
        System.out.printf("protectedVar=%d%n", protectedVar);
        // System.out.printf("defaultVar=%d%n", defaultVar);
        // System.out.printf("privateVar=%d%n", privateVar);
    }   
    public static void main(String[] args){
        //go()호출하기
        Son2 s=new Son2();
        s.go();
    }
}
