package glaces.tests;
import geometrie.Point ;
import glaces.Iceberg2D;
import glaces.ArcticImage;
import glaces.Ocean;
import glaces.Jeu;

/**
 * Test pour la classe glaces.ArcticImage
 * @author Iliana SKAPER
 */
public class TestArcticImage {
        public static void main(String[] args) {
            System.out.println("Debut test ArcticImage");

            int[][] tab = new int[300][300];
            ArcticImage img = new ArcticImage(300, 300);

            for(int i = 0; i<300; i++){
                for(int j = 0; j<300; j++){
                    tab[i][j] = (j%2 == 0) ? 0 : 1 ;
                }
            }

            img.setColors(tab);

            System.out.println("Fin test ArcticImage");



            System.out.println("Début test pour ocean");

            Ocean oce = new Ocean(3, 700, 400);
            Ocean o = new Ocean();
            ArcticImage img_oce = new ArcticImage(oce.getWidth(), oce.getHeight());
            ArcticImage img_o = new ArcticImage(o.getWidth(), o.getHeight());

            img_oce.setColors(oce.getColors());
            img_o.setColors(o.getColors());

            System.out.println("Fin test pour ocean");


        }
}

