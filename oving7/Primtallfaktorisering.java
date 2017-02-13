package oving7;

import java.util.Scanner;

public class Primtallfaktorisering {
	public static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Skriv et heltall stoerre enn 0:");
		if(!console.hasNextInt()) {
			System.out.println("Feil verdi");
			return;
		} 
		int heltall = console.nextInt();
		if(heltall<1) {
			System.out.println("Feil verdi");
			return;
		}
		System.out.println("Faktorer:");
		finnMinsteDivisor(heltall);
	}
	public static void finnMinsteDivisor(int v) {
		for (int i=2; i<=v; i++) {
			while (v % i == 0) { //Sjekker om v kan deles på i og evt deles tallet på i samt skriver ut i. 
				v /= i;
				System.out.println(i);
			}
		}
	}
}