package view;

import modele.Capteur;
import modele.Observateur;

import java.io.IOException;

public abstract class Visualisateur implements Observateur {

    protected Capteur capteur;

    public Visualisateur(Capteur capteur){
        this.capteur = capteur;
    }

    public Capteur getCapteur() {
        return capteur;
    }

    public void initialize() throws IOException {
        this.getCapteur().attacher(this);
    }
}
