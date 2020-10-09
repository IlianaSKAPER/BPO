package glaces.tests;
import geometrie.Point ;
import glaces.Iceberg2D;
import glaces.ArcticImage;
import glaces.Ocean;
import glaces.Pingouin;
import glaces.Jeu;

/**
 * Un iceberg rectangulaire
 * @author Martine Gautier, Université de Lorraine
 */
public class TestPingouin {
    public static void main(String[] args) {
        testConstructeurAuto();
        testEnHaut();
        testEnBas();
        testVersDroite();
        testVersGauche();
        testDeplacement();
        testToucheLeBordVrai();
        testToucheLeBordFaux();
    }

    private static void testConstructeurAuto(){
        Pingouin pingu = new Pingouin();
        boolean b = pingu.getPosition().getAbscisse() == 0 && pingu.getPosition().getOrdonnee() == 0;
        assert(b): "bug constructeur auto";
    }

    private static void testEnHaut() {
        Pingouin pingu = new Pingouin();
        pingu.enHaut();
        boolean b = pingu.getPosition().getAbscisse() == 0 && pingu.getPosition().getOrdonnee() == 30;
        assert(b): " bug test enHaut";
    }
    private static void testEnBas() {
        Pingouin pingu = new Pingouin();
        pingu.enBas();
        boolean b = pingu.getPosition().getAbscisse() == 0 && pingu.getPosition().getOrdonnee() == -30;
        assert(b): " bug test enBas";
    }
    private static void testVersGauche() {
        Pingouin pingu = new Pingouin();
        pingu.versGauche();
        boolean b = pingu.getPosition().getAbscisse() == -30 && pingu.getPosition().getOrdonnee() == 0;
        assert(b): " bug test versGauche";
    }
    private static void testVersDroite() {
        Pingouin pingu = new Pingouin();
        pingu.versDroite();
        boolean b = pingu.getPosition().getAbscisse() == 30 && pingu.getPosition().getOrdonnee() == 0;
        assert(b): " bug test versDroite";
    }

    private static void testDeplacement() {
        Pingouin pingu = new Pingouin(30, new Point(50, 30));
        pingu.versDroite();
        pingu.enHaut();
        boolean b = pingu.getPosition().getAbscisse() == 80 && pingu.getPosition().getOrdonnee() == 60;
        System.out.println(pingu.getPosition().toString());
        assert(b): "bug testDeplacement";
    }

    private static void testToucheLeBordVrai(){
        Ocean oce = new Ocean();
        boolean b = oce.getPingouin().toucheLeBord(oce);
        assert(b): "bug toucheLeBord (vrai)";
    }
    private static void testToucheLeBordFaux(){
        Ocean oce = new Ocean();
        oce.getPingouin().enHaut();
        oce.getPingouin().versGauche();
        boolean b = oce.getPingouin().toucheLeBord(oce);
        assert(!b): "bug toucheLeBord (faux)";
    }


}