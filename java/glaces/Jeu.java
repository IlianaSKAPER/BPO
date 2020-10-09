package glaces;

import geometrie.Point ;
import glaces.Iceberg2D;
import glaces.ArcticImage;
import glaces.Ocean;
import glaces.Pingouin;
import java.util.Scanner;

public class Jeu{
    private Ocean ocean;
    private ArcticImage img;
    private boolean fin;

    /**
     * constructeur sans paramètre
     */
    public Jeu(){
        this.ocean = new Ocean(3, 800, 500);
        this.img = new ArcticImage(800, 500);
        this.fin = false;
    }

    public Ocean getOcean(){
        return this.ocean;
    }

    private void quitter(){
        this.fin = true;
    }

    public void jouer(){
        this.img.setColors(this.ocean.getColors());
        Scanner scan = new Scanner(System.in);
        String choix;

        while(!this.fin) {
            System.out.println("Deplacement ? (ZSDQ) : ");

            choix = scan.nextLine();

            if (choix.equals("z") || choix.equals("Z")) {
                this.ocean.getPingouin().enHaut();
                if(this.ocean.getPingouin().toucheLeBordHaut(this.ocean)) {
                    this.ocean.getPingouin().enBas();
                }
            } else if (choix.equals("s") || choix.equals("S")){
                this.ocean.getPingouin().enBas();
                if(this.ocean.getPingouin().toucheLeBordBas(this.ocean)) {
                    this.ocean.getPingouin().enHaut();
                }
            } else if (choix.equals("d") || choix.equals("D")) {
                this.ocean.getPingouin().versDroite();
                if(this.ocean.getPingouin().toucheLeBordDroit(this.ocean)) {
                    this.ocean.getPingouin().versGauche();
                }
            } else if (choix.equals("q") || choix.equals("Q")){
                this.ocean.getPingouin().versGauche();
                if(this.ocean.getPingouin().toucheLeBordGauche(this.ocean)) {
                    this.ocean.getPingouin().versDroite();
                }
            } else {
                this.quitter();
            }

            ocean.pingouinMangePoisson();

            ocean.deplacerPoissons();

            this.img.setColors(this.ocean.getColors());
        }
        scan.close();
    }


}