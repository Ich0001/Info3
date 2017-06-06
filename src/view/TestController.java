package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ControlModel;

public class TestController implements ActionListener {
	private ControlDeveloperView cV;
	private ControlModel cM;

	public TestController(ControlDeveloperView cV, ControlModel cM) {
		this.cV = cV;
		this.cM = cM;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s1 = ((KonfigurationViewGear) cV.getKonfigurationsfenster()
				.getKonfiguration()).getTextSpeed();
		cV.getTextArea().setText(s1);
		cV.getKonfigurationsfenster().getKonfiguration().clearInput();
	}
}
