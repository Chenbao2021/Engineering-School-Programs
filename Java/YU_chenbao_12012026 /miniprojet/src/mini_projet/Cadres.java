package mini_projet;

import java.util.LinkedList;

public class Cadres extends Piece_composite {
	LinkedList<Piece_fragile> TabPieces= new LinkedList<Piece_fragile>();
	public Cadres(int reference,String denomination,float poids) {
		super(reference,denomination,poids);
	}
}
