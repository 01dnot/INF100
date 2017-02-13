package oving6;

public class Utlaan {
	private Bok bok;
	private String navn;

	public Utlaan(Bok bok, String navn) {
		settBok(bok);
		settNavn(navn);
	}

	public Bok hentBok() {
		return bok;
	}
	public String hentNavn() {
		return navn;
	}
	public void settBok(Bok bok) {
		this.bok = bok;
	}
	public void settNavn(String navn) {
		this.navn = navn;
	}
	public String toString() {
		return "Utlaan[utlaantBok=" + bok + ",laanersnavn=" + navn + "]";
	}
}
