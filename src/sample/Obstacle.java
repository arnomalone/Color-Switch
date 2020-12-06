package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public abstract class Obstacle extends Elements {
    boolean hit = false;
    protected int type;
    protected ElementColorChanger colorChanger;
    ElementStar star;
    public Obstacle(Image ip)
    {
        super(ip);
        this.setHeight(200);
        this.setWidth(200);

    }

    void setColor(Image ip){
        this.setFill(new ImagePattern(ip));
    }

    public abstract boolean isCollision(Elements ball);

    public abstract void switchColor(int num);
}
