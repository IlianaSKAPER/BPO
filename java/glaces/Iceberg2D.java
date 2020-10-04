package glaces;
import geometrie.Point ;

/**
 * Un iceberg rectangulaire
 * @author Martine Gautier, Université de Lorraine
 */
public class Iceberg2D {

    private Point enBasAGauche ;
    private Point enHautADroite ;

    /**
     * Construction
     * @param g le coin en bas à gauche
     * @param d le coin en haut à droite
     * uniquement en coordonnées positives
     */
    public Iceberg2D(Point g, Point d) {
        this.enBasAGauche = g;
        this.enHautADroite = d;
    }

    /**
     * Construction par fusion de deux icebergs qui se touchent
     * @param i1 premier iceberg à fusionner
     * @param i2 deuxième iceberg à fusionner
     */
    public Iceberg2D(Iceberg2D i1, Iceberg2D i2) {
        double xEnBasAGauche = (i1.coinEnBasAGauche().getAbscisse() < i2.coinEnBasAGauche().getAbscisse())
                ? i1.coinEnBasAGauche().getAbscisse()
                : i2.coinEnBasAGauche().getAbscisse() ;
        double yEnBasAGauche = (i1.coinEnBasAGauche().getOrdonnee() < i2.coinEnBasAGauche().getOrdonnee())
                ? i1.coinEnBasAGauche().getOrdonnee()
                : i2.coinEnBasAGauche().getOrdonnee();
        double xEnHautADroite = (i1.coinEnHautADroite().getAbscisse() > i2.coinEnHautADroite().getAbscisse())
                ? i1.coinEnHautADroite().getAbscisse()
                : i2.coinEnHautADroite().getAbscisse();
        double yEnHautADroite = (i1.coinEnHautADroite().getOrdonnee() > i2.coinEnHautADroite().getOrdonnee())
                ? i1.coinEnHautADroite().getOrdonnee()
                : i2.coinEnHautADroite().getOrdonnee();

        this.enBasAGauche = new Point(xEnBasAGauche, yEnBasAGauche);
        this.enHautADroite = new Point(xEnHautADroite, yEnHautADroite);
    }

    /**
     * Retourne le coin en bas à gauche
     * @return le coin en bas à gauche
     */
    public Point coinEnBasAGauche() {
        return this.enBasAGauche;
    }

    /**
     * Retourne le coin en haut à droite
     * @return le coin en haut à droite
     */
    public Point coinEnHautADroite() {
        return this.enHautADroite;
    }


    /**
     * Retourne la hauteur
     * @return hauteur
     */
    public double hauteur() {
        Double y1 = this.coinEnHautADroite().getOrdonnee();
        Double y2 = this.coinEnBasAGauche().getOrdonnee();
        return java.lang.Math.abs(y1 - y2);
    }

    /**
     * Retourne la largeur
     * @return largeur
     */
    public double largeur() {
        Double x1 = this.coinEnHautADroite().getAbscisse();
        Double x2 = this.coinEnBasAGauche().getAbscisse();
        return java.lang.Math.abs(x1 - x2);
    }

    /**
     * Retourne la surface totale
     * @return surface totale
     */
    public double surface() {
        return this.largeur() * this.hauteur() ;
    }

    /**
     * Retourne vrai si il y a une collision entre les deux icebergs
     * @param i iceberg potentiellement en collision
     * @return vrai si collision entre les deux icebergs
     */
    public boolean collision(Iceberg2D i) {
        return ( this.appartientA(i.coinEnBasAGauche())
                || this.appartientA(i.coinEnHautADroite())
                || this.appartientA(new Point(i.coinEnBasAGauche().getAbscisse(), i.coinEnHautADroite().getOrdonnee()))
                || this.appartientA(new Point(i.coinEnHautADroite().getAbscisse(), i.coinEnBasAGauche().getOrdonnee()))
                || i.appartientA(this.coinEnHautADroite())
                || i.appartientA(this.coinEnBasAGauche())
                || i.appartientA(new Point(this.coinEnBasAGauche().getAbscisse(), this.coinEnBasAGauche().getOrdonnee()))
                || i.appartientA(new Point(this.coinEnHautADroite().getAbscisse(), this.coinEnBasAGauche().getOrdonnee())) );
    }

    /**
     * Retourne vrai si le point p est à l'intérieur du rectangle iceberg
     * @param p un Point
     * @return vrai si p est dans l'iceberg
     */
    public boolean appartientA(Point p) {
        return (p.getAbscisse() >= this.coinEnBasAGauche().getAbscisse()
                && p.getAbscisse() <= this.coinEnHautADroite().getAbscisse()
                && p.getOrdonnee() >= this.coinEnBasAGauche().getOrdonnee()
                && p.getOrdonnee() <= this.coinEnHautADroite().getOrdonnee());
    }

    /**
     * Retourne vrai si this est plus volumineux que i
     * @param i iceberg à comparer
     * @return vrai si this est plus volumineux que i
     */
    public boolean estPlusGrosQue(Iceberg2D i) {
        if(this.surface() > i.surface()) {
            return true;
        }
        return false ;
    }

    public String toString() {
        return "(BD: " + this.coinEnBasAGauche().toString() + " , HG: " + this.coinEnHautADroite().toString() + " )";
    }

    /**
     * Retourne le point au centre
     * @return le point au centre de l'iceberg
     */
    public Point centre() {
        double x = this.coinEnBasAGauche().getAbscisse() + (this.largeur()/2);
        double y = this.coinEnBasAGauche().getOrdonnee() + (this.hauteur()/2);
        return new Point(x, y);
    }

    /**
     * Réduction dans les quatre directions ; le centre ne bouge pas
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void fondre(double fr) {
        /*this.casserBas(fr);
        this.casserDroite(fr);
        this.casserGauche(fr);
        this.casserHaut(fr);
        */
        double frXenHD = (fr - 1) * this.largeur() /2;
        double frXenBG = (1 - fr) * this.largeur() /2;
        double frYenHD = (fr - 1) * this.hauteur() /2;
        double frYenBG = (1 - fr) * this.hauteur() /2;

        this.coinEnHautADroite().deplacer(frXenHD, frYenHD);
        this.coinEnBasAGauche().deplacer(frXenBG, frYenBG);
    }

    /**
     * Casser une partie à droite
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserDroite(double fr) {
        this.coinEnHautADroite().deplacer((fr-1)*this.largeur(), 0);
    }

    /**
     * Casser une partie à gauche
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserGauche(double fr) {
        this.coinEnBasAGauche().deplacer((1-fr)*this.largeur(), 0);
    }


    /**
     * Casser une partie en haut
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserHaut(double fr) {
        this.coinEnHautADroite().deplacer(0, (fr-1)*this.hauteur());
    }

    /**
     * Casser une partie en bas
     * @param fr dans ]0..1[ : définit le pourcentage supprimé
     */
    public void casserBas(double fr) {
        this.coinEnBasAGauche().deplacer(0, (1-fr)*this.hauteur());
    }

}
