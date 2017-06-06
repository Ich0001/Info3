package model.gui;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import model.ControlModel;

public abstract class KonfigurationView extends JPanel {
	private ControlModel cM;

	public KonfigurationView(ControlModel cM) {
		this.cM = cM;
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
	}

	public abstract void clearInput();

}
