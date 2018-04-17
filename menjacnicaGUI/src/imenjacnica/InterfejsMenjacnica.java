package imenjacnica;

import java.util.GregorianCalendar;

import menjacnica.Kurs;

public interface InterfejsMenjacnica {
	public void dodajKurs(String naziv,GregorianCalendar datum, double prodajni, double srednji, double kupovni);
	public void brisanjeKursa(String naziv,GregorianCalendar datum, double prodajni, double srednji, double kupovni);
	public Kurs pronadjiKurs(String naziv, GregorianCalendar datum);
}
