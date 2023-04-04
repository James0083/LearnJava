package day05;

/*학사 관리 프로그램

학생: 학번(no), 이름(name), 학급명(className)		===> Student
강사: 교번(no), 이름(name), 과목(subject)		===> Teacher
직원: 사번(no), 이름(name), 부서(dept)			===> Staff

==> 추상화하고, 속성(멤버변수)을 모두 캡슐화한 뒤
      setter, getter를 구성하세요
      
showInfo()메서드 구성해서 각 정보 출력하기
*/
public class Student {
	private int no;
	private String name;
	private String className;

	public void setNo(int no) {
		//지역변수와 멤버변수의 이름이 같을 경우에는 지역변수가 우선
		//이것을 구분하기 위해 멤버변수 앞에는 "this."를 명시적으로 붙여준다.
		//this.변수 : 자기 객체의 인스턴스 변수를 참고할 때 this를 붙인다.
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getClassName() {
		return className;
	}

	////
	public void showInfo() {
//		String str = "---학생정보---\n";
//		str += "학번 : "+no+"\n";
//		str += "이름 : "+name+"\n";
//		str += "학급명 : "+className+"\n";
//		System.out.println(str);
		
		System.out.println("----학생정보----");
		System.out.printf("학번 : %d%n", getNo());
		System.out.printf("이름 : %s%n", getName());
		System.out.printf("학급명 : %s%n", getClassName());
	}
}
