package menjacnica;

import java.util.LinkedList;

public class Valuta {
	private String punNaziv;
	private String skrNaziv;
	private LinkedList<Kurs> kurs = new LinkedList<Kurs>();
	public String getPunNaziv() {
		return punNaziv;
	}
	public void setPunNaziv(String punNaziv) {
		if(punNaziv == null || punNaziv.isEmpty())
			throw new RuntimeException("Nepravilan unos za pun naziv valute");
		this.punNaziv = punNaziv;
	}
	public String getSkrNaziv() {
		return skrNaziv;
	}
	public void setSkrNaziv(String skrNaziv) {
		if(skrNaziv == null || skrNaziv.isEmpty())
			throw new RuntimeException("Nepravilan unos za skraceni naziv valute");
		this.skrNaziv = skrNaziv;
	}
	public LinkedList<Kurs> getKurs() {
		return kurs;
	}
	public void setKurs(Kurs k) {
		if(k == null)
			throw new RuntimeException("Nepravilan unos za kurs");
		this.kurs.add(k);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((punNaziv == null) ? 0 : punNaziv.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Valuta))
			return false;
		Valuta other = (Valuta) obj;
		if (punNaziv == null) {
			if (other.punNaziv != null)
				return false;
		} else if (!punNaziv.equals(other.punNaziv))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Valuta [punNaziv=" + punNaziv + ", skrNaziv=" + skrNaziv + ", kurs=" + kurs + "]";
	}
	
}
