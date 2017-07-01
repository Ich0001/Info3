package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.CommandList;
import model.ControlModel;

public class ProgrammAblaufView extends JPanel {
	private JPanel footer;
	private OurJTable table;
	private JButton buttonRemove = new JButton("Remove");
	private JButton buttonUp = new JButton("Up");
	private JButton buttonDown = new JButton("Down");
	private JButton buttonStart = new JButton("Start");
	private JButton buttonStop = new JButton("Stop");
	private ControlModel cM;
	private CommandList cL = ControlModel.getInstance().getControlProcess();
	private KonfigurationView konfiguration;

	public ProgrammAblaufView(OurJTable table) {
		this.table = table;
		cM = ControlModel.getInstance();

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

		// ButtonRemove
		buttonRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControlDeveloperView.getInstance().getKonfigurationsFenster()
						.setKonfigurationIdle();

				int index = table.getSelectedRow();
				if (index >= 0) {
					cL.remove(table.getSelectedRow());
					table.getTableModel().removeRow(table.getSelectedRow());
					System.out.println("gelöscht");
					ControlDeveloperView.getInstance().println(
							">>Zeile " + (index + 1) + " geloescht");
				} else {
					System.out.println("kein Element ausgewaehlt");
					ControlDeveloperView.getInstance().println(
							">>Kein Element ausgewaehlt!");

					table.getTableModel().fireTableDataChanged();
				}
			}
		});

		// ButtonUp
		buttonUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();

				if (index > 0) {
					cL.moveUp(table.getSelectedRow());
					table.getTableModel().moveRow(table.getSelectedRow(),
							table.getSelectedRow(), table.getSelectedRow() - 1);
					System.out.println("Nach Oben verschoben");
					ControlDeveloperView.getInstance().println(
							">>Zeile " + (index + 1) + " mit Zeile " + (index)
									+ " getauscht");
				} else if (index == 0) {
					System.out
							.println("Kann nicht nach Oben verschoben werden!!!");
					ControlDeveloperView.getInstance().println(
							">>Zeile " + (index + 1)
									+ " Kann nicht getauscht werden!");
				}

				else {
					System.out.println("kein Element ausgewaehlt");
					ControlDeveloperView.getInstance().println(
							">>Kein Element ausgewaehlt!");
				}
			}
		});

		// ButtonDown
		buttonDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();

				if (index >= 0
						&& index != (cM.getControlProcess().getNrContent() - 1)) {
					cL.moveDown(table.getSelectedRow());
					table.getTableModel().moveRow(table.getSelectedRow(),
							table.getSelectedRow(), table.getSelectedRow() + 1);
					System.out.println("Nach Unten verschoben");
					System.out
							.println(cM.getControlProcess().getNrContent() - 1);
					System.out.println(index);
					ControlDeveloperView.getInstance().println(
							">>Zeile " + (index + 1) + " mit Zeile "
									+ (index + 2) + " getauscht");
				} else if (index != -1
						&& index == (cM.getControlProcess().getNrContent() - 1)) {

					System.out
							.println("Kann nicht nach unten verschoben werden!!!");
					ControlDeveloperView.getInstance().println(
							">>Zeile " + (index + 1)
									+ " Kann nicht getauscht werden!");
				} else {
					System.out.println("kein Element ausgewaehlt");
					ControlDeveloperView.getInstance().println(
							">>Kein Element ausgewaehlt!");
				}
			}
		});

		// Footer
		footer.add(buttonPanel, BorderLayout.EAST);
		add(footer, BorderLayout.SOUTH);
		JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, BorderLayout.CENTER);
	}
}