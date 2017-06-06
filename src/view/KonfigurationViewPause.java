package view;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.ControlModel;

public class KonfigurationViewPause extends KonfigurationView {
	private JLabel label1 = new JLabel("Duration: ");
	private JTextField textField1 = new JTextField(8);

	public KonfigurationViewPause(ControlModel cM) {
		super(cM);
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
	}

	public String getTextDuration() {
		return textField1.getText();
	}

	@Override
	public void clearInput() {
		textField1.setText("");
	}
}
