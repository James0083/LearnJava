package day07;

import javax.swing.JOptionPane;

public class AnimalTest {
	public static void main(String[] args) {
		String type = JOptionPane.showInputDialog("동물 종류 입력");
		String cnt = JOptionPane.showInputDialog("새끼 수 입력");
		if(type==null||cnt==null) return;

		Animal a;
		switch(type) {
		case "강아지": case "개":
			a=new Dog();
			break;
		case "고양이":
			a=new Cat();
			break;
		case "오리":
			a=new Duck();
			break;
		default:
			System.out.println("그런 동물 안키워요~~");
			return;
		}
		a.crySound();
		a.getBaby(Integer.parseInt(cnt));
		
		//////////
		//강사
		int cnt_int=Integer.parseInt(cnt);
		Animal an=null;
//		Animal a=new Animal(); //[X] //추상클래스는 타입 선언은 가능하나 new해서 객체생성은 할 수 없다
//		if(type=="강아지") {
		if(type.equals("강아지")) {
//			Dog d=new Dog();
			an=new Dog();
//			d.crySound();
//			d.getBaby(cnt_int);
		}else if(type.equals("고양이")) {
			an=new Cat();
		}else if(type.equals("오리")) {
			an=new Duck();
		}
		else {
			System.out.println("그런 동물 안키워!!");
			return;
		}
		an.crySound();
		an.getBaby(cnt_int);
	}
}
