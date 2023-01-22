package view;

import data.Stub;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import modele.capteur.Capteur;
import modele.capteur.CapteurTemperatureActif;
import modele.capteur.CapteurTemperatureVirtuel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AffichageCapteurs {

    @FXML
    TreeView<Capteur> arbreCapteurs;

    @FXML
    VBox ucDetailsGenerauxEmplacement;

    @FXML
    VBox ucDetailsCapteurEmplacement;

    UCDetailsgeneraux ucDetailsGeneraux = new UCDetailsgeneraux();

    UCDetailsCapteursActifs ucDetailsCapteursActifs = new UCDetailsCapteursActifs();

    UCDetailsCapteursVirtuels ucDetailsCapteursVirtuels = new UCDetailsCapteursVirtuels();

    private List<Capteur> listeCapteurs = new ArrayList<>();

    public AffichageCapteurs() throws IOException {
    }

    public void initialize(){

        Stub charge = new Stub();
        CapteurTemperatureVirtuel maison = charge.chargerDonnees();
        CapteurVue capteurVue = new CapteurVue();
        TreeItem<Capteur> arbre = capteurVue.convert(maison);
        arbreCapteurs.setRoot(arbre);
        arbreCapteurs.setCellFactory(param -> new CelluleCapteur());

        arbreCapteurs.getSelectionModel().selectedItemProperty().addListener((__, oldValue, newValue) -> {
            if (oldValue != null){
                ucDetailsGeneraux.unbindToOldValues(oldValue.getValue());

            }
            if (newValue != null){
                ucDetailsGenerauxEmplacement.getChildren().clear();
                ucDetailsCapteurEmplacement.getChildren().clear();
                ucDetailsGenerauxEmplacement.getChildren().add(ucDetailsGeneraux);
                ucDetailsGeneraux.bindToNewValues(newValue.getValue());
                if (newValue.getValue() instanceof CapteurTemperatureVirtuel){
                    ucDetailsCapteurEmplacement.getChildren().add(ucDetailsCapteursVirtuels);
                    ucDetailsCapteursVirtuels.bindToNewValues((CapteurTemperatureVirtuel) newValue.getValue());
                }
                else if(newValue.getValue() instanceof CapteurTemperatureActif){
                    ucDetailsCapteurEmplacement.getChildren().add(ucDetailsCapteursActifs);
                    ucDetailsCapteursActifs.bindToNewValues((CapteurTemperatureActif) newValue.getValue());
                }
            }
        });
    }
}
