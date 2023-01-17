package data;

import modele.capteur.CapteurRealiste;
import modele.capteur.CapteurTemperaturePassif;
import modele.capteur.CapteurTemperatureVirtuel;
import modele.capteur.CapteurVariatif;

public class Stub {

    public CapteurTemperatureVirtuel chargerDonnees(){
        CapteurTemperatureVirtuel maison = new CapteurTemperatureVirtuel("Maison");
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
        maison.ajouterCapteur(etage1,4);
        maison.ajouterCapteur(etage2,4);
        maison.ajouterCapteur(grenier,3);
        maison.ajouterCapteur(thermostat,1);
        return maison;
    }
}
