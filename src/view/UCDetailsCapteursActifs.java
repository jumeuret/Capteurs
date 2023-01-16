package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import modele.Capteur;

import java.io.IOException;

public class UCDetailsCapteursActifs extends HBox {

    @FXML
    Label temps;

    @FXML
    Spinner nouveauTemps;

    @FXML
    Label strategie;

    @FXML
    ComboBox nouvelleStrategie;

    @FXML
    ToggleButton generationAuto;

    @FXML
    BorderPane contenu;

    public UCDetailsCapteursActifs() throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/UCDetailsCapteurActifs.fxml"));
        fxml.setController(this);
        fxml.setRoot(this);
        fxml.load();
    }
/*
    public void bindToNewValues(Capteur capteur){
        nom.textProperty().bindBidirectional(nouveauNom.textProperty());
        nom.textProperty().bindBidirectional(capteur.nomProperty());
        id.textProperty().bind(capteur.idProperty().asString());
    }

    public void unbindToOldValues(Capteur capteur){
        nom.textProperty().unbindBidirectional(capteur.nomProperty());
    }
    */
}
