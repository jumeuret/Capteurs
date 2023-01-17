package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import modele.Capteur;

import java.io.IOException;

public class UCDetailsCapteursVirtuels extends HBox {

    @FXML
    TableView<Capteur> tableau;

    public UCDetailsCapteursVirtuels() throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/UCDetailsCapteurVirtuels.fxml"));
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
