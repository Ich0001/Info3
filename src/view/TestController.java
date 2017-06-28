package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ControlModel;

public class TestController implements ActionListener {
	private ControlDeveloperView cV;
	private ControlModel cM;

	public TestController() {
		this.cV = ControlDeveloperView.getInstance();
		this.cM = ControlModel.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s1 = ((KonfigurationViewGear) cV.getKonfigurationsFenster()
				.getKonfiguration()).getTextSpeed();
		cV.getTextArea().setText(s1);
		cV.getKonfigurationsFenster().getKonfiguration().clearInput();
	}
}
