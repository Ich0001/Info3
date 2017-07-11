package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Command;
import model.ControlModel;
import model.Direction;
import model.Gear;
import model.Pause;
import model.Repetition;
import view.ControlDeveloperView;
import view.KonfigurationView;
import view.KonfigurationViewDirection;
import view.KonfigurationViewGear;
import view.KonfigurationViewIdle;
import view.KonfigurationViewPause;
import view.KonfigurationViewRepetition;

public class ButtonSaveController implements ActionListener {
	private KonfigurationView konfiguration;

	public ButtonSaveController() {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			konfiguration = ControlDeveloperView.getInstance()
					.getKonfigurationsFenster().getKonfiguration();
			// Direction
			if (konfiguration instanceof KonfigurationViewDirection) {
				String degree = ((KonfigurationViewDirection) konfiguration)
						.getTextDegree();
				konfiguration.clearInput();
				int selRow = ControlDeveloperView.getInstance().getOurJTable()
						.getSelectedRow();
				Command command = ControlModel.getInstance()
						.getControlProcess().get(selRow);
				((Direction) command).setDegree(Integer.parseInt(degree));
			}

			// Gear
			else if (konfiguration instanceof KonfigurationViewGear) {
				String speed = ((KonfigurationViewGear) konfiguration)
						.getTextSpeed();
				String duration = ((KonfigurationViewGear) konfiguration)
						.getTextDuration();
				konfiguration.clearInput();

				int selRow = ControlDeveloperView.getInstance().getOurJTable()
						.getSelectedRow();
				Command command = ControlModel.getInstance()
						.getControlProcess().get(selRow);
				((Gear) command).setSpeed(Integer.parseInt(speed));
				((Gear) command).setDuration(Double.parseDouble(duration));
			}

			// Repetition
			else if (konfiguration instanceof KonfigurationViewRepetition) {
				String nrSteps = ((KonfigurationViewRepetition) konfiguration)
						.getTextNrSteps();
				String nrRepetitions = ((KonfigurationViewRepetition) konfiguration)
						.getTextNrRepetitions();
				konfiguration.clearInput();

				int selRow = ControlDeveloperView.getInstance().getOurJTable()
						.getSelectedRow();
				Command command = ControlModel.getInstance()
						.getControlProcess().get(selRow);
				((Repetition) command).setNrSteps(Integer.parseInt(nrSteps));
				((Repetition) command).setNrRepetitions(Integer
						.parseInt(nrRepetitions));
			}

			// Pause
			else if (konfiguration instanceof KonfigurationViewPause) {
				String duration = ((KonfigurationViewPause) konfiguration)
						.getTextDuration();
				konfiguration.clearInput();

				int selRow = ControlDeveloperView.getInstance().getOurJTable()
						.getSelectedRow();
				Command command = ControlModel.getInstance()
						.getControlProcess().get(selRow);
				((Pause) command).setDuration(Double.parseDouble(duration));
			}

			// Idle
			else if (konfiguration instanceof KonfigurationViewIdle) {
				ControlDeveloperView.getInstance().println(
						">>Kein Kommando ausgewählt!");
			}

			else {
				System.out.println("Fehler in KonfigurationsFensterView :-(");
			}

			// Informiere das TableModel, dass sich am Inhalt was geaendert hat
			ControlModel.getInstance().getControlProcess()
					.fireTableDataChanged();

		} catch (ClassCastException e) {
			System.out.println("Falsche Auswahl beim Druecken von 'Save'");
			ControlDeveloperView.getInstance().println(">>Falsche Auswahl!");
		} catch (NumberFormatException e) {
			System.out.println("Keine oder Falsche Zeichen eingegeben!");
			ControlDeveloperView.getInstance().println(
					">>Keine oder Falsche Zeichen eingegeben!");
		} finally {

		}
	}
}
