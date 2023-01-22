package view.visualisateurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import modele.capteur.capteurActif.CapteurRealiste;
import modele.capteur.CapteurTemperature;

/**
 * Classe dérivée de Visualisateur Code Behind de Thermostat.fxml
 */
public class Thermostat extends Visualisateur {

    /**
     * Constructeur de fenêtre Thermometre
     * @param capteurThermostat
     */
    public Thermostat(CapteurTemperature capteurThermostat) {
        super(capteurThermostat);
    }

    /**
     * Attribut Button permettant de lancer la méthode clicFermer
     */
    @FXML
    Button fermer;

    /**
     * Attribut Slider
     */
    @FXML
    Spinner<Double> curseur;

    /**
     * Méthode permettant de fermer la fenêtre Thermometre
     * @param event
     */
    @FXML
    private void clicFermer(ActionEvent event) {

        //Button fermerBis = (Button) event.getSource();
        //Stage stage = (Stage) fermerBis.getScene().getWindow();
        Stage stage = (Stage) fermer.getScene().getWindow();
        stage.close();
    }

    private void update(){
        double intervale;
        if (((CapteurTemperature) capteur).getTemperature() == curseur.getValue()){
            return;
        }
        else if (((CapteurTemperature) capteur).getTemperature() < curseur.getValue()) {
            intervale = curseur.getValue() - ((CapteurTemperature) capteur).getTemperature();
            curseur.decrement((int) intervale);
        }
        else{
            intervale = ((CapteurTemperature) capteur).getTemperature() - curseur.getValue();
            curseur.increment((int) intervale);
        }
    }

    /**
     * Méthode d'initialisation bindant la valeur de l'attribut CapteurTemperature avec la valeur du Slider
     */
    public void initialize(){
        SpinnerValueFactory.DoubleSpinnerValueFactory factory;
        if (capteur instanceof CapteurRealiste){
            factory = new SpinnerValueFactory.DoubleSpinnerValueFactory(((CapteurRealiste) capteur).getMinTemperature(), ((CapteurRealiste) capteur).getMaxTemperature());
        }
        else {
            factory = new SpinnerValueFactory.DoubleSpinnerValueFactory(-93,56);
        }
        factory.setAmountToStepBy(0.5);
        factory.setValue(((CapteurTemperature)getCapteur()).getTemperature());
        curseur.setValueFactory(factory);
        ((CapteurTemperature)getCapteur()).temperatureProperty().addListener((__,___,newValue) -> update());
    }


}
