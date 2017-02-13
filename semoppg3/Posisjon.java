package semesteroppg_3;
//Klasse for posisjon til labyrint i oppgave 1.
public class Posisjon {
	private int x; 
	private int y;

	public Posisjon(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int hentX() {
		return x;
	}
	public int hentY() {
		return y;
	}
}
