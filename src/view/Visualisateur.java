package view;

import modele.Capteur;
import modele.Observateur;

import java.io.IOException;

/**
 * Classe abstraite dérivée d'Observateur permettant de créer des fenêtres
 */
public abstract class Visualisateur implements Observateur {

    /**
     * Attribut capteur des Visualisateur
     */
    protected Capteur capteur;

    /**
     * Constructeur de Visualisateur
     * @param capteur
     */
    public Visualisateur(Capteur capteur){
        this.capteur = capteur;
    }

    /**
     * Getter du Capteur
     * @return le Capteur
     */
    public Capteur getCapteur() {
        return capteur;
    }

    /**
     * Méthode se lançant à l'initialisation permettant au Visualisateur d'observer le Capteur
     * @throws IOException
     */
    public void initialize() throws IOException {
        this.getCapteur().attacher(this);
    }
}
