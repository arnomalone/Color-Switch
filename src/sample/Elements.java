package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public abstract class Elements extends Rectangle {
    RotateTransition rotateTransition;
    Elements(Image ip){
        super();
        this.setFill(new ImagePattern(ip));
        startRotate();
    }

    private void startRotate(){
        rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.seconds(5));
        rotateTransition.setNode(this);
        rotateTransition.setByAngle(360);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
    }
}
