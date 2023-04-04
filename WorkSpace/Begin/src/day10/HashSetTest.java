package day10;
/* Set 계열
 * - HashSet, TreeSet
 * - 순서를 기억하지 않음 (무순서)
 * - 데이터 중복을 허용하지 않음
 * - 해시셋은 객체를 저장하기 전에 객체의 hashCode()를 호출해서
 *   해시코드를 얻어낸다. 그리고 이미 저장되어 있는 객체들의 해시코드와
 *   비교한다. 만약 동일한 해시코드가 있다면 다시 equals()메소드로
 *   두 객체를 비교해서 true가 나오면 동일한 객체로 판단하고
 *   중복 저장을 하지 않는다.
 */
import java.util.*;
public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> set=new HashSet<>();
		//add() : 데이터 저장
		set.add("HTML");
		set.add("CSS");
		set.add("JavaScript");
		set.add("Java");
		System.out.println("set.size() 1: "+set.size());
		set.add("CSS"); //중복저장 불가
		System.out.println("set.size() 2: "+set.size());

		//Iterator<E>	iterator()
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("-------------------------");
		
		for(String str:set) {
			System.out.println(str.toLowerCase());
		}
	}

}
