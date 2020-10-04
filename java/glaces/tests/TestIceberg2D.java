package glaces.tests;
import geometrie.Point ;
import glaces.Iceberg2D;

/**
 * Un iceberg rectangulaire
 * @author Martine Gautier, Université de Lorraine
 */
public class TestIceberg2D {
        public static void main(String[] args) {
            System.out.println("Debut test Iceberg2D");

            testCoinEnBasAGauche();
            testCoinEnHautADroite();

            testIceberg2D_1();
            testIceberg2D_2();
            testIceberg2D_3();
            testIceberg2D_4();
            testIceberg2D_5();

            testHauteur_0();
            testHauteur_1();
            testHauteur_2();

            testLargeur_0();
            testLargeur_1();
            testLargeur_2();

            testSurface_0();
            testSurface_1();
            testSurface_2();

	/*
            testAppartientA_0();
            testAppartientA_Faux();
            testAppartientA_Vrai();
            */

            testCollision_0();
            testCollision_Faux();
            testCollision_Vrai();
            testCollision_Vrai_2();

            testCentre();
            testCentre_0();

            testFondre_0();
            testFondre_fr0();
            testFondre_fr1();
            testFondre_fr05();

            testCasserDroite_0();
            testCasserDroite_fr0();
            testCasserDroite_fr1();
            testCasserDroite_fr05();

            testCasserGauche_0();
            testCasserGauche_fr0();
            testCasserGauche_fr1();
            testCasserGauche_fr05();

            testEstPlusGrosQueFaux();
            testEstPlusGrosQueVrai();

            System.out.println("Fin test Iceberg2D");
        }

        private static void testCoinEnBasAGauche() {
            Point p1, p2;
            Iceberg2D i1;
            Point pBG;
            boolean b;
            p1 = new Point(1., 2.);
            p2 = new Point(99., 77.);
            i1 = new Iceberg2D(p1, p2);
            pBG = i1.coinEnBasAGauche();
            b = (pBG.getAbscisse() == p1.getAbscisse() && pBG.getOrdonnee() == p1.getOrdonnee());
            assert(b): "Bug dans coinEnBasAGauche";
        }
    private static void testCoinEnHautADroite() {
        Point p1, p2;
        Iceberg2D i1;
        Point pHD;
        boolean b;
        p1 = new Point(3., 2.);
        p2 = new Point(45., 32.);
        i1 = new Iceberg2D(p1, p2);
        pHD = i1.coinEnBasAGauche();
        b = (pHD.getAbscisse() == p1.getAbscisse() && pHD.getOrdonnee() == p1.getOrdonnee());
        assert(b): "Bug dans coinEnHautADroite";
    }

