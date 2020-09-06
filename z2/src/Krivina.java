package karting;

public class Krivina  extends Specificnost implements Cloneable {
	private double maxBrzina;
    private double staraBrzina;
	public Krivina(double m) {
		maxBrzina=m;
	}
	public double dohvMaksBrzinu() {
		return this.maxBrzina;
	}
	
	
	@Override
	public void ispoljiEfekat(Object o) throws GNeodgovarajuciObjekat {
		if(!(o instanceof Vozilo)) throw new GNeodgovarajuciObjekat();
		else {Vozilo vozilo = (Vozilo) o;
		staraBrzina=vozilo.dohvMaksBrzinu();
		if(maxBrzina* vozilo.dohvUpravljivost()<vozilo.dohvMaksBrzinu()) {
			
			vozilo.postMaksBrzinu(maxBrzina*vozilo.dohvUpravljivost());
			}
		}
	}

	@Override
	public void ponistiEfekat(Object o) throws GNeodgovarajuciObjekat {
		if(!(o instanceof Vozilo)) throw new GNeodgovarajuciObjekat();
		Vozilo vozilo = (Vozilo) o;
		vozilo.postMaksBrzinu(staraBrzina);
		}
		
	
	@Override
	public Krivina clone() {
		try {
			Krivina k= (Krivina) super.clone();
			k.id=++posID;
			return k;			
		}
		catch (CloneNotSupportedException e ) {
			e.getStackTrace();
			return null;
		}
	}
	@Override
	public String toString() {
		return "K"+maxBrzina;
	}
	
}
