package oving5;

import java.util.Scanner;
import java.io.*;
import java.util.NoSuchElementException;
public class PersonKoordinater {
	public static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		final String FEIL_MELDING = "Error. Feil format.";
		System.out.println("Hvilken fil skal leses inn?");
		String filNamn = console.nextLine();
		console.close();
		try {
			Scanner inn = new Scanner(new File(filNamn));
			if(!inn.hasNextInt()) { //Om ikke tall i første rekke
				System.out.println(FEIL_MELDING);
				inn.close();
				return;
			}
			int antallPersoner = inn.nextInt();
			if(antallPersoner<2) { //Om mindre enn 2 personer
				System.out.println(FEIL_MELDING);
				inn.close();
				return;
			}
			String[] navneListe = new String[antallPersoner];
			double[][] koordinater = new double[antallPersoner][2];
			hentData(navneListe, koordinater, filNamn);
			skrivUtFormat(navneListe, koordinater);

			inn.close();
		}
		catch(FileNotFoundException filUnntak) {
			System.out.println("Finner ikke fil.");
		}
		catch(NoSuchElementException antallUnntak) {
			System.out.println(FEIL_MELDING);
		}
		catch(NumberFormatException unntak) {
			System.out.println(FEIL_MELDING);
		}

	}
	public static void hentData(String[] navneliste, double[][] koordinater, String filNamn) throws FileNotFoundException {
		Scanner inn = new Scanner(new File(filNamn));
		inn.nextLine(); //Hopper over foerste linje
		for(int i=0; i<navneliste.length; i++) {
			navneliste[i] = inn.next();
			koordinater[i][0] = Double.parseDouble(inn.next());
			koordinater[i][1] = Double.parseDouble(inn.next());
			inn.nextLine();
		}
		inn.close();
	}
	public static void skrivUtFormat(String[] navneListe, double[][] koordinater) {
		System.out.printf("%-10s" + " " + "%10s" + " " + "%10s\n", "Navn", "X", "Y");
		for(int i=0; i<navneListe.length; i++) {
			System.out.printf("%-10s" + " " + "%10f" + " " + "%10f\n", navneListe[i], koordinater[i][0], koordinater[i][1]);
		}
	}
}
