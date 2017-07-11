package view;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelListener;

import model.Command;
import model.ControlModel;

@SuppressWarnings("serial")
public class OurJTable extends JTable implements TableModelListener {
	private ControlModel cM;

	public OurJTable() {
		cM = ControlModel.getInstance();
		setModel(cM.getControlProcess());
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		super.valueChanged(e);

		int selectedRow = getSelectedRow();
		KonfigurationView newKonfigurationView;
		if (selectedRow >= 0) {
			Command selectedElement = cM.getControlProcess().get(selectedRow);
			String name = selectedElement.getName();

			switch (name) {
			case "Direction":
				newKonfigurationView = new KonfigurationViewDirection(cM);
				break;
			case "Gear":
				newKonfigurationView = new KonfigurationViewGear(cM);
				break;
			case "Repetition":
				newKonfigurationView = new KonfigurationViewRepetition(cM);
				break;
			case "Pause":
				newKonfigurationView = new KonfigurationViewPause(cM);
				break;
			default:
				newKonfigurationView = new KonfigurationViewIdle();
			}
		} else {
			System.out.println("Keine Zeile ausgewaehlt");
			newKonfigurationView = new KonfigurationViewIdle();
		}
		ControlDeveloperView.getInstance().getKonfigurationsFenster()
				.changeKonfiguration(newKonfigurationView);
	}
}
