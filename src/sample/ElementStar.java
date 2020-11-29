package sample;

import javafx.scene.image.Image;

public class ElementStar extends Elements {
    boolean hit = false;
    Double radius;
    ElementStar(Double r, Image ip){
        super(ip);
        radius = r;
        this.setFitHeight(20);
        this.setFitWidth(20);
        setTranslateX(200-(this.getFitWidth()/2));
        setTranslateY(-10-(this.getFitHeight()/2));
    }

    public Double getRadius() {
        return radius;
    }
}
