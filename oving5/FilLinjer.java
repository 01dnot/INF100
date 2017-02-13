package oving5;
import java.util.Scanner;
import java.io.*;
public class FilLinjer {

	public static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Hvilken fil skal leses inn?");
		String filNamn = console.nextLine();
		console.close();
		try 
		{
			Scanner inn = new Scanner(new File(filNamn));
			int teller = 1;
			while(inn.hasNextLine()) {
				String streng = inn.nextLine();
				System.out.println(teller + "  " + "(" + streng.length() + " tegn" + ") " + streng);
				teller++;
			}
			inn.close();
		}
		catch(FileNotFoundException unntak) {
			System.out.println("Finner ikke fil.");
		}
	}
}
