package modele.generateur;

import javafx.application.Platform;
import modele.capteur.CapteurTemperatureActif;

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