    private static void testIceberg2D_1() {
        Point p1, p2, p3, p4;
        Iceberg2D i1, i2, i3;
        boolean b;
        p1 = new Point(3., 2.);
        p2 = new Point(45., 32.);
        p3 = new Point(5., 7.);
        p4 = new Point(222., 80.);
        i1 = new Iceberg2D(p1, p2);
        i2 = new Iceberg2D(p3, p4);
        i3 = new Iceberg2D(i1, i2);
        b = (i3.coinEnBasAGauche().getAbscisse() == 3.
                && i3.coinEnBasAGauche().getOrdonnee() == 2.
                && i3.coinEnHautADroite().getAbscisse() == 222.
                && i3.coinEnHautADroite().getOrdonnee() == 80.);
        assert (b) : "Bug dans le constructeur de fusion : test 1";
    }
    private static void testIceberg2D_2() {
        Point p1, p2, p3, p4;
        Iceberg2D i1, i2, i3;
        boolean b;
        p1 = new Point(3., 2.);
        p2 = new Point(45., 32.);
        p3 = new Point(5., 7.);
        p4 = new Point(222., 80.);
        i1 = new Iceberg2D(p1, p2);
        i2 = new Iceberg2D(p3, p4);
        i3 = new Iceberg2D(i2, i1);
        b = (i3.coinEnBasAGauche().getAbscisse() == 3.
                && i3.coinEnBasAGauche().getOrdonnee() == 2.
                && i3.coinEnHautADroite().getAbscisse() == 222.
                && i3.coinEnHautADroite().getOrdonnee() == 80.);
        assert (b) : "Bug dans le constructeur de fusion : test 2";
    }
    private static void testIceberg2D_3() {
        Point p1, p2, p3, p4;
        Iceberg2D i1, i2, i3;
        boolean b;
        p1 = new Point(3., 2.);
        p2 = new Point(45., 32.);
        p3 = new Point(5., 7.);
        p4 = new Point(222., 80.);
        i1 = new Iceberg2D(p1, p4);
        i2 = new Iceberg2D(p3, p2);
        i3 = new Iceberg2D(i1, i2);
        b = (i3.coinEnBasAGauche().getAbscisse() == 3.
                && i3.coinEnBasAGauche().getOrdonnee() == 2.
                && i3.coinEnHautADroite().getAbscisse() == 222.
                && i3.coinEnHautADroite().getOrdonnee() == 80.);
        assert (b) : "Bug dans le constructeur de fusion : test 3";
    }
    private static void testIceberg2D_4() {
        Point p1, p2, p3, p4;
        Iceberg2D i1, i2, i3;
        boolean b;
        p1 = new Point(3., 2.);
        p2 = new Point(45., 32.);
        p3 = new Point(5., 7.);
        p4 = new Point(222., 80.);
        i1 = new Iceberg2D(p3, p2);
        i2 = new Iceberg2D(p1, p4);
        i3 = new Iceberg2D(i1, i2);
        b = (i3.coinEnBasAGauche().getAbscisse() == 3.
                && i3.coinEnBasAGauche().getOrdonnee() == 2.
                && i3.coinEnHautADroite().getAbscisse() == 222.
                && i3.coinEnHautADroite().getOrdonnee() == 80.);
        assert (b) : "Bug dans le constructeur de fusion : test 4";
    }
    private static void testIceberg2D_5() {
        Point p1, p2, p3, p4;
        Iceberg2D i1, i2, i3;
        boolean b;
        p1 = new Point(0., 0.);
        p2 = new Point(0., 0.);
        p3 = new Point(0., 0.);
        p4 = new Point(0., 0.);
        i1 = new Iceberg2D(p1, p2);
        i2 = new Iceberg2D(p3, p4);
        i3 = new Iceberg2D(i1, i2);
        b = (i3.coinEnBasAGauche().getAbscisse() == 0.
                && i3.coinEnBasAGauche().getOrdonnee() == 0.
                && i3.coinEnHautADroite().getAbscisse() == 0.
                && i3.coinEnHautADroite().getOrdonnee() == 0.);
        assert (b) : "Bug dans le constructeur de fusion : test 5 (tous les points à 0,0)";
    }


    private static void testHauteur_0(){
        Point p1, p2;
        Iceberg2D i1;
        p1 = new Point(0., 0.);
        p2 = new Point(0., 0.);
        i1 = new Iceberg2D(p1, p2);
        assert (i1.hauteur() == 0) : "Bug dans hauteur() pour x et y = 0";
    }
    private static void testHauteur_1(){
        Point p1, p2;
        Iceberg2D i1;
        p1 = new Point(0., 0.);
        p2 = new Point(0., 4.);
        i1 = new Iceberg2D(p1, p2);
        assert (i1.hauteur() == 4) : "Bug dans hauteur() pour y=0 et y=4";
    }
    private static void testHauteur_2(){
        Point p1, p2;
        Iceberg2D i1;
        p1 = new Point(3., 5.);
        p2 = new Point(66., 25.);
        i1 = new Iceberg2D(p1, p2);
        assert (i1.hauteur() == 20) : "Bug dans hauteur() pour y=5 et y = 25";
    }
    private static void testLargeur_0(){
        Point p1, p2;
        Iceberg2D i1;
        p1 = new Point(0., 0.);
        p2 = new Point(0., 0.);
        i1 = new Iceberg2D(p1, p2);
        assert (i1.largeur() == 0) : "Bug dans largeur() pour x et y = 0";
    }
    private static void testLargeur_1(){
        Point p1, p2;
        Iceberg2D i1;
        p1 = new Point(0., 0.);
        p2 = new Point(4., 0.);
        i1 = new Iceberg2D(p1, p2);
        assert (i1.largeur() == 4) : "Bug dans largeur() pour X=0 et x=4";
    }
    private static void testLargeur_2(){
        Point p1, p2;
        Iceberg2D i1;
        p1 = new Point(3., 5.);
        p2 = new Point(66., 25.);
        i1 = new Iceberg2D(p1, p2);
        assert (i1.largeur() == 63) : "Bug dans largeur() pour x=3 et x=66";
    }
    private static void testSurface_0() {
        Point p1, p2;
        Iceberg2D i1;
        p1 = new Point(0., 0.);
        p2 = new Point(0., 0.);
        i1 = new Iceberg2D(p1, p2);
        assert (i1.surface() == 0) : "Bug dans surface() pour x et y = 0";
    }
    private static void testSurface_1() {
        Point p1, p2;
        Iceberg2D i1;
        p1 = new Point(1., 2.);
        p2 = new Point(3., 4.);
        i1 = new Iceberg2D(p1, p2);
        assert (i1.surface() == 4) : "Bug dans surface (test1)";
    }
    private static void testSurface_2() {
        Point p1, p2;
        Iceberg2D i1;
        p1 = new Point(1., 4.);
        p2 = new Point(2., 6.);
        i1 = new Iceberg2D(p1, p2);
        assert (i1.surface() == 2) : "Bug dans surface (test2)";
    }


