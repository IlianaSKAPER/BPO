package testAwaz;

import awaz.Awaz;
import awaz.AwazImage;
import java.util.Scanner;

/**
 * Classe testAwaz.MenuAwaz
 * Manipulation de mélodies
 * @author Iliana SKAPER
 */
public class MenuAwaz {
    public static void main(String[] args) {
        Awaz melodie = new Awaz() ;
        AwazImage img;
        Scanner scan;
        int choix= -1;

        do {
            System.out.println("1 : nouvelle melodie (efface l'ancienne melodie)");
            System.out.println("2 : ajouter une note");
            System.out.println("3 : nombre de notes de la melodie");
            System.out.println("4 : affiche la melodie");
            System.out.println("5 : affiche la melodie au format ABC");
            System.out.println("6 : donner un titre a la melodie");
            System.out.println("7 : afficher le titre de la melodie");
            System.out.println("8 : transposer");
            System.out.println("9 : enregistrer dans un fichier");
            System.out.println("10 : charger une melodie a partir d'un fichier");
            System.out.println("11 : jouer la melodie");
            //System.out.println("12 : jouer la melodie en format ABC");
            System.out.println("0 : quitter");

            scan = new Scanner(System.in);
            choix = scan.nextInt();

            switch(choix){
                case 0:
                    System.out.println("Au revoir !");
                    return;
                case 1:
                    melodie.nouveau();
                    System.out.println("Nouvelle mélodie.");
                    break;
                case 2:
                    scan = new Scanner(System.in);
                    melodie.add(scan.next());
                    break;
                case 3:
                    System.out.print("La mélodie contient ");
                    System.out.print(melodie.nbNotes());
                    System.out.println(" notes");
                    break;
                case 4:
                    System.out.print(melodie.toString());
                    System.out.println();
                    break;
                case 5:
                    System.out.print(melodie.toABC());
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Titre : ");
                    scan = new Scanner(System.in);
                    melodie.setTitre(scan.next());
                    break;
                case 7:
                    System.out.print("Le titre est : ");
                    System.out.println(melodie.getTitre());
                    break;
                case 8:
                    System.out.println("De combien de demi-tons ?");
                    scan = new Scanner(System.in);
                    melodie.transposer(scan.nextInt());
                    System.out.println("Melodie transposee");
                    break;
                case 9:
                    System.out.println("Nom du fichier ?");
                    scan = new Scanner(System.in);
                    melodie.enregistrer(scan.next());
                    System.out.println("Melodie enregistree");
                    break;
                case 10:
                    System.out.println("Nom du fichier ?");
                    scan = new Scanner(System.in);
                    melodie.nouveau();
                    melodie.ouvrir(scan.next());
                    System.out.println("Melodie chargee.");
                    break;
                case 11:
                    img = new AwazImage();
                    img.setTitre(melodie.getTitre());
                    img.setMelodie(melodie.toABC());
                    scan = new Scanner(System.in);
                    if(scan.next() != null){
                        img.fermer();
                    }
                    break;
                /** @bug setMelodieNotationAbcComplete()
                 * Exception in thread "main" j.a:
                 * Erreur dans la partition représentant la mélodie :
                 * Parse errors: 1
                 * AbcFile-Error!E! = 'B D <LF>' (@(L:1, C:1; 0->1))
	             *   at i.d.e(Unknown Source)
	             *   at i.d.b(Unknown Source)
                 *   at i.f.b(Unknown Source)
	             *   at awaz.AwazImage.setMelodieNotationAbcComplete(AwazImage.java:68)
	             *   at testAwaz.MenuAwaz.main(MenuAwaz.java:105)
                 */
                /*
                case 12:
                    img = new AwazImage();
                    img.setTitre(melodie.getTitre());
                    //img.setMelodieNotationAbcComplete(melodie.toString());
                    img.setMelodieNotationAbcComplete(melodie.toABC());
                    scan = new Scanner(System.in);
                    if(scan.next() != null){
                        img.fermer();
                    }
                    break;
                */
            }
        }while(choix != 0);
    }
}
