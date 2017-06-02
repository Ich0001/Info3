package model.gui;

import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.CommandType;
import model.ControlModel;

public class BefehleView extends JPanel {
	String[] liste = {"eins", "zwei", "drei"};
	private JList<CommandType> list;
	private BefehleViewFooter footer = new BefehleViewFooter();
	
	/**
	 * Create the panel.
	 */
	public BefehleView(ControlModel cM) {
		setLayout(new BorderLayout());
		list = new JList<CommandType>(cM.getCommandTypes());
//		add(list, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
		JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, BorderLayout.CENTER);

	}

}
