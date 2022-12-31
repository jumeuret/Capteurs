package modele;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public abstract class Sujet {

    /**
     *
     */
    private final List<Observateur> listeObservateurs = new ArrayList<>();

    public List<Observateur> getListeObservateurs() {
        return Collections.unmodifiableList(listeObservateurs);
    }

    public void attacher(Observateur observateur){
       listeObservateurs.add(observateur);
    }

    public void detacher(Observateur observateur){
        listeObservateurs.remove(observateur);
    }

    public void notifier() throws IOException {
        for (Observateur observateur : listeObservateurs){
            observateur.update();
        }
    }
}
