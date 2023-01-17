package modele.generateur;

import modele.capteur.CapteurTemperatureActif;

public abstract class GenerateurTemperature extends Thread {

    protected CapteurTemperatureActif capteurTemp;

    public GenerateurTemperature(CapteurTemperatureActif capteur){
        capteurTemp = capteur;
    }

    public abstract void run();
}
