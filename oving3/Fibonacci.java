import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);

		System.out.println("Oppgi hoeyeste tall som Fibonacci-tall kan vaere likt:");
		if(inn.hasNextInt()) {
			int hoyestetall = inn.nextInt();
			if(hoyestetall>=0) {

				// Fibonacci-utregningen
				int fibonacci = 0;
				int forrigeFibonacci = 1;

				int teller = 0;
				while (fibonacci <= hoyestetall) {
					System.out.println("Fibonacci-tall " + teller++ + " = " + fibonacci);
					int hoyestefib = fibonacci; 
					fibonacci += forrigeFibonacci; 
					forrigeFibonacci = hoyestefib;
				}

			} 
			else 
				System.out.println("Feil!  Maks-verdi maa minst vaere lik null.");

		} else 
			System.out.println("Feil!  Maa vaere tallverdi.");

	}

}
