package semesteroppg_2;

import java.util.Scanner;

public class YatzyToSpiller {

	public static Scanner inn = new Scanner(System.in);
	public static void main(String[] args) {

		final String FEIL_MELDING = "Ugyldig verdi. Programmet avsluttes.";
		final int ANTALL_RUNDER = 5;
		final int ANTALL_KAST = 5;
		final int ANTALL_SPILLERE = 2;
		int[][] terningVerdier = new int[ANTALL_KAST][ANTALL_KAST];
		int[][] poengVerdier = new int[ANTALL_RUNDER][ANTALL_RUNDER];
		String[] spillerNavn = new String[ANTALL_SPILLERE];

		for(int i=0; i<ANTALL_SPILLERE; i++) {
			System.out.println("Oppgi navnet til spiller " + (i+1) +":");
			spillerNavn[i] = inn.nextLine();
		}
		for(int i=0; i<ANTALL_RUNDER; i++) {
			for(int j=0; j<ANTALL_SPILLERE; j++) {
				System.out.println("Runde " + (i+1));
				System.out.println("Det er " + spillerNavn[j] + " sin tur.");
				for(int k = 0; k<ANTALL_KAST; k++) {
					terningVerdier[k][j] = terningkast();
					System.out.println("Terning " + (k+1) +": " + terningVerdier[k][j]);
				} 
				int valg; 
				for(int l=0; l<2; l++) {
					System.out.println("Omkast " + (l+1) + ". Skriv terningnummer (1-5) for aa kaste om, eller 0 for aa beholde terningene som de er:");
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
					omkast(terningVerdier, j, valg);
				}
				poengVerdier[i][j] = poengForTerninger(terningVerdier, j);
				System.out.println("Poeng: " + poengVerdier[i][j]);	
			}
		}
		for(int j=0; j<ANTALL_SPILLERE; j++) {
			System.out.println(spillerNavn[j] + " har " + totaltPoeng(poengVerdier, j) + " poeng.");
		}
		if(totaltPoeng(poengVerdier, 0)>totaltPoeng(poengVerdier, 1)) { // 0 og 1 henviser til radaene for spiller 1 eller spiller 2
			System.out.println(spillerNavn[0] + " vant.");
		} else if (totaltPoeng(poengVerdier, 0)<totaltPoeng(poengVerdier, 1)) {
			System.out.println(spillerNavn[1] + " vant.");
		} else {
			System.out.println("Uavgjort.");
		}
	}
	private static int terningkast() { // Metode som returnerer verdier mellom 1 og 6 
		int terningVerdi = (int)(6*Math.random()+1);
		return terningVerdi;
	}
	private static int poengForTerninger(int[][] terningVerdier, int j) {  // Metode som regner ut totalt poeng for alle terninger og returnerer den hoeyeste.
		int poengUtfall = 6;
		int[] midlPoengListe = new int[poengUtfall];
		for(int i=1; i<=poengUtfall; i++) {
			int teller=0;
			for(int k=0; k<terningVerdier.length; k++) {
				if(terningVerdier[k][j]==i) {
					teller++;
				}
			}
			midlPoengListe[i-1] = teller*i;
		}
		return hoyestVerdi(midlPoengListe);
	}
	private static int totaltPoeng(int[][] poengVerdier, int j) {  // Metode som returnerer sum av en bestemt tabellrad j.
		int total = 0;
		for(int i=0; i<poengVerdier.length; i++) {
			total += poengVerdier[i][j];
		}return total;
	}
	private static int hoyestVerdi(int[] verdiTabell) { // Metode som returnerer hoeyeste verdi i en tabell
		int hoyesteVerdi = verdiTabell[0];
		for(int i=0; i<verdiTabell.length; i++) {
			if(verdiTabell[i]>hoyesteVerdi) {
				hoyesteVerdi = verdiTabell[i];
			}
		} return hoyesteVerdi;
	}
	private static void omkast(int[][] terningVerdier, int j, int valg) { // Metode som endrer en terning og skriver ut nyeste terningverdier.
		if(valg>0) {
			terningVerdier[(valg-1)][j] = terningkast();
			for(int i=0; i<terningVerdier.length; i++) {
				System.out.println("Terning " + (i+1) +": " + terningVerdier[i][j]);
			}
		} else {
			return;
		}
	}

}
