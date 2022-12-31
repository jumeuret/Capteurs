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

public class Meteo extends Visualisateur {

    @FXML
    ImageView image;

    @FXML
    Button fermer;


    public Meteo(CapteurTemperature capteurMeteo){
        super(capteurMeteo);
    }
    @FXML
    private void clicFermer(ActionEvent event){

        //event.getSource().getClass().;
        //fermer.getScene().get;
        //stage.close();

    }

    @Override
    public void update() {
        CapteurTemperature monCapteur = (CapteurTemperature)this.getCapteur();
        int newTemperature = monCapteur.getTemperature();
        if(newTemperature >= 0 && )
    }
}
