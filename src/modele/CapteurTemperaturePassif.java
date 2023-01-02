package modele;

import java.io.IOException;

/**
 * Classe dérivée de CapteurTemperature permettant de créer des CapteurTemperature au comportement passif ( sans génération automatique de valeurs )
 */

public class CapteurTemperaturePassif extends CapteurTemperature {

    /**
     * Constructeur de CapteurTemperaturePassif
     * @param nomCapteur
     */
    public CapteurTemperaturePassif(String nomCapteur) {
        super(nomCapteur);
    }
}
