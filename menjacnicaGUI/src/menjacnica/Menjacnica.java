package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import imenjacnica.InterfejsMenjacnica;

public class Menjacnica implements InterfejsMenjacnica {

	private LinkedList<Valuta> v = new LinkedList<Valuta>();

	@Override
	public Kurs pronadjiKurs(String naziv, GregorianCalendar datum) {
		for (int i = 0; i < v.size(); i++) {
			if(v.get(i).getPunNaziv().equals(naziv))
				for (int j = 0; j < v.get(i).getKurs().size(); j++) {
					if(v.get(i).getKurs().get(i).getDatum().equals(datum))
						return v.get(i).getKurs().get(j);
				}
		
		}
		throw new RuntimeException("Kurs nije u listi");
	}

	@Override
	public void dodajKurs(String naziv, GregorianCalendar datum, double prodajni, double srednji, double kupovni) {
		Kurs k1 = new Kurs();
		k1.setDatum(datum);
		k1.setKupovni(kupovni);
		k1.setProdajni(prodajni);
		k1.setSrednji(srednji);
		for (int i = 0; i < v.size(); i++) {
			if(v.get(i).getPunNaziv().equals(naziv)) {
				v.get(i).setKurs(k1);
				return;
			}
		}
		
	}

	@Override
	public void brisanjeKursa(String naziv, GregorianCalendar datum, double prodajni, double srednji, double kupovni) {
		Kurs k1 = new Kurs();
		k1.setDatum(datum);
		k1.setKupovni(kupovni);
		k1.setProdajni(prodajni);
		k1.setSrednji(srednji);
		for (int i = 0; i < v.size(); i++) {
			if(v.get(i).getPunNaziv().equals(naziv) )
				for (int j = 0; j < v.get(i).getKurs().size(); j++) {
					if(v.get(i).getKurs().get(j).getDatum().equals(datum))
						v.get(i).getKurs().remove(j);
				}
				
		}
		
	}

}
