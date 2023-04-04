package day10;
import java.util.*;
/* - 순차적으로 데이터를 저장	: ArrayList를 사용하는 것이 좋고
 * - 중간에 삽입하거나 삭제	: LinkedList를 사용하는 것이 좋다
 */

public class LinkedListTest {

	public static void main(String[] args) {
		//FIFO구조: First In First Out
		LinkedList<String> list1=new LinkedList<>();
		list1.add("Hi");
		list1.add("Allo");
		list1.add("Bye");
		System.out.println(list1.size()+"개 저장함");
		list1.offer("JSP"); //add()와 동일
		list1.offer("Servlet");
		System.out.println(list1.size()+"개 저장함");
		list1.addFirst("Hello");
		list1.addLast("Spring");
		
		//데이터 꺼내기
		String str=list1.get(0);
		System.out.println(str);
		System.out.println(list1.get(list1.size()-1));
		//데이터 삭제: poll() => 첫번째 요소를 삭제하고 삭제한 요소를 반환한다
		String val=list1.poll();
		System.out.println(val+"을 삭제함");
		System.out.println(list1);
		
		list1.pop(); //poll()과 동일
		System.out.println(list1);
		//removeFirst(), removeLast(), pollFirst(), pollLast()
		
		list1.add(3, "Java"); //중간에 삽입. index 3인 곳에 "Java"를 삽입
		System.out.println(list1);
		list1.remove(4);
		System.out.println(list1);
	}

}