    private static void testAppartientA_0(){
        Point p1, p2, p3;
        Iceberg2D i1, i2;
        boolean b;
        p1 = new Point(0., 0.);
        p2 = new Point(0., 0.);
        p3 = new Point(0., 0.);
        i1 = new Iceberg2D(p1, p2);
        b = i1.appartientA(p3);
        assert(b): "Bug appartientA 0,0";
    }
    private static void testAppartientA_Vrai(){
        Point p1, p2, p3;
        Iceberg2D i1, i2;
        boolean b;
        p1 = new Point(1., 2.);
        p2 = new Point(33., 44.);
        p3 = new Point(25., 36.);
        i1 = new Iceberg2D(p1, p2);
        b = i1.appartientA(p3);
        assert(b): "Bug appartientA Vrai";
    }
    private static void testAppartientA_Faux(){
        Point p1, p2, p3;
        Iceberg2D i1, i2;
        boolean b;
        p1 = new Point(1., 2.);
        p2 = new Point(27., 88.);
        p3 = new Point(30., 100.);
        i1 = new Iceberg2D(p1, p2);
        b = i1.appartientA(p3);
        assert(!b): "Bug appartientA Faux";
    }

    private static void testCollision_0(){
        Point p1, p2, p3, p4;
        Iceberg2D i1, i2;
        boolean b;
        p1 = new Point(0., 0.);
        p2 = new Point(0., 0.);
        p3 = new Point(0., 0.);
        p4 = new Point(0., 0.);
        i1 = new Iceberg2D(p1, p2);
        i2 = new Iceberg2D(p3, p4);
        b = i1.collision(i2);
        assert(b): "Bug collision tous les points à 0,0";
    }
    private static void testCollision_Faux(){
        Point p1, p2, p3, p4;
        Iceberg2D i1, i2;
        boolean b;
        p1 = new Point(1., 2.);
        p2 = new Point(3., 4.);
        p3 = new Point(55., 66.);
        p4 = new Point(77., 88.);
        i1 = new Iceberg2D(p1, p2);
        i2 = new Iceberg2D(p3, p4);
        b = i1.collision(i2);
        assert(!b): "Bug collision Faux";
    }
    private static void testCollision_Vrai(){
        Point p1, p2, p3, p4;
        Iceberg2D i1, i2;
        boolean b;
        p1 = new Point(1., 5.);
        p2 = new Point(55., 66.);
        p3 = new Point(25., 34.);
        p4 = new Point(77., 88.);
        i1 = new Iceberg2D(p1, p2);
        i2 = new Iceberg2D(p3, p4);
        b = i1.collision(i2);
        assert(b): "Bug collision Vrai";
    }
    private static void testCollision_Vrai_2(){
        Point p1, p2, p3, p4;
        Iceberg2D i1, i2;
        boolean b;
        p1 = new Point(1., 5.);
        p2 = new Point(4., 10.);
        p3 = new Point(4., 10.);
        p4 = new Point(77., 88.);
        i1 = new Iceberg2D(p1, p2);
        i2 = new Iceberg2D(p3, p4);
        b = i1.collision(i2);
        assert(b): "Bug collision Vrai";
    }

    private static void testCentre(){
        Point p1, p2;
        Iceberg2D i1;
        p1 = new Point(1., 4.);
        p2 = new Point(3., 6.);
        i1 = new Iceberg2D(p1, p2);
        assert (i1.centre().getAbscisse() == 2 && i1.centre().getOrdonnee() == 5) : "Bug dans centre";
    }
    private static void testCentre_0(){
        Point p1, p2;
        Iceberg2D i1;
        p1 = new Point(0., 0.);
        p2 = new Point(0., 0.);
        i1 = new Iceberg2D(p1, p2);
        assert (i1.centre().getAbscisse() == 0 && i1.centre().getOrdonnee() == 0) : "Bug dans centre";
    }

