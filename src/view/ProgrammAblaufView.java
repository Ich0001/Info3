package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.CommandList;
import model.ControlModel;

@SuppressWarnings("serial")
public class ProgrammAblaufView extends JPanel {
	private JPanel footer;
	private JButton buttonRemove = new JButton("Remove");
	private JButton buttonUp = new JButton("Up");
	private JButton buttonDown = new JButton("Down");
	private JButton buttonStart = new JButton("Start");
	private JButton buttonStop = new JButton("Stop");
	private ControlModel cM;
	private CommandList cL = ControlModel.getInstance().getControlProcess();

	public ProgrammAblaufView(OurJTable table) {
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

				int index = table.getSelectedRow();
				if (index >= 0) {
					cL.remove(index);
					// Hier wird die nächste Zeile markiert, die nach dem
					// loeschen uebrig bleibt
					if (index < table.getRowCount())
						table.setRowSelectionInterval(index, index);
					else if (index == table.getRowCount() && index > 0)
						table.setRowSelectionInterval(index - 1, index - 1);
					else
						;

					ControlDeveloperView.getInstance().println(
							">>Zeile " + (index + 1) + " geloescht");
				} else {
					ControlDeveloperView.getInstance().println(
							">>Kein Element ausgewaehlt!");
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
					table.setRowSelectionInterval(index - 1, index - 1);
					ControlDeveloperView.getInstance().println(
							">>Zeile " + (index + 1) + " mit Zeile " + (index)
									+ " getauscht");
				} else if (index == 0) {
					ControlDeveloperView
							.getInstance()
							.println(
									">>Zeile "
											+ (index + 1)
											+ " Kann nicht nach oben verschoben werden!");
				} else {
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
					table.setRowSelectionInterval(index + 1, index + 1);
					ControlDeveloperView.getInstance().println(
							">>Zeile " + (index + 1) + " mit Zeile "
									+ (index + 2) + " getauscht");
				} else if (index >= 0
						&& index == (cM.getControlProcess().getNrContent() - 1)) {
					ControlDeveloperView
							.getInstance()
							.println(
									">>Zeile "
											+ (index + 1)
											+ " ist bereits die unterste Zeile und kann deshalb"
											+ " nicht nach unten verschoben werden!");
				} else {
					ControlDeveloperView.getInstance().println(
							">>Kein Element ausgewaehlt!");
				}
			}
		});

		buttonStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CommandList cL = ControlModel.getInstance().getControlProcess();
				final int NR_CONTENT = cL.getNrContent();
				for (int i = 0; i < NR_CONTENT; ++i) {
					ControlDeveloperView.getInstance().println(
							">>" + cL.get(i).toString());
				}
			}
		});

		buttonStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControlDeveloperView.getInstance().println(
						">>Ausfuehrung stoppen");
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