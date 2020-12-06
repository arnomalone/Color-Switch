package sample;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ElementColorChanger extends Elements {
    private boolean hit = false;
    private int nextColor;
    public ElementColorChanger() throws FileNotFoundException {
        super();
        image_path0 = "src/sample/resources/color_changer_trans.png";
        setImage();
        nextColor = 0;
        this.setHeight(30);
        this.setWidth(30);
        setTranslateX(250 - (this.getWidth() / 2));
        setTranslateY(500 - (this.getHeight() / 2));
    }

    public void setNextColor(int nextColor) {
        this.nextColor = nextColor;
    }

    public int getNextColor() {
        return nextColor;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    @Override
    public void setImage() throws FileNotFoundException {
        this.setFill(new ImagePattern(new Image(new FileInputStream(image_path0))));
    }
}