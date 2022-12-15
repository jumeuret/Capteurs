package view;

import modele.Capteur;
import modele.CapteurTemperature;

    public class Thermometre extends Visualisateur{

    private CapteurTemperature capteur;

    public Thermometre(CapteurTemperature capteurMeteo){
        super(capteurMeteo);
    }

    public void onChange(){
        //
    }


}
