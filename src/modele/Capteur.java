package modele;

/**
 * Classe abstraite permettant de créer des Capteur
 */
public abstract class Capteur {

    /**
     * Attribut identifiant du Capteur
     */
    private int id;
    /**
     * Attribut nom du Capteur
     */
    private String nom;
    /**
     * Attribut de classe permettant de guarantir l'unicité des identifiants des Capteur
     */
    private static int incrementation;

    /**
     * Contructeur de Capteur
     * @param nomCapteur
     */
    public Capteur(String nomCapteur){
        this.id = incrementation;
        incrementation = incrementation + 1;
        this.nom = nomCapteur;
    }

    /**
     * Getter de l'identifiant du Capteur
     * @return l'identifiant du Capteur
     */
    public int getId() {
        return id;
    }

    /**
     * Getter du nom du Capteur
     * @return le nom du Capteur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter du nom du capteur
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}
