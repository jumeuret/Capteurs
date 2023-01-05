package modele;

import java.io.IOException;

/**
 * Classe dérivée de CapteurTemperature permettant de créer des CapteurTemperature au comportement actif ( génération automatique de valeurs )
 */

public abstract class CapteurTemperatureActif extends CapteurTemperature {

    /**
     * Constructeur de CapteurTemperaturePassif
     * @param nomCapteur
     */
    public CapteurTemperatureActif(String nomCapteur) {
        super(nomCapteur);
        System.out.println("Hey !");
        genererTemperature();
    }

    /**
     * Méthode abstraite permettant de générer des températures
     */
    public abstract void genererTemperature();
}
