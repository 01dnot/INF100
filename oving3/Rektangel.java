import java.util.Scanner;

public class Rektangel {

	public static void main(String[] args) {

		Scanner inn = new Scanner(System.in);
		
		System.out.println("Oppgi hoeyde (minst 1):");
		if(inn.hasNextInt()) {
			int hoeyde = inn.nextInt();
			if(hoeyde>=1) {
				System.out.println("Oppgi bredde (minst 1):");
				if(inn.hasNextInt()) {
					int bredde = inn.nextInt();
						if(bredde>=1) {
							// Skriver ut rektangelet
							for(int tellerhoeyde = 1; tellerhoeyde<=hoeyde; tellerhoeyde++ ) {
								for(int tellerbredde = 1; tellerbredde<=bredde; tellerbredde++) {
								System.out.print("* ");
								} 
								System.out.println();
						}
					
					} else {
						System.out.println("Feil!  Bredde maa minst vaere lik 1.");
					}
						
					
				} else {
					System.out.println("Feil!  Bredde maa vaere ett tall.");
				}
			} else {
				System.out.println("Feil!  Hoeyde maa minst vaere lik 1.");
			}
		
		} else { 
			System.out.println("Feil!  Hoeyde maa vaere ett tall.");
		}
	}

}
