package semeteroppg1;
import java.util.Scanner;

public class Romertall {

	public static void main(String[] args) {

		Scanner inn = new Scanner(System.in);

		System.out.println("Oppgi romertall:");
		String romerTall = inn.next().toUpperCase(); // Fungerer for baade store og smaa bokstaver
		System.out.println("Verdien i desimaltall er: " + konverterFraRomertall(romerTall));

	}

	//Metode som tar inn tekststreng, henter opp metoden romertallTegnVerdi og returnerer summen av romertallene i strengen
	private static int konverterFraRomertall(String romerTall) {
		int totalt = 0; 

		while(romerTall.length()>=1) {
			//if setninger som foelger av psuedokoden i boken etter reglene for romertall.
			if(romerTall.length()==1) {
				totalt += romertallTegnVerdi(romerTall.charAt(0));
				romerTall = romerTall.substring(1);
			} else if(romertallTegnVerdi(romerTall.charAt(0))>=romertallTegnVerdi(romerTall.charAt(1))) {
				totalt += romertallTegnVerdi(romerTall.charAt(0));
				romerTall = romerTall.substring(1);
			} else {
				totalt += romertallTegnVerdi(romerTall.charAt(1))-romertallTegnVerdi(romerTall.charAt(0));
				romerTall = romerTall.substring(2);
			}		
		} 
		return totalt;
	}

	// Konverterer romertall til tall
	private static int romertallTegnVerdi(Character romertall) {
		switch(romertall) {
		case 'I': 
			return 1;
		case 'V':
			return 5; 
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default: // Dersom ikke romertall
			return 0;
		}
	}


}










