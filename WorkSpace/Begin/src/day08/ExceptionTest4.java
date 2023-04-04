package day08;
/*
 * try블럭 하나에 catch블럭을 여러 개 사용할 수 있다.
 * 이 때 주의사항. 자식 예외를 먼저 catch하고
 * 부모 예외를 나중에 catch해야 한다.
 * 
 * try{
 * 
 * }catch(  ){
 * 
 * }finally{
 * 		//반드시 한번은 수행하는 코드
 * 		//위에 return문이 오더라도 finally블럭을 실행한 뒤 return 된다
 * 
 * */
public class ExceptionTest4 {

	public static void main(String[] args) {
		try {
		//[1] ArrayIndesOutOfBoundsException
		//명령줄 인수 2개를 받아 나눗셈 수행
		String str1=args[0]; 
		String str2=args[1];
		System.out.println("args[0]: "+str1);
		System.out.println("args[1]: "+str2);
		
		//정수로 변환
		int num1=Integer.parseInt(str1); //[2] NumberFormatException
		int num2=Integer.parseInt(str2);
		System.out.printf("%d/%d=%d%n", num1,num2,num1/num2);
		//[3] ArithmeticException
		
		String str3="null";
		System.out.println(str3.toUpperCase());
		//[4] NullPointException
		
		
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("명령줄 인수 2개를 입력하세요");
			System.out.println("java day08.ExceptionTest4 10 5");
		}catch (NumberFormatException e) {
			System.out.println("숫자를 입력해야 해요!!");	
			return;
		}catch (ArithmeticException e) {
			System.out.println("분모가 0이 되어선 안돼요!!");
			System.exit(-1); //시스템 종료 ==> 종료시에는 finally{}은 수행되지 않는다.
		}catch (Exception e) {
			System.out.println("기타 예상치 못한 예외 발생함 : "+e);
		}finally {
			System.out.println("###반드시 실행되어야 할 코드 ###");
		}
		
		
		System.out.println("The End ~~~~~~~~~~~~~~~~~~~~~");
	}

}
