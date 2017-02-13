package semesteroppg_3;
//Bruker metodene fra de forrige klasse, ettersom de er identiske. Maa endres til riktig pakke:
import static semesteroppg_3.LabyrintSkattejakt.*;
import static semesteroppg_3.LabyrintVandring.*;
import java.util.Scanner;

public class LabyrintMonstre {
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
			if(hentTegn(labyrint, nyPosisjon) == 'm') { 
				funnetGull = monsterKamp(funnetGull);
				if(funnetGull<0) {
					System.out.println("Du er tom for gull. Monsteret spiste deg. Spillet avslutter");
					return;
				}
			}
			funnetGull += hentTegn(labyrint, nyPosisjon) == 'g' ? 1 : 0;
			labyrint[spillerPosisjon.hentY()][spillerPosisjon.hentX()] = ' ';
			spillerPosisjon = nyPosisjon;
		} while(merGull(labyrint));
		System.out.println("Du tok alt gullet i labyrinten!");
		System.out.println("Spiller-gull: " + funnetGull);
	}
	public static int terningkast() { //Genererer tall fra 1 til 6
		return (int)(Math.random()*6+1);
	}
	public static int monsterKamp(int funnetGull) { //Starter terningspill
		System.out.println("Et monster blokkerer veien din, og utfordrer deg til aa kaste hoeyeste terning.");
		do {
			System.out.println("Du og monsteret kaster terninger.");
			int dinVerdi = terningkast();
			int monsterVerdi = terningkast();
			System.out.println("Ditt kast: " + dinVerdi);
			System.out.println("Monsterets kast: " + monsterVerdi);
			if(dinVerdi>monsterVerdi) {
				System.out.println("Du kastet hoeyere enn monsteret, saa monsteret ga opp.");
				return funnetGull;
			}
			if(dinVerdi<monsterVerdi) {
				System.out.println("Monsteret kastet hoeyere enn deg.");
				funnetGull--;
				if(funnetGull<0) {
					return funnetGull;
				}
				System.out.println("Du brukte 1 gull til aa bestikke monsteret til aa ta en omkamp.");
			}
			if(dinVerdi==monsterVerdi) {
				System.out.println("Det ble uavgjort. Dere spiller paa nytt:");
			} 
		} while(true);
	} 
}	