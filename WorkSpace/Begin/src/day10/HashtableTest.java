package day10;
/* Map계열
 *  - Hashtable, HashMap
 *  - key값과 value값을 매핑하여 저장한다
 *  - key값의 중복을 허용하지 않는다
 *  - 무순서 (-> key나 value값을 받아올 때도 순서 규칙이 없다)
 *  - 데이터가 75%차면 자동으로 저장 영역을 확대한다
 *  - 데이터 저장: Object put(Object key, Object value)
 * 					  put(K key, V value)
 *  - 데이터 꺼내기: Object get(Object key) : key값에 매핑된 value값을 반환함
 */
import java.util.*;
public class HashtableTest {

	public static void main(String[] args) {
		//jdk1.4버전
		Hashtable h=new Hashtable(20,0.8f); //초기용량:20, 적재율(load factor):0.8
		//데이터의 저장 용량의 80%가 차면 자동으로 저장영역을 확대한다
		h.put("하나", Integer.valueOf(1));
		h.put("둘", "Two");
		h.put("빨강", "Red");
		h.put("파랑", java.awt.Color.blue);
		//h.put("하나", "One"); //[X]  key값의 중복을 허용하지 않음. 덮어쓰기 함
		
		Object obj = h.get("하나");
		Integer ival=(Integer)obj;
		System.out.print("ival="+ival);
		
		String str=(String)h.get("빨강");
		System.out.println(str);
		
//		String str=(String)h.get("빨강"); //ClassCastException 발생
		java.awt.Color str2 = (java.awt.Color)h.get("파랑");
		System.out.println(str2);
		
		
		//jdk 5.0버전 이후 -Generic 사용 <key값 유형, Value유형>
		Hashtable<String, Integer> h2 = new Hashtable<>();
		
		h2.put("생년", Integer.valueOf(2003));
		h2.put("나이", 20);
		h2.put("용돈", 100000);
		
		Integer year=h2.get("생년");
		System.out.println("생년: "+year+"년");
		System.out.println("h2.size(): "+h2.size());

		
		//Enumeration<K>	keys()
		//Set<K>	keySet()
		// [1] h2에 저장된 key값들만 출력하세요
		Enumeration<String> en = h2.keys(); //키값들만 Enumeration
		while (en.hasMoreElements()) {
			String key = en.nextElement();
			System.out.println(key+": "+h2.get(key));
		}
		
		System.out.println("-------------------------");
		
		//Enumeration<V>	elements()
		//Collection<V>	values()
		// [2] h2에 저장된 value값들만 출력하세요
		Enumeration<Integer> en2=h2.elements();
		while (en2.hasMoreElements()) {
			Integer value = en2.nextElement();
			System.out.println(value);
		}
		
		System.out.println("--------keySet()------------");
		//Set<K>	keySet()
		Set<String> kset=h2.keySet();
		Iterator<String> it=kset.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println(key);
		}
		
		System.out.println("--------values()------------");
		//Collection<V>	values()
		Collection<Integer> col=h2.values();
		Iterator<Integer> it2=col.iterator();
		for(;it2.hasNext();) {
			Integer val=it2.next();
			System.out.println(val);
		}
		
		//boolean	replace(K key, V oldValue, V newValue)
		h2.replace("용돈", 100000, 300000);
		
		System.out.println(h2.get("용돈"));
		
		//
		h2.remove("나이");
		System.out.println("----remove()이후-------");
		for(String key:h2.keySet()) {
			System.out.println(key+"=>"+h2.get(key));
		}
		//boolean containsKey(K)
		//boolean containsValue(V)
		System.out.println(h2.containsKey("나이"));
		System.out.println(h2.containsKey("용돈"));
		
		System.out.println(h2.containsValue(100000));
		System.out.println(h2.containsValue(300000));
		
		
		h2.clear(); //모두 삭제
		System.out.println("h2.size(): "+h2.size());
		
		
		
	}

}
