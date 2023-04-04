package day06;
import javax.swing.*;
import java.awt.*;


public class MyLayout extends JFrame{

	Container cp;
	JPanel p=new JPanel();		//꽉찬 패널
	JPanel p1_1=new JPanel();	//노란 패널
	JPanel p1_2=new JPanel();	//핑크 패널
	JButton []b = new JButton[6];
	public MyLayout() {
		super("::MyLayout::");
		cp=this.getContentPane();
		cp.add(p);
		p.setLayout(new BorderLayout());
		p.add(p1_1, BorderLayout.CENTER);
		p.add(p1_2, BorderLayout.SOUTH);
		//p.add(p1_2, "South");

		
		p1_1.setBackground(Color.yellow);
		p1_2.setBackground(Color.pink);
		
		p1_1.setLayout(new GridLayout(2,2,10,10));
		p1_2.setLayout(new GridLayout(2,1,10,10));
		
		for(int i=0;i<b.length;i++) {
			b[i] = new JButton("B"+(i+1));
			if(i<4) {
				p1_1.add(b[i]);
			}
			else { //i>=4
				p1_2.add(b[i]);
			}
			
		}
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MyLayout my=new MyLayout();
		my.setSize(500,500);
		my.setVisible(true);

	}

}
