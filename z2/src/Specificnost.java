package karting;

public abstract class Specificnost {
	
	protected static int posID=0;
	protected int id;
	
	public Specificnost() {
		id=++posID;
	}
	public int dohvatiId() {
		return this.id;
	}
	
	public abstract void ispoljiEfekat (Object o)throws GNeodgovarajuciObjekat;
	public abstract void ponistiEfekat(Object o)throws GNeodgovarajuciObjekat;
	
	
}
