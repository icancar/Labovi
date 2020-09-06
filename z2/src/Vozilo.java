package karting;

public class Vozilo {
	double maxBrzina, ubrzanje, upravljivost,trenutnaBrzina;
	String ime;
	public Vozilo(double maxBrzina, double ubrzanje, double upravljivost, String nazivTakmicara) {
		this.maxBrzina = maxBrzina;
		this.ubrzanje = ubrzanje;
		this.upravljivost = upravljivost>=1 ? 1 : (upravljivost<=0? 0: upravljivost);
		this.ime = nazivTakmicara;
		this.trenutnaBrzina=0;
	}
	public double dohvMaksBrzinu() {
		return this.maxBrzina;
	}
	public void postMaksBrzinu(double maxBrzinaa) {
		this.maxBrzina = maxBrzinaa;
		if(this.trenutnaBrzina>maxBrzinaa) this.trenutnaBrzina=maxBrzinaa;
	}
	public double dohvUbrzanje() {
		return this.ubrzanje;
	}
	public void postUbrzanje(double ubrzanje) {
		this.ubrzanje = ubrzanje;
	}
	public double dohvUpravljivost() {
		return this.upravljivost;
	}
	public void postUpravljivost(double upravljivost1) {
		this.upravljivost = upravljivost1;
	}
	public double dohvTrenBrzinu() {
		return this.trenutnaBrzina;
	}
	public void postTrenBrzinu(double trenutnaBrzina) {
		this.trenutnaBrzina = trenutnaBrzina;
	}
	public String dohvIme() {
		return this.ime;
	}
	public void postIme(String nazivTakmicara) {
		this.ime = nazivTakmicara;
	}
	@Override
	public String toString() {
		return ""+ime+"["+maxBrzina+","+ubrzanje+","+upravljivost+"]";
	}
	public double izracunajVreme(double daljina) {
		double vreme=0;
		double pocetnaBrzina=trenutnaBrzina;
		double trenBrzina=Math.sqrt(Math.pow(pocetnaBrzina, 2)+2*ubrzanje*daljina);
		if(trenBrzina>=maxBrzina) {
			trenBrzina=maxBrzina;
			double tUbrzano=(this.maxBrzina-pocetnaBrzina)/ubrzanje;
			double predjeniPutUbrzano =pocetnaBrzina*tUbrzano+ubrzanje*tUbrzano*tUbrzano*0.5;
			double predjeniPutRavnomjerno = daljina-predjeniPutUbrzano;
			double tRavnomjerno=predjeniPutRavnomjerno/maxBrzina;
			vreme=tUbrzano+tRavnomjerno;
			return vreme;
		}
		else {
			vreme=(-pocetnaBrzina+Math.sqrt(Math.pow(pocetnaBrzina,  2)+2*ubrzanje*daljina))/ubrzanje;
			return vreme;
		}
	}
	
	public double pomeriVozilo(double t) {
		double s=0;
		double pocetnaBrzina=this.trenutnaBrzina;
		this.trenutnaBrzina=pocetnaBrzina+this.ubrzanje*t;
		if(this.trenutnaBrzina>=this.maxBrzina) {
			this.trenutnaBrzina=this.maxBrzina;
			double tUbrzano=(this.maxBrzina-pocetnaBrzina)/this.ubrzanje;
			double tRavnomjerno=t-tUbrzano;
			s=pocetnaBrzina*tUbrzano+(this.ubrzanje*tUbrzano*tUbrzano)/2+this.maxBrzina*tRavnomjerno;
			return s;
		}
		else {
			s=pocetnaBrzina*t+(this.ubrzanje*t*t)/2;
			return s;
		}
		
	}	
	
}
