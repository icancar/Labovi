package raspored;

public class GIndeks extends Exception {
	int broj;
	public GIndeks(int i) {
		broj=i;
	}

	@Override
	public String toString() {
		return "Greska u indeksu broj: "+broj+"\n";
	}
	
	
}
