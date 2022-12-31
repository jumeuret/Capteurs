package console;

import modele.CapteurTemperature;
import view.Meteo;
import view.Thermometre;

/**
 * Classe d'affichage
 */
public class Afficheur {

    /**
     * Méthode affichant les informations d'un CapteurTemperature
     * @param capteur
     */
    public void afficherCapteurTemp(CapteurTemperature capteur){
        System.out.println(String.format("Capteur %d, nommé %s a pour température %d °C", capteur.getId(), capteur.getNom(), capteur.getTemperature()));
    }

    /**
     * Méthode affichant les informations d'une fenêtre Meteo
     * @param meteo
     */
    public void afficherMeteo(Meteo meteo){
        System.out.println(String.format("Fenêtre Météo basée sur le capteur %d, nommé %s affichant une température de %d °C", meteo.getCapteur().getId(), meteo.getCapteur().getNom(), ((CapteurTemperature)meteo.getCapteur()).getTemperature()));
    }

    /**
     * Méthode affichant les informations d'une fenêtre Thermometre
     * @param thermometre
     */
    public void afficherThermometre(Thermometre thermometre){
        System.out.println(String.format("Fenêtre Thermometre basée sur le capteur %d, nommé %s affichant une température de %d °C", thermometre.getCapteur().getId(), thermometre.getCapteur().getNom(), ((CapteurTemperature)thermometre.getCapteur()).getTemperature()));
    }
}
