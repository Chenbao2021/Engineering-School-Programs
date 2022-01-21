package mini_projet;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static Scanner sc=new Scanner(System.in);//On donne un nom;
	public static void main(String[] args) throws ExceptionContaineSelf, ExceptionContaineSame, FileNotFoundException {
	  	
		while(Menu()!=0);//Pour l'operation 0 on retourne 0 .
					//Nouvelle nomenclature , on retourne 1
		sc.close();
	}
	
	public static int Menu() throws NumberFormatException, ExceptionContaineSelf, ExceptionContaineSame, FileNotFoundException {
		//On donne un nom, puis on creer une nomenclature
		Scanner sc=new Scanner(System.in);
		System.out.println("Saisir le nom de votre Nomenclature.");
		Nomenclature thisN=new Nomenclature(sc.next());
		System.out.println("Votre nom est :"+thisN.name +"\n");
		//J'initialise qlq pieces dans nomenclature
		thisN.add_piece(new Piece_Base(10,"vif",10));
		thisN.add_piece(new Piece_Base(13,"vif",10));
		thisN.add_piece(new Piece_composite(20,"meuble",11));
		//J'affiche la phrase de commencement
		System.out.println("0-Exit\n1-Nouvelle nomenclature\n2-Ajouter une piece sans ces composants\n3-Afficher la nomenclature\n4-Liste les pieces de même d´enomination\n5-Ajouter un composant a une piece\n6-Afficher tous les d´etails d’une piece\n"
				+ "7-Supprimer une piece\n8-trier(Par reference)\n9-Afficher les pieces de bases\n10-Sauvegarder\n11-Lire une nomenclature");
		System.out.println("Entrer la valeur correspondant aux operation desire:");
		int a=9;
		while(!(a==0||a==1)) {
			switch(a=sc.nextInt()) {
				case 0:System.out.println("Merci, a bientot!");return 0;
				case 1:{
					System.out.println("On va creer une nouvelle nomenclature");
					return 1;
				}
				case 2:{ 
					thisN.case2_add_piece();
					break;
				}
				case 3:{
					System.out.println(thisN.toString()+"\n");
					break;
				}
				case 4:{
					System.out.println(thisN.case4_meme_denomination());
					break;
				}
				case 5:{
					thisN.case5_ajouter_composante_a_une_piece();
					break;
				}
				case 6:{
					System.out.println( thisN.case6_detaille_piece());
					break;
				}
				case 7:{
					thisN.case7_supprimer_piece();
					break;
				}
				case 8:{
					System.out.println( thisN.case8_trier_piece());
					break;
				}
				case 9:{
					System.out.println(thisN.case9_piece_base());
					break;
				}	
				case 10:{
					thisN.case10_sauvegarder();
					break;
				}
				case 11:{
					thisN.case11_charger_nomenclature();
					break;
				}
				default:{
					System.out.println("L'option que vous demandez n'existe pas ");
				}
			}
			System.out.println("L‘operation est faite,qu'est ce que vous voulez faire maintenant?");
		}
		return 1;
	}
}

