package modele;

import java.io.IOException;

/**
 * Classe dérivée de Capteur permettant de créer des CapteurTemperature
 */
public class CapteurTemperature extends Capteur{

    /**
     * Attribut température du CapteurTemperature
     */
    private int temperature;

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
    public int getTemperature() {
        return temperature;
    }

    /**
     * Setter de la température du CapteurTemperature
     * @param temperature
     * @throws IOException
     */
    public void setTemperature(int temperature) throws IOException {
        this.temperature = temperature;
        notifier();
    }

}
