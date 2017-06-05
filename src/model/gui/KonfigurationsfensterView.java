package model.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.ControlModel;

public class KonfigurationsfensterView extends JPanel {
	private ControlDeveloperView cV;
	private ControlModel cM;
	private KonfigurationView konfiguration;
	private KonfigurationViewFooter footer;
	

	public KonfigurationsfensterView(ControlDeveloperView cV, ControlModel cM) {
		this.cV = cV;
		this.cM = cM;
		konfiguration = new KonfigurationView(cM);
		footer = new KonfigurationViewFooter(cV, cM);
		setLayout(new BorderLayout());
		add(konfiguration, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
	}

	public KonfigurationView getKonfiguration() {
		return konfiguration;
	}

	public KonfigurationViewFooter getFooter() {
		return footer;
	}

}
