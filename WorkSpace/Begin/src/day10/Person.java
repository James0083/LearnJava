package day10;
//도메인 객체 (VO객체=Value Object, DTO객체=Data Transfer Object)

/*- 해시셋은 객체를 저장하기 전에  객체의 hashCode() 를 호출해서
 *   해시코드를 얻어낸다. 그리고 이미 저장되어 있는 객체들의 해시코드와
 *   비교한다. 만약 동일한 해시코드가 있다면 다시 equals()메소드로
 *   두 객체를 비교해서 true가 나오면 동일한 객체로 판단하고
 *   중복 저장을 하지 않는다.
 * */
public class Person {
	private String name;
	private int age;
	
	public Person() {
		this("아무개", 1);
	}
	public Person(String n, int a) {
		name = n;
		age = a;
	}
	
	//setter, getter----
	public void setName(String name) {
		this.name = name;		
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	/* 이름과 나이가 같으면 HashSet에 중복저장되지 않게 하기 위해
	 * hashCode()와 equals()를 재정의한다.
	 */
	
	//hashCode: 16진수
	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person user=(Person)obj;
			boolean bool=this.name.equals(user.name) && (this.age==user.age);
			return bool;
		}else {
			return false;
		}
	}
	
}///////////////
