package Recipe_Management;

/**
 * @author 유재원
 * 메뉴를 입력할 때 정수가 아닌 예외 처리 클래스
 * */

public class NotIntegerException extends Exception {
	/**기본생성자: 오류 메시지로 NotIntegerException를 출력*/
	public NotIntegerException() {
		super("NotIntegerException");
	}
	/**문자열을 생정자 인자로 전달받아 해당 문자열을 에러 메시지로 출력*/
	public NotIntegerException(String msg) {
		super(msg);
	}
	
}