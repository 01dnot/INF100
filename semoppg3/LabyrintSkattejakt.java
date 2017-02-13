package semesteroppg_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static semesteroppg_3.LabyrintVandring.*; //Bruker metodene fra forrige klasse, ettersom de er identiske. Maa endres til riktig pakke:

public class LabyrintSkattejakt {
	public static Scanner console = new Scanner(System.in);
	public static void main(String[] args) {
		final String VALG_MELDING = "Hvor vil du gaa? Skriv nord, soer, vest eller oest for aa gaa i respektiv retning, eller avslutt for aa avslutte.";
		char[][] labyrint = lesLabyrintFraFil();
		if(labyrint==null) {
			return;
		}
		int funnetGull = 0;
		Posisjon spillerPosisjon = finnPosisjon(labyrint);
		do{
			System.out.println("Spiller-gull: " + funnetGull);
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
			funnetGull += hentTegn(labyrint, nyPosisjon)=='g' ? 1 : 0;
			labyrint[spillerPosisjon.hentY()][spillerPosisjon.hentX()] = ' ';
			spillerPosisjon = nyPosisjon;
		} while(merGull(labyrint));
		System.out.println("Du tok alt gullet i labyrinten!");
		System.out.println("Spiller-gull: " + funnetGull);
	}
	public static char[][] lesLabyrintFraFil() { //Leser labyrint og lagrer i chartabell.
		System.out.println("Oppgi filen som labyrinten skal leses fra:");
		String filNavn = console.nextLine();
		try(Scanner inn = new Scanner(new File(filNavn))) {
			int labyrintHoeyde, labyrintLengde;
			if(inn.hasNextInt()) {
				labyrintLengde = inn.nextInt();
			} else {
				System.out.println("Feil format paa tekstfil. Kunne ikke lese lengde");
				return null;
			}
			if(inn.hasNextInt()) {
				labyrintHoeyde = inn.nextInt();
			} else {
				System.out.println("Feil format paa tekstfil. Kunne ikke lese hoeyde");
				return null;
			}
			char[][] labyrint = new char[labyrintHoeyde][labyrintLengde];
			inn.nextLine(); //Hopper til neste linje.
			for(int i=0; i<labyrintHoeyde; i++) {
				if(!inn.hasNextLine()) {
					System.out.println("Feil format paa tekstfil. For faa linjer");
					return null;
				}
				String linje = inn.nextLine();
				if(linje.length() != labyrintLengde) {
					System.out.println("Feil format paa tekstfil. Feil antall tegn");
					return null;
				}
				labyrint[i] = linje.toCharArray();
			}
			return labyrint;
		} catch(FileNotFoundException unntak) {
			System.out.println("Finner ikke fil");
			return null;
		} 
	}
	public static boolean merGull(char[][] labyrint) { //Ser om det finnes mer gull i labyrint
		int gull = 0;
		for(int y=0; y<labyrint.length; y++) {
			for(int x=0; x<labyrint[0].length; x++) {
				if(labyrint[y][x]=='g') {
					gull++;
				}
			}
		}
		return gull>0;
	}
	public static char hentTegn(char[][] labyrint, Posisjon p) { //Henter tegn i en posisjon
		return labyrint[p.hentY()][p.hentX()];
	}
}	