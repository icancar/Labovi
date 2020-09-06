package pitanja;

public class Pitanje implements Cloneable {
	private static int posID=1;
	private String tekst;
	private int brPoena;
	private double tezina;
	private int id=posID++;
	
	public Pitanje (String tekst, int brPoena, double tezina) {
		this.tekst=tekst;
		this.brPoena=brPoena;
		this.tezina=tezina;
	}
	
	public String getTekst() {return tekst;}
	public int getBrPoena() {return brPoena;}
	public double getTezina() {return tezina;}
	
	public Object clone() throws CloneNotSupportedException {
		Pitanje p= (Pitanje)super.clone();
		p.id=this.id;
		return p;
	}


	@Override
	public String toString() {
		return "Pitanje "+id+":"+tekst;	
	}	
}
