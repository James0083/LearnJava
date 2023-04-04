package day08;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class MyLoginPage extends JPanel{
	
	JTextField tfName;
	JPasswordField tfPwd;
	JButton btLogin;
	//x,y좌표 지정해서 붙이려면 기본 레이아웃을 해제해야 한다
	//대신 컴포넌트들의 사이즈와 x,y좌표를 일일히 수동으로 지정해야함
	//setBounds(x,y,w,h)
	public MyLoginPage() {
		this.setLayout(null); //레이아웃 해제
		
		tfName = new JTextField(20);
		tfPwd = new JPasswordField(20);
		btLogin = new JButton("Login");
		
		tfName.setBounds(90,  170,  200, 50); //x, y, width, height
		tfPwd.setBounds(90, 240, 200, 50);
		btLogin.setBounds(90, 310, 200, 50);
		btLogin.setBackground(new Color(110,200,110)); //r,g,b
		btLogin.setForeground(Color.white);
		
		btLogin.setOpaque(true); 		//(Mac) 배경색 주
		btLogin.setBorderPainted(false);
		
		tfName.setBorder(new TitledBorder("Name"));
		tfPwd.setBorder(new TitledBorder("Password"));
		
		add(tfName);
		add(tfPwd);
		add(btLogin);
	}
	
}
