package day07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyEngine extends JFrame implements ActionListener{

	Container cp;
	JPanel p = new MyJPanel();
	JButton[] btn = new JButton[4]; 
	String[] str = {"Naver", "Google", "Daum", "Yahoo"};
	Color origin;
	public MyEngine() {
		super("::MyEngine::");
		cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		p.setLayout(new GridLayout(2,2,10,10));
		
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton(str[i]);
			p.add(btn[i]);
			btn[i].addActionListener(this);
		}
		
		origin=btn[0].getBackground();
//		System.out.println(origin);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//-----------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String cmd=e.getActionCommand(); //이벤트소스의 문자열 반환
		this.setTitle(cmd+"버튼을 눌렀네요!!");
		Color bg = ((JButton)obj).getBackground();
		
		int n = -1;
		if(obj==btn[0]) {
			n=0;
			if(bg==Color.green) bg=null;
			else bg = Color.green;
		}
		else if(obj==btn[1]) {
			n=1;
			if(bg==Color.orange) bg=null;
			else bg=Color.orange;
		}
		else if(obj==btn[2]) {
			n=2;
			if(bg==Color.magenta) bg=null;
			else bg=Color.magenta;
		}
		else if(obj==btn[3]) {
			n=3;
			if(bg==Color.cyan) bg=null;
			else bg=Color.cyan;
		}
		btn[n].setBackground(bg);
		btn[n].setOpaque(true);
		btn[n].setBorderPainted(false);
		
		/*
		if(bg==origin) {
			if(obj==btn[0]) {
				btn[0].setBackground(Color.green);
			}
			else if(obj==btn[1]) {
				btn[1].setBackground(Color.orange);
			}
			else if(obj==btn[2]) {
				btn[2].setBackground(Color.magenta);
			}
			else if(obj==btn[3]) {
				btn[3].setBackground(Color.cyan);
			}
		}
		else {
			((JButton)obj).setBackground(origin);
		}
		*/
	}

	public static void main(String[] args) {
		MyEngine my = new MyEngine();
		my.setSize(500, 500);
		my.setVisible(true);

	}

}
