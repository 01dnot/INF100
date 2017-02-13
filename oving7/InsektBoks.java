package oving7;

import java.util.Scanner;

public class InsektBoks {
	
	public static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Skriv antall insekter (minst 1):");
		if(!console.hasNextInt()) {
			System.out.println("Feil. Avslutter programmet");
			return;
		}
		int nInsekt = console.nextInt();
		if(nInsekt<1) {
			System.out.println("Feil. Avslutter programmet");
			return;
		}
		Insekt[] insektBoks = new Insekt[nInsekt];
		for(int i=0; i<nInsekt; i++) { //Genererer insekter med tilfeldige startposisjoner fra 0 til 20.
			insektBoks[i] = new Insekt(tilfeldigTall(0,20),tilfeldigTall(0,20));
		}
		System.out.println("Skriv antall iterasjoner (minst 1):");
		if(!console.hasNextInt()) {
			System.out.println("Feil. Avslutter programmet");
			return;
		}
		int nIterasjoner = console.nextInt();
		if(nIterasjoner<1) {
			System.out.println("Feil. Avslutter programmet");
			return;
		}
		for(int i=0; i<nIterasjoner; i++) {
			System.out.println("-----------");
			System.out.println("Iterasjon " + (i+1));
			insektBoks[tilfeldigTall(0,insektBoks.length-1)].snuMotHoeyre(); //Flytter tilfeldig valgt insekt mot hoeyre.
			insektBoks[tilfeldigTall(0,insektBoks.length-1)].snuMotVenstre();//Flytter tilfeldig valgt insekt mot venstre.
			for(int j=0; j<nInsekt; j++) { //Beveger alle insekt fremover.
				insektBoks[j].bevegFremover();
				System.out.println("Insekt: " + insektBoks[j].hentY() + "," + insektBoks[j].hentX());
			}
		}
	}
	public static int tilfeldigTall(int fra, int til) { //Genererer tilfeldig til fra og med til og med.
		return (int)(Math.random()*((til+1)-fra) + fra);
	}
}
