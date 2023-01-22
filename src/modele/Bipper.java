package modele;

import javafx.application.Platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Bipper extends Thread {

    private List<GenerateurTemperature> generateurs = new ArrayList<>();

    private long intervale;

    private AtomicBoolean enMarche = new AtomicBoolean(false);

    public Bipper(long intervale){
        this.intervale = intervale;
        enMarche.set(true);
    }

    public void observer(GenerateurTemperature generateur){
        generateurs.add(generateur);
    }

    public void bip() throws IOException {
        for (GenerateurTemperature generateur : generateurs) {
            generateur.change();
        }
    }

    public void stopped(){
        enMarche.set(false);
    }

    public void run(){
        while (enMarche.get()) {
            try {
                Thread.sleep(intervale);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Platform.runLater(() -> {
                try {
                    bip();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
