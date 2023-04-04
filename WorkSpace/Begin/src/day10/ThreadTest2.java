package day10;
/*Thread구현 방법
 * [1] java.lang.Thread 클래스를 상속
 * [2] java.lang.Runnable 인터헤이스를 상속
 */
class SnailThread extends Thread{
	public SnailThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(this.getName()+" 스레드가 기어갑니다");
			
			/*
			try {
			Thread.sleep(1000);	// 밀리초 (1/1000)단위 ==> Block상태가 된다.
			//1초간 sleep
			}catch (InterruptedException e) { //<= 스레드에 interrupt()메서드가 호출될 때 예외가 발생함
				e.printStackTrace();
				break;
			}
			//*/
			
		}//for----------
	}//run()------------
}//////////////////////
public class ThreadTest2 {
	public static void main(String[] args) {
		SnailThread tr1=new SnailThread("똘똘이 달팽이");
		SnailThread tr2=new SnailThread("홀쭉이 달팽이");
		SnailThread tr3=new SnailThread("이쁜이 달팽이");
		//스레드 동작시키려면 run()[x]이 아니라 start()를 호출해야 함
		
		//우선순위: 1(제일낮음) ~ 10(제일높음)
		tr1.setPriority(Thread.MIN_PRIORITY);//1
		tr2.setPriority(Thread.NORM_PRIORITY);//5
		tr3.setPriority(Thread.MAX_PRIORITY);//10
		
		tr1.start();
		tr2.start();
		tr3.start();
		
		//tr2.interrupt();//InterruptedException이 발생됨
		
		try {
			tr2.join();
			//tr2스레드가 작업을 다 마칠때까지 
			//tr2.join()호출한 스레드(여기서는 main스레드)가 block상태가 된다
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Hello World~~");
		
	}

}/////////////////////