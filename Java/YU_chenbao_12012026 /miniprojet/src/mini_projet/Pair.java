package mini_projet;

@SuppressWarnings("hiding")
public class Pair<Piece, Integer> {
	    private Piece p;
	    private Integer i;
	    public Pair(Piece p, Integer i){
	        this.p = p;
	        this.i = i;
	    }
	    public Piece getPiece(){ return p; }
	    public Integer getInteger(){ return i; }
	    public void setPiece(Piece p){ this.p = p; }
	    public void setInteger(Integer i){ this.i = i; }
}


