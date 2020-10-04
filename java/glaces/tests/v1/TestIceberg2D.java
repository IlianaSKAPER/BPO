package glaces.tests;
import geometrie.Point ;
import glaces.Iceberg2D;

/**
 * Un iceberg rectangulaire
 * @author Martine Gautier, Université de Lorraine
 */
public class TestIceberg2D {
        public static void main(String[] args) {
            Iceberg2D ib = new Iceberg2D(new Point(1, 2), new Point(4, 3));
            Iceberg2D ib2 = new Iceberg2D(new Point(4, 3), new Point(7, 6));

            Point p1 = ib.coinEnBasAGauche();
            Point p2 = ib.coinEnHautADroite();
            System.out.println("ib : BG : " + p1.toString() + " , HD : " + p2.toString());
            System.out.println("ib version tostring : " + ib.toString());
            System.out.println("ib2 : " + ib2.toString());

            System.out.println("H : " + ib.hauteur());
            System.out.println("H : " + ib2.hauteur());

            System.out.println("L : " + ib.largeur());
            System.out.println("L : " + ib2.largeur());

            System.out.println("S : " + ib.surface());
            System.out.println("S : " + ib2.surface());

            System.out.println("Centre ib : " + ib.centre() + " , centre ib2 : " + ib2.centre());

            Iceberg2D ib3 = new Iceberg2D(ib, ib2);
            System.out.println("Fusion : HD : " + ib3.coinEnHautADroite().toString() + " BG : " + ib3.coinEnBasAGauche().toString());
            System.out.println("icebergs fusionne : " + ib3.toString());

            System.out.println("Fondre :");
            System.out.println("centre avant fonte : " + ib.centre());
            System.out.println(ib.toString());
            ib.fondre(0.5);
            System.out.println("centre apres fonte : " + ib.centre());
            System.out.println(ib.toString());

            System.out.println("Fonctions 'casser' : ");
            System.out.println("Avant: " + ib2.toString());
            ib2.casserHaut(0.7);
            System.out.println("casserHaut : " + ib2.toString());
            ib2.casserBas(0.7);
            System.out.println("casserBas : " + ib2.toString());
            ib2.casserDroite(0.7);
            System.out.println("casserDroite : " + ib2.toString());
            ib2.casserGauche(0.7);
            System.out.println("casserGauche : " + ib2.toString());
        }
}
