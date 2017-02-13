import java.util.Scanner;
public class HoeydeMeterFot {

	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);
		System.out.println("Hva heter du?");
		final String NAVN = inn.nextLine();
		System.out.println("Skriv 1 for aa konvertere fra metriske enheter til imperiske. Skriv 2 for aa konvertere fra imperiske enheter til metriske:");
		
		final double FOTENHET = 3.2808399;
	    final String FEIL_MELDING = "Ugyldig valg";
		
	    if(inn.hasNextInt()) {
	    	final int VALG = inn.nextInt();
	    	
	    	if(VALG==1) {
				System.out.println("Oppgi hoeyde i meter:");
				if(inn.hasNextDouble()) {
					double meter = inn.nextDouble();
					double omgjortmf = meter*FOTENHET;
					System.out.println("Hei " + NAVN + "! " + "Din hoeyde er " + omgjortmf + " fot.");
				} else {
					System.out.println(FEIL_MELDING);
				}
	    	}
				
	    	else if(VALG==2) {
				System.out.println("Oppgi hoeyde i fot:");
				if(inn.hasNextDouble()) {
					double FOT = inn.nextDouble();
					double omgjortfm = FOT/FOTENHET;
					System.out.println("Hei " + NAVN + "!" + "Din hoeyde er" + omgjortfm + " meter.");
				} else {
					System.out.println(FEIL_MELDING);
				}
	    	
	    	
			} else {
				System.out.println(FEIL_MELDING);
			}
		
		} else {
			System.out.println(FEIL_MELDING);
	
		}
	
		
	
	
	}

}
