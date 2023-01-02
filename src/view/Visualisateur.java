package view;

import modele.Capteur;

import java.io.IOException;

/**
 * Classe abstraite permettant de créer des fenêtres
 */
public abstract class Visualisateur {

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
}
