package day08;

import javax.swing.JOptionPane;

public class PongApp {
	
	public static void login(String name) 
	throws NotSupportedNameException
	{
		//퐁씨 성이면 "환영합니다 XXX님" 콘솔에 출력
		// boolean startsWith(String str) / boolean endsWith(String str)
		if(name.startsWith("퐁")) {
			System.out.println(name+"님 환영합니다~~");
			
		}else if(name.startsWith("콩")) {
			//콩씨 성이면 "콩씨는 절대로 로그인 불가!!" 콘솔에 출력 => 예외상황
			throw new NotSupportedNameException("콩씨는 절대로 로그인 불가!!");
		}else {
			//기타 성이면 "기타 성씨 분들은 이용에 제한이 있어요"를 출력 => 예외상황
			throw new NotSupportedNameException("기타 성씨 분들은 이용에 제한이 있어요");
		}
	}//----------------

	public static void main(String[] args) {
		String name=JOptionPane.showInputDialog("로그인 이름을 입력하세요");
		if(name==null) return;
		try {
		PongApp.login(name);
		} catch (NotSupportedNameException e) {
			//public String getMessage();
			String msg=e.getMessage();
			System.out.println(msg);
			
//			e.printStackTrace();
			//스택 기록을 출력해서 보여준다 (예외가 발생한 지점 추적 가능) - debug할 때 사용
		}
	}//---------------
}//////////////////////////
