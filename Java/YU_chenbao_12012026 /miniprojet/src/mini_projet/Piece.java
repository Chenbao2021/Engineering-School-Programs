package mini_projet;

public abstract class Piece implements java.lang.Comparable<Piece>{
	protected int reference;
	protected String denomination;
	protected float poids;
	int TotalPiece = 1;
	
	public int getTotalPiece() {
		return TotalPiece;
	}
	public abstract int get_reference() ;//Retourner la reference 
	public abstract String get_Denomination();
	public abstract float get_poids();
	
	public Piece(int reference,String denomination,float poids)
	{
		this.reference=reference;
		this.denomination=denomination;
		this.poids=poids;
	}
	public String toString()
	{
		return "Reference:"+this.get_reference()+",Denomination "+this.get_Denomination()+", poids:"+this.get_poids();
	}
	public boolean equals(Piece o)
	{
		if(this.denomination == o.denomination && this.reference==o.reference && this.poids == o.poids) return true;
		else return false;
	}
	static public boolean est_composante(Piece a, Piece_composite b)
	{
		for(Pair<Piece, Integer> i:b.getTabPiece()) {
			if(i.getPiece().equals(a)) {
				return true;
			}
			else if(i.getPiece() instanceof Piece_composite) {
				i.getPiece();
				if(Piece.est_composante(a, (Piece_composite)i.getPiece())==true) {
					return true;
				}
			}
		}
		return false;
	}
	public int compareTo(Piece e) {
		if(this.get_reference()<e.get_reference()) return -1;
		else if(this.get_reference()==e.get_reference()) return 0;
		else return 1;
	}
}
