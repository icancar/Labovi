package karting;

public class Deonica implements Cloneable {
	private double duzina;
	private Elem prvi, posl;
	private class Elem {
		Specificnost s;
		Elem sled;
		private Elem(Specificnost ss) {
			s=ss;
			sled=null;
		}
	}
	
	
	public Deonica(double duzina) {
		this.duzina=duzina;
		prvi=posl=null;
	}
	public double dohvDuzinu() {
		return this.duzina;
	}
	
	public void dodajSpecificnost(Specificnost s) {
		Elem novi=new Elem (s);
		if(prvi==null) {
			prvi=posl=novi;
		}
		else {
			posl.sled=novi;
			posl=posl.sled;
		}
	}
	public Specificnost izbaciSpecificnost(int id) {
		Elem preth=null;
		Elem tek=prvi;
		while(tek!=null) {
			if (tek.s.dohvatiId()==id) {
				if (tek==prvi) { prvi=prvi.sled;
				return tek.s;
				}
				else {
				preth.sled=tek.sled;
				tek.sled=null;
				return tek.s;
				}
			}
			else {
				preth=tek;
				tek=tek.sled;
			
			}
		}
		return null;
	}
	public Specificnost dohvSpecificnost(int pozicija) {
		int br=0;
		for(Elem tek=prvi;tek!=null;tek=tek.sled) {
			if (br==pozicija) return tek.s;
			else br++;
		}
		return null;
	}
	public int brojSpecificnosti() {
		int br=0;
		for(Elem tek=prvi;tek!=null;tek=tek.sled) {
			br++;
		}
		return br;
	}
	
	
	
	@Override
	public Deonica clone()  {
		Deonica d=null;
		try {
			d=(Deonica)super.clone();
			d.prvi=null;
			d.posl=null;
			for(Elem tek=prvi;tek!=null;tek=tek.sled){
				if(tek.s instanceof Krivina) {
					d.dodajSpecificnost(((Krivina)tek.s).clone());
				}
							
			}
		}
			catch (CloneNotSupportedException g) {
				g.getStackTrace();
				return null;
			}
		return d;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder ();
		sb.append("deonica (").append(duzina).append("m)\n");
		for(Elem tek=prvi;tek!=null;tek=tek.sled) {
			sb.append(tek.s).append('\n');
		}
		return sb.toString();
	}
	
	
	
}
