package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import modele.Capteur;
import modele.CapteurTemperature;

import java.io.IOException;

public class Thermometre extends Visualisateur {

        public Thermometre(CapteurTemperature capteurMeteo) {
            super(capteurMeteo);
        }

        public void onChange() {
            //
        }

        @FXML
        Button fermer;

        @FXML
        Slider curseur;

        @FXML
        private void clicFermer(ActionEvent event) {

            //Button fermerBis = (Button) event.getSource();
            //Stage stage = (Stage) fermerBis.getScene().getWindow();
            Stage stage = (Stage) fermer.getScene().getWindow();
            stage.close();

        }

        @Override
        public void update() {
            curseur.setValue(((CapteurTemperature)capteur).getTemperature());
        }

        @FXML
        public void onMouseClicked() throws IOException {
            ((CapteurTemperature)capteur).setTemperature((int)curseur.getValue());
        }

        @FXML
        public void onMouseDragged() throws IOException {
            ((CapteurTemperature)capteur).setTemperature((int)curseur.getValue());
        }
    }
