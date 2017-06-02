package model.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KonfigurationsfensterView extends JPanel {
	private KonfigurationView konfiguration = new KonfigurationView();
	private KonfigurationViewFooter footer = new KonfigurationViewFooter();

	public KonfigurationsfensterView() {
		setLayout(new BorderLayout());
		add(konfiguration, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
	}

}
