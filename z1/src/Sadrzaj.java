package raspored;

import java.util.List;

public abstract class Sadrzaj {
	protected String naziv;
	protected Vreme trajanje, pocetak;
	public Sadrzaj(String naziv, Vreme trajanje) {
		this.naziv = naziv;
		this.trajanje = trajanje;
		try {
			pocetak = new Vreme();
		} catch (GVreme e) {
			System.out.println(e);
		}

	}

	public abstract Vreme preklapaSe(
			Sadrzaj s1);/*
						 * {
						 * 
						 * int pomeraj = 15; if(this.pocetak.dohvVreme()<s1.dohvPocetak().dohvVreme()) {
						 * for(int i=this.pocetak.dohvVreme();i<Vreme.saberi(this.dohvPocetak(),this.
						 * dohvTrajanje()).dohvVreme();i+=pomeraj) { if (i==s1.pocetak.dohvVreme())
						 * return s1.dohvPocetak(); //if(
						 * i==Vreme.saberi(s1.trajanje,s1.pocetak).dohvVreme()) return this.pocetak; } }
						 * else if(s1.dohvPocetak().dohvVreme()<=this.pocetak.dohvVreme()) { for(int
						 * i=s1.pocetak.dohvVreme();i<Vreme.saberi(s1.dohvTrajanje(),s1.dohvPocetak()).
						 * dohvVreme();i+=pomeraj) { if(i==this.pocetak.dohvVreme()) return
						 * this.pocetak; //if(i==Vreme.saberi(this.trajanje,this.pocetak).dohvVreme())
						 * return s1.dohvPocetak(); } } return null; }
						 */

	public String dohvNaziv() {
		return naziv;
	}
	public Vreme dohvTrajanje() {
		return trajanje;
	}

	public Vreme dohvPocetak() {
		return pocetak;
	}

	public Sadrzaj postPocetak(Vreme v) throws GVreme {
		this.pocetak = v;
		return this;
	}
	
	public abstract char dohvOznaku();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.dohvOznaku()).append(",").append(this.dohvNaziv()).append("|").append(this.dohvPocetak());
		sb.append("-").append(Vreme.saberi(this.dohvPocetak(), this.dohvTrajanje()));
		return sb.toString();
	}

	public void pomeri(Vreme pomeraj) throws GVreme {
		this.pocetak = Vreme.saberi(this.pocetak, pomeraj);
	}

}
