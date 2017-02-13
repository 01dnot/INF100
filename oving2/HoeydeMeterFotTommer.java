import java.util.Scanner;

public class HoeydeMeterFotTommer {

	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);
		System.out.println("Hva heter du?");
		final String NAVN = inn.nextLine();
		System.out.println("Skriv 1 for aa konvertere fra metriske enheter til imperiske. Skriv 2 for aa konvertere fra imperiske enheter til metriske:");
		
		final double FOTENHET = 3.2808399;
	    final double TOMMERENHET = FOTENHET/12;
		final String FEIL_MELDING = "Ugyldig valg";
		
	    
	    if(inn.hasNextInt()) {
	    	final int VALG = inn.nextInt();
	    	
	    	if(VALG==1) {
				System.out.println("Oppgi hoeyde i meter:");
				if(inn.hasNextDouble()) {
					double meter = inn.nextDouble();
					double fot = FOTENHET*meter;
					double tommer = (fot%1)*12;
					
					System.out.println("Hei " + NAVN + "! " + "Din hoeyde er " + Math.round(fot) + " fot og " + Math.round(tommer) + " tommer.");
				} else {
					System.out.println(FEIL_MELDING);
				}
	    	}
				
	    	else if(VALG==2) {
				System.out.println("Oppgi hoeyde i fot:");
				if(inn.hasNextInt()) {
					int FOT = inn.nextInt();
					System.out.println("Oppgi hoeyde i tommer");
					if(inn.hasNextInt()) {
						int tommer = inn.nextInt();
						double omgjortfm = FOT/FOTENHET;
						double omgjorttm = tommer/TOMMERENHET;
						System.out.println("Hei " + NAVN + "! " + "Din hoeyde er " + (omgjortfm + omgjorttm) + " meter.");
					} else {
						System.out.println(FEIL_MELDING);
					}
					
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


