package modele.capteur;

import java.util.*;

/**
 * Classe dérivée de CapteurTemperature permettant de créer des CapteurTemperature au comportement actif ( génération automatique de valeurs )
 */

public class CapteurTemperatureVirtuel extends CapteurTemperature {

    private Map<Integer, CapteurTemperature> listeCapteurs = new HashMap<>();

    /**
     * Constructeur de CapteurTemperatureVirtuel
     * @param nomCapteur
     */
    public CapteurTemperatureVirtuel(String nomCapteur) {
        super(nomCapteur);

        genererTemperature();
    }

    public Map<Integer, CapteurTemperature> getListeCapteurs() {
        return listeCapteurs;
    }

    public void ajouterCapteur(CapteurTemperature capteur, int poids){
        listeCapteurs.putIfAbsent(poids, capteur);
        //capteur.temperatureProperty().addListener();
    }

    /**
     * Méthode permettant de générer des températures
     */
    public void genererTemperature(){
        double moyenne = 0;
        for (CapteurTemperature capteur: listeCapteurs.values()) {
            for (int poids : listeCapteurs.keySet()){
                moyenne = moyenne + poids * capteur.getTemperature();
            }
        }
        moyenne = moyenne / listeCapteurs.size();
        setTemperature(moyenne);
    }
}
