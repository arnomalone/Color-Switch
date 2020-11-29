package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class Ball extends Circle {
    boolean dead = false;
    Ball(int x, int y, Double r, Color color){
        super(r, color);
        setTranslateX(x);
        setTranslateY(y);
    }
    void moveUp() {
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(0.16));
        trans.setCycleCount(1);
        trans.setNode(this);
        trans.setToY(getTranslateY()<300?300:getTranslateY()-30);
        trans.play();
    }
    void moveDown() {
        setTranslateY(getTranslateY()+1.2);
        if(getTranslateY()>600){
            setTranslateY(600);
        }
    }
}
