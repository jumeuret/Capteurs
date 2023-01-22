package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modele.capteur.CapteurTemperature;
import modele.capteur.CapteurVariatif;

import java.io.IOException;

/**
 * Classe Code Behind de FenetrePrinciaple.fxml
 */
public class FenetrePrincipale {

    private Bipper bipper = new Bipper(500);

    /**
     * Attribut CapteurTemperature des fenêtres
     */
    private final CapteurTemperature capteurTemp = new CapteurCPU("CapteurTemp", bipper);

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

    @FXML
    private Button boutonTreeView = new Button();

    /**
     * Attribut Button permettant de lancer la méthode clicFermer
     */
    @FXML
    Button fermer;

    public FenetrePrincipale() throws IOException {
    }

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
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/Meteo.fxml"));
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
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/Thermometre.fxml"));
        fxml.setController(thermometre);
        Scene scene = new Scene(fxml.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void clickBoutonThermostat(ActionEvent event) throws IOException {
        Thermostat thermostat = new Thermostat(capteurTemp);
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/Thermostat.fxml"));
        fxml.setController(thermostat);
        Scene scene = new Scene(fxml.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

        @FXML
    private void clickBoutonCapteurs(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/Capteurs.fxml"));
        Scene scene = new Scene(fxml.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setMinWidth(1000);
        stage.show();
    }
}