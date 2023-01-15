package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.Capteur;
import modele.CapteurTemperature;
import modele.CapteurTemperaturePassif;
import modele.CapteurTemperatureVirtuel;

import java.io.IOException;

public class CelluleCapteur extends TreeCell<Capteur> {

    @Override
    protected void updateItem(Capteur capteur, boolean empty) {
        super.updateItem(capteur, empty);
        if (capteur == null || empty) {
            setGraphic(null);
        }
        else {
            ImageView image = new ImageView();
            if (capteur instanceof CapteurTemperaturePassif){
                try {
                    image.setImage(new Image(getClass().getResource("/images/capteurPassif.png").openStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (capteur instanceof CapteurTemperatureVirtuel){
                try {
                    image.setImage(new Image(getClass().getResource("/images/capteurVirtuel.png").openStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                try {
                    image.setImage(new Image(getClass().getResource("/images/capteurActif.png").openStream()));
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
