package view;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import modele.capteur.Capteur;
import modele.capteur.CapteurTemperature;
import modele.capteur.CapteurTemperatureVirtuel;

import java.io.IOException;

public class UCDetailsCapteursVirtuels extends VBox {

    @FXML
    TableView<Capteur> tableau;

    @FXML
    TableColumn<Capteur, Integer> poids;

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

    public void initialize(){

        poids.setEditable(true);
    }

    public void bindToNewValues(CapteurTemperatureVirtuel capteur){
        /*
        tableau.setRowFactory(param -> {
            param
        });
        poids.setCellValueFactory(param -> new SimpleIntegerProperty(capteur.trouverPoidsCapteurObserve(param.getValue())));
        type.setCellValueFactory(param -> {
            param.getValue().set
        });
        */
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
            DoubleProperty poids = new SimpleDoubleProperty();
            poids.set(poidsFinal);
            return poids;
        });
        id.setCellValueFactory(
                new PropertyValueFactory<Capteur,Integer>("id")
        );

        //tableau.setItems(capteur.getListeCapteurs().values());
         */
    }

    public void unbindToOldValues(Capteur capteur){
        //nom.textProperty().unbindBidirectional(capteur.nomProperty());
    }
}
