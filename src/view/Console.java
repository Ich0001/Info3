package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Console extends JPanel {
	private JTextArea textArea;
	private JScrollPane scrolltxt;

	public Console() {
		setLayout(new BorderLayout());
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrolltxt = new JScrollPane(textArea,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrolltxt.setPreferredSize(new Dimension(40, 100));

		add(scrolltxt, BorderLayout.CENTER);
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void scrollToBottom() {
		JScrollBar scrollBar = scrolltxt.getVerticalScrollBar();
		scrollBar.setValue(scrollBar.getMaximum());
	}
}
