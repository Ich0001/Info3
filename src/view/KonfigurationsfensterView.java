package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.ControlModel;

public class KonfigurationsFensterView extends JPanel {
	private KonfigurationView konfiguration;
	private JButton buttonSave;
	private JPanel footer;

	public KonfigurationsFensterView() {
		konfiguration = new KonfigurationViewGear(ControlModel.getInstance());
		buttonSave = new JButton("Save");
		footer = new JPanel();

		setLayout(new BorderLayout());

		// Hier muss man noch den richtigen Controller reinschreiben (statt
		// ButtonAddController). Und auskommentieren.
		// buttonSave.addActionListener(new ButtonAddController(null, null));
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
