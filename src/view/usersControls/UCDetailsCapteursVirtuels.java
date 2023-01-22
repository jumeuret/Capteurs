package view.usersControls;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modele.capteur.Capteur;
import modele.capteur.CapteurTemperature;
import modele.capteur.capteurActif.CapteurTemperaturePassif;
import modele.capteur.capteurActif.CapteurTemperatureVirtuel;

import java.io.IOException;

public class UCDetailsCapteursVirtuels extends VBox {

    @FXML
    TableView<Capteur> tableau;

    @FXML
    TableColumn<Capteur, Integer> poids;

    @FXML
    TableColumn<Capteur, ImageView> type;

    @FXML
    TableColumn<Capteur, Integer> id;

    @FXML
    Button ajout;

    @FXML
    ComboBox<Capteur> capteurs;

    @FXML
    TextField nouveauPoids;

    public UCDetailsCapteursVirtuels() throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/Users Controls/UCDetailsCapteurVirtuels.fxml"));
        fxml.setController(this);
        fxml.setRoot(this);
        fxml.load();
    }

    public void initialize(){
        ajout.setOnAction( event -> {
            if (capteurs.getSelectionModel().getSelectedItem() != null){
                if (nouveauPoids.getText() != null){
                    //ajout.getScene().getWindow().
                    int poids = Integer.parseInt(nouveauPoids.getText());
                    //arbreCapteurs.getRoot().ajouterCapteur(capteurs.getSelectionModel().getSelectedItem(), poids);
                }
            }
        });
    }

    public void bindToNewValues(CapteurTemperatureVirtuel capteur){

        //Ne fonctionne pas
        tableau.setRowFactory( param -> {
            TableRow<Capteur> ligne = new TableRow<>();
            ContextMenu menu = new ContextMenu();
            MenuItem suppression = new MenuItem("Supprimer");
            suppression.setOnAction( event -> {
                tableau.getItems().remove(ligne.getItem());
                capteur.supprimerCapteur((CapteurTemperature) ligne.getItem());
            });
            return ligne;
        });

        id.setCellValueFactory(
                new PropertyValueFactory<Capteur,Integer>("id")
        );
        ObservableList<Capteur> obsListe = FXCollections.observableArrayList(capteur.getListeCapteursSansPoids());

        poids.setCellValueFactory(param -> {
            int poids = capteur.trouverPoidsCapteurObserve(param.getValue());
            ObservableValue<Integer> poidsFinal = new SimpleIntegerProperty(poids).asObject();
            return poidsFinal;
        });

        //poids.setCellFactory(TextFieldTableCell.<Capteur>forTableColumn());

        poids.setEditable(true);

        poids.setOnEditCommit((TableColumn.CellEditEvent<Capteur, Integer> event) -> {
            TablePosition<Capteur, Integer> pos = event.getTablePosition();

            Integer nouveauPoids = event.getNewValue();

            int row = pos.getRow();
            Capteur capteurCourant = event.getTableView().getItems().get(row);
            capteur.setPoids(capteurCourant, nouveauPoids);
        });

        type.setCellValueFactory(param -> {
            ImageView image = new ImageView();
            if (param.getValue() instanceof CapteurTemperaturePassif){
                try {
                    image.setImage(new Image(getClass().getResource("/images/Capteurs/capteurPassif.png").openStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (param.getValue() instanceof CapteurTemperatureVirtuel){
                try {
                    image.setImage(new Image(getClass().getResource("/images/Capteurs/capteurVirtuel.png").openStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                try {
                    image.setImage(new Image(getClass().getResource("/images/Capteurs/capteurActif.png").openStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            image.setFitHeight(37);
            image.setFitWidth(15);
            ObservableValue<ImageView> iconeFinale = new SimpleObjectProperty<ImageView>(image);
            return iconeFinale;
        });

        tableau.setItems(obsListe);
    }

    public void unbindToOldValues(Capteur capteur){

    }
}
