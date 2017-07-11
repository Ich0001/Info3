package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ButtonSaveController;

public class KonfigurationsfensterView extends JPanel {
	private KonfigurationView konfiguration;
	private JButton buttonSave;
	private JPanel footer;
	private KonfigurationView konfigurationsFensterIdle = new KonfigurationViewIdle();

	public KonfigurationsfensterView() {
		konfiguration = konfigurationsFensterIdle;

		buttonSave = new JButton("Save");
		footer = new JPanel();

		setLayout(new BorderLayout());

		buttonSave.addActionListener(new ButtonSaveController());

		footer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		footer.add(buttonSave);

		add(konfiguration, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
	}

	public KonfigurationView getKonfiguration() {
		return konfiguration;
	}

	public void setKonfigurationIdle() {
		changeKonfiguration(konfigurationsFensterIdle);
	}

	public void changeKonfiguration(KonfigurationView newKonfiguration) {
		remove(konfiguration);
		konfiguration = newKonfiguration;
		add(konfiguration, BorderLayout.CENTER);
		repaint();
		ControlDeveloperView.getInstance().pack();
	}
}
