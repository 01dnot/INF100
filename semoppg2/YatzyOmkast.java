package semesteroppg_2;

import java.util.Scanner;

public class YatzyOmkast {

	public static Scanner inn = new Scanner(System.in);

	public static void main(String[] args) {
		final String FEIL_MELDING = "Ugyldig verdi. Programmet avsluttes.";
		final int ANTALL_RUNDER = 5;
		final int ANTALL_KAST = 5;
		int[] terningVerdier = new int[ANTALL_KAST];
		int[] poengVerdier = new int[ANTALL_RUNDER];

		for(int i = 0; i<ANTALL_RUNDER; i++) {
			System.out.println("Runde " + (i+1));
			for(int j = 0; j<ANTALL_KAST; j++) {
				terningVerdier[j] = terningkast();
				System.out.println("Terning " + (j+1) +": " + terningVerdier[j]);
			} 
			int valg;
			for(int k=0; k<2; k++) {
				System.out.println("Omkast " + (k+1) + ". Skriv terningnummer (1-5) for aa kaste om, eller 0 for aa beholde terningene som de er:");
				if(!inn.hasNextInt()) {
					System.out.println(FEIL_MELDING);
					return;
				}
				valg = inn.nextInt();
				if(valg<0 || valg>5) {
					System.out.println(FEIL_MELDING);
					return;
				}
				if(valg==0) {
					break;
				}
				omkast(terningVerdier, valg);
			}
			poengVerdier[i] = poengForTerninger(terningVerdier);
			System.out.println("Poeng: " + poengVerdier[i]);	
		}
		skrivUtTotal(poengVerdier);
	}
	private static int terningkast() { // Metode som returnerer verdier mellom 1 og 6 
		int terningVerdi = (int)(6*Math.random()+1);
		return terningVerdi;
	}
	private static int poengForTerninger(int[] terningVerdier) {   // Metode som regner ut totalt poeng for alle terninger og returnerer den hoeyeste.
		int poengUtfall = 6;
		int[] midlPoengListe = new int[poengUtfall];
		for(int i=1; i<=poengUtfall; i++) {
			int teller=0;
			for(int j=0; j<terningVerdier.length; j++) {
				if(terningVerdier[j]==i) {
					teller++;
				}
			}
			midlPoengListe[i-1] = teller*i;
		}
		return hoyestVerdi(midlPoengListe);
	}
	private static void skrivUtTotal(int[] poengVerdier) { // Metode som skriver ut sum av en tabell.
		int total = 0;
		for(int i=0; i<poengVerdier.length; i++) {
			total += poengVerdier[i];
		}	System.out.println("Poeng totalt: " + total);
	}
	private static int hoyestVerdi(int[] verdiTabell) { // Metode som returnerer hoeyeste verdi i en tabell
		int hoyesteVerdi = verdiTabell[0];
		for(int i=0; i<verdiTabell.length; i++) {
			if(verdiTabell[i]>hoyesteVerdi) {
				hoyesteVerdi = verdiTabell[i];
			}
		} return hoyesteVerdi;
	}
	private static void omkast(int[] terningVerdier, int valg) { // Metode som endrer en terning og skriver ut nyeste terningverdier.
		if(valg>0) {
			terningVerdier[(valg-1)] = terningkast();
			for(int j=0; j<terningVerdier.length; j++) {
				System.out.println("Terning " + (j+1) +": " + terningVerdier[j]);
			}
		} else { return; }
	}
}