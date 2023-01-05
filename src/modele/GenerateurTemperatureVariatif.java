package modele;

import javafx.application.Platform;

import java.util.Random;

public class GenerateurTemperatureVariatif extends GenerateurTemperature {

    public GenerateurTemperatureVariatif(CapteurTemperatureActif capteur){

        super(capteur);
    }

    public void run(){
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Platform.runLater(() -> {
                Random random = new Random();
                double randomDouble;
                randomDouble = random.nextDouble(((CapteurVariatif) capteurTemp).getMinVariation(), ((CapteurVariatif) capteurTemp).getMaxVariation());
                randomDouble = ((CapteurVariatif) capteurTemp).getTemperatureInitiale() + randomDouble;
                capteurTemp.setTemperature(randomDouble);
            });
        }
    }
}
