package linux.java;
//Son1.jav
//javac -d . Son1.java 

public class Son1 extends Parent{
    public void go(){
        System.out.printf("publicVar=%d%n", publicVar);
        System.out.printf("protectedVar=%d%n", protectedVar);
        System.out.printf("defaultVar=%d%n", defaultVar);
        // System.out.printf("privateVar=%d%n", privateVar);
    }   
    public static void main(String[] args){
        //go()호출하기
        Son1 s=new Son1();
        s.go();
    }
}
