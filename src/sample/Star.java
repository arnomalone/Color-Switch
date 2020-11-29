package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Star extends Circle {
    boolean hit = false;
    Star(Double r, Color color){
        super(r, color);
        setTranslateX(200);
        setTranslateY(-10);
    }

    void moveDown(){
        setTranslateY(getTranslateY()+1.2);
    }
}
