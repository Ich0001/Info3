package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import model.Command;
import model.CommandType;
import model.ControlModel;
import view.ControlDeveloperView;

public class ButtonAddController implements ActionListener {
	private ControlModel cM;
	private JList<CommandType> list;

	public ButtonAddController(JList<CommandType> list) {
		cM = ControlModel.getInstance();
		this.list = list;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		// Ermitteln ausgewähltes Element
		CommandType cT = list.getSelectedValue();

		// Abfragen ob ueberhaupt ein Listenelement ausgewaehlt worden ist
		if (cT != null) {
			// Instanziieren des neuen Commands
			Command c = cT.createInctance();

			// Speichern des Commands in der verketteten Liste
			cM.getControlProcess().add(c);
			System.out.println(">>" + c.getName() + " hinzugefügt");
		} else {
			ControlDeveloperView.getInstance().println(
					">>Kein Kommando ausgewählt!");
		}
	}
}
