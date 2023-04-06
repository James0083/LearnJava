package Recipe_Management;

public class InputMismatchException extends Exception{

	/**기본생성자: 오류 메시지로 InputMismatchException를 출력*/
	public InputMismatchException() {
		super("InputMismatchException");
	}

	/**문자열을 전달받아 해당 문자열을 에러 메시지로 출력*/
	public InputMismatchException(String msg) {
		super(msg);
	}

}
