package modele.generateur;

import javafx.application.Platform;
import modele.capteur.CapteurRealiste;
import modele.capteur.CapteurTemperatureActif;

import java.util.Random;

public class GenerateurTemperatureRealiste extends GenerateurTemperature {

    public GenerateurTemperatureRealiste(CapteurTemperatureActif capteur){

        super(capteur);
    }

    public void run(){
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Platform.runLater(() -> {
                Random random = new Random();
                double randomDouble;
                randomDouble = random.nextDouble(((CapteurRealiste) capteurTemp).getMinTemperature(), ((CapteurRealiste) capteurTemp).getMaxTemperature());
                capteurTemp.setTemperature(randomDouble);
            });
        }
    }
}
