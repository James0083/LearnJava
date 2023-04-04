package day05;
/*학사 관리 프로그램

학생: 학번(no), 이름(name), 학급명(className)		===> Student
강사: 교번(no), 이름(name), 과목(subject)		===> Teacher
직원: 사번(no), 이름(name), 부서(dept)			===> Staff

==> 추상화하고, 속성(멤버변수)을 모두 캡슐화한 뒤
      setter, getter를 구성하세요
      
showInfo()메서드 구성해서 각 정보 출력하기
*/
public class Teacher {
	private int no;
	private String name;
	private String subject;
	
	public void setNo(int no) {
		this.no=no;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setSubject(String subject) {
		this.subject=subject;
	}
	
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getSubject() {
		return subject;
	}
	
	//////
	public void showInfo() {
		String str = "---교사정보---\n";
		str += "교번 : "+no+"\n";
		str += "이름 : "+name+"\n";
		str += "과목 : "+subject+"\n";
		System.out.println(str);
	}
}
