package model.gui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KonfigurationView extends JPanel {
	private JLabel label1 = new JLabel("Speed");
	private JLabel label2 = new JLabel("Duration");
	private JTextField textField1 = new JTextField("eins");
	private JTextField textField2 = new JTextField("zwei");

//	public KonfigurationView() {
//		setLayout(new FlowLayout(FlowLayout.CENTER,5, 5));
//		add(label1);
//		add(textField1);
//		add(label2);
//		add(textField2);
//	}
	
	//GridBag-Layout funktioniert noch nicht so wirklich.
	public KonfigurationView() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.gridx=1;
		c.gridy=2;
		c.gridwidth=2;
		c.gridheight=1;
		add(label1,c);
		c.gridx=3;
		c.gridwidth=5;
		add(textField1,c);
		c.gridx=1;
		c.gridy=3;
		c.gridwidth=2;
		add(label2);
		c.gridx=3;
		c.gridwidth=5;
		add(textField2,c);
	}
	
}
