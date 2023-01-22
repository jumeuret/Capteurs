package view;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modele.capteur.*;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UCDetailsCapteursActifs extends VBox {

    @FXML
    Label temps;

    @FXML
    Spinner<Double> nouveauTemps;

    @FXML
    Label strategie;

    @FXML
    ComboBox nouvelleStrategie;

    @FXML
    ToggleButton generationAuto;

    @FXML
    BorderPane contenu;

    public UCDetailsCapteursActifs() throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/UCDetailsCapteurActifs.fxml"));
        fxml.setController(this);
        fxml.setRoot(this);
        fxml.load();
        nouveauTemps.setEditable(true);
    }

    public void initialize(){
        nouvelleStrategie.getItems().add("Aléatoire");
        nouvelleStrategie.getItems().add("Réaliste");
        nouvelleStrategie.getItems().add("Variative");
        nouvelleStrategie.getItems().add("CPU");
    }

    public void clicCapteur(MouseEvent event){
        if (event.getButton() == MouseButton.SECONDARY){
            //System.out.println("Hey !");
        }
    }

    public void bindToNewValues(Capteur capteur){
        //System.out.println("J'y suis !");
        if (nouveauTemps.getValueFactory() == null) {
            SpinnerValueFactory.DoubleSpinnerValueFactory factory;
            if (capteur instanceof CapteurRealiste) {
                factory = new SpinnerValueFactory.DoubleSpinnerValueFactory(((CapteurRealiste) capteur).getMinTemperature(), ((CapteurRealiste) capteur).getMaxTemperature());
            }
            else {
                factory = new SpinnerValueFactory.DoubleSpinnerValueFactory(-93, 56);
            }
            factory.setAmountToStepBy(0.5);
            factory.setValue(((CapteurTemperature) capteur).getTemperature());
            nouveauTemps.setValueFactory(factory);
        }
        ((CapteurTemperature) capteur).temperatureProperty().addListener((__, ___, newValue) -> {
            //System.out.println("Je m'enfonce !");
            double intervale;
            if (((CapteurTemperature) capteur).getTemperature() == nouveauTemps.getValue()) {
                //System.out.println("Pas bouger  -> " + ((CapteurTemperature) capteur).getTemperature());
            } else if (((CapteurTemperature) capteur).getTemperature() < nouveauTemps.getValue()) {
                //System.out.println("Assis ! : " + nouveauTemps.getValue() + " -> " + ((CapteurTemperature) capteur).getTemperature());

                intervale = nouveauTemps.getValue() - ((CapteurTemperature) capteur).getTemperature();
                nouveauTemps.getValueFactory().setValue(((CapteurTemperature) capteur).getTemperature());
                nouveauTemps.decrement((int) intervale);
            } else {
                //System.out.println("Debout ! : " + nouveauTemps.getValue() + " -> " + ((CapteurTemperature) capteur).getTemperature());
                intervale = ((CapteurTemperature) capteur).getTemperature() - nouveauTemps.getValue();
                nouveauTemps.getValueFactory().setValue(((CapteurTemperature) capteur).getTemperature());
                nouveauTemps.increment((int) intervale);
            }
        });

        generationAuto.selectedProperty().addListener((__, oldValue, newValue) -> {
            if (newValue){
                //Stopper génération auto
                generationAuto.setText("Reprendre");
            }
            else{
                //Lancer génération auto
                generationAuto.setText("Arrêt");
            }
        });

        //temps.textProperty().bindBidirectional(((CapteurTemperature) capteur).temperatureProperty());

        //strategie.textProperty().bindBidirectional(nouvelleStrategie.getSelectionModel().getSelectedItem().toString());




    }

    public void unbindToOldValues(Capteur capteur){
    }
}
