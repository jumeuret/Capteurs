package view;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import modele.Capteur;
import modele.CapteurTemperature;
import modele.CapteurTemperaturePassif;

import java.io.IOException;

/**
 * Classe dérivée de Visualisateur Code Behind de Thermometre.fxml
 */
public class Thermometre extends Visualisateur {

    /**
     * Constructeur de fenêtre Thermometre
     * @param capteurMeteo
     */
    public Thermometre(CapteurTemperature capteurMeteo) {
        super(capteurMeteo);
    }

    /**
     * Attribut Button permettant de lancer la méthode clicFermer
     */
    @FXML
    Button fermer;

    /**
     * Attribut Slider
     */
    @FXML
    Slider curseur;

    /**
     * Méthode permettant de fermer la fenêtre Thermometre
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
     * Méthode d'initialisation bindant la valeur de l'attribut CapteurTemperature avec la valeur du Slider
     */
    public void initialize(){
        curseur.valueProperty().bindBidirectional(((CapteurTemperature)getCapteur()).temperatureProperty());
    }
}
