package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;

import model.ControlModel;

public class ControlDeveloperView extends JFrame {
	private static final ControlDeveloperView INSTANCE = new ControlDeveloperView();
	private JPanel contentPane;
	private ControlModel cM;

	private BefehleView befehleView;
	private ProgrammAblaufView programmAblaufView;
	private KonfigurationsFensterView konfigurationsFensterView;
	private Console console;
	private JMenuBar menuBar;
	private OurJTable table;

	/**
	 * Konstruktor
	 */
	private ControlDeveloperView() {
		super("ControlDeveloper");
		this.cM = ControlModel.getInstance();

		// Erzeugen der Objekte
		table = new OurJTable();
		// Tabelleneinteilung
		TableColumnModel colModel = table.getColumnModel();
		colModel.getColumn(0).setPreferredWidth(20);
		colModel.getColumn(2).setPreferredWidth(200);

		befehleView = new BefehleView(this.cM, table);
		programmAblaufView = new ProgrammAblaufView(table);
		konfigurationsFensterView = new KonfigurationsFensterView();
		console = new Console();
		menuBar = new JMenuBar();

		// Definieren des Frames, und des ContentPanes, das alles im Rahmen
		// enthaelt.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));
		setContentPane(contentPane);

		// Hinzufuegen der eigens definierten Panels
		add(befehleView, BorderLayout.WEST);
		add(programmAblaufView, BorderLayout.CENTER);
		add(konfigurationsFensterView, BorderLayout.EAST);

		// Konfigurieren und hinzufuegen der Konsole mit TextArea
		add(console, BorderLayout.SOUTH);

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
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt",
					"text");

			@Override
			public void actionPerformed(ActionEvent e) {

				// Action beim Speichern
				if (e.getSource() == speichern) {
					savefile.showSaveDialog(savefile);
					if (!savefile.getSelectedFile().getAbsolutePath()
							.endsWith(".txt")) { // .txt hinzufuegen
						File datei = new File(savefile.getSelectedFile()
								+ ".txt");
						cM.save(datei);
					}

					// Action beim Laden
				} else if (e.getSource() == laden) {
					chooser.showOpenDialog(getParent());
					File datei = chooser.getSelectedFile();

					// TableModel erst leeren
					final int ROW_COUNT = table.getTableModel().getRowCount();
					for (int i = 0; i < ROW_COUNT; ++i) {
						table.getTableModel().removeRow(0);
					}

					cM.load(datei);
					for (int i = 0; i < cM.getControlProcess().getNrContent(); i++) {
						Vector<String> v = new Vector<String>();
						v.add(Integer.toString(i + 1));
						v.add(cM.getControlProcess().get(i).getName());
						v.add(cM.getControlProcess().get(i)
								.propertiesToString());
						table.getTableModel().addRow(v);
					}

					// Action beim Info
				} else if (e.getSource() == info) {
					ImageIcon icon = new ImageIcon("src/icon.png");

					JOptionPane
							.showMessageDialog(
									null,
									"ControlDeveloper:"
											+ "\nBeschreibung:ControlDeveloper ist ein Steuerungsprogram "
											+ "\nzur Steuerung eines Fahrzeugs über eine Bluetooth-Schnittstelle."
											+ "\n(c)Copyrights: Jonathan Pfrommer, Aabed Solayman, Lukas Erkert",
									"About", JOptionPane.INFORMATION_MESSAGE,
									icon);

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

	@Override
	public JMenuBar getJMenuBar() {
		return menuBar;
	}

	public OurJTable getOurJTable() {
		return table;
	}

	public JTextArea getTextArea() {
		return console.getTextArea();
	}

	public void scrollToBottom() {
		console.scrollToBottom();
	}

	/**
	 * Die Methode print druckt einen uebergebenen String in der Konsole im
	 * Sueden der Anwendung aus. Es wird kein Zeilenumbruch am Ende eingefuegt.
	 * 
	 * @param string
	 *            Auszugebender String
	 */
	public void print(String string) {
		getTextArea().append(string);
		scrollToBottom();
	}

	/**
	 * Die Methode println druckt einen uebergebenen String in der Konsole im
	 * Sueden der Anwendung aus. Es wird ein Zeilenumbruch am Ende eingefuegt.
	 * 
	 * @param string
	 *            Auszugebender String
	 */
	public void println(String string) {
		getTextArea().append(string + "\n");
		scrollToBottom();
	}
}
