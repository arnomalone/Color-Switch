package sample;

import javafx.scene.image.Image;

public class ElementColorChanger extends Elements {
    boolean hit = false;
    public ElementColorChanger(Image ip) {
        super(ip);
        this.setFitHeight(25);
        this.setFitWidth(25);
        setTranslateX(200 - (this.getFitWidth() / 2));
        setTranslateY(500 - (this.getFitHeight() / 2));
    }
}