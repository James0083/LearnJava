package day10;
import java.util.*;

public class HashMapTest {
	//회원(아이디(K) == 비밀번호(V) 저장 ===> HashMap
	
	HashMap<String, String> map = new HashMap<>();
	
	public void join() {
		map.put("hong", "123");
		map.put("choi", "abc");
		map.put("admin", "tiger"); //관리자
		System.out.println(">>회원 가입 완료<<");
	}//------------
	/*입력한 값이 map에 저장되어 있는지 체크
	 * 1) 해당 아이디가 map에 저장되어 있는지 검사
	 *    (a) 없다면 => "없는 아이디입니다"
	 *    (b) 있다면 
	 *    		=> 비밀번호 체크
	 *    			=> 비번 일치하면 
	 *    				[1] 일반 유저=> 환영메시지 보여주기
	 *    				[2] 관리자면 => 관리자 모드를 이용할 수 있어요	
	 *             		반복문 벗어나기
	 *              => 비번 불일치라면 =>"비밀번호가 틀려요"
	 *                  반복문 계속 수행
	 * */
	public void loginCheck() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.print("아이디: ");
			String userId = sc.nextLine();
			System.out.print("비밀번호: ");
			String pwd = sc.nextLine();
			//System.out.println(userId+"/"+pwd);
			if(map.containsKey(userId)) {
				if(map.get(userId).equals(pwd)) {
					if(userId.equals("admin")) {
						System.out.println("관리자 모드를 이용할 수 있어요");
						break;
					}else {
						System.out.println("환영합니다"+userId+"님");
						break;
					}
				}else {
					System.out.println("비밀번호가 틀려요");
				}
			}else {
				System.out.println("없는 아이디입니다");
			}
			
			//----강사-----
			boolean isExist=map.containsKey(userId);
			if(!isExist) {
				System.out.println(userId+"는 없는 아이디입니다");
				continue;
			}
			//아이디가 있는 경우
			String realPwd=map.get(userId);
			if(!realPwd.equals(pwd)) {
				System.out.println("비밀번호가 일치하지 않아요!!");
				continue;
			}
			//아이디와 비번이 일치한 경우
			String msg="";
			if(userId.equals("admin")) {
				msg="관리자 모드를 이용할 수 있습니다~";
			}else {
				msg="환영합니다. "+userId+"님~~";
			}
			System.out.println(msg);
			break;
		}
	}
	
	public static void main(String[] args) {
		//join()
		//loginCheck() 호출하세요
		HashMapTest app = new HashMapTest();
		app.join();
		app.loginCheck();

	}

}
