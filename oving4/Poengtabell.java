package oving4;
import java.util.Scanner;
public class Poengtabell {

	private static Scanner inn = new Scanner(System.in);

	public static void main(String[] args) {
		final String FEIL_MELDING_DELTAKERE = "Feil!  Antall deltakere maa vaere minst 1.";

		System.out.println("Oppgi antall deltakere:");
		int antallDeltakere = hentTall(FEIL_MELDING_DELTAKERE, 1, Integer.MAX_VALUE);
		String[] navn = new String[antallDeltakere];
		int[] poeng = new int[antallDeltakere];

		for(int i=0; i<antallDeltakere; i++) {
			System.out.println("Oppgi navn paa deltaker " + (i+1) + ":");
			navn[i] = inn.nextLine();
			System.out.println("Oppgi score til " + navn[i] + " (heltall):");
			poeng[i] = inn.nextInt();
			inn.nextLine(); // Toemmer bufferen
		}
		skrivUtNavnOgPoeng(navn, poeng);
	}

	private static void skrivUtNavnOgPoeng(String[] navn, int[] poeng) {
		System.out.println("Deltakere og scores:");
		for(int i=0; i<navn.length; i++) {
			System.out.printf("%10s " ,navn[i]);
			for(int j=0; j<poeng[i]; j++) {
				System.out.print("|");
			}
			System.out.print(" ("+ poeng[i] + ")");
			System.out.println();
		}
	}

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
				inn.nextLine(); // Toemmer bufferen
				return verdi;
			}
		} while(true);
	}
}
