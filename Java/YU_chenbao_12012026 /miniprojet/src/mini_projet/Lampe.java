package mini_projet;

public class Lampe extends Piece implements Piece_fragile{
	float puissance;
	public Lampe(int reference,String denomination,float poids,float puissance)
	{
		super(reference,denomination,poids);
		this.puissance=puissance;
	}
	
	public float getPuissance() {
		return puissance;
	}

	@Override
	public int get_reference() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String get_Denomination() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float get_poids() {
		// TODO Auto-generated method stub
		return 0;
	}

}
