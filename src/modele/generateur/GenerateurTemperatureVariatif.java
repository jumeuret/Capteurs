package modele.generateur;

import modele.Bipper;
import modele.capteur.capteurActif.CapteurTemperatureActif;
import modele.capteur.capteurActif.CapteurVariatif;

import java.util.Random;

public class GenerateurTemperatureVariatif extends GenerateurTemperature {

    public GenerateurTemperatureVariatif(CapteurTemperatureActif capteur, Bipper bipper){

        super(capteur, bipper);
    }

    public void change(){
        Random random = new Random();
        double randomDouble;
        randomDouble = random.nextDouble(-15,15);
        ((CapteurVariatif) capteurTemp).getMinVariation();
        ((CapteurVariatif) capteurTemp).getMaxVariation();
        randomDouble = random.nextDouble(((CapteurVariatif) capteurTemp).getMinVariation(), ((CapteurVariatif) capteurTemp).getMaxVariation());
        randomDouble = capteurTemp.getTemperature() + randomDouble;
        capteurTemp.setTemperature(randomDouble);
    }
}
