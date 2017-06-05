package model.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.ControlModel;

public class KonfigurationView extends JPanel {
	private ControlModel cM;
	private JLabel label1 = new JLabel("Speed:");
	private JLabel label2 = new JLabel("Duration:");
	private JTextField textField1 = new JTextField(8);
	private JTextField textField2 = new JTextField(8);

	public KonfigurationView(ControlModel cM) {
		this.cM = cM;
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.insets = new Insets(5, 5, 5, 5);

		c.gridy = 0; // Zeile 0
		c.gridx = 0; // Spalte 0
		c.gridwidth = 1;
		c.gridheight = 1; // Zelle 1x1
		c.weightx = 0.3; // 30% der Breite
		add(label1, c);

		c.gridx = 1; // Spalte 1
		c.weightx = 0.7; // 70% der Breite
		add(textField1, c);

		c.gridy = 1; // Zeile 1
		c.gridx = 0; // Spalte 0
		c.weightx = 0.1; // 30% der Breite
		add(label2, c);

		c.gridx = 1; // Spalte 1;
		c.weightx = 0.9; // 70% der Breite
		add(textField2, c);
	}
	
	public String getText1(){
		return (textField1.getText() != null)?textField1.getText():null;
	}
	public String getText2(){
		return (textField2.getText() != null)?textField2.getText():null;
	}
	public void resetText1(){
		textField1.setText("");
	}
	public void resetText2(){
		textField2.setText("");
	}
}
