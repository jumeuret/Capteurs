package console;

import modele.CapteurTemperature;
import view.Meteo;
import view.Thermometre;

public class Afficheur {

    public void afficherCapteurTemp(CapteurTemperature capteur){
        System.out.println(String.format("Capteur %d, nommé %s a pour température %d °C", capteur.getId(), capteur.getNom(), capteur.getTemperature()));
    }

    public void afficherMeteo(Meteo meteo){
        System.out.println(String.format("Fenêtre Météo basée sur le capteur %d, nommé %s affichant une température de %d °C", meteo.getCapteur().getId(), meteo.getCapteur().getNom(), ((CapteurTemperature)meteo.getCapteur()).getTemperature()));
    }

    public void afficherThermometre(Thermometre thermometre){
        System.out.println(String.format("Fenêtre Thermometre basée sur le capteur %d, nommé %s affichant une température de %d °C", thermometre.getCapteur().getId(), thermometre.getCapteur().getNom(), ((CapteurTemperature)thermometre.getCapteur()).getTemperature()));
    }
}
