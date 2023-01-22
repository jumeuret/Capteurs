package view;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import modele.capteur.CapteurTemperatureVirtuel;

public class CreationCapteurTemperatureVirtuel {

    @FXML
    GridPane grid;

    private CapteurTemperatureVirtuel capteur;

    public CreationCapteurTemperatureVirtuel(CapteurTemperatureVirtuel capteur){
        this.capteur = capteur;
    }
}
