package view;

import data.Stub;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import modele.*;

import java.io.IOException;
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

        Stub charge = new Stub();
        Registre maison = charge.chargerDonnees();
        Capteur racine = new CapteurTemperature("racine");
        TreeItem<Capteur> laRacine = new TreeItem<>(racine);
        //arbreCapteurs.setShowRoot(false);

        for (Capteur capteur: maison.getListeCapteurs()) {
            laRacine.getChildren().add(new TreeItem<>(capteur));
        }
        arbreCapteurs.setCellFactory(param -> new CelluleCapteur());
        arbreCapteurs.setRoot(laRacine);
        //laRacine.setExpanded(true);

        /*
        TreeItem<String> racine = new TreeItem<>();
        racine.setExpanded(true);
        racine.getChildren().add(new TreeItem<>("1"));
        racine.getChildren().add(new TreeItem<>("2"));
        racine.getChildren().add(new TreeItem<>("3"));
        //arbreCapteurs = new TreeView<>(racine);
        arbreCapteurs.setRoot(racine);


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
