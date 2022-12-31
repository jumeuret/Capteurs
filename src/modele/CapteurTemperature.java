package modele;

public class CapteurTemperature extends Capteur{

    private int temperature;

    public CapteurTemperature(String nomCapteur) {
        super(nomCapteur);
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

}
