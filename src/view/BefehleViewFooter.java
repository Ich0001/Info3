package view;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BefehleViewFooter extends JPanel {
	private JButton button1 = new JButton("Button1");

	public BefehleViewFooter() {
		setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		add(button1);
	}
}