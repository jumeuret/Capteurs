package modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.io.IOException;

/**
 * Classe dérivée de Capteur permettant de créer des CapteurTemperature
 */
public class CapteurTemperature extends Capteur{

    /**
     * Attribut température du CapteurTemperature
     */
    protected DoubleProperty temperature = new SimpleDoubleProperty();

    /**
     * Propriété température du CapteurTemperature
     * @return température du CapteurTemperature
     */
    public DoubleProperty temperatureProperty(){
        return temperature;
    };

    /**
     * Constructeur de CapteurTemperature
     * @param nomCapteur
     */
    public CapteurTemperature(String nomCapteur) {
        super(nomCapteur);
    }

    /**
     * Getter de la température du CapteurTemperature
     * @return température du CapteurTemperature
     */
    public double getTemperature(){
        return this.temperature.get();
    }
}
