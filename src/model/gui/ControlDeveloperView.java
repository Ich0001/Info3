package model.gui;

import java.awt.BorderLayout;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.ControlModel;

public class ControlDeveloperView extends JFrame {
	private JPanel contentPane;
	private ControlModel cM;
	
	private BefehleView befehleView;
	private KonfigurationsfensterView konfigurationsfenster;
	private JTextArea textArea;
	private JMenuBar menuBar;

	/**
	 * Launch the application. Wird jetzt in der Klasse ControlDeveloper
	 * ausgefuehrt (main-Methode)
	 */
	// public static void main(String[] args) {
	// ControlModel cM = ControlModel.getInstance();
	// ControlDeveloperView frame = new ControlDeveloperView(cM);
	// frame.setVisible(true);
	// }

	/**
	 * Create the frame.
	 */
	public ControlDeveloperView(ControlModel cM) {
		super("ControlDeveloper");
		this.cM = cM;
		//Erzeugen der Objekte
		befehleView = new BefehleView(this.cM);
		konfigurationsfenster = new KonfigurationsfensterView(this, cM);
		textArea = new JTextArea("HALLO\nHallo");
		menuBar = new JMenuBar();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));
		setContentPane(contentPane);


		add(befehleView, BorderLayout.WEST);

		
		add(konfigurationsfenster, BorderLayout.EAST);


		textArea.setEditable(false);
		add(textArea, BorderLayout.SOUTH);


		JMenu menuInfo = new JMenu("File", true);
		menuInfo.add(new JMenuItem("Haste gedacht da steht jetzt was :D"));
		menuBar.add(menuInfo);
		menuBar.add(new JMenu("Info", false));
		add(menuBar, BorderLayout.NORTH);
	}

	public BefehleView getBefehleView() {
		return befehleView;
	}

	public KonfigurationsfensterView getKonfigurationsfenster() {
		return konfigurationsfenster;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

//	public JMenuBar getMenuBar() {
//		return menuBar;
//	}

}
