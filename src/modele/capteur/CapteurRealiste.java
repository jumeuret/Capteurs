package modele.capteur;

import modele.Bipper;
import modele.generateur.GenerateurTemperatureRealiste;

public class CapteurRealiste extends CapteurTemperatureActif{

    // >= -213 °C
    private double minTemperature;

    private double maxTemperature;

    /**
     * Constructeur de CapteurRealiste
     *
     * @param nomCapteur
     */
    public CapteurRealiste(String nomCapteur, double min, double max, Bipper bipper) {
        super(nomCapteur, bipper);
        if (min < -213){
            min = -213;
        }
        else{
            minTemperature = min;
        }
        maxTemperature = max;
        genererTemperature();
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    @Override
    public void genererTemperature() {

        new GenerateurTemperatureRealiste(this, bipper);
        bipper.run();
    }
}
