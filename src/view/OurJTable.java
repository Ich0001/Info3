package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Command;
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
		setRowSelectionAllowed(true);
		setModel(tableModel);

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = getSelectedRow();
				if (selectedRow >= 0) {
					Command selectedElement = cM.getControlProcess().get(
							selectedRow);
					String name = selectedElement.getName();

					KonfigurationView newKonfigurationView;
					switch (name) {
					case "Direction":
						newKonfigurationView = new KonfigurationViewDirection(
								cM);
						break;
					case "Gear":
						newKonfigurationView = new KonfigurationViewGear(cM);
						break;
					case "Repetition":
						newKonfigurationView = new KonfigurationViewRepetition(
								cM);
						break;
					case "Pause":
						newKonfigurationView = new KonfigurationViewPause(cM);
						break;
					default:
						newKonfigurationView = null;
					}

					ControlDeveloperView.getInstance()
							.getKonfigurationsFenster()
							.changeKonfiguration(newKonfigurationView);
				} else
					System.out.println("Keine Zeile ausgewaehlt");
			}
		});
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}
}
