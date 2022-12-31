package modele;

import java.io.IOException;

public class CapteurTemperature extends Capteur{

    private int temperature;

    public CapteurTemperature(String nomCapteur) {
        super(nomCapteur);
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) throws IOException {
        this.temperature = temperature;
        notifier();
    }

}
