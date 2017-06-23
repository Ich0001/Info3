package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ProgrammAblaufViewFooter extends JPanel {
	private JButton buttonRemove = new JButton("Remove");
	private JButton buttonUp = new JButton("Up");
	private JButton buttonDown = new JButton("Down");
	private JButton buttonStart = new JButton("Start");
	private JButton buttonStop = new JButton("Stop");

	public ProgrammAblaufViewFooter() {
		setLayout(new BorderLayout());

		JPanel removePanel = new JPanel();
		removePanel.add(buttonRemove);
		add(removePanel, BorderLayout.WEST);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(buttonUp);
		buttonPanel.add(buttonDown);
		buttonPanel.add(buttonStop);
		buttonPanel.add(buttonStart);
		add(buttonPanel, BorderLayout.EAST);

	}
}
