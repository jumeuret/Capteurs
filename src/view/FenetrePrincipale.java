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
import modele.CapteurTemperaturePassif;

import java.io.IOException;

/**
 * Classe Code Behind de FenetrePrinciaple.fxml
 */
public class FenetrePrincipale {

    /**
     * Attribut CapteurTemperature des fenêtres
     */
    private final CapteurTemperaturePassif capteurTemp = new CapteurTemperaturePassif("CapteurTemp");

    /**
     * Attribut Button lancant la méthode clickBoutonMeteo
     */
    @FXML
    private Button boutonMeteo = new Button();

    /**
     * Attribut Button lancant la méthode clickBoutonThermometre
     */
    @FXML
    private Button boutonThermometre = new Button();

    /**
     * Attribut Button permettant de lancer la méthode clicFermer
     */
    @FXML
    Button fermer;

    /**
     * Méthode permettant de fermer toutes les fenêtres
     * @param event
     */
    @FXML
    private void clicFermer(ActionEvent event) {

        //Button fermerBis = (Button) event.getSource();
        //Stage stage = (Stage) fermerBis.getScene().getWindow();
        Stage stage = (Stage) fermer.getScene().getWindow();
        stage.close();
    }

    /**
     * Méthode permettant de lancer la création d'une fenêtre Meteo
     * @param event
     * @throws IOException
     */
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

    /**
     * Méthode permettant de lancer la création d'une fenêtre Thermometre
     * @param event
     * @throws IOException
     */
    @FXML
    private void clickBoutonThermometre(ActionEvent event) throws IOException {
        Thermometre thermometre = new Thermometre(capteurTemp);
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Thermometre.fxml"));
        fxml.setController(thermometre);
        Scene scene = new Scene(fxml.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}