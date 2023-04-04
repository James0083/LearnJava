package day08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //[1]
//CardLayout
public class MyAppTeacher extends JFrame{ //[2]

	Container cp;
//	JPanel p = new JPanel(); //1번 카드
	MyLoginPage p = new MyLoginPage(); //1번 카드
	JPanel p2 = new JPanel(); //2번 카드
	CardLayout card;
	JButton btBack;

	public MyAppTeacher() {
		super("::MyApp_Teacher::");
		cp = this.getContentPane(); //기본 BorderLayout ==> CardLayout으로 변경
		card = new CardLayout();
		cp.setLayout(card);
		
		cp.add(p,"login"); //yellow
		cp.add(p2,"home"); //pink

//		p.btLogin.addActionListener(this); //[4]
		MyHandler handler=new MyHandler();
		p.btLogin.addActionListener(handler);
		
		p.setBackground(Color.yellow);
		p2.setBackground(Color.pink);
		
		p2.setLayout(new BorderLayout());
		btBack=new JButton("뒤로가기(Back)");
		p2.add(btBack, "South");
		btBack.addActionListener(handler);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자-------------------------------
	
	class MyHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			if(obj==p.btLogin) {
				String name = p.tfName.getText();
	//			String pwd=p.tfPwd.getText();
				char[] ch=p.tfPwd.getPassword();
				String pwd=new String(ch);
			
				try {
					login(name, pwd);
				}catch (NotSupportedNameException ex) {
					JOptionPane.showMessageDialog(cp, ex.getMessage()); //프레임 중앙에 띄움
					reset();
				}
			}
			else if(obj==btBack) {
				card.show(cp,"login");
				reset();
			}
		}
	}///////////////////////////

	public void reset() {
		p.tfName.setText("");
		p.tfPwd.setText("");
		p.tfName.requestFocus(); //입력 포커스 주기
		
	}
	
	public void passwdCheck(String name,String pwd)
	throws NotSupportedNameException
	{
		if(pwd.equals("123")) {
			card.show(cp, "home");
			setTitle(name+"님 환영합니다~~");
		}else {
			throw new NotSupportedNameException("비밀번호가 일치하지 않습니다!!");
		}
	}//--------------------------------
			
	
	public void login(String name, String pwd) throws NotSupportedNameException {
		if(name.startsWith("퐁")) {
			passwdCheck(name, pwd);
		}else if(name.startsWith("콩")) {
			throw new NotSupportedNameException("콩씨는 절대로 입장할 수 없어요!!");
		}else {
			passwdCheck(name, pwd);
			card.show(cp, "home");
			throw new NotSupportedNameException("기타 성씨 분들은 이용에 제한이 있어요!");
		}
	}

	public static void main(String[] args) {
		MyAppTeacher my = new MyAppTeacher();
		my.setSize(400, 700);
		my.setLocation(400, 200);
		
		my.setVisible(true);

	}

}
