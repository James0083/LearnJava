package day06;
import javax.swing.*;
import java.awt.*;
//GridLayout : 행과 열의 형태로 배치한다

public class MyGridDemo extends JFrame{

	Container cp;
	JPanel p=new JPanel();
	
	JButton[] b=new JButton[6];

	JPanel p1_1, p1_2;
	JCheckBox c1;
	JButton bt;
	
	public MyGridDemo() {
		super("::MyGridDemo::");
		cp=this.getContentPane();
		cp.add(p);
		p.setLayout(new GridLayout(4,2,10,10)); //행, 열, hgap, vgap
		
		//배열에 버튼 생성해서 저장하기 -for루프 이용해서
		//p에 붙이기
		for(int i=0;i<b.length;i++) {
			b[i] = new JButton("b"+(i+1));
			p.add(b[i]);
		}
		p1_1=new JPanel();
		p1_2=new JPanel();
		//p1_1.setBackground(Color.white);
		//p1_2.setBackground(Color.darkGray);
		
		p1_1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p1_2.setLayout(new FlowLayout(FlowLayout.LEFT));  //Layout설정은 add하기 전에 해야한다.
		
		p.add(p1_1);
		p.add(p1_2);
		
		c1=new JCheckBox("동의합니다", true);
		p1_1.add(c1);
		c1.setBackground(Color.white);
		
		p1_2.add(bt=new JButton("Submit"));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MyGridDemo my=new MyGridDemo();
		my.setSize(500,500);
		my.setVisible(true);
	}

}
