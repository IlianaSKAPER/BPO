package glaces.tests;

import geometrie.Point;
import glaces.Iceberg2D;
import glaces.ArcticImage;
import glaces.Ocean;
import glaces.Pingouin;
import glaces.Jeu;

public class TestJeu{
    public static void main(String[] args) {
        //testJeu_auto();
        //testJeu_param();
        //testGetOcean();

        //Ocean oce = new Ocean(4, 500, 800);
        //System.out.println(oce.toString());
        //Jeu game = new Jeu(oce);
        //Jeu game = new Jeu(new Ocean(4, 500, 800));
        //Jeu game = new Jeu();

        /*
        System.out.println(game.getOcean().toString());
        if(game != null) {
            //game.jouer();
        }
        */

        //jouer();

        Jeu game = new Jeu('v');
        game.jouer2();
    }
/*
    private static void testJeu_auto() {
        Jeu j = new Jeu();
        assert(j != null): "bug declaration de Jeu sans param";
    }*/
    /*
    private static void testJeu_param() {
        Jeu j = new Jeu(new Ocean());
        assert(j != null): "bug declaration de Jeu avec param Ocean";
    }*/
/*
    private static void testGetOcean() {
        Jeu j = new Jeu();
        Ocean oce = j.getOcean();
        assert(oce != null): "bug dans récup de Ocean (==null)";
        assert(oce.getCount() == 4 && oce.getHeight() == 500 && oce.getWidth() == 700): "bug récupération ocean, mauvaise valeurs";
    }*/
}