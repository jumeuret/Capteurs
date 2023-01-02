package modele;

public class CapteurRealiste extends CapteurTemperatureActif{

    // >= -213 °C
    private double minTemperature;

    private double maxTemperature;

    /**
     * Constructeur de CapteurRealiste
     *
     * @param nomCapteur
     */
    public CapteurRealiste(String nomCapteur, double min, double max) {
        super(nomCapteur);
        if (min < -213){
            min = -213;
        }
        else{
            minTemperature = min;
        }
        maxTemperature = max;
    }

    @Override
    public void genererTemperature() {

    }
}
