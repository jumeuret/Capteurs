package modele;

import java.io.IOException;

/**
 * Interface observant des Sujet afin d'être prévenus de leurs modifications
 */
public interface Observateur {

    /**
     * Méthode abstraite peremttant d'actualiser les Observateur
     * @throws IOException
     */
    void update() throws IOException;
}
