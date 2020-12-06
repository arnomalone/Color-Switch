package sample;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ElementStar extends Elements {
    boolean hit = false;
    Double radius;
    ElementStar(Double r) throws FileNotFoundException {
        super();
        image_path0 = "src/sample/resources/star_tran.png";
        radius = r;
        setImage();
        this.setHeight(30);
        this.setWidth(30);
        setTranslateX(250-(this.getWidth()/2));
        setTranslateY(-10-(this.getHeight()/2));
    }

    public Double getRadius() {
        return radius;
    }

    @Override
    public void setImage() throws FileNotFoundException {
        this.setFill(new ImagePattern(new Image(new FileInputStream(image_path0))));
    }
}