    private static void testFondre_0(){
        Point p1, p2;
        Iceberg2D i1;
        double fr = 0.5;
        p1 = new Point(0., 0.);
        p2 = new Point(0., 0.);
        i1 = new Iceberg2D(p1, p2);
        i1.fondre(fr);
        assert (i1.coinEnBasAGauche().getAbscisse() == 0
                && i1.coinEnBasAGauche().getOrdonnee() == 0
                && i1.coinEnHautADroite().getAbscisse() == 0
                && i1.coinEnHautADroite().getOrdonnee() == 0) : "Bug dans fondre pour 0,0";
    }
    private static void testFondre_fr05(){
        Point p1, p2, centre;
        Iceberg2D i1;
        double fr = 0.5;
        p1 = new Point(1., 1.);
        p2 = new Point(3., 9.);
        i1 = new Iceberg2D(p1, p2);
        centre = i1.centre();
        i1.fondre(fr);
        assert (i1.coinEnBasAGauche().getAbscisse() == 1.5
                && i1.coinEnBasAGauche().getOrdonnee() == 3.
                && i1.coinEnHautADroite().getAbscisse() == 2.5
                && i1.coinEnHautADroite().getOrdonnee() == 7.
                && centre.getAbscisse() == i1.centre().getAbscisse()
                && centre.getOrdonnee() == i1.centre().getOrdonnee()) : "Bug dans fondre pour fr=0.5";
    }
    private static void testFondre_fr0(){
        Point p1, p2, centre;
        Iceberg2D i1;
        double fr = 0;
        p1 = new Point(1., 1.);
        p2 = new Point(3., 9.);
        i1 = new Iceberg2D(p1, p2);
        centre = i1.centre();
        i1.fondre(fr);
        assert (i1.coinEnBasAGauche().getAbscisse() == i1.centre().getAbscisse()
                && i1.coinEnBasAGauche().getOrdonnee() == i1.centre().getOrdonnee()
                && i1.coinEnHautADroite().getAbscisse() == i1.centre().getAbscisse()
                && i1.coinEnHautADroite().getOrdonnee() == i1.centre().getOrdonnee()
                && centre.getAbscisse() == i1.centre().getAbscisse()
                && centre.getOrdonnee() == i1.centre().getOrdonnee()) : "Bug dans fondre pour fr=0";
    }
    private static void testFondre_fr1(){
        Point p1, p2, centre;
        Iceberg2D i1;
        double fr = 1;
        p1 = new Point(1., 1.);
        p2 = new Point(3., 9.);
        i1 = new Iceberg2D(p1, p2);
        centre = i1.centre();
        i1.fondre(fr);
        assert (i1.coinEnBasAGauche().getAbscisse() == 1.
                && i1.coinEnBasAGauche().getOrdonnee() == 1.
                && i1.coinEnHautADroite().getAbscisse() == 3.
                && i1.coinEnHautADroite().getOrdonnee() == 9.
                && centre.getAbscisse() == i1.centre().getAbscisse()
                && centre.getOrdonnee() == i1.centre().getOrdonnee()) : "Bug dans fondre pour fr=1";
    }
    private static void testCasserDroite_0() {
        Point p1, p2;
        Iceberg2D i1;
        double fr = 0.5;
        p1 = new Point(0., 0.);
        p2 = new Point(0., 0.);
        i1 = new Iceberg2D(p1, p2);
        i1.casserDroite(fr);
        assert (i1.coinEnBasAGauche().getAbscisse() == 0.
                && i1.coinEnBasAGauche().getOrdonnee() == 0.
                && i1.coinEnHautADroite().getAbscisse() == 0.
                && i1.coinEnHautADroite().getOrdonnee() == 0.) : "Bug casser droite pour 0.0";
    }
    private static void testCasserDroite_fr05() {
        Point p1, p2;
        Iceberg2D i1;
        double fr = 0.5;
        p1 = new Point(1., 5.);
        p2 = new Point(9., 10.);
        i1 = new Iceberg2D(p1, p2);
        i1.casserDroite(fr);
        assert (i1.coinEnBasAGauche().getAbscisse() == 1.
                && i1.coinEnBasAGauche().getOrdonnee() == 5.
                && i1.coinEnHautADroite().getAbscisse() == 5.
                && i1.coinEnHautADroite().getOrdonnee() == 10.) : "Bug casser droite pour fr=0.5";
    }
    private static void testCasserDroite_fr1() {
        Point p1, p2;
        Iceberg2D i1;
        double fr = 1;
        p1 = new Point(1., 5.);
        p2 = new Point(9., 10.);
        i1 = new Iceberg2D(p1, p2);
        i1.casserDroite(fr);
        assert (i1.coinEnBasAGauche().getAbscisse() == 1.
                && i1.coinEnBasAGauche().getOrdonnee() == 5.
                && i1.coinEnHautADroite().getAbscisse() == 9.
                && i1.coinEnHautADroite().getOrdonnee() == 10.) : "Bug casser droite pour fr=1";
    }
    private static void testCasserDroite_fr0() {
        Point p1, p2;
        Iceberg2D i1;
        double fr = 0.;
        p1 = new Point(1., 5.);
        p2 = new Point(9., 10.);
        i1 = new Iceberg2D(p1, p2);
        i1.casserDroite(fr);
        assert (i1.coinEnBasAGauche().getAbscisse() == 1.
                && i1.coinEnBasAGauche().getOrdonnee() == 5.
                && i1.coinEnHautADroite().getAbscisse() == 1.
                && i1.coinEnHautADroite().getOrdonnee() == 10.) : "Bug casser droite pour fr=0";
    }


