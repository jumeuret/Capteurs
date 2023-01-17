package exec;

import console.Afficheur;
import modele.capteur.CapteurTemperature;
import view.Meteo;
import view.Thermometre;

import java.io.IOException;

/**
 * Classe de tests console
 */
public class Main {

    /**
     * Méthode de test de création et de modifications de fenêtre Meteo, Thermometre et de CapteurTemperature
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Afficheur affiche = new Afficheur();
        CapteurTemperature capteur = new CapteurTemperature("Test");
        CapteurTemperature capteur2 = new CapteurTemperature("Test2");
        //capteur.setTemperature(10);
        Meteo meteo = new Meteo(capteur);
        Thermometre thermometre = new Thermometre(capteur);

        affiche.afficherCapteurTemp(capteur);
        affiche.afficherCapteurTemp(capteur2);
        affiche.afficherMeteo(meteo);
        affiche.afficherThermometre(thermometre);
        //((CapteurTemperature)thermometre.getCapteur()).setTemperature(-2);
        affiche.afficherCapteurTemp(capteur);
        affiche.afficherMeteo(meteo);
        affiche.afficherThermometre(thermometre);

    }
}
