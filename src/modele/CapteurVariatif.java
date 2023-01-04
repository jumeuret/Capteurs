package modele;

import java.util.Random;

public class CapteurVariatif extends CapteurTemperatureActif{

    private double minVariation;

    private double maxVariation;

    private double temperatureInitiale;

    /**
     * Constructeur de CapteurVariatif
     *
     * @param nomCapteur
     */
    public CapteurVariatif(String nomCapteur, double min, double max) {
        super(nomCapteur);
        minVariation = min;
        maxVariation = max;
    }

    @Override
    public void setTemperature(double temperature) {
        temperatureInitiale = super.getTemperature();
        super.setTemperature(temperature);
    }

    public double getMaxVariation() {
        return maxVariation;
    }

    public double getMinVariation() {
        return minVariation;
    }

    public double getTemperatureInitiale() {
        return temperatureInitiale;
    }

    @Override
    public void genererTemperature() {

    }
}
