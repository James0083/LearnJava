package day08;
/*사용자 정의 예외 만들기
 * [1] Exception을 상속받는다
 * [2] 생성자를 구성하고 super("예외메시지");를 호출한다
 * */
public class NotSupportedNameException extends Exception{
	
	public NotSupportedNameException() {
		super("NotSupportedNameException");
	}
	public NotSupportedNameException(String msg) {
		super(msg);
	}
}
