package modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Registre {

    private List<Capteur> listeCapteurs = new ArrayList<>();

    public void ajouterCapteur(Capteur capteur){
        listeCapteurs.add(capteur);
    }

    public List<Capteur> getListeCapteurs() {
        return listeCapteurs;
    }
}
