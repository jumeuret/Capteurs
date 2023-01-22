package modele.generateur;

import modele.Bipper;
import modele.capteur.capteurActif.CapteurTemperatureActif;

import java.io.IOException;

public abstract class GenerateurTemperature {

    protected CapteurTemperatureActif capteurTemp;

    public GenerateurTemperature(CapteurTemperatureActif capteur, Bipper bipper){
        capteurTemp = capteur;
        bipper.observer(this);
    }

    public abstract void change() throws IOException;
}
