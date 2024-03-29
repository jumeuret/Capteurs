package modele.generateur;

import modele.Bipper;
import modele.capteur.capteurActif.CapteurRealiste;
import modele.capteur.capteurActif.CapteurTemperatureActif;

import java.util.Random;

public class GenerateurTemperatureRealiste extends GenerateurTemperature {

    public GenerateurTemperatureRealiste(CapteurTemperatureActif capteur, Bipper bipper){

        super(capteur, bipper);
    }

    public void change(){
        Random random = new Random();
        double randomDouble;
        randomDouble = random.nextDouble(((CapteurRealiste) capteurTemp).getMinTemperature(), ((CapteurRealiste) capteurTemp).getMaxTemperature());
        capteurTemp.setTemperature(randomDouble);
    }
}
