package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import modele.Capteur;
import modele.CapteurTemperature;

import java.awt.*;

public class Meteo extends Visualisateur {

    public Meteo(CapteurTemperature capteurMeteo){
        super(capteurMeteo);
    }
    @FXML
    private void clicFermer(ActionEvent event){

        //stage.close();

    }
}
