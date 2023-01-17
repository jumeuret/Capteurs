package view;

import data.Stub;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import modele.capteur.Capteur;
import modele.capteur.CapteurTemperature;
import modele.capteur.CapteurTemperatureActif;
import modele.capteur.CapteurTemperatureVirtuel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AffichageCapteurs {

    @FXML
    TreeView<Capteur> arbreCapteurs;

    @FXML
    HBox ucDetailsGenerauxEmplacement;

    @FXML
    HBox ucDetailsCapteurEmplacement;

    UCDetailsgeneraux ucDetailsGeneraux = new UCDetailsgeneraux();

    UCDetailsCapteursActifs ucDetailsCapteursActifs = new UCDetailsCapteursActifs();

    UCDetailsCapteursVirtuels ucDetailsCapteursVirtuels = new UCDetailsCapteursVirtuels();

    private List<Capteur> listeCapteurs = new ArrayList<>();

    public AffichageCapteurs() throws IOException {
    }

    public void initialize(){

        //arbreCapteurs.getSelectionModel().getSelectedItem().
        //arbreCapteurs.setRoot(new TreeItem(new Registre()));

        Stub charge = new Stub();
        CapteurTemperatureVirtuel maison = charge.chargerDonnees();
        CapteurVue capteurVue = new CapteurVue();
        //TreeItem<Capteur> laRacine = new TreeItem<>(maison);
        TreeItem<Capteur> arbre = capteurVue.convert(maison);
        //TreeItem<Capteur> arbre = capteurVue.convert(laRacine);
        arbreCapteurs.setRoot(arbre);
        arbreCapteurs.setCellFactory(param -> new CelluleCapteur());

        arbreCapteurs.getSelectionModel().selectedItemProperty().addListener((__, oldValue, newValue) -> {
            if (oldValue != null){
                //unbind bidirectionnal
                ucDetailsGeneraux.unbindToOldValues(oldValue.getValue());

            }
            if (newValue != null){
                ucDetailsGenerauxEmplacement.getChildren().clear();
                ucDetailsCapteurEmplacement.getChildren().clear();
                //Afficher détails généraux
                ucDetailsGenerauxEmplacement.getChildren().add(ucDetailsGeneraux);
                //bind détails généraux
                ucDetailsGeneraux.bindToNewValues(newValue.getValue());
                //Mettre UC de type & Bind UC par type
                if (newValue.getValue() instanceof CapteurTemperatureVirtuel){
                    ucDetailsCapteurEmplacement.getChildren().add(ucDetailsCapteursVirtuels);
                    //
                }
                else if(newValue.getValue() instanceof CapteurTemperatureActif){
                    ucDetailsCapteurEmplacement.getChildren().add(ucDetailsCapteursActifs);
                    //
                }
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
