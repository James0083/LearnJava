package day07;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //[1]
/*이벤트 처리 절차
 * [1] import java.awt.event.*;
 * [2] XXXListener 인터페이스를 상속받는다 (ActionListener)
 * [3] 추상메서드를 오버라이딩한다. (빈블럭으로) => 이벤트 처리 메서드
 * [4] 이벤트소스에 리스너를 붙인다. addXXXListener()메서드 이용
 * 		=> b1.addActionListener(핸들러객체)
 * [5] 오버라이딩한 메서드에 이벤트 처리코드를 구현
 * 
 * JButton => ActionEvent => ActionListener
 * 추상메서드
 * void	actionPerformed(ActionEvent e)
 * */
public class MyGui extends JFrame implements ActionListener{ //[2]

	Container cp;
	JPanel p = new JPanel();
	
	JButton btR, btG, btB;

	public MyGui() {
		super("::MyGui::");
		cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		p.add(btR=new JButton("Red"));
		p.add(btG=new JButton("Green"));
		p.add(btB=new JButton("Blue"));
		//리스너 부착-----
		btR.addActionListener(this); //[4]
		btG.addActionListener(this); 
		btB.addActionListener(this); 
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자 ----------------
	
	public void actionPerformed(ActionEvent e) { //[3]
		//[5] 이벤트 처리 코드
		Object obj=e.getSource();//이벤트가 발생한 이벤트소스의 주소값을 반환한다
		if(obj==btR) {
			p.setBackground(Color.red);
		}else if(obj==btG){
			p.setBackground(Color.green);
		}else if(obj==btB) {
			p.setBackground(Color.blue);
		}
	}

	public static void main(String[] args) {
		MyGui my = new MyGui();
		my.setSize(500, 500);
		my.setVisible(true);

	}

}