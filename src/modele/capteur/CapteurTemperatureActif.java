package modele.capteur;

/**
 * Classe dérivée de CapteurTemperature permettant de créer des CapteurTemperature au comportement actif ( génération automatique de valeurs )
 */

public abstract class CapteurTemperatureActif extends CapteurTemperatureBidule {

    /**
     * Constructeur de CapteurTemperaturePassif
     * @param nomCapteur
     */
    public CapteurTemperatureActif(String nomCapteur) {
        super(nomCapteur);
        genererTemperature();
    }

    /**
     * Méthode permettant de générer des températures
     */
    public void genererTemperature(){

    };
}
