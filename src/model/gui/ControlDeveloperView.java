package model.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ControlModel cM = ControlModel.getInstance();
		ControlDeveloperView frame = new ControlDeveloperView(cM);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ControlDeveloperView(ControlModel cM) {
		super("ControlDeveloper");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));
//		setContentPane(contentPane);
		
		BefehleView befehleView = new BefehleView(cM);
		add(befehleView, BorderLayout.WEST);
		
		KonfigurationsfensterView konfigurationsfenster = new KonfigurationsfensterView();
		add(konfigurationsfenster, BorderLayout.EAST);
		
		JTextArea textArea = new JTextArea("HALLO\nHallo");
		textArea.setEditable(false);
		add(textArea, BorderLayout.SOUTH);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menuInfo = new JMenu("File", true);
		menuInfo.add(new JMenuItem("Haste gedacht da steht jetzt was :D"));
		menuBar.add(menuInfo);
		menuBar.add(new JMenu("Info", false));
		add(menuBar, BorderLayout.NORTH);
	}

}
