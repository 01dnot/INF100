package oving6;

public class Bok implements Comparable<Bok> {
	private String isbn;
	private String forfatterNavn;
	private String bokTittel;
	private int antallEksemplarer;
	private int antallUtlaant = 0;

	public Bok(String isbn, String forfatterNavn, String bokTittel, int antallEksemplarer) {
		settIsbn(isbn);
		settForfatterNavn(forfatterNavn);
		settBokTittel(bokTittel);
		settAntallEksemplarer(antallEksemplarer);
	}

	public String hentIsbn() {
		return isbn;
	}
	public String hentForfatterNavn() {
		return forfatterNavn;
	}
	public String hentBokTittel() {
		return bokTittel;
	}
	public int hentAntallEksemplarer() {
		return antallEksemplarer;
	}
	public int hentAntallUtlaant() {
		return antallUtlaant;
	}
	public void settIsbn(String isbn) {
		if (isbn == null) {
			IllegalArgumentException unntak
			= new IllegalArgumentException(
					"ISBN kan ikkje vera null.");
			throw unntak;
		}
		this.isbn = isbn;
	}
	public void settForfatterNavn(String forfatterNavn) {
		if (forfatterNavn == null) {
			IllegalArgumentException unntak
			= new IllegalArgumentException(
					"Forfatternavn kan ikkje vera null.");
			throw unntak;
		}
		this.forfatterNavn = forfatterNavn;
	}
	public void settBokTittel(String bokTittel) {
		if (bokTittel == null) {
			IllegalArgumentException unntak
			= new IllegalArgumentException(
					"Boktittel kan ikkje vera null.");
			throw unntak;
		}
		this.bokTittel = bokTittel;
	}
	public void settAntallEksemplarer(int antallEksemplarer) {
		if (antallEksemplarer < 1) {
			IllegalArgumentException unntak
			= new IllegalArgumentException(
					"Antall eksemplarer kan ikkje vera mindre enn 1.");
			throw unntak;
		}
		this.antallEksemplarer = antallEksemplarer;
	}
	public void settAntallUtlaant(int antallUtlaant) {
		this.antallUtlaant += antallUtlaant;
	}
	public String toString() {
		return "Bok[ISBN=" + isbn + ",forfatterNavn=" + 
				forfatterNavn + ",bokTittel=" + bokTittel + ",antallEksemplarer=" + antallEksemplarer + ",antallUtlaant=" + antallUtlaant + "]";
	}
	public int compareTo(Bok bok) {
		int i = forfatterNavn.compareTo(bok.hentForfatterNavn());
		if(i!=0) {
			return i;
		} else {
			int j = bokTittel.compareTo(bok.hentBokTittel());
			if(j!=0) {
				return j;
			} else {
				return isbn.compareTo(bok.hentIsbn());
			}
		}
	}
}