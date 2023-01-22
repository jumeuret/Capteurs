package view;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import modele.capteur.*;

import java.awt.*;

public class CreationCapteurTemperatureActif {

    @FXML
    GridPane grid;

    @FXML
    Label max;

    @FXML
    Label min;

    private CapteurTemperatureActif capteur;

    public CreationCapteurTemperatureActif(CapteurTemperatureActif capteur){
        this.capteur = capteur;
        if (capteur instanceof CapteurRealiste){
            max.setText("Température maximale du capteur");
            min.setText("Température minimale du capteur");
        }
        else if (capteur instanceof CapteurVariatif){
            max.setText("Variation maximale du capteur");
            min.setText("Variation minimale du capteur");
        }
    }
}
