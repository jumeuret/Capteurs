package view;

import data.Stub;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import modele.Capteur;
import modele.Registre;

import java.util.ArrayList;
import java.util.List;

public class VueCapteurs extends TreeItem {

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

        Stub charge = new Stub();
        Registre maison = charge.chargerDonnees();


        /*
        arbreCapteurs.setEditable(true);
        arbreCapteurs.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>(){
            @Override
            public TreeCell<String> call(TreeView<String> p) {
                return new VueCapteurFactory();
            }
        });
         */
    }
}
