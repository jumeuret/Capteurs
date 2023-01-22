package modele;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import modele.generateur.GenerateurTemperature;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Bipper extends Thread {

    private List<GenerateurTemperature> generateurs = new ArrayList<>();

    private LongProperty intervale = new SimpleLongProperty();

    public LongProperty intervaleProperty(){
        return intervale;
    }

    private AtomicBoolean enMarche = new AtomicBoolean(false);

    public Bipper(long intervale){
        setIntervale(intervale);
        enMarche.set(true);
    }

    public long getIntervale() {
        return intervale.get();
    }

    public void setIntervale(long intervale) {
        this.intervale.set(intervale);
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
                Thread.sleep(getIntervale());
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
