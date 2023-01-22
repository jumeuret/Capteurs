package modele.capteur.capteurActif;

import modele.Bipper;
import modele.generateur.GenerateurTemperatureVariatif;

public class CapteurVariatif extends CapteurTemperatureActif{

    private double minVariation;

    private double maxVariation;

    /**
     * Constructeur de CapteurVariatif
     *
     * @param nomCapteur
     */
    public CapteurVariatif(String nomCapteur, double min, double max, Bipper bipper) {
        super(nomCapteur, bipper);
        minVariation = min;
        maxVariation = max;
        genererTemperature();
    }

    @Override
    public void setTemperature(double temperature) {
        super.setTemperature(temperature);
    }

    public double getMaxVariation() {
        return maxVariation;
    }

    public double getMinVariation() {
        return minVariation;
    }

    @Override
    public void genererTemperature() {
        new GenerateurTemperatureVariatif(this, bipper).change();
        bipper.start();
    }
}
