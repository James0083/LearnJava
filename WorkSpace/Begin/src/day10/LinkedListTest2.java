package day10;

/* ArrayList는 순차적으로 데이터를 저장할 때 적합
 * LinkedList는 데이터를 저장후 수시로 객체를 삽입,수정해야 할 경우
 *            적합함
 *  LinkedList는 인접 참조를 링크해서 체인처럼 관리한다.
 *****************************************************
 *  순차적으로 추가/삭제		|	중간에 추가/삭제	|  검색	
 *  ArrayList : 빠르다.	|	느리다.			|  빠르다
 *  LinkedList: 느리다.	|   빠르다.			|   느리다.
  *****************************************************
 * */
import java.util.*;

public class LinkedListTest2 {
	public static void main(String[] args) {
		List<String> lst1=new ArrayList<>();
		List<String> lst2=new LinkedList<>();
		//데이터 1만건을 저장한 후 수행시간을 측정해보자
		long startTime=System.nanoTime();
		for(int i=0;i<10000;i++) {
			//lst1.add("Hello"); //순차적으로 ArrayList에 저장
			lst1.add(0,"Hello"); //중간에 데이터를 삽입할 경우
			
		}
		long endTime=System.nanoTime();
		
		long gapTime = endTime-startTime;
		System.out.println("ArrayList에 걸린 시간: "+gapTime+"ns");
		System.out.println("1st1.size(): "+lst1.size());
		System.out.println("****************************************");
		
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++) {
			//lst2.add("Hello"); //순차적으로 LinkedList에 저장
			lst2.add(0,"Hello"); //중간에 데이터를 삽입할 경우
		}
		endTime=System.nanoTime();
		
		gapTime = endTime-startTime;
		System.out.println("LinkedList에 걸린 시간: "+gapTime+"ns");
		System.out.println("1st2.size(): "+lst2.size());
	}
}
