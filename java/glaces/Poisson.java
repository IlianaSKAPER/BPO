package glaces;
import geometrie.Point ;
import glaces.Iceberg2D;
import glaces.Pingouin;
import glaces.Ocean;
import java.util.Random;
import java.lang.Math;

/**
 * Poisson contenu dans un ocean
 * @author Iliana SKAPER
 */
public class Poisson {

    private int largeur;
    private int hauteur;
    private Point position;
    private int deplacement;
    private boolean mange;

    /**
     * Construction
     * @param p le Point de la position du poisson
     */
    public Poisson(Point p) {
        this.largeur = 10;
        this.hauteur = 5;
        this.position = p;
        this.mange = false;

        /* Déplacement choisi aléatoirement
        si vaut 1 : déplacement sur les abscisses
        si vaut 0 : déplacement sur les ordonnees
        */
        Random r = new Random();
        this.deplacement = r.nextInt(1);
    }

    public int getHeight() {
        return this.hauteur;
    }

    public int getWidth() {
        return this.largeur;
    }

    public Point getPosition() {
        return this.position;
    }

    public int getDeplacement(){
        return this.deplacement;
    }

    public void poissonMange(){
        this.mange = true;
    }
    public boolean isEaten() {
        return this.mange;
    }

    public void deplacer() {
        if(this.deplacement == 1) {
            this.position.deplacer(30, 0);
        } else {
            this.position.deplacer(0, 30);
        }
    }

    public void reset(int c) {
        if(this.deplacement == 1) {
            this.position.deplacer(-c, 0);
        } else {
            this.position.deplacer(0, -c);
        }
    }



}
