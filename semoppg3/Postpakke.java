package semesteroppg_3;
//Klasse for pakker i oppgave 2.
public class Postpakke {
	private String navn;
	private String adresse;
	private int postNummer;
	private double pakkeVekt;

	public Postpakke(String pNavn, String pAdresse, int pPostNummer, double pPakkeVekt) {
		navn = pNavn;
		adresse = pAdresse;
		postNummer = pPostNummer;
		pakkeVekt = pPakkeVekt;
	}
	public String hentNavn() {
		return navn;
	}
	public String hentAdresse() {
		return adresse;
	}
	public int hentPostNummer() {
		return postNummer;
	}
	public double hentPakkeVekt() {
		return pakkeVekt;
	}	
}
