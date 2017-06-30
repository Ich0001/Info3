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
						// TODO exception-handling fuer den Fall dass nicht nur
						// Zahlen eingegeben wurden
						((Direction) command).setDegree(Integer
								.parseInt(degree));

						// System.out.println("Degree="
						// + ((Direction) (ControlModel.getInstance()
						// .getControlProcess().get(selRow)))
						// .getDegree());
						// ControlDeveloperView
						// .getInstance()
						// .getTextArea()
						// .append("\n>>Zeile "
						// + (selRow + 1)
						// + ": Degree="
						// + ((Direction) (ControlModel
						// .getInstance()
						// .getControlProcess()
						// .get(selRow))).getDegree());

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
						// TODO exception-handling fuer den Fall dass nicht nur
						// Zahlen eingegeben wurden
						((Gear) command).setSpeed(Integer.parseInt(speed));
						((Gear) command).setDuration(Double
								.parseDouble(duration));

						// System.out.println("speed="
						// + ((Gear) (ControlModel.getInstance()
						// .getControlProcess().get(selRow)))
						// .getSpeed()
						// + "  duration="
						// + ((Gear) (ControlModel.getInstance()
						// .getControlProcess().get(selRow)))
						// .getDuration());
						// System.out.println("speed:" + speed + "  duration:"
						// + duration);
						// ControlDeveloperView
						// .getInstance()
						// .getTextArea()
						// .append("\n>>Zeile "
						// + (selRow + 1)
						// + ": Speed="
						// + ((Gear) (ControlModel.getInstance()
						// .getControlProcess()
						// .get(selRow))).getSpeed()
						// + "  Duration="
						// + ((Gear) (ControlModel.getInstance()
						// .getControlProcess()
						// .get(selRow))).getDuration());
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
						// TODO exception-handling fuer den Fall dass nicht nur
						// Zahlen eingegeben wurden
						((Repetition) command).setNrSteps(Integer
								.parseInt(nrSteps));
						((Repetition) command).setNrRepetitions(Integer
								.parseInt(nrRepetitions));

						// System.out.println("NrSteps="
						// + ((Repetition) (ControlModel.getInstance()
						// .getControlProcess().get(selRow)))
						// .getNrSteps()
						// + "  NrRepetitions="
						// + ((Repetition) (ControlModel.getInstance()
						// .getControlProcess().get(selRow)))
						// .getNrRepetitions());
						// System.out.println("NrSteps:" + nrSteps
						// + "  NrRepetitions:" + nrRepetitions);
						// ControlDeveloperView
						// .getInstance()
						// .getTextArea()
						// .append("\n>>Zeile "
						// + (selRow + 1)
						// + ": NrSteps="
						// + ((Repetition) (ControlModel
						// .getInstance()
						// .getControlProcess()
						// .get(selRow))).getNrSteps()
						// + "  NrRepetitions="
						// + ((Repetition) (ControlModel
						// .getInstance()
						// .getControlProcess()
						// .get(selRow)))
						// .getNrRepetitions());
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
						// TODO exception-handling fuer den Fall dass nicht nur
						// Zahlen eingegeben wurden
						((Pause) command).setDuration(Double
								.parseDouble(duration));

						// System.out.println("duration="
						// + ((Pause) (ControlModel.getInstance()
						// .getControlProcess().get(selRow)))
						// .getDuration());
						// System.out.println("duration:" + duration);
						// ControlDeveloperView
						// .getInstance()
						// .getTextArea()
						// .append("\n>>Zeile "
						// + (selRow + 1)
						// + ": Duration="
						// + ((Pause) (ControlModel.getInstance()
						// .getControlProcess()
						// .get(selRow))).getDuration());

					} else {
						System.out
								.println("Fehler in KonfigurationsFensterView :-(");
					}

					// Setze die geaenderten Inhalte aus der verketteten Liste
					// in das TableModel um
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
											.getOurJTable().getSelectedRow(), 2);
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
