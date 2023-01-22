package modele.generateur;

import modele.capteur.CapteurTemperatureActif;

public abstract class GenerateurTemperature {

    protected CapteurTemperatureActif capteurTemp;

    public GenerateurTemperature(CapteurTemperatureActif capteur, Bipper bipper){
        capteurTemp = capteur;
        bipper.observer(this);
    }

    public abstract void change() throws IOException;
}
