package modele.capteur;

import modele.Bipper;
import modele.generateur.GenerateurTemperatureCPU;

import java.io.IOException;

public class CapteurCPU extends CapteurTemperatureActif{

    /**
     * Constructeur de CapteurVariatif
     *
     * @param nomCapteur
     */
    public CapteurCPU(String nomCapteur, Bipper bipper) throws IOException {
        super(nomCapteur, bipper);
        genererTemperature();
    }

    @Override
    public void setTemperature(double temperature) {
        super.setTemperature(temperature);
    }

    @Override
    public void genererTemperature() {
        new GenerateurTemperatureCPU(this, bipper).change();
        bipper.start();
    }
}
