package semesteroppg_3;

import java.util.Scanner;
public class Postsystem {
	public static Scanner console = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Hvor mange postpakker skal registreres?");
		int antallPakker = console.nextInt();
		console.nextLine(); //Toemmer bufferen
		Postpakke[] pakkeTabell = new Postpakke[antallPakker];
		for(int i=0; i<antallPakker; i++) { //Registrer pakker
			System.out.println("Pakke " + (i+1));
			System.out.println("Oppgi mottakerens navn:");
			String navn = console.nextLine();
			System.out.println("Oppgi mottakerens addresse:");
			String adresse = console.nextLine();
			System.out.println("Oppgi mottakerens postnummer:");
			int postNummer = console.nextInt();
			System.out.println("Oppgi pakkens vekt:");
			double pakkeVekt = console.nextDouble();
			console.nextLine(); //Toemmer bufferen
			pakkeTabell[i]  = new Postpakke(navn, adresse, postNummer, pakkeVekt);
		}
		console.close();
		for(int i=0; i<antallPakker; i++) { //Skriver ut pakker
			System.out.println("Pakke " + (i+1));
			System.out.println("Mottakers navn: "+ pakkeTabell[i].hentNavn());
			System.out.println("Mottakers addresse: " + pakkeTabell[i].hentAdresse());
			System.out.println("Mottakers postnummer: " + pakkeTabell[i].hentPostNummer());
			System.out.println("Pakkens vekt: " + pakkeTabell[i].hentPakkeVekt());
		}
	}
}
