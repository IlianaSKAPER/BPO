package glaces;
import geometrie.Point ;
import glaces.Iceberg2D;
import glaces.Pingouin;
import java.util.Random;
import java.lang.Math;

/**
 * Ocean contenant des Icebergs
 * @author Iliana SKAPER
 */
public class Ocean {

    private int largeur;
    private int hauteur;
    private Iceberg2D[] tabIceberg;
    private Pingouin pingouin;
    private Poisson[] poissons;

    /**
     * Construction
     * valeurs automatiques
     */
    public Ocean() {
        this.largeur = 300;
        this.hauteur = 300;
        this.tabIceberg = new Iceberg2D[2];
        tabIceberg[0] = new Iceberg2D(new Point(50, 50), new Point(90, 100));
        tabIceberg[1] = new Iceberg2D(new Point(170, 100), new Point(200, 260));
        this.pingouin = new Pingouin(20, new Point(this.largeur - 20, 0));

        this.poissons = new Poisson[10];
        for(int i = 0; i < 10; i++) {
            this.poissons[i] = new Poisson(new Point(i*30, i*30));
        }
    }

    /**
     * Construction
     * @param nb nombre d'icebergs
     * @param larg largeur de l'ocean
     * @param haut hauteur de l'ocean
     */
    public Ocean(int nb, int larg, int haut){
        this.hauteur = haut;
        this.largeur = larg;
        this.pingouin = new Pingouin(20, new Point(this.largeur - 20, 0));

        this.tabIceberg = new Iceberg2D[nb];
        /*
        Random  g  =  new  Random();
        for(int i = 0; i<nb; i++){  //pour chaque iceberg
            int x1 = i*(larg/nb) + g.nextInt( (i+1)*(larg/(2*nb)) );
            int x2 = ((i+1)*(larg/(2*nb))) + g.nextInt( (i+1)*(larg/nb) );
            int y1 = g.nextInt(larg);
            int y2 = g.nextInt(larg);
            tabIceberg[i] = new Iceberg2D(new Point(Math.max(x1, x2), Math.min(y1, y2)), new Point(Math.min(x1, x2), Math.max(y1, y2)));
        }*/
        Random g = new Random();
        double l = (double) larg;
        double n = (double) nb;
        double h = (double) haut;
        int marge1 = g.nextInt((int)((3.*l)/(10.*n))) + (int)(l/(10*n));
        for (int i = 0; i<nb; i++) {
            int x1 = i * (larg/nb) + marge1;
            int x2 = (i+1) * (larg/nb) - marge1;
            int y1 = g.nextInt(haut - 10) +10;
            int y2 = g.nextInt(haut - 10) + 10;
            tabIceberg[i] = new Iceberg2D(new Point(x1, Math.min(y1, y2)), new Point(x2, Math.max(y1, y2)));
        }

        this.poissons = new Poisson[10];
        for(int i = 0; i < 10; i++) {
            double pois_x = g.nextInt(this.getWidth() - 10);
            double pois_y = g.nextInt(this.getHeight() - 5);
            this.poissons[i] = new Poisson(new Point(pois_x, pois_y));
        }
    }

    /**
     * Hauteur de l'océan
     * @return hauteur
     */
    public int getHeight(){
        return this.hauteur;
    }

    /**
     * Largeur de l'océan
     * @return largeur
     */
    public int getWidth(){
        return this.largeur;
    }

    /**
     * Retourne le nombre d'iceberg
     * @return la taille du tableau d'iceberg
     */
    public int getCount() {
        return this.tabIceberg.length;
    }

    /**
     * Retourne l'Iceberg contenu dans l'indice i de tabIceberg
     * @param i indice dans le tableau tabIceberg
     * @return un Iceberg2D dont l'indice est i
     */
    public Iceberg2D getTabIceberg_ind(int i){
        return tabIceberg[i];
    }

    /**
     * renvoie le Pingouin de l'Ocean
     * @return pingouin
     */
    public Pingouin getPingouin(){
        return this.pingouin;
    }

    /**
     * fait fondre tous les Icebergs
     * @param fr facteur de réduction ]O.,1.[
     */
    public void fondre(double fr) {
        for (int i = 0; i < this.getCount(); i++) {
            tabIceberg[i].fondre(fr);
        }
    }

