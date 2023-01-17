package modele.capteur;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe abstraite permettant de créer des Capteur
 */
public abstract class Capteur {

    protected IntegerProperty id = new SimpleIntegerProperty();

    public IntegerProperty idProperty(){
        return id;
    }

    public int getId(){
        return id.get();
    }

    protected StringProperty nom = new SimpleStringProperty();

    public StringProperty nomProperty(){
        return nom;
    }

    public String getNom(){
        return this.nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    /**
     * Attribut de classe permettant de guarantir l'unicité des identifiants des Capteur
     */
    private static int incrementation;

    /**
     * Contructeur de Capteur
     * @param nomCapteur
     */
    public Capteur(String nomCapteur){
        id.set(incrementation);
        incrementation = incrementation + 1;
        setNom(nomCapteur);
    }
}
