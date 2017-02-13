package semeteroppg1;

import java.util.Scanner;
public class EnkelKryptering {

	public static void main(String[] args) {

		Scanner inn = new Scanner(System.in);

		System.out.println("Inn-tekst:");
		String innTekst = inn.nextLine();
		System.out.println("Noekkel-verdi:");
		int noekkelVerdi = inn.nextInt();

		caesarChifferKryptering(innTekst, noekkelVerdi);
	}
	//Metode som tar inn tekststreng + forskyvningsverdi og skriver ut forskjoevete karakterer
	private static void caesarChifferKryptering(String innTekst, int noekkelVerdi) {
		final int ANTALL_TEGN_I_ALFABET = 26;
		System.out.println("Ut-tekst: ");
		for(int i = 0; i<innTekst.length(); i++) {
			if(innTekst.charAt(i)>='a' && innTekst.charAt(i)<='z') {
				//Ved bruk av modulus blir karakteren i posisjon "i" forskoevet med noekkelverdi og plassert i midl
				int midl = (innTekst.charAt(i)+noekkelVerdi-'a')%ANTALL_TEGN_I_ALFABET;
				//Maa ha to forskjellige regneopperasjoner om midl<0
				midl = (midl<0) ? midl+(ANTALL_TEGN_I_ALFABET)+'a' : midl+'a' ;
				System.out.print((char)midl);
				//om karakteren er ett annet tegn enn a-z blir orginalkarakteren skrevet ut
			} else {
				System.out.print(innTekst.charAt(i));
			}	
		}
	}
}
