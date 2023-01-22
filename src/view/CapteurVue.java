package view;

import javafx.scene.control.TreeItem;
import modele.capteur.Capteur;
import modele.capteur.capteurActif.CapteurTemperatureVirtuel;

public class CapteurVue extends TreeItem<Capteur> {

    public TreeItem<Capteur> convert(Capteur capteur){

        TreeItem<Capteur> racine = new TreeItem<>(capteur);
        if (capteur instanceof CapteurTemperatureVirtuel){
            for (int poids : ((CapteurTemperatureVirtuel) capteur).getListeCapteurs().keySet()){
                for (Capteur fils: ((CapteurTemperatureVirtuel) capteur).getListeCapteurs().getOrDefault(poids, null)) {
                    racine.getChildren().add(convert(fils));
                }
            }
        }
        return racine;
    }
}
