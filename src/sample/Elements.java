package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.Serializable;


public abstract class Elements extends Rectangle implements Serializable {
    RotateTransition rotateTransition;
    String image_path0;

    Elements(){
        super();
        startRotate();
    }

    public abstract void setImage() throws FileNotFoundException;

    private void startRotate(){
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.seconds(5));
        rotateTransition.setNode(this);
        rotateTransition.setByAngle(360);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
    }
}
