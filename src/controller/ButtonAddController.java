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
	private ControlDeveloperView cV;
	private ControlModel cM;
	private JList<CommandType> list;
	private OurJTable ourJTable;

	public ButtonAddController(JList<CommandType> list, OurJTable ourJTable) {
		cV = ControlDeveloperView.getInstance();
		cM = ControlModel.getInstance();
		this.ourJTable = ourJTable;
		this.list = list;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Ermitteln ausgewähltes Element
		CommandType cT = list.getSelectedValue();
		// Instanziieren des neuen Commands
		System.out.println(cT);

		if (cT != null) {
			Command c = cT.createInctance();
			// Speichern des Commands in der verketteten Liste
			cM.getControlProcess().add(c);
			// Informiere Tabelle (OurJTable) ueber die Aenderung
			Vector<String> v = new Vector<String>();
			v.add(Integer.toString(cM.getControlProcess().getNrContent()));
			v.add(c.getName());
			v.add(c.propertiesToString());
			System.out.println(v);
			this.ourJTable.getTableModel().addRow(v);
			this.ourJTable.getTableModel().fireTableDataChanged();

			System.out.println(v);

			System.out.println("addButton");
		} else
			System.out.println("Kein Kommando ausgewaehlt!");
	}
}
