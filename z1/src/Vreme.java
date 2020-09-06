package raspored;

public class Vreme {
	private int sat, minut;
	public Vreme (int sat, int minut)throws GVreme{
		if(sat<0 || sat> 23 || minut<0 || minut>59 || (minut%15)!=0) throw new GVreme(sat, minut);
		this.sat=sat;
		this.minut=minut;
	}
	public Vreme ()throws GVreme {
		this(0,0);
	}
	
	public boolean equals(Object v1) {
		if( !(v1 instanceof Vreme) ) return false;
		Vreme vr= (Vreme) v1;
		return (this.dohvVreme()==vr.dohvVreme());
	}
	
	public static Vreme saberi(Vreme v1, Vreme v2) {
		int minNovo, satNovo;
		minNovo=v2.minut+v1.minut;
		satNovo=(v2.sat+v1.sat+minNovo/60)%24;
		minNovo %=60;
		try {
		return new Vreme(satNovo, minNovo);} catch (GVreme g) {System.out.println(g); return null;}
		}

	public int dohvVreme() {
		return sat*60+minut;
	}
	@Override
	public String toString() {
		return "("+sat+":"+minut+")";
	}
	
}
