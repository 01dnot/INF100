package oving7;

public class Insekt {
	private int xKoordinat;
	private int yKoordinat;
	private int retning;

	public Insekt(int xK, int yK) {
		this.xKoordinat = xK;
		this.yKoordinat = yK;
		this.retning = 0;
	}
	public int hentX() {
		return xKoordinat;
	}
	public int hentY() {
		return yKoordinat;
	}
	public void snuMotHoeyre() {
		retning = (++retning)%4;
	}
	public void snuMotVenstre() {
		this.retning = ((--retning)%4+4);
	}
	public void bevegFremover() {
		if(retning%4==0) { 
			xKoordinat++;
		}else if(retning%4==1) {
			yKoordinat++;
		} else if(retning%4==2) {
			xKoordinat--;
		} else {
			yKoordinat--;
		}
	}
	public String toString() {
		String streng = "Insekt[xPosisjon=" + xKoordinat + ",yPosisjon=" + yKoordinat + ",retning=" + retning + "]";
		return streng;
	}
}

