package raspored;

import java.util.LinkedList;
import java.util.List;

public class Ponavljajuci extends Sadrzaj {
	private Vreme periodaPonavljanja;
	private int brPonavljanja;

	public Ponavljajuci(String naziv, Vreme trajanje, Vreme perioda) {
		super(naziv, trajanje);
		this.periodaPonavljanja = perioda;
	}

	@Override
	public char dohvOznaku() {
		return 'P';
	}

	public Vreme dohvPeriodu() {
		return periodaPonavljanja;
	}

	@Override
	public String toString() {
		return super.toString() + "T" + periodaPonavljanja;
	}

	public Vreme preklapaSe(Sadrzaj s1) {

		if (s1 instanceof Ponavljajuci) {
			Ponavljajuci s = (Ponavljajuci) s1;
			int ponoc = 1425;
			Vreme tek = this.pocetak;
			while ((tek.dohvVreme() + this.trajanje.dohvVreme()) <= ponoc) {
				Vreme t = s.pocetak;
				while ((t.dohvVreme() + s.trajanje.dohvVreme()) <= ponoc) {
					if (preklop(tek, this.trajanje, t, s.trajanje) != null) {
						return preklop(tek, this.trajanje, t, s.trajanje);
					}
					if ((t.dohvVreme() + s.dohvPeriodu().dohvVreme()) > ponoc)
						break;
					t = Vreme.saberi(t, s.dohvPeriodu());
				}
				if ((tek.dohvVreme() + this.periodaPonavljanja.dohvVreme()) > ponoc)
					break;
				tek = Vreme.saberi(tek, this.periodaPonavljanja);
			}
			return null;
		} else
			return null;
	}

	private Vreme preklop(Vreme v1pocetak, Vreme v1trajanje, Vreme v2pocetak, Vreme v2trajanje) {
		int pomeraj = 15;
		if (v1pocetak.dohvVreme() < v2pocetak.dohvVreme()) {
			for (int i = v1pocetak.dohvVreme(); i < (v1pocetak.dohvVreme() + v1trajanje.dohvVreme()); i += pomeraj)
				if (i == v2pocetak.dohvVreme())
					return v2pocetak;
		} else if (v2pocetak.dohvVreme() <= v1pocetak.dohvVreme()) {
			for (int i = v2pocetak.dohvVreme(); i <= (v2pocetak.dohvVreme() + v2trajanje.dohvVreme()); i += pomeraj)
				if (i == v1pocetak.dohvVreme())
					return v1pocetak;
		}
		return null;
	}

}
