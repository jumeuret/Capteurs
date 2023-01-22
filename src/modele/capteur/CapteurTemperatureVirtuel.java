package modele.capteur;

import java.util.*;

/**
 * Classe dérivée de CapteurTemperature permettant de créer des CapteurTemperature au comportement actif ( génération automatique de valeurs )
 */

public class CapteurTemperatureVirtuel extends CapteurTemperature {

    private Map<Integer, List<CapteurTemperature>> listeCapteurs = new HashMap<>();

    /**
     * Constructeur de CapteurTemperatureVirtuel
     * @param nomCapteur
     */
    public CapteurTemperatureVirtuel(String nomCapteur) {
        super(nomCapteur);

        genererTemperature();
    }

    public Map<Integer, List<CapteurTemperature>> getListeCapteurs() {
        return listeCapteurs;
    }

    public void ajouterCapteur(CapteurTemperature capteur, int poids){
        if(listeCapteurs.containsKey(poids)){
            if (listeCapteurs.getOrDefault(poids, null) != null) {
                ArrayList<CapteurTemperature> nouvelleListe = new ArrayList<>();
                nouvelleListe.addAll(listeCapteurs.getOrDefault(poids, null));
                nouvelleListe.add(capteur);
                listeCapteurs.replace(poids, nouvelleListe);
            }
        }
        else{
            ArrayList<CapteurTemperature> nouvelleListe = new ArrayList<>();
            nouvelleListe.add(capteur);
            listeCapteurs.putIfAbsent(poids, nouvelleListe);
        }
        //capteur.temperatureProperty().addListener();
    }

    public void supprimerCapteur(CapteurTemperature capteur){
        int poids = trouverPoidsCapteurObserve(capteur);
        listeCapteurs.getOrDefault(poids, null).remove(capteur);
    }

    public int trouverPoidsCapteurObserve(Capteur capteur){

        for (int poids : listeCapteurs.keySet()) {
            for (CapteurTemperature leCapteur : listeCapteurs.getOrDefault(poids, null)) {
                if (leCapteur.getId() == capteur.getId()) {
                    return poids;
                }
            }
        }
        return -1;
    }

    /**
     * Méthode permettant de générer des températures
     */
    public void genererTemperature(){
        double moyenne = 0;
        for (int poids : listeCapteurs.keySet()){
            for (CapteurTemperature capteur: listeCapteurs.getOrDefault(poids, null)) {
                moyenne = moyenne + poids * capteur.getTemperature();
            }
        }
        moyenne = moyenne / listeCapteurs.size();
        setTemperature(moyenne);
    }
}
