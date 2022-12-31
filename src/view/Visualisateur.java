package view;

import modele.Capteur;
import modele.Observateur;

public abstract class Visualisateur implements Observateur {

    private Capteur capteur;

    public Visualisateur(Capteur capteur){
        this.capteur = capteur;
    }

    public Capteur getCapteur() {
        return capteur;
    }

    public void fermer(){
        //
    }

    public void initialize() {
        this.getCapteur().attacher(this);
    }
}
