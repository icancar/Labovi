package pitanja;

public class PitanjeSaPonudjenimOdgovorima extends Pitanje {
	private String [] odgovori;
	
	public PitanjeSaPonudjenimOdgovorima(String tekst, int brPoena, double tezina, String[] odg) {
		super(tekst, brPoena, tezina);
		odgovori=odg;		
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append('\n');
		int br=1;
		for(int i=0;i<odgovori.length;i++) {
			sb.append(br).append(".").append(odgovori[i]).append("\n");
		}
		return sb.toString();
	}

	
	
}
