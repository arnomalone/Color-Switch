package sample;

import javafx.scene.image.Image;

public class ElementStar extends Elements {
    boolean hit = false;
    Double radius;
    ElementStar(Double r, Image ip){
        super(ip);
        radius = r;
        this.setHeight(30);
        this.setWidth(30);
        setTranslateX(250-(this.getWidth()/2));
        setTranslateY(-10-(this.getHeight()/2));
    }

    public Double getRadius() {
        return radius;
    }
}
