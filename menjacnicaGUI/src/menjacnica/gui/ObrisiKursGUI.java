package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ObrisiKursGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNaziv;
	private JTextField textFieldSifra;
	private JTextField textFieldNaziv;
	private JLabel lblProdajniKurs;
	private JTextField textFieldProdajni;
	private JLabel lblKupovniKurs;
	private JTextField textFieldKupovni;
	private JLabel lblNewLabel_1;
	private JTextField textFieldSrednji;
	private JLabel lblSkraceniNaziv;
	private JTextField textFieldSkraceni;
	private JButton btnObrisi;
	private JButton btnOdustani;
	private JCheckBox chckbxNewCheckBox;
	
	private MenjacnicaGUI glavniProzor;
	/**
	 * Create the frame.
	 */
	public ObrisiKursGUI(MenjacnicaGUI glavniProzor) {
		setResizable(false);
		setTitle("Obrisi kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNaziv());
		contentPane.add(getTextFieldSifra());
		contentPane.add(getTextFieldNaziv());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getTextFieldProdajni());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getTextFieldKupovni());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTextFieldSrednji());
		contentPane.add(getLblSkraceniNaziv());
		contentPane.add(getTextFieldSkraceni());
		contentPane.add(getBtnObrisi());
		contentPane.add(getBtnOdustani());
		contentPane.add(getChckbxNewCheckBox());
		this.glavniProzor = glavniProzor;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sifra");
			lblNewLabel.setBounds(51, 11, 46, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setBounds(226, 11, 46, 14);
		}
		return lblNaziv;
	}
	private JTextField getTextFieldSifra() {
		if (textFieldSifra == null) {
			textFieldSifra = new JTextField();
			textFieldSifra.setBounds(51, 39, 150, 20);
			textFieldSifra.setColumns(10);
		}
		return textFieldSifra;
	}
	private JTextField getTextFieldNaziv() {
		if (textFieldNaziv == null) {
			textFieldNaziv = new JTextField();
			textFieldNaziv.setBounds(226, 39, 150, 20);
			textFieldNaziv.setColumns(10);
		}
		return textFieldNaziv;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(51, 70, 86, 14);
		}
		return lblProdajniKurs;
	}
	private JTextField getTextFieldProdajni() {
		if (textFieldProdajni == null) {
			textFieldProdajni = new JTextField();
			textFieldProdajni.setBounds(51, 95, 150, 20);
			textFieldProdajni.setColumns(10);
		}
		return textFieldProdajni;
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(226, 70, 77, 14);
		}
		return lblKupovniKurs;
	}
	private JTextField getTextFieldKupovni() {
		if (textFieldKupovni == null) {
			textFieldKupovni = new JTextField();
			textFieldKupovni.setBounds(226, 95, 150, 20);
			textFieldKupovni.setColumns(10);
		}
		return textFieldKupovni;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Srednji kurs");
			lblNewLabel_1.setBounds(51, 126, 86, 14);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextFieldSrednji() {
		if (textFieldSrednji == null) {
			textFieldSrednji = new JTextField();
			textFieldSrednji.setBounds(51, 151, 150, 20);
			textFieldSrednji.setColumns(10);
		}
		return textFieldSrednji;
	}
	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
			lblSkraceniNaziv.setBounds(226, 126, 86, 14);
		}
		return lblSkraceniNaziv;
	}
	private JTextField getTextFieldSkraceni() {
		if (textFieldSkraceni == null) {
			textFieldSkraceni = new JTextField();
			textFieldSkraceni.setBounds(226, 151, 150, 20);
			textFieldSkraceni.setColumns(10);
		}
		return textFieldSkraceni;
	}
	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				obrisi();
				}
			});
			btnObrisi.setEnabled(false);
			btnObrisi.setBounds(51, 222, 150, 23);
		}
		return btnObrisi;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnOdustani.setBounds(226, 222, 150, 23);
		}
		return btnOdustani;
	}
	private JCheckBox getChckbxNewCheckBox() {
		if (chckbxNewCheckBox == null) {
			chckbxNewCheckBox = new JCheckBox("Zaista obrisi kurs");
			chckbxNewCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (chckbxNewCheckBox.isSelected())
						btnObrisi.setEnabled(true);
					else
						btnObrisi.setEnabled(false);
				}
			});
			chckbxNewCheckBox.setBounds(51, 192, 150, 23);
		}
		return chckbxNewCheckBox;
	}
	private void obrisi() {
		try {
			String s;
			s = "Pun naziv valute je "+textFieldNaziv.getText() + " skraceni naziv valute je " + textFieldSkraceni.getText()
			+ " sifra valute je " + textFieldSifra.getText() + " prodajni kurs iznosi " + textFieldProdajni.getText()
			+ " srednji kurs iznosi " + textFieldSrednji.getText()+ " kupovni kurs iznosi " + textFieldKupovni.getText();
			glavniProzor.textArea.setText(s);
			dispose();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(contentPane, e1.getMessage(),
					"Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
}
