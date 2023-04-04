package day09;
//도메인 객체 (VO객체=Value Object, DTO객체=Data Transfer Object)
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
	
	
}