    /**
     * Retourne le tableau de couleurs, 0 si c'est la mer, 1 si c'est la glace
     * @return un tableau à deux dimensions d'entiers [x][y] avec x=largeur et y=hauteur
     */
    public int[][] getColors(){
        int[][] colors = new int[this.getWidth()][this.getHeight()];
        //on initialise toutes les cases à 0 (eau)
        for(int j = 0; j < getHeight(); j++) {
            for(int i = 0; i < getWidth(); i++) {
                colors[i][j] = 0;
            }
        }

        //pour chaque iceberg
        for(int i = 0; i < this.getCount(); i++) {
            //pour chaque ligne le long de la hauteur
            for(int j = 0; j < this.getTabIceberg_ind(i).hauteur(); j++) {
                //pour pour chaque point le long de la largeur
                for(int k = 0; k < this.getTabIceberg_ind(i).largeur(); k++) {
                    // x : abscisse du point minimal de l'iceberg plus la largeur parcourue par la boucle
                    int x = (int) this.getTabIceberg_ind(i).coinEnBasAGauche().getAbscisse() + k;
                    // y : ordonnée du point minimal plus la hauteur parcourue dans la boucle
                    int y = (int) this.getTabIceberg_ind(i).coinEnBasAGauche().getOrdonnee() + j;
                    colors[x][y] = 1; //on met de la glace
                }
            }
        }

        //pour le pingouin :
        for(int j = 0; j < this.pingouin.getSize(); j++) {
            for(int i = 0; i < this.pingouin.getSize(); i++) {
                int x = ((int) this.pingouin.getPosition().getAbscisse()) + i;
                int y = ((int) this.pingouin.getPosition().getOrdonnee()) + j;
                colors[x][y] = 2;
            }
        }

        //pour les poissons:
        for(int k = 0; k<10; k++) {
            if(!(this.poissons[k].isEaten())) {
                for(int j = 0; j < this.poissons[k].getHeight(); j++) {
                    for(int i = 0; i < this.poissons[k].getWidth(); i++) {
                        int x = ((int) this.poissons[k].getPosition().getAbscisse()) + i;
                        int y = ((int) this.poissons[k].getPosition().getOrdonnee()) + j;
                        if(this.poissons[k].getDeplacement() == 1){
                            colors[x][y] = 4;
                        } else {
                            colors[x][y] = 5;
                        }
                    }
                }
            }
        }

        return colors;
    }



    public void deplacerPoissons(){
        for(int k = 0; k<10; k++) {
            if(this.poissons[k].getDeplacement() == 1 && this.poissons[k].getPosition().getAbscisse() >= this.largeur + this.poissons[k].getWidth()){
                this.poissons[k].reset(this.largeur);
            } else if(this.poissons[k].getDeplacement() == 0 && this.poissons[k].getPosition().getOrdonnee() >= this.hauteur + this.poissons[k].getHeight()) {
                this.poissons[k].reset(this.hauteur);
            } else {
                this.poissons[k].deplacer();
            }
        }
    }

    public boolean pingouinTouchePoisson(int i) {
            double pois_x_min, pois_x_max, pois_y_min, pois_y_max, ping_x_min, ping_x_max, ping_y_min, ping_y_max;
            pois_x_min = this.poissons[i].getPosition().getAbscisse();
            pois_x_max = this.poissons[i].getPosition().getAbscisse() + this.poissons[i].getWidth();
            pois_y_min = this.poissons[i].getPosition().getOrdonnee();
            pois_y_max = this.poissons[i].getPosition().getOrdonnee() +this.poissons[i].getHeight();

            boolean b = (this.pingouin.appartientA(this.poissons[i].getPosition())
                    || this.pingouin.appartientA(new Point(pois_x_max, pois_y_max))
                    || this.pingouin.appartientA(new Point(pois_x_min, pois_y_max))
                    || this.pingouin.appartientA(new Point(pois_x_max, pois_y_min)) );

            return b;
    }

    public void pingouinMangePoisson() {
        for(int i = 0; i<10; i++) {
            if(this.pingouinTouchePoisson(i)) {
                this.poissons[i].poissonMange();
            }
        }
    }


    /**
     * retourne les informations (taille de l'ocean, nb d'icebergs, description des icebergs) en format String
     * @return un String à propos de Ocean
     */
    public String toString() {
        String s = "Ocean : H=" + this.getHeight() + " L=" + this.getWidth() + " et nb icebergs = " + this.getCount() + "   Icebergs : ";
        for(int i = 0; i<this.getCount(); i++) {
            s = s + "IB" + (i+1) + ": " + this.tabIceberg[i].toString() + " ";
        }
        return s;
    }



}
