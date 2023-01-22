package modele.capteur;

/**
 * Classe dérivée de CapteurTemperature permettant de créer des CapteurTemperature au comportement actif ( génération automatique de valeurs )
 */

public abstract class CapteurTemperatureActif extends CapteurTemperature {

    /**
     * Constructeur de CapteurTemperaturePassif
     * @param nomCapteur
     */
    public CapteurTemperatureActif(String nomCapteur, Bipper bipper) {
        super(nomCapteur, bipper);
    }

    /**
     * Méthode permettant de générer des températures
     */
    public void genererTemperature() throws IOException {

    };
}
