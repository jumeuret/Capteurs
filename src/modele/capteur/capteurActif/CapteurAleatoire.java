package modele.capteur.capteurActif;

import modele.Bipper;
import modele.generateur.GenerateurTemperatureAleatoire;

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
