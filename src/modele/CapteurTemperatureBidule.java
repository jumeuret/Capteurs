package modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.io.IOException;

/**
 * Classe dérivée de Capteur permettant de créer des CapteurTemperature
 */
public abstract class CapteurTemperatureBidule extends CapteurTemperature{

    protected Bipper bipper;

    /**
     * Constructeur de CapteurTemperature
     * @param nomCapteur
     */
    public CapteurTemperatureBidule(String nomCapteur, Bipper bipper) {
        super(nomCapteur);
        this.bipper = bipper;
    }

    /**
     * Méthode abstraite permettant de générer des températures
     */
    public abstract void genererTemperature();
}
