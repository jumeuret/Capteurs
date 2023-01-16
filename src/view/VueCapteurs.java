package view;

import data.Stub;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import modele.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VueCapteurs {

    @FXML
    TreeView<Capteur> arbreCapteurs;

    @FXML
    HBox ucDetailsGenerauxEmplacement;

    UCDetailsgeneraux ucDetailsGeneraux = new UCDetailsgeneraux();

    private List<Capteur> listeCapteurs = new ArrayList<>();

    public VueCapteurs() throws IOException {
    }

    public void initialize(){

        //arbreCapteurs.getSelectionModel().getSelectedItem().
        //arbreCapteurs.setRoot(new TreeItem(new Registre()));

        Stub charge = new Stub();
        Registre maison = charge.chargerDonnees();
        Capteur racine = new CapteurTemperature("racine");
        TreeItem<Capteur> laRacine = new TreeItem<>(racine);

        for (Capteur capteur: maison.getListeCapteurs()) {
            laRacine.getChildren().add(new TreeItem<>(capteur));
        }
        arbreCapteurs.setRoot(laRacine);
        arbreCapteurs.setShowRoot(false);
        arbreCapteurs.setCellFactory(param -> new CelluleCapteur());

        arbreCapteurs.getSelectionModel().selectedItemProperty().addListener((__, oldValue, newValue) -> {
            if (oldValue != null){
                //unbind bidirectionnal
                ucDetailsGeneraux.unbindToOldValues(oldValue.getValue());
            }
            if (newValue != null){
                ucDetailsGenerauxEmplacement.getChildren().clear();
                //Afficher détails généraux
                ucDetailsGenerauxEmplacement.getChildren().add(ucDetailsGeneraux);
                //bind détails généraux
                ucDetailsGeneraux.bindToNewValues(newValue.getValue());
                //Mettre UC de type
                if (newValue.getValue() instanceof CapteurTemperatureVirtuel){

                }
                //Bind UC par type
            }
        });

        //nom.textProperty().bind(arbreCapteurs.getSelectionModel().getSelectedItem().getValue().nomProperty());

        /*if (arbreCapteurs.getSelectionModel().getSelectedItem().getValue() instanceof CapteurTemperatureVirtuel){
            DetailsCapteursVirtuels infosVirtuel = new DetailsCapteursVirtuels();
            infos.setCenter(infosVirtuel.contenu);
        }
        else if(arbreCapteurs.getSelectionModel().getSelectedItem().getValue() instanceof CapteurTemperatureActif){
            DetailsCapteursActifs infosActif = new DetailsCapteursActifs();
            infos.setCenter(infosActif.contenu);
        }*/


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
