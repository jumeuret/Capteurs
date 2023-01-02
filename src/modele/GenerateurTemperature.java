package modele;

import javafx.application.Platform;

import java.util.Random;

public class GenerateurTemperature extends Thread {

    private CapteurTemperatureActif capteurTemp;

    public GenerateurTemperature(CapteurTemperatureActif capteur){
        capteurTemp = capteur;
    }

    public void run(){
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Platform.runLater(() -> {
                capteurTemp.genererTemperature();
            });
            new GenerateurTemperature(capteurTemp).start();
        }
    }
}
