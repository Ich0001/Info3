package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

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
        JScrollPane scrolltxt = new JScrollPane(textArea);
		add(scrolltxt, BorderLayout.SOUTH);
		textArea.setBorder(new EmptyBorder(0,0,50,0));
		
		// Konfigurieren und hinzufuegen der JMenuBar
		
		add(menuBar, BorderLayout.NORTH);
		// File Menu
		JMenu file = new JMenu("File", true);
		menuBar.add(file);

		// File Items
		JMenuItem speichern = new JMenuItem("Speichern");
		JMenuItem laden = new JMenuItem("Laden");
		file.add(speichern);
		file.add(laden);

		// Help Menu
		JMenu help = new JMenu("Help", true);
		menuBar.add(help);
		JMenuItem info = new JMenuItem("About ControlDeveloper");
		help.add(info);
		ActionListener al = new ActionListener() {

		// JFileChoose
		JFileChooser chooser = new JFileChooser();
		JFileChooser savefile = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "text");

		@Override
	public void actionPerformed(ActionEvent e) {

				// Action beim Speichern
				if (e.getSource() == speichern) {
					savefile.showSaveDialog(savefile);
					if (!savefile.getSelectedFile().getAbsolutePath().endsWith(".txt")) {	//.txt hinzufuegen
						File datei = new File(savefile.getSelectedFile() + ".txt");
						cM.save(datei);
					}

					// Action beim Laden
				} else if (e.getSource() == laden) {
					// chooser.setFileFilter(filter);
					chooser.showOpenDialog(getParent());
					File datei = chooser.getSelectedFile();
					cM.load(datei);

					// Action beim Info
				} else if (e.getSource() == info) {
					try {
						Desktop desktop = java.awt.Desktop.getDesktop();
						URI oURL = new URI( "file://"+System.getProperty("user.dir") + "/doc/index.html"); 
						desktop.browse(oURL);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			}

		};
		speichern.addActionListener(al);
		laden.addActionListener(al);
		info.addActionListener(al);

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
