package day06;
import javax.swing.*;
import java.awt.*;
/*
 * 컨테이너
 *  Frame계열 - 디폴트 레이아웃 (BorderLayout) 
 *  Panel계열 - 디폴트 레이아웃 (FlowLayout)
 *  
 *  LayoutManager
 *    - BorderLayout
 *    - FlowLayout
 *    - GridLayout
 *    - CardLayout
 * 
 * */

public class MyDemo extends JFrame{

	Container cp;
	JPanel p;
	
	JButton b1, b2, b3, b4;
	
	public MyDemo() {
		super("::MyDemo::"); //JFrame("문자열") - 창 이름 설정
		cp=this.getContentPane(); //컨텐트 페인 => BorderLayout
		p=new JPanel(); // 컨테이너 => FlowLayout(중앙 정렬)
		cp.add(p);
		p.setBackground(Color.white);
		//JPanel의 레이아웃 설정
		//FlowLayout(int align);
		//FlowLayout(int align, int hgap, int vgap);
		FlowLayout f1=new FlowLayout(FlowLayout.RIGHT, 20, 50);
						//컴포넌트 사이 수평간격:20, 수직간격:50
		p.setLayout(f1);
		//컴포넌트를 붙이기 전에 레이아웃을 설정해야 함
		
		
		
		
		b1=new JButton("b1");
		b2=new JButton("b2");
		b3=new JButton("b3");
		b4=new JButton("b4");
		
		p.add(b1); p.add(b2);
		p.add(b3); p.add(b4);
		
		//창닫기 처리
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MyDemo my=new MyDemo();
		my.setSize(500,500);
		my.setVisible(true);
	}

}
