package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.capteur.Capteur;

import java.io.IOException;

public class UCDetailsgeneraux extends HBox {

    @FXML
    Label nom;

    @FXML
    Label id;

    @FXML
    TextField nouveauNom;

    @FXML
    VBox ucDetailsCapteurEmplacement;

    public UCDetailsgeneraux() throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/UCDetailsGeneraux.fxml"));
        fxml.setController(this);
        fxml.setRoot(this);
        fxml.load();
    }

    public void initialize(){

    }

    public void bindToNewValues(Capteur capteur){
        nom.textProperty().bindBidirectional(nouveauNom.textProperty());
        nom.textProperty().bindBidirectional(capteur.nomProperty());
        id.textProperty().bind(capteur.idProperty().asString());
    }

    public void unbindToOldValues(Capteur capteur){
        nom.textProperty().unbindBidirectional(capteur.nomProperty());
    }
}
