package mini_projet;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Nomenclature {
	String name;
	LinkedList<Piece> TabPieces= new LinkedList<Piece>();
	LinkedList<Piece_fragile> TabPieces_fragile= new LinkedList<Piece_fragile>();
	int total_piece=0;
	Scanner sc=new Scanner(System.in);
			
	public Nomenclature(String name) {
		this.name=name;
	}
	public String toString(){
		StringBuffer LC =new StringBuffer("La Nomenclature :"+this.name +", contient au total: "+this.total_piece+" pieces,dont :\n");
		for(Piece e:TabPieces) {
			LC.append("Piece:"+e.get_Denomination()+"\n");
		}
		return LC.toString();
	}
	public boolean Verifier_Existance_piece(int reference) {
		for(Piece e:TabPieces) {
			if(e.get_reference()==reference) return true;
		}
		return false;
	}
	public Piece Chercher_piece(int reference) {
		for(Piece e:TabPieces) {
			if(e.get_reference()==reference) return e;
		}
		return null;
	}
	public String piece_composite_correspondantes(Piece a) {
		StringBuffer LP=new StringBuffer("Les pieces composites contiennent cette piece sont:");
		for(Piece e:TabPieces) {
			if(e instanceof Piece_composite) {
				if(Piece.est_composante(a, (Piece_composite)e)) {
					LP.append(e.get_Denomination());
				}
			}
		}
		
		return LP.toString();
	}
	
	public void add_piece(Piece a) throws ExceptionContaineSame
	{
		for(Piece e:TabPieces) {
			if(e.get_reference()==a.get_reference()) {
				throw new ExceptionContaineSame();
			}
		}
		TabPieces.add(a);
		this.total_piece++;
	}
	public boolean sup_piece(Piece a) {
		for(Piece e:TabPieces) {
			if(e instanceof Piece_composite) {
				if(Piece.est_composante(a, (Piece_composite)e)) {
					return false;
				}
			}
		}
		TabPieces.remove(a);
		return true ;
	}
	
	
	
	//Methodes de interface
	
	public void case2_add_piece() throws ExceptionContaineSame
	{
		System.out.println("On va ajouter l'existance d'une piece dans votre liste des pieces ,1.Piece basique ou 2.compose");
		if(sc.nextInt()==1) {
			int i,j;
			String s;
			System.out.println("Entrez la reference  de la piece");
			i=sc.nextInt();
			System.out.println("Entrez le nom  de la piece");
			s=sc.next();
			System.out.println("Entrez le poid  de la piece");
			j=sc.nextInt();
			 this.add_piece( new Piece_Base(i,s,j));
		}
		else {
			int i;
			float j;
			String s;
			System.out.println("Entrez la reference  de la piece");
			i=sc.nextInt();
			System.out.println("Entrez le nom  de la piece");
			s=sc.next();
			System.out.println("Entrez le poid  de la piece");
			j=sc.nextFloat();
			 this.add_piece(new Piece_composite(i,s,j));
		}
	}
	public String case4_meme_denomination()
	{
		StringBuffer D=new StringBuffer("Les pieces en meme denomination sont:\n");
		System.out.println("Quelle est denomination a chercher?");
		String d=sc.next();
		for(Piece e:this.TabPieces) {
			if(e.get_Denomination().equals(d)) {
				D.append("La piece de reference:"+e.get_reference()+"\n");
			}
		}
		return(D.toString());
	}
	public void case5_ajouter_composante_a_une_piece() throws ExceptionContaineSelf
	{
		int reference;
		System.out.println("Voulez ajouter 1.Piece basique ou 2.compose?");
		if(sc.nextInt()==1) {
			System.out.println("Entrez la reference de piece composite (principale):");
			if(this.Verifier_Existance_piece(reference=sc.nextInt() ) !=false ) {
				if(this.Chercher_piece(reference) instanceof Piece_composite) {
					Piece_composite o=(Piece_composite) this.Chercher_piece(reference);
					int i,j;
					System.out.println("Entrez la reference  de la piece Basique");
					i=sc.nextInt();
					System.out.println("Entrez le nombre  de la piece");
					j=sc.nextInt();
					if(this.Verifier_Existance_piece(i)==false) {
						System.out.println("La piece base n'existent pas !Faut l'ajouter dans la liste d'abord(option2)");
					}
					else {
					     o.add_Pair(this.Chercher_piece(i),j);
					}
				}
			}
		}
		else {
			System.out.println("Entrez la reference de piece composite(Principale):");
			if(this.Verifier_Existance_piece(reference=sc.nextInt() ) !=false ) {
				if(this.Chercher_piece(reference) instanceof Piece_composite) {
					Piece_composite o=(Piece_composite) this.Chercher_piece(reference);
					int i,j;
					System.out.println("Entrez la reference  de la piece a composite(a ajouter)");
					i=sc.nextInt();
					System.out.println("Entrez le nombre  de la piece");
					j=sc.nextInt();
					if(this.Verifier_Existance_piece(i)==false) {
						System.out.println("La piece base n'existent pas !Faut l'ajouter dans la liste d'abord(option2)");
					}
					else {
						o.add_Pair(this.Chercher_piece(i),j);
					}
				}
			}
		}
}
	public String case6_detaille_piece()
	{
		System.out.println("Entrez la reference");
		int reference=sc.nextInt();
		if(this.Verifier_Existance_piece(reference)==false) {
			return("La piece n'existe pas\n");
		}
		if(this.Chercher_piece(reference) instanceof Piece_composite)
		{
			Piece_composite a=(Piece_composite)this.Chercher_piece(reference);
			return a.toString()+a.affiche_tous_les_sous_composants(a, 1);
		}
		return(this.Chercher_piece(reference).toString());
	}
	public void case7_supprimer_piece()
	{
		System.out.println("Entrez la reference");
		int reference=sc.nextInt();
		if(this.Verifier_Existance_piece(reference)) {
			this.sup_piece(this.Chercher_piece(reference));
		}
		this.total_piece--;
	}
	public String case8_trier_piece()
	{
		Collections.sort(this.TabPieces);
		StringBuffer PB= new StringBuffer("Les pieces(trie par reference) sont:\n");
		for(Piece e:this.TabPieces) {
			PB.append("nom :"+e.get_Denomination()+" reference:"+e.get_reference()+"\n");
		}
		return(PB.toString());
	}
	public String case9_piece_base()
	{
		StringBuffer PB= new StringBuffer("Les pieces de base sont:\n");
		for(Piece e:this.TabPieces) {
			if(e instanceof Piece_Base) {
			PB.append("nom :"+e.get_Denomination()+" reference:"+e.get_reference()+"\n");
			}
		}
		return(PB.toString());
	}
	public void case10_sauvegarder() throws FileNotFoundException
	{
		PrintWriter writer2 = new PrintWriter(this.name+".txt");
		writer2.println(this.name +" "+  this.total_piece);
		for(Piece e:this.TabPieces) {
			writer2.println(e.get_reference()+" "+e.get_Denomination()+" "+e.get_poids() );
			if(e instanceof Piece_composite) {
				Piece_composite t=(Piece_composite)e;
				for(Pair<Piece, Integer> r:t.getTabPiece()) {
					writer2.println("    "+r.getPiece().get_reference()+" "+r.getInteger());
					
				}
			}
			writer2.println("    -1 -1");
		}
		writer2.close();
		System.out.println("Votre Nomenclature est bien sauvergarde\n");
	}
	public void case11_charger_nomenclature() throws NumberFormatException, ExceptionContaineSelf, ExceptionContaineSame, FileNotFoundException {
		this.TabPieces=new  LinkedList<Piece>();
		this.TabPieces_fragile=new LinkedList<Piece_fragile>();
		System.out.println("Entrer le nom de fichier\n");
		String str=sc.next();
		java.io.File fic = new java.io.File(str);
		Scanner lecteur = new Scanner(fic);
		String[] temp;
		temp= lecteur.nextLine().split(" "); 
		this.total_piece=0;
		while(lecteur.hasNextLine()) {
		    temp= lecteur.nextLine().split(" ");
		    if(temp.length==3) {
		    	String[] temp2=lecteur.nextLine().split(" ");
		    	if(Integer.parseInt(temp2[4])==-1 && Integer.parseInt(temp2[5])==-1) {
		    		this.add_piece(new Piece_Base(Integer.parseInt(temp[0]),temp[1],Float.parseFloat(temp[2])));
		    	}
		    	else {
		    		Piece_composite pc=new Piece_composite(Integer.parseInt(temp[0]),temp[1],Float.parseFloat(temp[2]));
			    	this.add_piece(pc);
		    	}
		    }
		 }
		lecteur.close();
		lecteur = new Scanner(fic);
		temp= lecteur.nextLine().split(" "); 
		while(lecteur.hasNextLine() ) {
		    temp= lecteur.nextLine().split(" ");
			Piece p1=this.Chercher_piece(Integer.parseInt(temp[0]));
		    temp= lecteur.nextLine().split(" ");
		    while(Integer.parseInt(temp[4])!=-1 && Integer.parseInt(temp[5])!=-1) {
		    	Piece_composite p2=(Piece_composite) p1;
		    	p2.add_Pair(this.Chercher_piece(Integer.parseInt(temp[4])), Integer.parseInt(temp[5]));
			    temp= lecteur.nextLine().split(" ");
		    }
		 }
		lecteur.close();
	}
}
