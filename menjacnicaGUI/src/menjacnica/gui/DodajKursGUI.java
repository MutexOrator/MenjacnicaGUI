package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.Valuta;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSifra;
	private JLabel lblNaziv;
	private JTextField textFieldSifra;
	private JTextField textFieldNaziv;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textFieldProdajni;
	private JTextField textFieldKupovni;
	private JLabel lblNewLabel_2;
	private JLabel lblSkraceniNaziv;
	private JTextField textFieldSrednji;
	private JTextField textFieldSkraceniNaziv;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private MenjacnicaGUI glavniProzor;

	/**
	 * Create the frame.
	 */
	public DodajKursGUI(MenjacnicaGUI glavniProzor) {
		setResizable(false);
		setTitle("Dodaj kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblSifra());
		contentPane.add(getLblNaziv());
		contentPane.add(getTextFieldSifra());
		contentPane.add(getTextFieldNaziv());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTextFieldProdajni());
		contentPane.add(getTextFieldKupovni());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblSkraceniNaziv());
		contentPane.add(getTextFieldSrednji());
		contentPane.add(getTextFieldSkraceniNaziv());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
		
		this.glavniProzor = glavniProzor;
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
			lblSifra.setBounds(39, 21, 127, 14);
		}
		return lblSifra;
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setBounds(213, 21, 46, 14);
		}
		return lblNaziv;
	}
	private JTextField getTextFieldSifra() {
		if (textFieldSifra == null) {
			textFieldSifra = new JTextField();
			textFieldSifra.setBounds(39, 43, 127, 20);
			textFieldSifra.setColumns(10);
		}
		return textFieldSifra;
	}
	private JTextField getTextFieldNaziv() {
		if (textFieldNaziv == null) {
			textFieldNaziv = new JTextField();
			textFieldNaziv.setBounds(213, 43, 127, 20);
			textFieldNaziv.setColumns(10);
		}
		return textFieldNaziv;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Prodajni kurs");
			lblNewLabel.setBounds(39, 80, 127, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Kupovni kurs");
			lblNewLabel_1.setBounds(213, 80, 127, 14);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextFieldProdajni() {
		if (textFieldProdajni == null) {
			textFieldProdajni = new JTextField();
			textFieldProdajni.setBounds(39, 105, 127, 20);
			textFieldProdajni.setColumns(10);
		}
		return textFieldProdajni;
	}
	private JTextField getTextFieldKupovni() {
		if (textFieldKupovni == null) {
			textFieldKupovni = new JTextField();
			textFieldKupovni.setBounds(213, 105, 127, 20);
			textFieldKupovni.setColumns(10);
		}
		return textFieldKupovni;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Srednji kurs");
			lblNewLabel_2.setBounds(39, 136, 127, 14);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
			lblSkraceniNaziv.setBounds(213, 136, 127, 14);
		}
		return lblSkraceniNaziv;
	}
	private JTextField getTextFieldSrednji() {
		if (textFieldSrednji == null) {
			textFieldSrednji = new JTextField();
			textFieldSrednji.setBounds(39, 161, 127, 20);
			textFieldSrednji.setColumns(10);
		}
		return textFieldSrednji;
	}
	private JTextField getTextFieldSkraceniNaziv() {
		if (textFieldSkraceniNaziv == null) {
			textFieldSkraceniNaziv = new JTextField();
			textFieldSkraceniNaziv.setBounds(213, 161, 127, 20);
			textFieldSkraceniNaziv.setColumns(10);
		}
		return textFieldSkraceniNaziv;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String s;
						s = "Pun naziv valute je "+textFieldNaziv.getText() + " skraceni naziv valute je " + textFieldSkraceniNaziv.getText()
						+ " sifra valute je " + textFieldSifra.getText() + " prodajni kurs iznosi " + textFieldProdajni.getText()
						+ " srednji kurs iznosi " + textFieldSrednji.getText()+ " kupovni kurs iznosi " + textFieldKupovni.getText() + "\n";
						glavniProzor.textArea.setText(s);
						dispose();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(contentPane, e1.getMessage(),
								"Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnDodaj.setBounds(39, 207, 127, 23);
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
			});
			btnOdustani.setBounds(213, 207, 127, 23);
		}
		return btnOdustani;
	}
}
