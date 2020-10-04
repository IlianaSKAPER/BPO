package glaces;

import geometrie.Point ;
import glaces.Iceberg2D;
import glaces.ArcticImage;
import glaces.Ocean;
import glaces.Pingouin;
import java.util.Scanner;

public class Jeu{
    //private Ocean ocean;
    //private ArcticImage img;
    //private boolean fin;

    /**
     * constructeur sans paramètre

    public Jeu(){
        this.ocean = new Ocean(3, 800, 500);
        this.img = new ArcticImage(800, 500);
        this.fin = false;
    }*/

    /**
     * constructeur vide
     */
    public Jeu(char c){ }
/*
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

            if (choix == "z" || choix == "Z") {
                this.ocean.getPingouin().enHaut();
            } else if (choix == "s" || choix == "S") {
                this.ocean.getPingouin().enBas();
            } else if (choix == "d" || choix == "D") {
                this.ocean.getPingouin().versDroite();
            } else if (choix == "q" || choix == "Q"){
                this.ocean.getPingouin().versGauche();
            } else {
                this.quitter();
            }

            this.img.setColors(this.ocean.getColors());
        }
        scan.close();
    }*/

    public void jouer2(){
        Ocean ocean = new Ocean(3, 800, 500);
        ArcticImage img = new ArcticImage(800, 500);
        boolean fin = false;
        img.setColors(ocean.getColors());
        Scanner scan = new Scanner(System.in);
        String choix;

        while(!fin) {
            System.out.println("Deplacement ? (ZSDQ) : ");

            choix = scan.nextLine();

            if (choix == "z" || choix == "Z") {
                ocean.getPingouin().enHaut();
            } else if (choix == "s" || choix == "S") {
                ocean.getPingouin().enBas();
            } else if (choix == "d" || choix == "D") {
                ocean.getPingouin().versDroite();
            } else if (choix == "q" || choix == "Q"){
                ocean.getPingouin().versGauche();
            } else {
                fin = true;
            }

            img.setColors(ocean.getColors());
            System.out.println(ocean.getPingouin().getPosition().toString());
        }
        scan.close();
    }
}