package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import menjacnica.Menjacnica;

import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ScrollPaneConstants;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton btnDodajKurs;
	private JButton btnObrisiKurs;
	private JButton btnIzvrsiZamenu;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKnjigu;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	/////////////////////////////////
	protected Menjacnica sistem;
	private JScrollPane scrollPane_1;
	protected JTextArea textArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int opcija = JOptionPane.showConfirmDialog(contentPane,
						"Da li zelite da izadjete iz programa", "Izlazak",
						JOptionPane.YES_NO_CANCEL_OPTION);

				if (opcija == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/icons/images.jpg")));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 864, 407);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.EAST);
		contentPane.add(getScrollPane_1(), BorderLayout.SOUTH);
		
		sistem = new Menjacnica();
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			addPopup(scrollPane, getPopupMenu());
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(160, 10));
			panel.add(getBtnDodajKurs());
			panel.add(getBtnObrisiKurs());
			panel.add(getBtnIzvrsiZamenu());
		}
		return panel;
	}
	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj kurs");
			btnDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					prikaziDodajKursGUI();
				}
			});
			btnDodajKurs.setPreferredSize(new Dimension(110, 23));
		}
		return btnDodajKurs;
	}
	private JButton getBtnObrisiKurs() {
		if (btnObrisiKurs == null) {
			btnObrisiKurs = new JButton("Obrisi kurs");
			btnObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					prikaziObrisiKursGUI();
				}
			});
			btnObrisiKurs.setPreferredSize(new Dimension(110, 23));
		}
		return btnObrisiKurs;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.setPreferredSize(new Dimension(110, 23));
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
		}
		return btnIzvrsiZamenu;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmNewMenuItem());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Open");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						JFileChooser fc = new JFileChooser();
						int returnVal = fc.showOpenDialog(contentPane);

						if (returnVal == JFileChooser.APPROVE_OPTION) {
							File file = fc.getSelectedFile();
							textArea.append("Ucitan fajl: " + file.getAbsolutePath()+" \n");
						
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(contentPane, e1.getMessage(),
								"Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
			mntmNewMenuItem.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						JFileChooser fc = new JFileChooser();
						int returnVal = fc.showSaveDialog(contentPane);

						if (returnVal == JFileChooser.APPROVE_OPTION) {
							File file = fc.getSelectedFile();

							textArea.append("Sacuvan fajl " + file.getAbsolutePath()+"\n");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(contentPane, e1.getMessage(),
								"Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int opcija = JOptionPane.showConfirmDialog(contentPane,
							"Da li zelite da izadjete iz programa", "Izlazak",
							JOptionPane.YES_NO_CANCEL_OPTION);

					if (opcija == JOptionPane.YES_OPTION)
						System.exit(0);
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmExit;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(contentPane,
							"Autor: Dusko Milosevic, Verzija 1.0", "O programu Menjacnica",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return mntmAbout;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u0160ifra", "Skra\u0107eni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"
				}
			));
		}
		return table;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKnjigu());
			popupMenu.add(getMntmNewMenuItem_1());
			popupMenu.add(getMntmNewMenuItem_2());
		}
		return popupMenu;
	}
	private JMenuItem getMntmDodajKnjigu() {
		if (mntmDodajKnjigu == null) {
			mntmDodajKnjigu = new JMenuItem("Dodaj kurs");
			mntmDodajKnjigu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					prikaziDodajKursGUI();
				}
			});
		}
		return mntmDodajKnjigu;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("Obrisi kurs");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					prikaziObrisiKursGUI();
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("Izrvsi zamenu");
		}
		return mntmNewMenuItem_2;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane_1.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane_1.setViewportView(getTextArea_1());
		}
		return scrollPane_1;
	}
	private JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private void prikaziDodajKursGUI() {
		DodajKursGUI prozor = new DodajKursGUI(this);
		prozor.setLocationRelativeTo(contentPane);
		prozor.setVisible(true);
	}
	private void prikaziObrisiKursGUI() {
		
//		if (table.getSelectedRow() != -1) {
//			MenjacnicaTableModel model = (MenjacnicaTableModel)(table.getModel());
			ObrisiKursGUI prozor = new ObrisiKursGUI(this);
			prozor.setLocationRelativeTo(contentPane);
			prozor.setVisible(true);
		}
	}

