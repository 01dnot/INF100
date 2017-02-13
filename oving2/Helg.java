import java.util.Scanner;
public class Helg {
	
	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);
		System.out.println("Hva heter du?");
		String navn = inn.nextLine();
		System.out.println("Hva liker du best aa gjoere paa loerdager?:");
		String loerdager = inn.nextLine();
		System.out.println("Hva liker du best aa gjoere paa soendager?:");
		String soendager = inn.nextLine();
		System.out.println("Hei " + navn + "." + " Paa loerdager liker du best aa " + loerdager + ". Paa soendager liker du best aa " + soendager + ".");
	}
}
