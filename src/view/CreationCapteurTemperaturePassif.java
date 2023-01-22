package view;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import modele.capteur.CapteurTemperaturePassif;

public class CreationCapteurTemperaturePassif {

    @FXML
    GridPane grid;

    private CapteurTemperaturePassif capteur;

    public CreationCapteurTemperaturePassif(CapteurTemperaturePassif capteur){
        this.capteur = capteur;
    }
}
