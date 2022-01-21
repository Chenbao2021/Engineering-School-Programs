package mini_projet;


import java.util.LinkedList;

public class Piece_composite extends Piece {
	private LinkedList<Pair<Piece, Integer>> TabPiece = new LinkedList<Pair<Piece, Integer>>();

	float TotalPoids = 0;

	public Piece_composite(int reference, String String, float poids) {
		super(reference,String,poids);
		this.TotalPoids = poids;
	}

	// Methodes
	public void add_Pair(Piece a, int i) throws ExceptionContaineSelf {
		if(this.equals(a) ) { throw new ExceptionContaineSelf();}
		else if (a instanceof Piece_composite && Piece.est_composante((Piece)this,(Piece_composite)a)) {
			throw new ExceptionContaineSelf();
		}
		TabPiece.add(new Pair<Piece, Integer>(a, i));
		TotalPoids += a.get_poids() * i;
		TotalPiece ++;
	}
	public String affiche_tous_les_sous_composants(Piece a, int decal) {
		StringBuffer LC = new StringBuffer();
		String decaleEspace = "";

		for (int i = 0; i < decal; i++) {
			decaleEspace += " ";
		}
		for (Pair<Piece, Integer> e : TabPiece) {
			LC.append(decaleEspace + decaleEspace + e.getPiece().get_Denomination() + ",Quantite:" + e.getInteger()
					+ ",Poids:" + e.getPiece().get_poids() + "\n");
			if (e.getPiece() instanceof Piece_composite) {
				// LC.append(affiche_tous_les_sous_composants(e.getPiece(),2*decal));
				Piece_composite c = (Piece_composite) e.getPiece();
				LC.append(c.affiche_tous_les_sous_composants(c, 2 * decal));
			}
		}
		return LC.toString();
	}

	public String toString() {
		return super.toString()+"\n";
	}
	
	public LinkedList<Pair<Piece, Integer>> getTabPiece() {
		return TabPiece;
	}
	
	@Override
	public int get_reference() {
		// TODO Auto-generated method stub
		return this.reference;
	}

	@Override
	public String get_Denomination() {
		// TODO Auto-generated method stub
		return this.denomination;
	}

	@Override
	public float get_poids() {
		// TODO Auto-generated method stub
		return this.poids;
	}

}
