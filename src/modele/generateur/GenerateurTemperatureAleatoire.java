package modele.generateur;

import modele.Bipper;
import modele.capteur.capteurActif.CapteurTemperatureActif;

import java.util.Random;

public class GenerateurTemperatureAleatoire extends GenerateurTemperature {

    public GenerateurTemperatureAleatoire(CapteurTemperatureActif capteur, Bipper bipper){
        super(capteur, bipper);
    }

    public void change(){
        Random random = new Random();
        double randomDouble;
        randomDouble = random.nextDouble(-100, 100);
        capteurTemp.setTemperature(randomDouble);
    }
}
