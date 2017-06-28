package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JList;

import model.Command;
import model.CommandType;
import model.ControlModel;
import view.ControlDeveloperView;
import view.OurJTable;

public class ButtonAddController implements ActionListener {
	private ControlModel cM;
	private JList<CommandType> list;
	private OurJTable ourJTable;

	public ButtonAddController(JList<CommandType> list, OurJTable ourJTable) {
		cM = ControlModel.getInstance();
		this.ourJTable = ourJTable;
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

			// Informiere Tabelle (OurJTable) ueber die Aenderung
			Vector<String> v = new Vector<String>();
			v.add(Integer.toString(cM.getControlProcess().getNrContent()));
			v.add(c.getName());
			v.add(c.propertiesToString());
			this.ourJTable.getTableModel().addRow(v);
			this.ourJTable.getTableModel().fireTableDataChanged();
			ControlDeveloperView.getInstance().getTextArea()
					.append("\n>>" + c.getName() + " hinzugefügt");
		} else {
			ControlDeveloperView.getInstance().getTextArea()
					.append("\n>>Kein Kommando ausgewählt!");
		}
	}
}
