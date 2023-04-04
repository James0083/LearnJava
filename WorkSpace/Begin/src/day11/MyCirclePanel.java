package day11;

import javax.swing.JPanel;
import java.awt.*;

public class MyCirclePanel extends JPanel {
	
	int x=50, y=150;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		g.setColor(Color.blue);
//		g.drawRect(50, 50, 100, 100); // x, y, w, h
//		g.fillRect(50, 50, 100, 100);
		
		
		g.setColor(Color.orange);
//		g.drawOval(50, 50, 100, 100);
		g.fillOval(x, y, 100, 100);
//		g.drawImage();
	}
}
