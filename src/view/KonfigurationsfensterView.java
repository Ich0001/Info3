package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Command;
import model.ControlModel;
import model.Direction;
import model.Gear;
import model.Pause;
import model.Repetition;

public class KonfigurationsFensterView extends JPanel {
	private KonfigurationView konfiguration;
	private JButton buttonSave;
	private JPanel footer;
	KonfigurationView konfigurationsFensterIdle = new KonfigurationViewIdle();

	public KonfigurationsFensterView() {
		konfiguration = konfigurationsFensterIdle;

		buttonSave = new JButton("Save");
		footer = new JPanel();

		setLayout(new BorderLayout());

		buttonSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					// Direction
					if (konfiguration instanceof KonfigurationViewDirection) {
						String degree = ((KonfigurationViewDirection) konfiguration)
								.getTextDegree();
						konfiguration.clearInput();
						int selRow = ControlDeveloperView.getInstance()
								.getOurJTable().getSelectedRow();
						Command command = ControlModel.getInstance()
								.getControlProcess().get(selRow);
						((Direction) command).setDegree(Integer
								.parseInt(degree));
					}

					// Gear
					else if (konfiguration instanceof KonfigurationViewGear) {
						String speed = ((KonfigurationViewGear) konfiguration)
								.getTextSpeed();
						String duration = ((KonfigurationViewGear) konfiguration)
								.getTextDuration();
						konfiguration.clearInput();

						int selRow = ControlDeveloperView.getInstance()
								.getOurJTable().getSelectedRow();
						Command command = ControlModel.getInstance()
								.getControlProcess().get(selRow);
						((Gear) command).setSpeed(Integer.parseInt(speed));
						((Gear) command).setDuration(Double
								.parseDouble(duration));
					}

					// Repetition
					else if (konfiguration instanceof KonfigurationViewRepetition) {
						String nrSteps = ((KonfigurationViewRepetition) konfiguration)
								.getTextNrSteps();
						String nrRepetitions = ((KonfigurationViewRepetition) konfiguration)
								.getTextNrRepetitions();
						konfiguration.clearInput();

						int selRow = ControlDeveloperView.getInstance()
								.getOurJTable().getSelectedRow();
						Command command = ControlModel.getInstance()
								.getControlProcess().get(selRow);
						((Repetition) command).setNrSteps(Integer
								.parseInt(nrSteps));
						((Repetition) command).setNrRepetitions(Integer
								.parseInt(nrRepetitions));
					}

					// Pause
					else if (konfiguration instanceof KonfigurationViewPause) {
						String duration = ((KonfigurationViewPause) konfiguration)
								.getTextDuration();
						konfiguration.clearInput();

						int selRow = ControlDeveloperView.getInstance()
								.getOurJTable().getSelectedRow();
						Command command = ControlModel.getInstance()
								.getControlProcess().get(selRow);
						((Pause) command).setDuration(Double
								.parseDouble(duration));
					}

					// Idle
					else if (konfiguration instanceof KonfigurationViewIdle) {
						ControlDeveloperView.getInstance().println(
								">>Kein Kommando ausgewählt!");
					}

					else {
						System.out
								.println("Fehler in KonfigurationsFensterView :-(");
					}

					// Setze die geaenderten Inhalte aus der verketteten Liste
					// in das TableModel um
					if (konfiguration instanceof KonfigurationViewDirection
							|| konfiguration instanceof KonfigurationViewGear
							|| konfiguration instanceof KonfigurationViewRepetition
							|| konfiguration instanceof KonfigurationViewPause) {
						ControlDeveloperView
								.getInstance()
								.getOurJTable()
								.getTableModel()
								.setValueAt(
										ControlModel
												.getInstance()
												.getControlProcess()
												.get(ControlDeveloperView
														.getInstance()
														.getOurJTable()
														.getSelectedRow())
												.propertiesToString(),
										ControlDeveloperView.getInstance()
												.getOurJTable()
												.getSelectedRow(), 2);
					}
				}

				catch (NumberFormatException e) {
					System.out.println("Scheisse gebaut");
					ControlDeveloperView.getInstance().println(
							">>Keine oder Falsche Zeichen eingegeben!");
				} finally {

				}

			}
		});
		footer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		footer.add(buttonSave);

		add(konfiguration, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
	}

	public KonfigurationView getKonfiguration() {
		return konfiguration;
	}

	public void setKonfigurationIdle() {
		changeKonfiguration(konfigurationsFensterIdle);
	}

	public void changeKonfiguration(KonfigurationView newKonfiguration) {
		remove(konfiguration);
		konfiguration = newKonfiguration;
		add(konfiguration, BorderLayout.CENTER);
		repaint();
		ControlDeveloperView.getInstance().pack();
	}
}
