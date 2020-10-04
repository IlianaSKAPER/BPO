package glaces;

import geometrie.Point ;
import glaces.Iceberg2D;
import glaces.Ocean;
import glaces.ArcticImage;
import glaces.Ocean;

public class Pingouin{
    private Point position;
    private int taille;

    /**
     * constructeur de base
     * taille = 10
     * et position à 0,0
     */
    public Pingouin(){
        this.taille = 10;
        this.position = new Point(0, 0);
    }

    /**
     * constructeur avec paramètres
     * @param size taille du pingouin
     * @param p un Point (coordonnees du pingouin)
     */
    public Pingouin(int size, Point p){
        this.taille = size;
        this.position = p;
    }

    /**
     * Donne la position x, y du pingouin
     * @return un Point qui est les coordonnées en bas à gauche du pingouin
     */
    public Point getPosition(){
        return this.position;
    }

    /**
     * Donne la taille du pingouin
     * @return le champ taille du pingouin
     */
    public int getSize() {
        return this.taille;
    }

    /**
     * Fonctions de déplacement vers le haut
     */
    public void enHaut(){
        this.position.deplacer(30, 0);
    }

    /**
     * Fonctions de déplacement vers le bas
     */
    public void enBas(){
        this.position.deplacer(-30, 0);
    }

    /**
     * Fonctions de déplacement vers la droite
     */
    public void versDroite(){
        this.position.deplacer(0, 30);
    }

    /**
     * Fonctions de déplacement vers la gauche
     */
    public void versGauche(){
        this.position.deplacer(0, -30);
    }


    /**
     * Test si le pingouin est au bord de la fenêtre
     * @return un booléen: vrai si le pingouin touche le bord, faux sinon
     */
    public boolean toucheLeBord(Ocean oce) {
        boolean b1 = this.position.getAbscisse() == 0;
        boolean b2 = this.position.getOrdonnee() == 0;
        boolean b3 = this.position.getAbscisse() + this.taille == oce.getHeight();
        boolean b4 = this.position.getOrdonnee() + this.taille == oce.getWidth();
        return (b1 || b2 || b3 || b4);
    }

}