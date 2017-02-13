package semeteroppg1;

import java.util.Scanner;

public class TerningSimulering {

	private static Scanner inn = new Scanner(System.in);

	public static void main(String[] args) {

		final String FEIL_VERDI = "Angi bare heltall fra 1 til 6:";
		final String FEIL_ANTALL = "Angi kun positivt heltall:";

		// Henter tall fra brukeren mellom 1 og 6
		System.out.println("Oppgi verdien som terningens verdi skal vaere hoeyere eller lik (heltall fra 1 til 6):");		
		int verdi = hentTall(FEIL_VERDI, 1, 6);

		// Henter antall terningkast fra brukeren - tallet skal vaere positivt
		System.out.println("Oppgi antall terningkast (positivt heltall):");
		int antallKast = hentTall(FEIL_ANTALL, 0, Integer.MAX_VALUE);

		// Kaster terningen og taller opp antall suksesser
		int antallSuksess = 0;
		for(int kast = 1; antallKast >= kast; kast++) {
			//Genererer ett tilfeldig heltall mellom 1 og 6.
			int tilfeldigTall = (int) (1 + 6 * Math.random());
			if(tilfeldigTall>=verdi) {
				antallSuksess++;
			}
		}

		// Printer ut resultatet
		System.out.println("Terningens verdi var stoerre eller lik " + verdi + " " + antallSuksess + " av " + antallKast + " ganger." 
				+ "\np(v)>=" + verdi + ")  = " + (double)antallSuksess/antallKast);

	}

	//Henter tall fra bruker og skriver evt ut passende feilmelding.
	private static int hentTall(String feilMelding, int min, int max) {
		do {
			if(!inn.hasNextInt()) {
				System.out.println(feilMelding);
				inn.next();
				continue;
			} 
			int verdi = inn.nextInt();

			if(verdi<min || verdi>max) {
				System.out.println(feilMelding);
			} else {
				return verdi;
			}
		} while(true);


	}

}
