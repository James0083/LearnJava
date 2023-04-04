package day06;

//import pack.My1;
//import pack.My2;
import pack.*;
import pack.demo.*;

public class TestPack {

	public static void main(String[] args) {
		// My1과 My2객체 생성 후 sub1(), sub2()호출하기
		My1 m1=new My1();
		My2 m2=new My2();
		m1.sub1();
		m2.sub2();
		
		// Demo객체 생성후 foo()호출하기
		Demo dm=new Demo();
		dm.foo();
	}

}
