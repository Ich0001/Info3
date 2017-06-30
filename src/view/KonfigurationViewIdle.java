package view;

import javax.swing.JLabel;

import model.ControlModel;

public class KonfigurationViewIdle extends KonfigurationView {
	private JLabel label = new JLabel("  Kein Kommando ausgewählt  ");

	public KonfigurationViewIdle() {
		super(ControlModel.getInstance());
		add(label);
	}

	@Override
	public void clearInput() {
	}

}
