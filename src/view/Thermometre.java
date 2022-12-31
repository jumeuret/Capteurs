package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import modele.Capteur;
import modele.CapteurTemperature;

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
     * Méthode permettant de fermer les fenêtres Thermometre
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
     * Méthode permettant de mettre à jour la valeur de l'attribut Slider selon la valeur du CapteurTemperature
     */
    @Override
    public void update() {
        curseur.setValue(((CapteurTemperature)capteur).getTemperature());
    }

    /**
     * Méthode permettant de faire changer la valeur de l'attribut CapteurTemperature selon la valeur du Slider
     * @throws IOException
     */
    @FXML
    public void onMouseClicked() throws IOException {
        ((CapteurTemperature)capteur).setTemperature((int)curseur.getValue());
    }

    /**
     * Méthode permettant de faire changer la valeur de l'attribut CapteurTemperature selon la valeur du Slider
     * @throws IOException
     */
    @FXML
    public void onMouseDragged() throws IOException {
        ((CapteurTemperature)capteur).setTemperature((int)curseur.getValue());
    }
}
