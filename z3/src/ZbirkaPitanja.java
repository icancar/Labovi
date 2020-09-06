package pitanja;

import java.util.LinkedList;
import java.util.List;

public class ZbirkaPitanja {
	private List<Pitanje> pitanja;
	private IteratorPitanja iterator;
	
	public ZbirkaPitanja() {
		pitanja=new LinkedList<Pitanje>();
		iterator=null;
	}
	public void dodaj(Pitanje p){
		pitanja.add(p);
	}
	public List<Pitanje> getPitanja(){
		return pitanja;
	}
	public IteratorPitanja iterator() {
		/*if(iterator==null)*/ return iterator=new IteratorPitanja(this);
		
	}
	public Pitanje dohvati(int broj)throws GNemaPitanja {
		if(pitanja.size()<=broj) throw new GNemaPitanja();
		if(pitanja.get(broj)==null) throw new GNemaPitanja();
		return pitanja.get(broj);
	}
	public int brPitanja() {
		return pitanja.size();
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<pitanja.size();i++) {
			sb.append(pitanja.get(i)).append('\n').append('\n');
		}
		return sb.toString();
	}
	
	
	
	
}
