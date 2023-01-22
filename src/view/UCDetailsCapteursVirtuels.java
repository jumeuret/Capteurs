package view;

import javafx.beans.property.*;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modele.capteur.Capteur;
import modele.capteur.CapteurTemperature;
import modele.capteur.CapteurTemperaturePassif;
import modele.capteur.CapteurTemperatureVirtuel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UCDetailsCapteursVirtuels extends VBox {

    @FXML
    TableView<Capteur> tableau;

    @FXML
    TableColumn<Capteur, Integer> poids;

    @FXML
    TableColumn<Capteur, ImageView> type;

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

        id.setCellValueFactory(
                new PropertyValueFactory<Capteur,Integer>("id")
        );
        ObservableList<Capteur> obsListe = FXCollections.observableArrayList(capteur.getListeCapteursSansPoids());

        poids.setCellValueFactory(param -> {
            int poids = capteur.trouverPoidsCapteurObserve(param.getValue());
            ObservableValue<Integer> poidsFinal = new SimpleIntegerProperty(poids).asObject();
            return poidsFinal;
        });

        type.setCellValueFactory(param -> {
            ImageView image = new ImageView();
            if (param.getValue() instanceof CapteurTemperaturePassif){
                try {
                    image.setImage(new Image(getClass().getResource("/images/capteurPassif.png").openStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (param.getValue() instanceof CapteurTemperatureVirtuel){
                try {
                    image.setImage(new Image(getClass().getResource("/images/capteurVirtuel.png").openStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                try {
                    image.setImage(new Image(getClass().getResource("/images/capteurActif.png").openStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            image.setFitHeight(37);
            image.setFitWidth(15);
            //CelluleIcone icone = new CelluleIcone(image);
            ObservableValue<ImageView> iconeFinale = new SimpleObjectProperty<ImageView>(image);
            return iconeFinale;
        });
        poids.setEditable(true);

        tableau.setItems(obsListe);
    }

    public void unbindToOldValues(Capteur capteur){
        //nom.textProperty().unbindBidirectional(capteur.nomProperty());
    }
}
