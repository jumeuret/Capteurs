package view;

import javafx.scene.image.ImageView;

public class CelluleIcone {

    private ImageView image;

    CelluleIcone(ImageView image) {
        this.image = image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public ImageView getImage() {
        return image;
    }
}
