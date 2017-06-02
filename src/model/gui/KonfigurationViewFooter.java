package model.gui;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class KonfigurationViewFooter extends JPanel {
	private JButton buttonSave = new JButton("Save");
	
	public KonfigurationViewFooter() {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(buttonSave);	
	}
}
