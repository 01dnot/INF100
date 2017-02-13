import java.util.Scanner;

public class ToStoersteTall {

	public static void main(String[] args) {

		Scanner inn = new Scanner(System.in);
		
		final String FEIL_MELDING = "Ugyldig verdi!";
		int antall;
		int nestStoerstVerdi = Integer.MIN_VALUE;
		int stoerstVerdi = Integer.MIN_VALUE;
		int verdi = 0;
		
		System.out.println("Hvor mange tall skal leses inn (minst 2)?:");
		if (inn.hasNextInt()) {
			int antallTall = inn.nextInt();
			inn.nextLine(); // Toemmer bufferen i tilfelle noe mer ligger etter mellom
			if (antallTall>=2) {
				for (antall = 1; antall<=antallTall; antall++ ) {
					System.out.println("Oppgi verdi " + antall + ":");
					if (inn.hasNextInt()) {
						    verdi = inn.nextInt();
						if (verdi >= stoerstVerdi) {
							nestStoerstVerdi = stoerstVerdi;
							stoerstVerdi = verdi ;
						} else if (verdi >= nestStoerstVerdi) {
							nestStoerstVerdi = verdi;
						}
						inn.nextLine(); // Toemmer bufferen
					} else {
						System.out.println(FEIL_MELDING); 
						inn.nextLine(); // Toemmer bufferen
						antall--;
					}
				} System.out.println("størst" + stoerstVerdi + "nest" + nestStoerstVerdi);
					
					
				} else {
					System.out.println(FEIL_MELDING);
			} 
				} else {
				System.out.println(FEIL_MELDING);
			}
					
			
		} 
		
	}

