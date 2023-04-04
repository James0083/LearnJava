package day10;

public class ThreadTest1 {

	public static void main(String[] args) {
		System.out.println("Hello World~~~");
		//현재 실행중인 스레드를 알아보자
		Thread tr=Thread.currentThread();
		System.out.println(tr.getName()+" 스레드가 실행 중 입니다");
		
		int cnt=Thread.activeCount();
		System.out.println("현재 실행 중인 스레드 개수: "+cnt);
		
		Thread.currentThread().setName("Happy Thread");
		System.out.println(Thread.currentThread().getName()+" 스레드로 이름 변경");

	}

}
