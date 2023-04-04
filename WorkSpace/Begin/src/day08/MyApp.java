package day08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //[1]
//CardLayout
public class MyApp extends JFrame implements ActionListener{ //[2]

	Container cp;
//	JPanel p = new JPanel(); //1번 카드
	MyLoginPage p = new MyLoginPage(); //1번 카드
	JPanel p2 = new JPanel(); //2번 카드
	CardLayout card;

	public MyApp() {
		super("::MyApp::");
		cp = this.getContentPane(); //기본 BorderLayout ==> CardLayout으로 변경
		card = new CardLayout();
		cp.setLayout(card);
		
		//cp.add(p, "Center");
		cp.add(p,"login"); //yellow
		cp.add(p2,"home"); //pink
		
//		card.show(cp,"home");
		
		p.btLogin.addActionListener(this); //[4]
		
		p.setBackground(Color.yellow);
		p2.setBackground(Color.pink);
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){ //[3]
		Object obj = e.getSource();
		if(obj==p.btLogin) {
			String name=p.tfName.getText();
			if(name==null) return;
			try {
				login(name);
			}catch (NotSupportedNameException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage()); //프레임 중앙에 띄움
			}
		}
	}
	
	public void login(String name) throws NotSupportedNameException {
		if(name.startsWith("퐁")) {
			card.show(cp, "home");
			
		}else if(name.startsWith("콩")) {
			reset();
			throw new NotSupportedNameException();
		}else {
			card.show(cp, "home");
			throw new NotSupportedNameException();
		}
	}
	public void reset() {
		p.tfName.setText("");
		p.tfPwd.setText("");
		p.tfName.requestFocus(); //입력 포커스 주기
		
	}

	public static void main(String[] args) {
		MyApp my = new MyApp();
		my.setSize(400, 700);
		my.setLocation(400, 200);
		
		my.setVisible(true);

	}

}
