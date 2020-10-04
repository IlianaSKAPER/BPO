package glaces.tests;

import geometrie.Point ;
import glaces.Iceberg2D;
import glaces.ArcticImage;
import glaces.Ocean;

public class TestOcean{
    public static void main(String[] args) {
        System.out.println("Debut test Ocean");
        testGetCount();
        testGetCount_0();

        testGetHeight_0();
        testGetHeight_auto();
        testGetHeight_donne();

        testGetWidth_0();
        testGetWidth_auto();
        testGetWidth_donne();

        testFondre();

        testOceanParam();

        testGetColors();

        testOceanParam_string();

        testToString();

        afficheOcean();
        afficheOcean2();

        System.out.println("Fin test Ocean");

    }

    private static void testGetCount(){
        Ocean oc = new Ocean();
        Ocean oc2 = new Ocean(6, 200, 200);
        boolean b = (oc.getCount() == 2 && oc2.getCount() == 6);
        assert(b): "bug dans getCount";
    }
    private static void testGetCount_0() {
        Ocean oc = new Ocean(0, 200, 200);
        assert(oc.getCount() == 0) : "bug dans getcount pour nb = 0";
    }

    private static void testGetHeight_auto() {
        Ocean oc = new Ocean();
        assert (oc.getHeight() == 300) : "Bug dans getHeight pour construction automatique (H=400)";
    }
    private static void testGetHeight_0() {
        Ocean oc = new Ocean(0, 0, 0);
        assert (oc.getHeight() == 0) : "Bug dans getHeight (H=0)";
    }
    private static void testGetHeight_donne(){
        Ocean oc = new Ocean(20, 500, 1000);
        assert (oc.getHeight() == 1000) : "Bug dans getHeight (H=1000)";
    }


    private static void testGetWidth_auto() {
        Ocean oc = new Ocean();
        assert (oc.getWidth() == 300) : "Bug dans getWidth pour construction automatique (L=400)";
    }
    private static void testGetWidth_0() {
        Ocean oc = new Ocean(0, 0, 0);
        assert (oc.getWidth() == 0) : "Bug dans getWidth (L=0)";
    }
    private static void testGetWidth_donne(){
        Ocean oc = new Ocean(20, 500, 1000);
        assert (oc.getWidth() == 500) : "Bug dans getWidth (L=500)";
    }

    private static void testFondre() {
        Ocean oc = new Ocean();
        boolean b1, b2, b3, b4, b5, b6, b7, b8;
        //tabIceberg[0] = new Iceberg2D(new Point(50, 50), new Point(90, 100));
        //tabIceberg[1] = new Iceberg2D(new Point(170, 100), new Point(200, 260));
        oc.fondre(0.5);
        // tab_0 = (<60, 62.5>, <80, 87.5>)
        //tab_1 = (<177.5, 140>, <192.5, 220>)
        b1 = (oc.getTabIceberg_ind(0).coinEnBasAGauche().getAbscisse() == 60.);
        b2 = (oc.getTabIceberg_ind(0).coinEnBasAGauche().getOrdonnee() == 62.5);
        b3 = (oc.getTabIceberg_ind(0).coinEnHautADroite().getAbscisse() == 80.);
        b4 = (oc.getTabIceberg_ind(0).coinEnHautADroite().getOrdonnee() == 87.5);
        b5 = (oc.getTabIceberg_ind(1).coinEnBasAGauche().getAbscisse() == 177.5);
        b6 = (oc.getTabIceberg_ind(1).coinEnBasAGauche().getOrdonnee() == 140.);
        b7 = (oc.getTabIceberg_ind(1).coinEnHautADroite().getAbscisse() == 192.5);
        b8 = (oc.getTabIceberg_ind(1).coinEnHautADroite().getOrdonnee() == 220.);
        assert(b1 && b2 && b3 && b4 && b5 && b6 && b7 && b8) : "bug dans la fonction fondre";

    }

    private static void testOceanParam(){
        Ocean oc = new Ocean(3, 500, 905);
        assert (oc != null): "bug construction ocean retourne null";
        assert( oc.getCount() == 3) : "bug construction Ocean avec parametres, mauvais nb d'iceberg";
        assert( oc.getHeight() == 905 && oc.getWidth() == 500) : "bug construction par parametre, mauvais hauteur/largueur";
    }

    private static void testOceanParam_string(){
        Ocean oc = new Ocean(3, 400, 250);
        System.out.println("3, 400, 250");
        System.out.println(oc.toString());
    }

    private static void testToString() {
        Ocean oc = new Ocean(3, 500, 1000);
        System.out.println("Test toSring() : Doit afficher L=500, H=1000, nb=3 + 3 icebergs");
        System.out.println(oc.toString());
    }

    private static void testGetColors(){
        Ocean oc = new Ocean();
        int[][] tab = oc.getColors();
        boolean error = false;

        for(int j =  0; j < oc.getHeight(); j++) {
            for(int i = 0; i < oc.getWidth(); i++) {
                Point p = new Point(i, j);
                //si on a de la glace dans tab mais que le point n'appartient pas à un iceberg : erreur
                if( (tab[i][j] == 1) && !(appartientA(p, oc.getTabIceberg_ind(0))) && !(appartientA(p, oc.getTabIceberg_ind(1))) ) {
                    error = true;
                //si on a de l'eau dans tab mais que le point appartient à un icebeg : erreur
                } else if ((tab[i][j]==0) && appartientA(p, oc.getTabIceberg_ind(0)) && appartientA(p, oc.getTabIceberg_ind(1))){
                    error = true;
                }
            }
        }
        assert(!error): "Bug pour getColors()";
    }

    private static boolean appartientA(Point p, Iceberg2D i) {
        return (p.getAbscisse() >= i.coinEnBasAGauche().getAbscisse()
                && p.getAbscisse() <= i.coinEnHautADroite().getAbscisse()
                && p.getOrdonnee() >= i.coinEnBasAGauche().getOrdonnee()
                && p.getOrdonnee() <= i.coinEnHautADroite().getOrdonnee());
    }

    private static void afficheOcean(){
        Ocean ocean = new Ocean();
        ArcticImage img = new ArcticImage(ocean.getWidth(), ocean.getHeight());
        img.setColors(ocean.getColors());
    }

    private static void afficheOcean2(){
        Ocean ocean = new Ocean(3, 500, 800);
        ArcticImage img = new ArcticImage(ocean.getWidth(), ocean.getHeight());
        img.setColors(ocean.getColors());
    }


}