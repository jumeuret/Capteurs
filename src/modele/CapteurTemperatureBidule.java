package modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.io.IOException;

/**
 * Classe dérivée de Capteur permettant de créer des CapteurTemperature
 */
public abstract class CapteurTemperatureBidule extends CapteurTemperature{

    /**
     * Constructeur de CapteurTemperature
     * @param nomCapteur
     */
    public CapteurTemperatureBidule(String nomCapteur) {
        super(nomCapteur);
    }

    /**
     * Méthode abstraite permettant de générer des températures
     */
    public abstract void genererTemperature();
}
