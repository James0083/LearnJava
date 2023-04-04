package day06;
import javax.swing.*;
import java.awt.*;
/*
 * 컨테이너
 *  Frame계열 - 디폴트 레이아웃 (BorderLayout) 
 *  Panel계열 - 디폴트 레이아웃 (FlowLayout)
 *  
 *  LayoutManager
 *    - BorderLayout : 동,서,남,북,중앙의 영역을 지정해서 컴포넌트를 붙여 배치한다
 *    					영역을 지정하지 않으면 중앙에 붙는다
 *    - FlowLayout	 : 
 *    - GridLayout	 : 
 *    - CardLayout	 : 
 * 
 * */

public class MyBorderDemo extends JFrame{

	Container cp;
	JPanel p;
	
	JButton b1, b2, b3, b4, b5;
	
	public MyBorderDemo() {
		super("::MyBorderDemo::"); //JFrame("문자열") - 창 이름 설정
		cp=this.getContentPane(); //컨텐트 페인 => BorderLayout
		p=new JPanel(); // 컨테이너 => FlowLayout(중앙 정렬)
		cp.add(p);
		p.setBackground(Color.white);

		BorderLayout b=new BorderLayout(10,10); //hgap, vgap
		p.setLayout(b);
		
		
		b1=new JButton("b1");
		b2=new JButton("b2");
		b3=new JButton("b3");
		b4=new JButton("b4");
		b5=new JButton("b5");
		
		p.add(b1, BorderLayout.NORTH); 
		p.add(b2, BorderLayout.SOUTH);
		p.add(b3, BorderLayout.EAST); 
		p.add(b4, "West");
		p.add(b5, "Center");
		
		
		//창닫기 처리
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MyBorderDemo my=new MyBorderDemo();
		my.setSize(500,500);
		my.setVisible(true);
	}

}
