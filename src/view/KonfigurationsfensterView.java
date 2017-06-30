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

	public KonfigurationsFensterView() {
		konfiguration = new KonfigurationViewPause(ControlModel.getInstance());
		buttonSave = new JButton("Save");
		footer = new JPanel();

		setLayout(new BorderLayout());

		buttonSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
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
					((Direction) command).setDegree(Integer.parseInt(degree));

					System.out.println("degree="
							+ ((Direction) (ControlModel.getInstance()
									.getControlProcess().get(selRow)))
									.getDegree());
				} else if (konfiguration instanceof KonfigurationViewGear) {
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
					((Gear) command).setDuration(Double.parseDouble(duration));

					System.out.println("speed="
							+ ((Gear) (ControlModel.getInstance()
									.getControlProcess().get(selRow)))
									.getSpeed()
							+ "  duration="
							+ ((Gear) (ControlModel.getInstance()
									.getControlProcess().get(selRow)))
									.getDuration());

					System.out.println("speed:" + speed + "  duration:"
							+ duration);
				} else if (konfiguration instanceof KonfigurationViewRepetition) {
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
					((Repetition) command).setNrSteps(Integer.parseInt(nrSteps));
					((Repetition) command).setNrRepetitions(Integer
							.parseInt(nrRepetitions));

					System.out.println("nrSteps="
							+ ((Repetition) (ControlModel.getInstance()
									.getControlProcess().get(selRow)))
									.getNrSteps()
							+ "  nrRepetitions="
							+ ((Repetition) (ControlModel.getInstance()
									.getControlProcess().get(selRow)))
									.getNrRepetitions());

					System.out.println("nrSteps:" + nrSteps
							+ "  nrRepetitions:" + nrRepetitions);
				} else if (konfiguration instanceof KonfigurationViewPause) {
					String duration = ((KonfigurationViewPause) konfiguration)
							.getTextDuration();
					konfiguration.clearInput();

					int selRow = ControlDeveloperView.getInstance()
							.getOurJTable().getSelectedRow();
					Command command = ControlModel.getInstance()
							.getControlProcess().get(selRow);
					// TODO exception-handling fuer den Fall dass nicht nur
					// Zahlen eingegeben wurden
					((Pause) command).setDuration(Double.parseDouble(duration));

					System.out.println("duration="
							+ ((Pause) (ControlModel.getInstance()
									.getControlProcess().get(selRow)))
									.getDuration());

					System.out.println("duration:" + duration);
				} else
					System.out
							.println("Fehler in KonfigurationsFensterView :-(");
				ControlDeveloperView
						.getInstance()
						.getOurJTable()
						.getTableModel()
						.setValueAt(
								ControlModel
										.getInstance()
										.getControlProcess()
										.get(ControlDeveloperView.getInstance()
												.getOurJTable()
												.getSelectedRow())
										.propertiesToString(),
								ControlDeveloperView.getInstance()
										.getOurJTable().getSelectedRow(), 2);
				;
				System.out.println("fire");
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

	public void changeKonfiguration(KonfigurationView newKonfiguration) {
		remove(konfiguration);
		konfiguration = newKonfiguration;
		add(konfiguration, BorderLayout.CENTER);
		repaint();
		ControlDeveloperView.getInstance().pack();
	}
}
