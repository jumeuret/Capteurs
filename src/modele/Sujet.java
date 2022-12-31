package modele;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe abtraite permettant de prévenir les Observateur des changements du Sujet
 */
public abstract class Sujet {

    /**
     * Attribut listant tous les Observateurs du sujet
     */
    private final List<Observateur> listeObservateurs = new ArrayList<>();

    /**
     * Getter de la liste des Observateurs
     * @return la liste des Observateurs
     */
    public List<Observateur> getListeObservateurs() {
        return Collections.unmodifiableList(listeObservateurs);
    }

    /**
     * Méthode permettant d'ajouter un nouvel Observateur à la liste
     * @param observateur
     */
    public void attacher(Observateur observateur){
       listeObservateurs.add(observateur);
    }

    /**
     * Méthode permettant de retirer un Observateur à la liste
     * @param observateur
     */
    public void detacher(Observateur observateur){
        listeObservateurs.remove(observateur);
    }

    /**
     * Méthode permettant de prévenir des modifications tous les Observateurs
     * @throws IOException
     */
    public void notifier() throws IOException {
        for (Observateur observateur : listeObservateurs){
            observateur.update();
        }
    }
}
