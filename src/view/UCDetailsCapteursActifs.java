package view;

import javafx.beans.property.Property;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import modele.capteur.*;

import java.io.IOException;

public class UCDetailsCapteursActifs extends HBox {

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

    }

    public void bindToNewValues(Capteur capteur){
        if (nouveauTemps.getValueFactory() == null) {
            SpinnerValueFactory.DoubleSpinnerValueFactory factory;
            if (capteur instanceof CapteurRealiste) {
                factory = new SpinnerValueFactory.DoubleSpinnerValueFactory(((CapteurRealiste) capteur).getMinTemperature(), ((CapteurRealiste) capteur).getMaxTemperature());
            } else {
                factory = new SpinnerValueFactory.DoubleSpinnerValueFactory(-93, 56);
            }
            factory.setAmountToStepBy(0.5);
            factory.setValue(((CapteurTemperature) capteur).getTemperature());
            nouveauTemps.setValueFactory(factory);
        }
        ((CapteurTemperature) capteur).temperatureProperty().addListener((__, ___, newValue) -> {
            double intervale;
            if (((CapteurTemperature) capteur).getTemperature() == nouveauTemps.getValue()) {
                return;
            } else if (((CapteurTemperature) capteur).getTemperature() < nouveauTemps.getValue()) {
                intervale = nouveauTemps.getValue() - ((CapteurTemperature) capteur).getTemperature();
                nouveauTemps.decrement((int) intervale);
            } else {
                intervale = ((CapteurTemperature) capteur).getTemperature() - nouveauTemps.getValue();
                nouveauTemps.increment((int) intervale);
            }
        });
        generationAuto.selectedProperty().addListener((__, oldValue, newValue) -> {
            if (newValue){
                capteur.bi
                //Stopper génération auto
            }
            else{
                //Lancer génération auto
            }
        });
    }

    public void unbindToOldValues(Capteur capteur){
    }
}
