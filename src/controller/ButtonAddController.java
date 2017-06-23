package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

import model.Command;
import model.CommandType;
import model.ControlModel;
import view.ControlDeveloperView;
import view.OurJTable;

public class ButtonAddController implements ActionListener {
	private ControlDeveloperView cV;
	private ControlModel cM;
	private JList<CommandType> list;
	private DefaultTableModel tableModel;
	private OurJTable ourtable;

	public ButtonAddController(JList<CommandType> list, OurJTable ourJTable) {
		cV = ControlDeveloperView.getInstance();
		cM = ControlModel.getInstance();
		ourtable = ourJTable;
		this.list = list;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Ermitteln ausgewähltes Element
		CommandType cT = list.getSelectedValue();
		// Instanziieren des neuen Commands
		System.out.println(cT);

		Command c = cT.createInctance();
		// Speichern des Commands in der verketteten Liste
		cM.getControlProcess().add(c);
		// Informiere Tabelle (OurJTable) über die Änderung
		Vector<String> v = new Vector<String>();
		v.add(Integer.toString(cM.getControlProcess().getNrContent()));
		v.add(c.getName());
		v.add("xyz");

		ourtable.tableModel.addRow(v);
		ourtable.tableModel.fireTableDataChanged();

		System.out.println(v);

		System.out.println("addButton");

	}
}
