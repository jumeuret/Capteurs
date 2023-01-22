package view.visualisateurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modele.capteur.CapteurTemperature;

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

    private void changeImage() throws IOException {
        Image newImage;
        if (((CapteurTemperature)getCapteur()).getTemperature() < 0){
            newImage = new Image(getClass().getResource("/images/Meteo/neige.png").openStream());
        }
        else if (((CapteurTemperature)getCapteur()).getTemperature() < 22) {
            newImage = new Image(getClass().getResource("/images/Meteo/nuages.png").openStream());
        }
        else{
            newImage = new Image(getClass().getResource("/images/Meteo/soleil.png").openStream());
        }
        imageView.setImage(newImage);
    }

    /**
     * Constructeur de fenêtre Meteo
     * @param capteurMeteo
     * @throws IOException
     */
    public Meteo(CapteurTemperature capteurMeteo) throws IOException {
        super(capteurMeteo);
    }

    /**
     * Méthode permettant de fermer la fenêtre Meteo
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


    public void initialize() {
        ((CapteurTemperature)getCapteur()).temperatureProperty().addListener((o, oldValue, newValue) -> {
            try {
                changeImage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
