package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modele.Capteur;
import modele.CapteurTemperature;

import java.io.IOException;

public class FenetrePrincipale {

    private CapteurTemperature capteurTemp = new CapteurTemperature("CapteurTemp");

    @FXML
    private Button boutonMeteo = new Button();

    @FXML
    private void clickBoutonMeteo(ActionEvent event) throws IOException {
        Meteo meteo = new Meteo(capteurTemp);
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Meteo.fxml"));
        fxml.setController(meteo);
        Scene scene = new Scene(fxml.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}

// Instancier un FWMLLoader avec instance Capteur ???
// GetTemperature