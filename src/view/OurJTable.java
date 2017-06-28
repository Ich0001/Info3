package view;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ControlModel;

public class OurJTable extends JTable {
	private DefaultTableModel tableModel;
	private Vector<String> v;
	private ControlModel cM;

	public OurJTable() {
		cM = ControlModel.getInstance();
		v = new Vector<String>();
		v.add("Nr.");
		v.add("Command");
		v.add("Configuration");
		tableModel = new DefaultTableModel(v, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		setModel(tableModel);
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}
}
