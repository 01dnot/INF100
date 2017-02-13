package semeteroppg1;

import java.util.Scanner;

public class Fyltsirkel {

	public static void main(String[] args) {

		Scanner inn = new Scanner(System.in);
		final String FEIL_MELDING = "Feil!  Radius maa vaere minst 1.";

		System.out.println("Oppgi radius (minst 1):");

		//Initierer radius og skriver ut feilmelding om feil brukerinput
		if(!inn.hasNextInt()) {
			System.out.println(FEIL_MELDING);
			return;
		} 
		int radius = inn.nextInt();

		if(radius<1) {
			System.out.println(FEIL_MELDING);
			return;
		}

		skrivUtSirkel(radius);

	}

	//Metode som tar inn radius og printer ut en sirkel. Gjoeres via to for loekker som danner ett kordinatsystem.
	private static void skrivUtSirkel(int radius) {
		for(int y = -radius; y<radius+1; y++) {
			for(int x = -radius; x<radius+1; x++) {
				//if setningen bestemmer om x og y er innenfor sirkelomraadet og skriver deretter enten ut "  " eller "**"
				if(y*y+x*x<=(radius+0.3)*(radius+0.3)) {
					System.out.print("**");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

}
