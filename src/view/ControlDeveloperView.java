package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.ControlModel;

public class ControlDeveloperView extends JFrame {
	private static final ControlDeveloperView INSTANCE = new ControlDeveloperView();
	private JPanel contentPane;
	private ControlModel cM;

	private BefehleView befehleView;
	private ProgrammAblaufView programmAblaufView;
	private KonfigurationsFensterView konfigurationsFensterView;
	private JTextArea textArea;
	private JMenuBar menuBar;
	private OurJTable table;

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
	private ControlDeveloperView() {
		super("ControlDeveloper");
		this.cM = ControlModel.getInstance();

		// Erzeugen der Objekte
		table = new OurJTable();
		befehleView = new BefehleView(this.cM, table);
		programmAblaufView = new ProgrammAblaufView(table);
		konfigurationsFensterView = new KonfigurationsFensterView();
		textArea = new JTextArea("Programm gestartet:");
		menuBar = new JMenuBar();

		// Definieren des Frames, und des ContentPanes, das alles im Rahmen
		// enthaelt.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));
		setContentPane(contentPane);

		// Hinzufuegen der eigens definierten Panels
		add(befehleView, BorderLayout.WEST);
		add(programmAblaufView, BorderLayout.CENTER);
		add(konfigurationsFensterView, BorderLayout.EAST);

		// Konfigurieren und hinzufuegen der TextArea
		textArea.setEditable(false);
		add(textArea, BorderLayout.SOUTH);

		// Konfigurieren und hinzufuegen der JMenuBar
		JMenu menuInfo = new JMenu("File", true);
		menuInfo.add(new JMenuItem("Haste gedacht da steht jetzt was :D"));
		menuBar.add(menuInfo);
		menuBar.add(new JMenu("Info", false));
		add(menuBar, BorderLayout.NORTH);
	}

	/**
	 * KlassenMethode (static), um das einzige Objekt dieser Klasse (Singleton)
	 * zu bekommen.
	 * 
	 * @return Einziges Objekt / einzige Instanz dieser Klasse
	 */
	public static ControlDeveloperView getInstance() {
		return INSTANCE;
	}

	public BefehleView getBefehleView() {
		return befehleView;
	}

	public KonfigurationsFensterView getKonfigurationsFenster() {
		return konfigurationsFensterView;
	}

	public ProgrammAblaufView getProgrammAblaufView() {
		return programmAblaufView;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	@Override
	public JMenuBar getJMenuBar() {
		return menuBar;
	}

}
