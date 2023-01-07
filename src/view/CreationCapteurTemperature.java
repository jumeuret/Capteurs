package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modele.*;

public class CreationCapteurTemperature {

    @FXML
    Button passif;

    @FXML
    Button variatif;

    @FXML
    Button realiste;

    @FXML
    Button virtuel;

    @FXML
    BorderPane details;

    CapteurTemperature capteur;

    public void clicPassif(ActionEvent event) {
        capteur = new CapteurTemperaturePassif("temporaire");
        CreationCapteurTemperaturePassif construction = new CreationCapteurTemperaturePassif((CapteurTemperaturePassif) capteur);
        details.setCenter(construction.grid);
    }

    public void clicVirtuel(ActionEvent event) {
        capteur = new CapteurTemperatureVirtuel("temporaire");
        CreationCapteurTemperatureVirtuel construction = new CreationCapteurTemperatureVirtuel((CapteurTemperatureVirtuel) capteur);
        details.setCenter(construction.grid);
    }

    public void clicRealiste(ActionEvent event) {
        capteur = new CapteurRealiste("temporaire",0,0);
        CreationCapteurTemperatureActif construction = new CreationCapteurTemperatureActif((CapteurRealiste) capteur);
        details.setCenter(construction.grid);
    }

    public void clicVariatif(ActionEvent event) {
        capteur = new CapteurVariatif("temporaire",0,0);
        CreationCapteurTemperatureActif construction = new CreationCapteurTemperatureActif((CapteurVariatif) capteur);
        details.setCenter(construction.grid);
    }
}
