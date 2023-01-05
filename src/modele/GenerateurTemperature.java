package modele;

import javafx.application.Platform;

import java.util.Random;

public abstract class GenerateurTemperature extends Thread {

    protected CapteurTemperatureActif capteurTemp;

    public GenerateurTemperature(CapteurTemperatureActif capteur){
        capteurTemp = capteur;
    }

    public abstract void run();
}
