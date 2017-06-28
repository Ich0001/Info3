package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.CommandType;
import model.ControlModel;
import controller.ButtonAddController;

public class BefehleView extends JPanel {
	String[] liste = { "eins", "zwei", "drei" };
	private ControlModel cM;
	private JList<CommandType> list;
	private JButton buttonAdd = new JButton("Add");
	private OurJTable table;

	/**
	 * Create the panel.
	 */
	public BefehleView(ControlModel cM, OurJTable table) {
		this.cM = cM;
		this.table = table;
		setLayout(new BorderLayout());

		list = new JList<CommandType>(this.cM.getCommandTypes());
		JScrollPane scrollPane = new JScrollPane(list,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, BorderLayout.CENTER);

		JPanel footer = new JPanel();
		footer.add(buttonAdd);
		footer.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		ButtonAddController buttonAddController = new ButtonAddController(list,
				this.table);
		buttonAdd.addActionListener(buttonAddController);
		add(footer, BorderLayout.SOUTH);

	}
}
