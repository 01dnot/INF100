package semesteroppg_3;

import java.util.Scanner;

public class LabyrintVandring {	
	public static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {	
		final String VALG_MELDING = "Hvor vil du gaa? Skriv nord, soer, vest eller oest for aa gaa i respektiv retning, eller avslutt for aa avslutte.";
		char[][] labyrint = {
				{'*', '*', '*', '*'},
				{'*', ' ', ' ', '*'},
				{'*', ' ', '*', '*'},
				{'*', 's', '*', '*'},
				{'*', '*', '*', '*'},
		};
		Posisjon spillerPosisjon = finnPosisjon(labyrint);
		do{
			skrivLabyrint(labyrint, spillerPosisjon);
			System.out.println(VALG_MELDING);
			String valg = console.nextLine();
			if(valg.equals("avslutt")) {
				return;
			}
			Posisjon nyPosisjon = hentNyPosisjon(labyrint, valg, spillerPosisjon);
			if(nyPosisjon == null) {
				System.out.println("Ikke gyldig valg, proev igjen");
				continue;
			}
			if(!kanGaaTil(labyrint, nyPosisjon)) {
				System.out.println("Veien er blokkert! Proev igjen.");
				continue;
			}
			labyrint[spillerPosisjon.hentY()][spillerPosisjon.hentX()] = ' ';
			spillerPosisjon = nyPosisjon;
		} while(true);
	}
	public static void skrivLabyrint(char[][] labyrint, Posisjon spillerP) { //Skriver ut labyrint
		for(int y=0; y<labyrint.length; y++) {
			for(int x=0; x<labyrint[0].length; x++) {
				if(y==spillerP.hentY() && x==spillerP.hentX()) {
					System.out.print('s' + " ");
				} else {
					System.out.print(labyrint[y][x] + " ");
				}
			}
			System.out.println();
		}
	}
	public static Posisjon finnPosisjon(char[][] labyrint) { //Finner posisjon til s
		for(int y=0; y<labyrint.length; y++) {
			for(int x=0; x<labyrint[0].length; x++) {
				if(labyrint[y][x]=='s') { //s blir til mellomrom i main foeste gang man flytter seg
					return new Posisjon(x,y);
				}
			}
		}
		throw new IllegalStateException("Brettet hadde ingen spiller!");
	}
	public static Posisjon hentNyPosisjon(char[][] labyrint, String valg, Posisjon spillerP) { //Finner ny posisjon til s mhp valg
		int x = spillerP.hentX(), y = spillerP.hentY();
		switch(valg) {
		case "nord": y--; break;
		case "soer": y++; break;
		case "vest": x--; break;
		case "oest": x++; break;
		default: return null;
		}
		return new Posisjon(x,y);
	}
	public static boolean kanGaaTil(char[][] labyrint, Posisjon p) {
		return labyrint[p.hentY()][p.hentX()] != '*';
	}
}