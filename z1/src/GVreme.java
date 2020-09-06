package raspored;

public class GVreme extends Exception {
	private int sat, minut;
	public GVreme (int sat, int minut) {
		this.sat=sat;
		this.minut=minut;
	}
	@Override
	public String toString() {
		return "" + "Greska u vremenu ("+sat+ ":"+minut+")";
	}
	
}
