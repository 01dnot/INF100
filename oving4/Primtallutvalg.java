package oving4;
import java.util.Scanner;
public class Primtallutvalg {
	private static Scanner inn = new Scanner(System.in);

	public static void main(String[] args) {
		final String FEIL_MELDING = "Feil!  Antall verdier maa vaere minst 1. Proev paa nytt:";

		System.out.println("Hvor mange verdier skal leses inn?:");
		int antallVerdier = hentTall(FEIL_MELDING, 1, Integer.MAX_VALUE);

		//Lager og setter inn verdier i tabellen.
		int[] verdiTabell = new int[antallVerdier];
		for(int i = 0; i<antallVerdier; i++) {
			System.out.println("Oppgi verdi " + (i+1) + ":");
			verdiTabell[i] = inn.nextInt();
		}
		//Oppretter nye tabeller og setter inn verdier fra gamle tabell
		int[] primtallTabell = new int[antallVerdier];
		int[] andreTallTabell = new int[antallVerdier];
		int primtallPeker = 0;
		int andreTallPeker = 0;
		for(int i=0; i<antallVerdier; i++) {
			if(erPrimtall(verdiTabell[i])) {
				primtallTabell[primtallPeker++] = verdiTabell[i];
			} else {
				andreTallTabell[andreTallPeker++] = verdiTabell[i];
			}
		}
		//Skriver ut de 2 tabellene
		System.out.println("Primtall:");
		for(int i=0; i<primtallPeker; i++) {
			System.out.println(primtallTabell[i]);
		}
		System.out.println("Andre Tall:");
		for(int i=0; i<andreTallPeker; i++) {
			System.out.println(andreTallTabell[i]);
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

	private static boolean erPrimtall(int x) {
		for(int y = 2; y<x; y++) {
			if(x%y==0) {
				return false;
			}
		} return true;

	}
}
