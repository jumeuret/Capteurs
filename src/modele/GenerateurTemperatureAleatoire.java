package modele;

import javafx.application.Platform;

import java.util.Random;

public class GenerateurTemperatureAleatoire extends GenerateurTemperature {

    private CapteurTemperatureActif capteurTemp;

    public GenerateurTemperatureAleatoire(CapteurTemperatureActif capteur){

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
                randomDouble = random.nextDouble(-100, 100);
                capteurTemp.setTemperature(randomDouble);
            });
            new GenerateurTemperatureAleatoire(capteurTemp).start();
        }
    }
}
