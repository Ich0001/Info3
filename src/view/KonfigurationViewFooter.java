package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.ControlModel;

public class KonfigurationViewFooter extends JPanel {
	private JButton buttonSave = new JButton("Save");
	private ControlDeveloperView cV;
	private ControlModel cM;

	public KonfigurationViewFooter(ControlDeveloperView cV, ControlModel cM) {
		this.cV = cV;
		this.cM = cM;
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		TestController testController = new TestController(cV, cM);
		buttonSave.addActionListener(testController);
		add(buttonSave);
	}
}