package view;

import javafx.scene.control.TreeItem;
import modele.capteur.Capteur;
import modele.capteur.CapteurTemperature;
import modele.capteur.CapteurTemperatureVirtuel;

import java.util.List;

public class CapteurVue extends TreeItem<Capteur> {

    /*public TreeItem<Capteur> convert(TreeItem<Capteur> racine){

        for (Capteur capteur : ((CapteurTemperatureVirtuel) racine.getValue()).getListeCapteurs().values()) {
            TreeItem<Capteur> feuille = new TreeItem<>(capteur);
            racine.getChildren().add(feuille);
            if (capteur instanceof CapteurTemperatureVirtuel){
                feuille.getChildren().add(convert(feuille));
            }
        }
        return racine;
    }*/

    public TreeItem<Capteur> convert(Capteur capteur){

        TreeItem<Capteur> racine = new TreeItem<>(capteur);
        if (capteur instanceof CapteurTemperatureVirtuel){
            for (Capteur fils : ((CapteurTemperatureVirtuel)capteur).getListeCapteurs().values()) {
                racine.getChildren().add(convert(fils));
            }
        }
        return racine;
    }
}
