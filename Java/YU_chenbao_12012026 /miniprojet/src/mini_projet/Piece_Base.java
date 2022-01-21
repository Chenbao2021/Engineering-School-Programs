package mini_projet;

public class Piece_Base extends Piece {
	
	//Constructeurs
	public Piece_Base(int reference,String String,float poids)
	{
		super(reference,String,poids);
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
