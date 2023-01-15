package modele;

import javafx.application.Platform;

import java.util.Random;

public abstract class GenerateurTemperature {

    protected CapteurTemperatureActif capteurTemp;

    public GenerateurTemperature(CapteurTemperatureActif capteur, Bipper bipper){
        capteurTemp = capteur;
        bipper.observer(this);
    }

    public abstract void change();
}
