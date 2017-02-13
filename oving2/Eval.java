
public class Eval {

	public static void main(String[] args) {

		System.out.println(1 + 9 + 2); // 12 int fordi heltal +- heltal = heltal
		System.out.println(41 / 7); // 5 int Her får vi ut nærmeste heltal rundet nedover, men mangler rest paa ca. 0,857
		System.out.println(41 % 7); // 6 int Her får vi ut hvor mye som totalt er igjen naar vi har kuttet desimalene. altsaa 5*7=35 mangler 6 i rest for aa faa 41.
		System.out.println(41.0 / 7); // 5.857142857142857 double Her får vi flytaldeling som resulterer i ett flyttal uten rest. 
		System.out.println(1 - 9 + 2); // -6 int Heltal -+ heltal gir heltal
		System.out.println(1 - (9 + 2.0)); // -10.0 double  Heltal +- flyttal gir flyttal
		System.out.println(4 * 4 - 16); // int setningen bestaar av bare heltal derav gir den ut heltal.
		System.out.println(-(88.0/22 * 3) + 8*8); // 52.0 double heltal+- flyttal gir flyttal
	}

}
