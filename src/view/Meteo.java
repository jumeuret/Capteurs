package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modele.Capteur;
import modele.CapteurTemperature;

import java.awt.*;
import java.io.IOException;

/**
 * Classe dérivée de Visualisateur Code Behind de Meteo.fxml
 */
public class Meteo extends Visualisateur {

    /**
     * Attribut ImageView permettant de setter l'attribut Image
     */
    @FXML
    ImageView imageView;

    /**
     * Attribut Image
     */
    @FXML
    Image image;

    /**
     * Attribut Button permettant de lancer la méthode clicFermer
     */
    @FXML
    Button fermer;

    /**
     * Constructeur de fenêtre Meteo
     * @param capteurMeteo
     * @throws IOException
     */
    public Meteo(CapteurTemperature capteurMeteo) throws IOException {
        super(capteurMeteo);
        update();
    }

    /**
     * Méthode permettant de fermer la fenêtre
     * @param event
     */
    @FXML
    private void clicFermer(ActionEvent event) {

        //Button fermerBis = (Button) event.getSource();
        //Stage stage = (Stage) fermerBis.getScene().getWindow();
        Stage stage = (Stage) fermer.getScene().getWindow();
        stage.close();
    }

    /**
     * Méthode permettant de mettre à jour la valeur de l'attribut Image selon la valeur du CapteurTemperature
     * @throws IOException
     */
    @Override
    public void update() throws IOException {

        Image newImage;
        if ((((CapteurTemperature)capteur).getTemperature()) < 0){
            newImage = new Image(getClass().getResource("/images/neige.png").openStream());
        }
        else if ((((CapteurTemperature)capteur).getTemperature()) < 22) {
            newImage = new Image(getClass().getResource("/images/nuages.png").openStream());
        }
        else{
            newImage = new Image(getClass().getResource("/images/soleil.png").openStream());
        }
        imageView.setImage(newImage);
    }
}
