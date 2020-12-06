package sample;

import javafx.scene.image.Image;

public class ElementColorChanger extends Elements {
    private boolean hit = false;
    private int nextColor;
    Obstacle obstacle;
    public ElementColorChanger(Image ip) {
        super(ip);
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
}