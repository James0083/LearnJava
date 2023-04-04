package day04;
/*
 * [1] 구직자 클래스 구성해보기
 * 		- 속성 : 3개 이상
 * 		- 메서드 : 2개 이상
 */
public class JobSeeker {
	int salary;
	int age;
	String name;
	String field;
	public String introduce() {
		String intro = "----자기소개----\n";
		intro+="이  름 : "+name+"\n";
		intro += "나  이 : "+age+"\n";
		intro += "지원 분야 : "+field+"\n";
		intro += "희망 급여 : "+salary+"\n";
		return intro;
	}
	public String projects(String[] proj) {
		String str = "참여한 프로젝트 목록 ...\n";
		if(proj.length==0) return "없음";
		for(String p:proj) {
			str += p+"\n";
		}
//		//강사--
//		for(int i=0;i<proj.length;i++) {
//			str += proj[i]+"\n";
//		}
		return str;
	}
}
