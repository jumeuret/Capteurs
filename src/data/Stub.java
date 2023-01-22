package data;

import modele.Bipper;
import modele.capteur.capteurActif.CapteurRealiste;
import modele.capteur.capteurActif.CapteurTemperaturePassif;
import modele.capteur.capteurActif.CapteurTemperatureVirtuel;
import modele.capteur.capteurActif.CapteurVariatif;

public class Stub {

    public CapteurTemperatureVirtuel chargerDonnees(){
        Bipper bipper = new Bipper(500);
        CapteurTemperatureVirtuel maison = new CapteurTemperatureVirtuel("Maison");
        CapteurTemperaturePassif thermostat = new CapteurTemperaturePassif("Thermostat");
        CapteurVariatif salleDeBain = new CapteurVariatif("SalleDeBain",-5,5, bipper);
        CapteurRealiste cuisine = new CapteurRealiste("Cuisine", 15,30, bipper);
        CapteurVariatif salon = new CapteurVariatif("SalleDeBain",-10,10, bipper);
        CapteurRealiste chambre = new CapteurRealiste("Cuisine", 14,19, bipper);
        CapteurTemperatureVirtuel etage1 = new CapteurTemperatureVirtuel("Etage1");
        etage1.ajouterCapteur(salon, 4);
        etage1.ajouterCapteur(cuisine, 3);
        CapteurTemperatureVirtuel etage2 = new CapteurTemperatureVirtuel("Etage2");
        etage2.ajouterCapteur(salleDeBain,2);
        etage2.ajouterCapteur(chambre,1);
        CapteurVariatif grenier = new CapteurVariatif("Grenier",-15,15, bipper);
        maison.ajouterCapteur(etage1,4);
        maison.ajouterCapteur(etage2,4);
        maison.ajouterCapteur(grenier,3);
        maison.ajouterCapteur(thermostat,1);
        return maison;
    }
}
