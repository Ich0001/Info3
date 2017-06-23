package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProgrammAblaufView extends JPanel {
	private ProgrammAblaufViewFooter footer;
	private OurJTable table;

	public ProgrammAblaufView(OurJTable table) {
		setLayout(new BorderLayout());
		footer = new ProgrammAblaufViewFooter();
		this.table = table;

		add(footer, BorderLayout.SOUTH);
		JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, BorderLayout.CENTER);
	}
}