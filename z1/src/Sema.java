package raspored;

import java.util.*;

public class Sema {
	private List<Sadrzaj> lista;
	private Vreme pocetak, kraj;
	private String naziv;

	public Sema(String n, Vreme p, Vreme k) {
		naziv = n;
		pocetak = p;
		kraj = k;
		lista = new LinkedList<Sadrzaj>();
	}

	public Sema(String n) {
		try {
			pocetak = new Vreme(8, 0);
			kraj = new Vreme(22, 0);
		} catch (GVreme g) {
		}
		naziv = n;
		lista = new LinkedList<Sadrzaj>();
	}

	public int broj() {
		return lista.size();
	}

	public Sadrzaj dohvati(int i) throws GIndeks {
		if (i > lista.size())
			throw new GIndeks(i);
		return lista.get(i);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv).append(" : ").append(pocetak).append(" - ").append(kraj).append("\n");
		for (int i = 0; i < lista.size(); i++) {
			sb.append(lista.get(i)).append("\n");
		}
		return sb.toString();

	}
/*
	public void dodaj(Sadrzaj t) throws GDodaj, GVreme {
		System.out.println("Poziv dodaj, sadrzaj: " + t);
		System.out.println("*** " + this.toString());

		if (t instanceof Ponavljajuci) {
			Ponavljajuci s = (Ponavljajuci) t;
			if (lista.isEmpty() && (s.pocetak.dohvVreme() >= this.pocetak.dohvVreme()))  //lista prazna, pocetak sadrzaja se uklapa u pocetak seme
				lista.add(s);
			else if (lista.isEmpty() && (s.pocetak.dohvVreme() < this.pocetak.dohvVreme())) { // lista prazna, pocetak sadrzaja je prije pocetka seme
				s.pocetak=this.pocetak;
				lista.add(s);
				
			}
			else if(s.pocetak.dohvVreme()>=this.kraj.dohvVreme()) throw new GDodaj(); //nebitno da li je lista prazna, pocetak sadrzaja je posle kraja seme
			else if (!lista.isEmpty() && s.pocetak.dohvVreme() >= this.pocetak.dohvVreme()) { // uklapa se u semu,																				// treba
				Sadrzaj pom2=s;																				// provjeriti da li se
				// slucajno ne preklapa sa nekom semom
				for (int brojac = 0; brojac < lista.size();) {
					Sadrzaj pom=lista.get(brojac);
					
					while (pom.preklapaSe(pom2) != null) {
						pom2.pocetak=Vreme.saberi(pom2.pocetak, (new Vreme(0, 15)));
					}
					if (pom2.pocetak.dohvVreme() + pom2.dohvTrajanje().dohvVreme() > kraj.dohvVreme())
						throw new GDodaj();
					else if (pom.preklapaSe(pom2) == null)
						brojac++;
					else {
						brojac = 0;
						break;
					}
				}
				s.pocetak=pom2.pocetak;
				lista.add(s);
			} else {
				s.pocetak=this.pocetak;
				Sadrzaj pom2=s;	// dalje treba provjeriti da li se preklapa sa nekom semom
				for (int brojac = 0; brojac < lista.size();) {
					Sadrzaj pom=lista.get(brojac);
					while (pom.preklapaSe(pom2) != null) {
						pom2.pocetak=Vreme.saberi(pom2.pocetak, (new Vreme(0, 15)));
					}
					if (pom2.pocetak.dohvVreme() + pom2.dohvTrajanje().dohvVreme() > kraj.dohvVreme()) {
						System.out.println("Nije mogao da se doda sadrzaj: " + s);
						throw new GDodaj();
					} else if (pom.preklapaSe(pom2) == null)
						brojac++;
					else {
						brojac = 0;
						break;
					}

				}
				s.pocetak=pom2.pocetak;
				lista.add(s);
			}
			Collections.sort(lista, (s1, s2) -> s1.dohvPocetak().dohvVreme() - s2.dohvPocetak().dohvVreme());
			/*
			 * lista.sort(new Comparator<Sadrzaj>() {
			 * 
			 * @Override public int compare(Sadrzaj s1, Sadrzaj s2) { return
			 * s1.dohvPocetak().dohvVreme() - s2.dohvPocetak().dohvVreme(); }
			 * 
			 * });
			 
		}
	}
*/
	public void dodaj(Sadrzaj t) throws GDodaj, GVreme {
		if (t instanceof Ponavljajuci) {
			Ponavljajuci s = (Ponavljajuci) t;
			if (lista.isEmpty() && (s.pocetak.dohvVreme() >= this.pocetak.dohvVreme()))  //lista prazna, pocetak sadrzaja se uklapa u pocetak seme
				lista.add(s);
			else if (lista.isEmpty() && (s.pocetak.dohvVreme() < this.pocetak.dohvVreme())) { // lista prazna, pocetak sadrzaja je prije pocetka seme
				s.postPocetak(this.pocetak);
				lista.add(s);
				
			}
			else if(s.pocetak.dohvVreme()>=this.kraj.dohvVreme()) throw new GDodaj(); //nebitno da li je lista prazna, pocetak sadrzaja je posle kraja seme
			else if (!lista.isEmpty() && s.pocetak.dohvVreme() >= this.pocetak.dohvVreme()) { // uklapa se u semu,
																								// treba
																								// provjeriti da li se
				// slucajno ne preklapa sa nekom semom
				for (int brojac = 0; brojac < lista.size();) {
					while (lista.get(brojac).preklapaSe(s) != null) {
						s.pomeri(new Vreme(0,15));
					}
					if (s.pocetak.dohvVreme() + s.dohvTrajanje().dohvVreme() > kraj.dohvVreme())
						throw new GDodaj();
					else if (lista.get(brojac).preklapaSe(s) == null)
						brojac++;
					else {
						brojac = 0;
						break;
					}
				}

				lista.add(s);
			} else {
				s.postPocetak(this.pocetak); // dalje treba provjeriti da li se preklapa sa nekom semom
				for (int brojac = 0; brojac < lista.size();) {
					while (lista.get(brojac).preklapaSe(s) != null) {
						s.pocetak=Vreme.saberi(s.pocetak, (new Vreme(0, 15)));
					}
					if (s.pocetak.dohvVreme() + s.dohvTrajanje().dohvVreme() > kraj.dohvVreme()) {
						throw new GDodaj();
					} else if (lista.get(brojac).preklapaSe(s) == null)
						brojac++;
					else {
						brojac = 0;
						break;
					}

				}
				lista.add(s);
			}
			Collections.sort(lista, (s1, s2) -> s1.dohvPocetak().dohvVreme() - s2.dohvPocetak().dohvVreme());
		}
	}
	public double zauzetost() throws GVreme {
		int vremeTrajanjaSeme = Math.abs(this.kraj.dohvVreme() - this.pocetak.dohvVreme());
		int trajanjePrograma = 0;
		for (int i = 0; i < lista.size(); i++) {
			Sadrzaj te = lista.get(i);
			if (te instanceof Ponavljajuci) {
				Ponavljajuci pom=(Ponavljajuci) te;
				Ponavljajuci tek=new Ponavljajuci(pom.dohvNaziv(),pom.dohvTrajanje(), pom.dohvPeriodu());
				tek.postPocetak(pom.pocetak);
				while ((tek.pocetak.dohvVreme() + tek.trajanje.dohvVreme()) <= kraj.dohvVreme()) {
					trajanjePrograma += tek.trajanje.dohvVreme();
					if ((tek.pocetak.dohvVreme() + tek.dohvPeriodu().dohvVreme()) + tek.trajanje.dohvVreme() > kraj
							.dohvVreme())
						break;
					tek.pocetak = Vreme.saberi(tek.pocetak, tek.dohvPeriodu());
				}
			} else
				trajanjePrograma += 0;

		}
		return ((double) trajanjePrograma / (double) vremeTrajanjaSeme) * 100;
	}
}
