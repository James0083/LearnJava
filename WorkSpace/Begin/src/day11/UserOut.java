package day11;
//1~5만원 사이 금맥을 랜덤하게 인출하는 스레드
import java.util.Random;
public class UserOut extends Thread{
	
	private Account account;
	public UserOut(Account ac, String name) {
		this.account=ac;
		setName(name);
	}//---------------
	
	@Override
	public void run() {
		Random ran=new Random();
		for(int i=0;i<5;i++) {
			//int n=(int)(Math.random()*범위+시작수)
			//int val=ran.nextInt(범위)+시작수
			int val=ran.nextInt(5)+1;
			account.get(val);
		}
	}//-----------------
	
}