package oving4;
import java.util.Scanner;
public class Tabellstatistikk {
	
	private static Scanner inn = new Scanner(System.in);
	
	public static void main(String[] args) {
		final String FEIL_MELDING = "Feil!  Antall verdier maa vaere minst 1.:";
				
		System.out.println("Hvor mange verdier skal leses inn?:");
		int antallVerdier = hentTall(FEIL_MELDING, 1, Integer.MAX_VALUE);
		double[] tabell = new double[antallVerdier]; //Oppretter og gir verdier til tabellen
		for(int i =0; i<antallVerdier; i++) {
			System.out.println("Oppgi verdi " + (i+1) + ":");
			tabell[i] = inn.nextInt();
		}
		System.out.println("Tabell:"); //Skriver ut tabellen
		for(int i = 0; i<antallVerdier; i++) {
			System.out.println(tabell[i]);
		}
		System.out.println("Snitt: " + snitt(tabell));
		System.out.println("Varians: " + varians(tabell));
		System.out.println("Standardavvik: " + standardavvik(tabell));
		
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
	private static double snitt(double[] tabell)  {
		double sumTabell = 0;
		for(int i = 0; i<tabell.length; i++) {
			sumTabell += tabell[i];
			
		}
		return sumTabell/tabell.length;
	}
	private static double varians(double[] tabell) {
		double snitt = snitt(tabell);
		double varians = 0;
		for(int i = 0; i<tabell.length; i++) {
			varians += Math.pow((tabell[i]-snitt),2);
		} 	
		varians /= tabell.length;
		return varians;
	}
	private static double standardavvik(double[] tabell) {
		double varians = varians(tabell);
		double standardavvik = Math.sqrt(varians);
		return standardavvik;
	}
}
