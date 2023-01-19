package modele.capteur;

import modele.generateur.GenerateurTemperatureAleatoire;
import modele.generateur.GenerateurTemperatureVariatif;

public class CapteurAleatoire extends CapteurTemperatureActif{

    /**
     * Constructeur de CapteurVariatif
     *
     * @param nomCapteur
     */
    public CapteurAleatoire(String nomCapteur) {
        super(nomCapteur);
    }

    @Override
    public void setTemperature(double temperature) {
        super.setTemperature(temperature);
    }

    @Override
    public void genererTemperature() {
        new GenerateurTemperatureAleatoire(this).start();
    }
}
