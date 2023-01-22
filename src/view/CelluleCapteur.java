package view;

import javafx.scene.control.TreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.capteur.Capteur;
import modele.capteur.capteurActif.CapteurTemperaturePassif;
import modele.capteur.capteurActif.CapteurTemperatureVirtuel;

import java.io.IOException;

public class CelluleCapteur extends TreeCell<Capteur> {

    @Override
    protected void updateItem(Capteur capteur, boolean empty) {
        //System.out.println("UPDATE");
        super.updateItem(capteur, empty);
        if (capteur == null || empty) {
            setGraphic(null);
            setText(null);
        }
        else {
            ImageView image = new ImageView();
            if (capteur instanceof CapteurTemperaturePassif){
                try {
                    image.setImage(new Image(getClass().getResource("/images/Capteurs/capteurPassif.png").openStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (capteur instanceof CapteurTemperatureVirtuel){
                try {
                    image.setImage(new Image(getClass().getResource("/images/Capteurs/capteurVirtuel.png").openStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                try {
                    image.setImage(new Image(getClass().getResource("/images/Capteurs/capteurActif.png").openStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            image.setFitHeight(57);
            image.setFitWidth(35);
            setGraphic(image);
            setText(capteur.getNom());
        }
    }
}
