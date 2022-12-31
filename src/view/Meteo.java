package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modele.Capteur;
import modele.CapteurTemperature;

import java.awt.*;
import java.io.IOException;

public class Meteo extends Visualisateur {

    @FXML
    ImageView imageView;

    @FXML
    Image image;

    @FXML
    Button fermer;


    public Meteo(CapteurTemperature capteurMeteo){
        super(capteurMeteo);

    }
    @FXML
    private void clicFermer(ActionEvent event) throws IOException {

        //Button fermerBis = (Button) event.getSource();
        //Stage stage = (Stage) fermerBis.getScene().getWindow();
        Stage stage = (Stage) fermer.getScene().getWindow();
        stage.close();
        update();

    }

    @Override
    public void update() throws IOException {

        Image newImage;
        if ((((CapteurTemperature)capteur).getTemperature()) < 0){
            newImage = new Image(getClass().getResource("/images/neige.png").openStream());
        }
        else if ((((CapteurTemperature)capteur).getTemperature()) < 22) {
            newImage = new Image(getClass().getResource("/images/nuages.png").openStream());
        }
        else{
            newImage = new Image(getClass().getResource("/images/soleil.png").openStream());
        }
        imageView.setImage(newImage);
    }
}
