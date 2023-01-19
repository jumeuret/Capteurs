package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import modele.capteur.Capteur;
import modele.capteur.CapteurTemperature;
import modele.capteur.CapteurTemperatureVirtuel;

import java.io.IOException;

public class UCDetailsCapteursVirtuels extends HBox {

    @FXML
    TableView<Capteur> tableau;

    @FXML
    TableColumn<Capteur, Double> poids;

    @FXML
    TableColumn<Capteur, Image> type;

    @FXML
    TableColumn<Capteur, Integer> id;

    public UCDetailsCapteursVirtuels() throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/UCDetailsCapteurVirtuels.fxml"));
        fxml.setController(this);
        fxml.setRoot(this);
        fxml.load();
    }

    public void bindToNewValues(CapteurTemperatureVirtuel capteur){
        //poids.tableViewProperty()
        /*
        poids.setCellValueFactory(
                new PropertyValueFactory<Capteur,Double>("poids")
        );

        poids.setCellValueFactory(param -> {
            double poidsFinal = (double) capteur.getListeCapteurs().keySet().toArray()[0];
            for (int poids : capteur.getListeCapteurs().keySet()) {
                for (CapteurTemperature leCapteur : capteur.getListeCapteurs().getOrDefault(poids, null)) {
                    if (capteur.getId() == param.getValue().getId()) {
                        poidsFinal = poids;
                    }
                }
            }
            return poidsFinal;
        });
        id.setCellValueFactory(
                new PropertyValueFactory<Capteur,Integer>("id")
        );
        */
        //tableau.setItems(capteur.getListeCapteurs().values());
    }

    public void unbindToOldValues(Capteur capteur){
        //nom.textProperty().unbindBidirectional(capteur.nomProperty());
    }
}
