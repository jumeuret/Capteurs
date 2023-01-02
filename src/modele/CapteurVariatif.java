package modele;

public class CapteurVariatif extends CapteurTemperatureActif{

    private double minVariation;

    private double maxVariation;

    /**
     * Constructeur de CapteurVariatif
     *
     * @param nomCapteur
     */
    public CapteurVariatif(String nomCapteur, double min, double max) {
        super(nomCapteur);
        minVariation = min;
        maxVariation = max;
    }

    @Override
    public void genererTemperature() {

    }
}
