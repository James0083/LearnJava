package Recipe_Management;

import java.awt.*;
import javax.swing.*;

public class SearchPage extends JPanel{

	JPanel pN = new JPanel(), pC = new JPanel();
	JLabel lbSearch;
	JTextField tfSearch;
	JButton btSearch;
	JTextArea taSearch = new JTextArea();
	
	public SearchPage() {
		setLayout(new BorderLayout());
		add(pN, "North");
		add(taSearch, "Center");
		pN.add(lbSearch = new JLabel("검색어 입력 : "));
		pN.add(tfSearch = new JTextField(15));
		pN.add(btSearch = new JButton("검색"));
		
		taSearch.setEditable(false);
		taSearch.setText("---===---\n\n===---===");
		
	}
}
