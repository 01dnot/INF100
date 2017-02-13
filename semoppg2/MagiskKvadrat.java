package semesteroppg_2;
import java.util.Scanner;
public class MagiskKvadrat {
	public static Scanner inn = new Scanner(System.in);
	public static void main(String[] args) {

		final int N = 4;
		int[][] magiskKvadrat = new int[N][N]; 

		System.out.println("Fyll inn kvadratets verdier:");
		for(int rekke=0; rekke<N; rekke++) { //Fyller tabellen med tall
			for(int rad=0; rad<N; rad++) {
				System.out.println("Plass " + (rad+1) +", " + (rekke+1) + ":");
				magiskKvadrat[rekke][rad] = inn.nextInt();
			}
		}
		if(erMagiskKvadrat(magiskKvadrat)) {
			System.out.println("Dette er et magisk kvadrat.");
		}
		else {
			System.out.println("Dette er ikke et magisk kvadrat.");
		}
	}
	private static boolean erMagiskKvadrat(int[][] magiskKvadrat) {
		int N = magiskKvadrat.length;
		int sumRekke[] = new int[N];
		int sumRad[] = new int[N];
		int sumDiagonalEn = 0;
		int sumDiagonalTo = 0;
		int magiskKvadratSum = (N*(1+(N*N))/2); //Finner summen alle rekker rader og diagonaler maa ha.
		boolean riktigeSummer = false;

		for(int rekke=0; rekke<N; rekke++) { //Lagrer summen av rekker og rader i nye tabeller.
			for(int rad=0; rad<N; rad++) {
				sumRad[rekke] += magiskKvadrat[rekke][rad];
				sumRekke[rad] += magiskKvadrat[rekke][rad];
			} 	
			sumDiagonalEn += magiskKvadrat[rekke][rekke]; //Summerer diagonalene
			sumDiagonalTo += magiskKvadrat[rekke][N-rekke-1];
		}
		int antallRiktig = 0; // Teller opp antall rekker og rader med riktig sum.
		for(int i=0; i<N; i++) {
			if(sumRad[i]==magiskKvadratSum && sumRekke[i]==magiskKvadratSum) {
				antallRiktig++;
			}
		}
		if(antallRiktig==N && sumDiagonalEn==magiskKvadratSum && sumDiagonalTo==magiskKvadratSum) {
			riktigeSummer = true;
		}
		//Sjekker om alle tall er med i kvadratet
		boolean alleTall = false;
		boolean funnetTall;
		for(int nummer=1; nummer<=(magiskKvadrat.length*magiskKvadrat.length); nummer++) {
			funnetTall = false; 
			for(int rekke=0; rekke<magiskKvadrat.length && funnetTall==false; rekke++) {
				for(int rad=0; rad<magiskKvadrat.length; rad++) {
					if(magiskKvadrat[rekke][rad]==nummer) {
						funnetTall=true;
						break;
					}
				}
			} if(funnetTall==true) { alleTall=true; }
		} 
		if(alleTall && riktigeSummer) {
			return true;
		}
		return false;
	} 
}