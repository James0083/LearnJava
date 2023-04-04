package day07;
import javax.swing.*;
import java.awt.*;
//바깥여백을 주려면 public Insets getInsets()메서드를 오버라이드 해야 한다.

public class MyLayout extends JFrame{

	Container cp;
	JPanel p=new JPanel();		//꽉찬 패널
	JPanel p1_1;	//노란 패널
	JPanel p1_2;	//핑크 패널
	JButton []btn = new JButton[6];
	public MyLayout() {
		super("::MyLayout::");
		cp=this.getContentPane();
		
		cp.add(p);
		
		BorderLayout b = new BorderLayout(20,20);
		p.setLayout(b);
		
		p1_1 = new MyJPanel();
		p1_2 = new MyJPanel(25,25,25,25);
		
		p.add(p1_1, BorderLayout.CENTER);
		p.add(p1_2, BorderLayout.SOUTH);
		//p.add(p1_2, "South");

		
		p1_1.setBackground(Color.yellow);
		p1_2.setBackground(Color.pink);
		
		p1_1.setLayout(new GridLayout(2,2,10,10));
		p1_2.setLayout(new GridLayout(2,1,10,10));
		
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton("B"+(i+1));
			if(i<4) {
				p1_1.add(btn[i]);
			}
			else { //i>=4
				p1_2.add(btn[i]);
			}
			
		}
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------------------
	
	

	public static void main(String[] args) {
		MyLayout my=new MyLayout();
		my.setSize(500,500);
		my.setVisible(true);

	}

}
