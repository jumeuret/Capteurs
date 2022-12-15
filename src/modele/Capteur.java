package modele;

public abstract class Capteur extends Sujet {

    private int id;
    private String nom;
    private static int incrementation;

    public Capteur(String nomCapteur){
        this.id = incrementation;
        incrementation = incrementation + 1;
        this.nom = nomCapteur;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
