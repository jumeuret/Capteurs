package data;

import modele.*;

import java.util.List;

public class Stub {

    public Registre chargerDonnees(){
        Registre maison = new Registre();
        CapteurTemperaturePassif thermostat = new CapteurTemperaturePassif("Thermostat");
        CapteurVariatif salleDeBain = new CapteurVariatif("SalleDeBain",-5,5);
        CapteurRealiste cuisine = new CapteurRealiste("Cuisine", 15,30);
        CapteurVariatif salon = new CapteurVariatif("SalleDeBain",-10,10);
        CapteurRealiste chambre = new CapteurRealiste("Cuisine", 14,19);
        CapteurTemperatureVirtuel etage1 = new CapteurTemperatureVirtuel("Etage1");
        etage1.ajouterCapteur(salon, 4);
        etage1.ajouterCapteur(cuisine, 3);
        CapteurTemperatureVirtuel etage2 = new CapteurTemperatureVirtuel("Etage2");
        etage2.ajouterCapteur(salleDeBain,2);
        etage2.ajouterCapteur(chambre,1);
        CapteurVariatif grenier = new CapteurVariatif("Grenier",-15,15);
        maison.ajouterCapteur(etage1);
        maison.ajouterCapteur(etage2);
        maison.ajouterCapteur(grenier);
        return maison;
    }
}
