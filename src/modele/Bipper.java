package modele;

import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

public class Bipper extends Thread {

    private List<GenerateurTemperature> generateurs = new ArrayList<>();

    private long intervale;

    public Bipper(long intervale){
        this.intervale = intervale;
    }

    public void observer(GenerateurTemperature generateur){
        generateurs.add(generateur);
    }

    public void bip(){
        for (GenerateurTemperature generateur : generateurs) {
            generateur.change();
        }
    }

    public void run(){
        while (true) {
            try {
                Thread.sleep(intervale);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Platform.runLater(() -> {
                bip();
            });
        }
    }
}
