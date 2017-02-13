package semesteroppg_2;

import java.util.Scanner;

public class YatzyEnkel {


	public static Scanner inn = new Scanner(System.in);

	public static void main(String[] args) {
		final int ANTALL_RUNDER = 5;
		final int ANTALL_KAST = 5;
		int[] terningVerdier = new int[ANTALL_KAST];
		int[] poengVerdier = new int[ANTALL_RUNDER];

		for(int i=0; i<ANTALL_RUNDER; i++) {
			System.out.println("Runde " + (i+1));
			for(int j=0; j<ANTALL_KAST; j++) {
				terningVerdier[j] = terningkast();
				System.out.println("Terning " + (j+1) +": " + terningVerdier[j]);
			} 
			poengVerdier[i] = poengForTerninger(terningVerdier);
			System.out.println("Poeng: " + poengVerdier[i]);	
		}
		skrivUtTotal(poengVerdier);
	}
	public static int terningkast() { // Metode som returnerer verdier mellom 1 og 6 a
		int terningVerdi = (int)(6*Math.random()+1);
		return terningVerdi;
	}
	public static int poengForTerninger(int[] terningVerdier) { // Metode som regner ut totalt poeng for alle terninger og returnerer den hoeyeste.
		int poengUtfall = 6;
		int[] midlPoengListe = new int[poengUtfall];
		for(int i=1; i<=poengUtfall; i++) {
			int teller = 0;
			for(int j=0; j<terningVerdier.length; j++) {
				if(terningVerdier[j]==i) {
					teller++;
				}
			}
			midlPoengListe[i-1] = teller*i;
		}
		return hoyestVerdi(midlPoengListe);
	}
	public static void skrivUtTotal(int[] poengVerdier) { // Metode som skriver ut sum av en tabell
		int total = 0;
		for(int i=0; i<poengVerdier.length; i++) {
			total += poengVerdier[i];
		}	System.out.println("Poeng totalt: " + total);
	}
	public static int hoyestVerdi(int[] verdiTabell) { // Metode som returnerer hoeyeste verdi i en tabell
		int hoyesteVerdi = verdiTabell[0];
		for(int i=0; i<verdiTabell.length; i++) {
			if(verdiTabell[i]>hoyesteVerdi) {
				hoyesteVerdi = verdiTabell[i];
			}
		} return hoyesteVerdi;
	}
}