    private static void testCasserGauche_0() {
        Point p1, p2;
        Iceberg2D i1;
        double fr = 0.5;
        p1 = new Point(0., 0.);
        p2 = new Point(0., 0.);
        i1 = new Iceberg2D(p1, p2);
        i1.casserGauche(fr);
        assert (i1.coinEnBasAGauche().getAbscisse() == 0.
                && i1.coinEnBasAGauche().getOrdonnee() == 0.
                && i1.coinEnHautADroite().getAbscisse() == 0.
                && i1.coinEnHautADroite().getOrdonnee() == 0.) : "Bug casser gauche pour 0.0";
    }
    private static void testCasserGauche_fr05() {
        Point p1, p2;
        Iceberg2D i1;
        double fr = 0.5;
        p1 = new Point(1., 5.);
        p2 = new Point(9., 10.);
        i1 = new Iceberg2D(p1, p2);
        i1.casserGauche(fr);
        assert (i1.coinEnBasAGauche().getAbscisse() == 5.
                && i1.coinEnBasAGauche().getOrdonnee() == 5.
                && i1.coinEnHautADroite().getAbscisse() == 9.
                && i1.coinEnHautADroite().getOrdonnee() == 10.) : "Bug casser gauche pour fr=0.5";
    }
    private static void testCasserGauche_fr1() {
        Point p1, p2;
        Iceberg2D i1;
        double fr = 1;
        p1 = new Point(1., 5.);
        p2 = new Point(9., 10.);
        i1 = new Iceberg2D(p1, p2);
        i1.casserGauche(fr);
        assert (i1.coinEnBasAGauche().getAbscisse() == 1.
                && i1.coinEnBasAGauche().getOrdonnee() == 5.
                && i1.coinEnHautADroite().getAbscisse() == 9.
                && i1.coinEnHautADroite().getOrdonnee() == 10.) : "Bug casser gauche pour fr=1";
    }
    private static void testCasserGauche_fr0() {
        Point p1, p2;
        Iceberg2D i1;
        double fr = 0.;
        p1 = new Point(1., 5.);
        p2 = new Point(9., 10.);
        i1 = new Iceberg2D(p1, p2);
        i1.casserGauche(fr);
        assert (i1.coinEnBasAGauche().getAbscisse() == 9.
                && i1.coinEnBasAGauche().getOrdonnee() == 5.
                && i1.coinEnHautADroite().getAbscisse() == 9.
                && i1.coinEnHautADroite().getOrdonnee() == 10.) : "Bug casser gauche pour fr=0";
    }

    private static void testEstPlusGrosQueFaux(){
        Point p1, p2, p3, p4;
        Iceberg2D i1, i2;
        boolean b;
        p1 = new Point(1., 5.);
        p2 = new Point(4., 10.);
        p3 = new Point(4., 10.);
        p4 = new Point(77., 88.);
        i1 = new Iceberg2D(p1, p2);
        i2 = new Iceberg2D(p3, p4);
        b = i1.estPlusGrosQue(i2);
        assert(!b): "Bug plsugrosque Faux";
    }
    private static void testEstPlusGrosQueVrai(){
        Point p1, p2, p3, p4;
        Iceberg2D i1, i2;
        boolean b;
        p1 = new Point(1., 5.);
        p2 = new Point(4., 10.);
        p3 = new Point(4., 10.);
        p4 = new Point(77., 88.);
        i1 = new Iceberg2D(p1, p2);
        i2 = new Iceberg2D(p3, p4);
        b = i2.estPlusGrosQue(i1);
        assert(b): "Bug plsugrosque Vrai";
    }
}

