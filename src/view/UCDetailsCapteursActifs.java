package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import modele.capteur.Capteur;

import java.io.IOException;

public class UCDetailsCapteursActifs extends HBox {

    @FXML
    Label temps;

    @FXML
    Spinner<Double> nouveauTemps;

    @FXML
    Label strategie;

    @FXML
    ComboBox nouvelleStrategie;

    @FXML
    ToggleButton generationAuto;

    @FXML
    BorderPane contenu;

    public UCDetailsCapteursActifs() throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/UCDetailsCapteurActifs.fxml"));
        fxml.setController(this);
        fxml.setRoot(this);
        fxml.load();
    }

    public void bindToNewValues(Capteur capteur){
        //temps.textProperty().bindBidirectional(nouveauTemps.valueFactoryProperty().get().valueProperty().);
        //temps.textProperty().bindBidirectional();
    }

    public void unbindToOldValues(Capteur capteur){
    }
}
