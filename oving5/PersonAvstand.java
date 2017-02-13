package oving5;

import java.util.Scanner;
import java.io.*;
import java.util.NoSuchElementException;
public class PersonAvstand {

	public static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		final String FEIL_MELDING = "Error. Programmet avsluttes.";

		System.out.println("Hvilken fil skal leses inn?");
		String innFilNamn = console.nextLine();
		System.out.println("Hvilken fil skal resultatet lagres til?");
		String utFilNamn = console.nextLine();
		console.close();

		try {
			Scanner inn = new Scanner(new File(innFilNamn));
			if(!inn.hasNextInt()) { //Om ikke tall i første rekke
				System.out.println(FEIL_MELDING);
				inn.close();
				return;
			}
			int antallPersoner = inn.nextInt();
			if(antallPersoner<2) {
				System.out.println(FEIL_MELDING);
				inn.close();
				return;
			}
			String[] navneListe = new String[antallPersoner];
			double[][] koordinater = new double[antallPersoner][2];
			hentData(navneListe, koordinater, innFilNamn);
			skrivUtFormat(navneListe, koordinater, utFilNamn);

			inn.close();
		}
		catch(FileNotFoundException filUnntak) {
			System.out.println(FEIL_MELDING);
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

		inn.nextLine();
		for(int i=0; i<navneliste.length; i++) {
			navneliste[i] = inn.next();
			koordinater[i][0] = Double.parseDouble(inn.next());
			koordinater[i][1] = Double.parseDouble(inn.next());
			inn.nextLine();
		}
		inn.close();
	}
	public static void skrivUtFormat(String[] navneListe, double[][] koordinater, String utFilNamn) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(utFilNamn);
		System.out.println("Personer-par:");
		System.out.printf("%-10s" + " " + "%10s" + " " + "%10s\n", "Navn 1", "Navn 2", "Avstand");
		out.printf("%-10s" + " " + "%10s" + " " + "%10s\n", "Navn 1", "Navn 2", "Avstand");
		for(int i=0; i<(navneListe.length-1); i++) {
			for(int j=(i+1); j<navneListe.length; j++) {
				System.out.printf("%-10s" + " " + "%10s" + " " + "%10f\n", navneListe[i], navneListe[j], regnUt(i, j, koordinater));
				out.printf("%-10s" + " " + "%10s" + " " + "%10f\n", navneListe[i], navneListe[j], regnUt(i, j, koordinater));
			}
		}
		out.close();
	}

 public static double regnUt(int i, int j, double[][] koordinater) {
	double svar = Math.sqrt(Math.pow((koordinater[i][0]-koordinater[j][0]),2)+Math.pow((koordinater[i][1]-koordinater[j][1]),2));
	 return svar;
 }
}
