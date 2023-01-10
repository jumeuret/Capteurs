package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import modele.Capteur;
import modele.Registre;

import java.util.ArrayList;
import java.util.List;

public class VueCapteurs {

    @FXML
    TreeView<Capteur> arbreCapteurs;

    @FXML
    Label nom;

    @FXML
    Label id;

    @FXML
    TextField nouveauNom;

    private List<Capteur> listeCapteurs = new ArrayList<>();

    public void initialize(){
        nom.textProperty().bindBidirectional(nouveauNom.textProperty());
        //arbreCapteurs.getSelectionModel().getSelectedItem().
        //arbreCapteurs.setRoot(new TreeItem(new Registre()));
    }
}
