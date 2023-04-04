package day06;

class Person{
	int no;
	String name;
	
	public Person(String name, int no) {//인자 생성자
		this.name=name;
		this.no=no;
	}
}///////////////
class Student extends Person{
	String className;
	// 자식클래스의 생성자에서는 묵시적으로 super()를 호출한다
	// 즉 부모의 디폴트 생성자를 호출한다.
	public Student() {
		//super(); //[X]
		super("홍길동", 1);
		//super() 생성자 안에서만 호출할 수 있으며, 첫번째 줄에 위치해야 함
		//부모에 기본생성자가 없을 경우에는 부모 클래스가 가지고 있는 인자생성자를 명시적으로 호출하면 해결됨
		this.className="1반";
	}
}///////////////
class Teacher extends Person{
	String subject;
	public Teacher(String name, int no, String subject) {
		//super(); //[X]
		super(name, no);
		this.subject=subject;
	}
}///////////////

public class Inheritance2 {

	public static void main(String[] args) {
		Person p=new Teacher("김교사", 100, "수학");
		Person p2=new Student();
		Person p3=new Person("김철수",1);
	}

}
