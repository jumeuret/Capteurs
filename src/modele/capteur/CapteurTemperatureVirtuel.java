package modele.capteur;

import java.util.*;

/**
 * Classe dérivée de CapteurTemperature permettant de créer des CapteurTemperature au comportement actif ( génération automatique de valeurs )
 */

public class CapteurTemperatureVirtuel extends CapteurTemperatureBidule {

    private Map<Integer, CapteurTemperatureBidule> listeCapteurs = new HashMap<>();

    /**
     * Constructeur de CapteurTemperatureVirtuel
     * @param nomCapteur
     */
    public CapteurTemperatureVirtuel(String nomCapteur) {
        super(nomCapteur);

        genererTemperature();
    }

    public void ajouterCapteur(CapteurTemperatureBidule capteur, int poids){
        listeCapteurs.putIfAbsent(poids, capteur);
        //capteur.temperatureProperty().addListener();
    }

    /**
     * Méthode permettant de générer des températures
     */
    public void genererTemperature(){
        double moyenne = 0;
        for (CapteurTemperatureBidule capteur: listeCapteurs.values()) {
            for (int poids : listeCapteurs.keySet()){
                moyenne = moyenne + poids * capteur.getTemperature();
            }
        }
        moyenne = moyenne / listeCapteurs.size();
        setTemperature(moyenne);
    }
}
