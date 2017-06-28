package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProgrammAblaufView extends JPanel {
	private JPanel footer;
	private OurJTable table;
	private JButton buttonRemove = new JButton("Remove");
	private JButton buttonUp = new JButton("Up");
	private JButton buttonDown = new JButton("Down");
	private JButton buttonStart = new JButton("Start");
	private JButton buttonStop = new JButton("Stop");

	public ProgrammAblaufView(OurJTable table) {
		this.table = table;
		setLayout(new BorderLayout());
		footer = new JPanel();
		footer.setLayout(new BorderLayout());

		JPanel removePanel = new JPanel();
		removePanel.add(buttonRemove);
		footer.add(removePanel, BorderLayout.WEST);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(buttonUp);
		buttonPanel.add(buttonDown);
		buttonPanel.add(buttonStop);
		buttonPanel.add(buttonStart);
		footer.add(buttonPanel, BorderLayout.EAST);

		add(footer, BorderLayout.SOUTH);
		JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, BorderLayout.CENTER);
	}
}