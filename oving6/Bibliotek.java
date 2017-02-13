package oving6;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Bibliotek {
	public static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Bok> bokListe = new ArrayList<Bok>();
		ArrayList<Utlaan> utlaanListe = new ArrayList<Utlaan>();
		do {
			char valg = meny();
			switch(valg) {
			case '0': return;
			case '1': leggTilNyBok(bokListe); break;
			case '2': fjernBok(bokListe); break;
			case '3': skrivUtListe(bokListe); break;
			case '4': registrerUtlaan(bokListe, utlaanListe); break;
			case '5': skrivUtUtlaanListe(utlaanListe); break;
			default: System.out.println("Ugyldig valg. Proev igjen."); break;
			}
		} while(true);
	}
	public static char meny() {
		System.out.print("Velkommen til biblioteket. \n"
				+ "Skriv 0 for aa avslutte. \n"
				+ "Skriv 1 for aa registrere en bok. \n"
				+ "Skriv 2 for aa fjerne en bok. \n"
				+ "Skriv 3 for aa skrive ut liste av boeker.\n"
				+ "Skriv 4 for aa registrere utlaan. \n"
				+ "Skriv 5 for aa skrive ut liste av utlaan.");
		String streng = console.nextLine();
		if(streng.length() == 0) {
			return '\0'; // Om tom streng returnerer og begynner paa nytt
		}
		return streng.charAt(0);
	}
	public static void leggTilNyBok(ArrayList<Bok> bokListe) {
		System.out.print("Skriv ISBN:");
		String isbn = console.nextLine();
		if (isbn.length() == 0) {
			System.out.println("ISBN kan ikke vaere null");
			return;
		}
		for(int i=0; i<bokListe.size(); i++) {
			if(isbn.equals(bokListe.get(i).hentIsbn())) {
				System.out.println("ISBN er allerede registrert.");
				return;
			}
		}
		System.out.print("Skriv forfatterens navn: ");
		String forfatterNavn = console.nextLine();
		if (forfatterNavn.length() == 0) {
			System.out.println("Forfatternavn kan ikke vaere null");
			return;
		}
		System.out.print("Skriv bokens tittel: ");
		String bokTittel = console.nextLine();
		if (bokTittel.length() == 0) {
			System.out.println("Boktittel kan ikke vaere null");
			return;
		}
		System.out.print("Skriv antall eksemplarer (heltall stoerre enn 0): ");
		if(!console.hasNextInt()) {
			System.out.println("Antall eksemplarer maa vaere heltal stoerre enn 0");
			return;
		}
		int antallEksemplarer = console.nextInt();
		if(antallEksemplarer<1) {
			System.out.println("Antall eksemplarer maa vaere heltal stoerre enn 0");
			return;
		}
		console.nextLine(); //Toemmer bufferen
		Bok bok = new Bok(isbn, forfatterNavn, bokTittel, antallEksemplarer);
		bokListe.add(bok);
		System.out.println("Boken ble registrert: " + bok);
	}
	public static void fjernBok(ArrayList<Bok> bokListe) {
		System.out.print("Skriv ISBN: ");
		String isbn = console.nextLine();
		for(int i=0; i<bokListe.size(); i++) {
			if(isbn.equals(bokListe.get(i).hentIsbn())) {
				System.out.println("Boken ble fjernet: " + bokListe.get(i));
				bokListe.remove(i);
				return;
			} 
		}
		System.out.println("Fant ikke ISBN");
		return;
	}
	public static void skrivUtListe(ArrayList<Bok> bokListe) {
		Collections.sort(bokListe);
		for(int i=0; i<bokListe.size(); i++) {
			System.out.println(bokListe.get(i));
		}
	}
	public static void registrerUtlaan(ArrayList<Bok> bokListe, ArrayList<Utlaan> utlaanListe) {
		System.out.println("Skriv ISBN:");
		String isbn = console.nextLine();
		if (isbn.length() == 0) {
			System.out.println("ISBN kan ikke vaere null");
			return;
		}
		for(int i=0; i<bokListe.size(); i++) {
			if(isbn.equals(bokListe.get(i).hentIsbn())) {
				if(bokListe.get(i).hentAntallUtlaant()<bokListe.get(i).hentAntallEksemplarer()) {
					System.out.println("Skriv navn:");
					String navn = console.nextLine();
					Utlaan utlaan = new Utlaan(bokListe.get(i), navn);
					utlaanListe.add(utlaan);
					bokListe.get(i).settAntallUtlaant(1);
					System.out.println("Boken ble utlaant: " + utlaan);
					return;
				}
				System.out.println("Ingen flere eksemplarer aa laane ut");
				return;
			}
		}
	}
	public static void skrivUtUtlaanListe(ArrayList<Utlaan> utlaanListe) {
		utlaanListe.forEach(System.out::println);
	}
}