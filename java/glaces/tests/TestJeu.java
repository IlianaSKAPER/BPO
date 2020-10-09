package glaces.tests;

import geometrie.Point;
import glaces.Iceberg2D;
import glaces.ArcticImage;
import glaces.Ocean;
import glaces.Pingouin;
import glaces.Jeu;

public class TestJeu{
    public static void main(String[] args) {
        //testJeu_constructeur();
        //testGetOcean();

        Jeu game = new Jeu();
        game.jouer();

    }

    private static void testJeu_constructeur() {
        Jeu j = new Jeu();
        assert(j != null): "bug declaration de Jeu sans param";
    }

    private static void testGetOcean() {
        Jeu j = new Jeu();
        Ocean oce = j.getOcean();
        assert(oce != null): "bug dans récup de Ocean (==null)";
        assert(oce.getCount() == 3 && oce.getHeight() == 500 && oce.getWidth() == 800): "bug récupération ocean, mauvaise valeurs";
    }
}