package testAwaz;

import awaz.Awaz;
import awaz.AwazImage;

/**
 * Cette classe est le point de départ du Tp Awaz
 * @author martine
 * @version Janvier 2018
 */
public class MainAwaz {
    public static void main(String[] args) {
        // Création d'une mélodie vide
        Awaz melodie = new Awaz() ;
        AwazImage img = new AwazImage();
        int nb = -1;
        int i = 0;

       melodie.add("Do");
       melodie.add("Ré");
       melodie.add("Mi");
       
       System.out.println(melodie.toString());
       
       nb = melodie.nbNotes();
       System.out.printf("nb notes = ");
       System.out.println(nb);
       
       melodie.transposer(2);
       System.out.println(melodie);
       
       melodie.nouveau();
       melodie.add("Sol");
       melodie.add("La");
       melodie.add("Si");
       
       while(melodie.ieme(i) != null){
       	System.out.print(melodie.ieme(i));
       	System.out.println("  ");
       	i++;
       }
       System.out.println();
       
	
	melodie.enregistrer("monAwaz");
	
	melodie.add("Do");
       melodie.add("Mi");
       melodie.add("Do");
	
	System.out.println(melodie.toABC());
	
	
	img.setTitre("Awaz in Han");
	
	img.setMelodie(melodie.toABC());
	
	
	
	
	
	
    }
}
