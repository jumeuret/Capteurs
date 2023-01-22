package modele.capteur;

import modele.Bipper;
import modele.generateur.GenerateurTemperatureAleatoire;
import modele.generateur.GenerateurTemperatureRealiste;
import modele.generateur.GenerateurTemperatureVariatif;

public class CapteurAleatoire extends CapteurTemperatureActif{

    /**
     * Constructeur de CapteurVariatif
     *
     * @param nomCapteur
     */
    public CapteurAleatoire(String nomCapteur, Bipper bipper) {
        super(nomCapteur, bipper);
    }

    @Override
    public void setTemperature(double temperature) {
        super.setTemperature(temperature);
    }

    @Override
    public void genererTemperature() {
        new GenerateurTemperatureAleatoire(this, bipper);
        bipper.run();
    }
}
