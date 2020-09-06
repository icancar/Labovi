package pitanja;

public class IteratorPitanja {
	private ZbirkaPitanja zbirka;
	private Pitanje tekuce;
	private int brojac=0;
	
	public IteratorPitanja(ZbirkaPitanja z) {
		zbirka=z;
		tekuce=zbirka.getPitanja().get(0);
	}
	public Pitanje dohvati() throws GNemaPitanja{
		if (!this.postoji()) throw new GNemaPitanja();
		return zbirka.getPitanja().get(brojac);
	}
	
	public boolean postoji() {
		return (tekuce!=null);
	}
	public void sledece()throws GNemaPitanja{
		if(brojac>=zbirka.getPitanja().size()-1) {tekuce=null; throw new GNemaPitanja();}
		//if(zbirka.getPitanja().get(brojac+1)==null) {tekuce=null; }
		else tekuce=zbirka.getPitanja().get(brojac++);
	}	
	
}
