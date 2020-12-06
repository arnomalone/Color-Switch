package sample;


import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ElementBall extends Elements {
    String image_path1, image_path2, image_path3;
    public ElementBall(int x, int y) throws FileNotFoundException {
        super();
        image_path0 = "src/sample/resources/purple_ball.png";
        image_path1 = "src/sample/resources/yellow_ball.png";
        image_path2 = "src/sample/resources/red_ball.png";
        image_path3 = "src/sample/resources/blue_ball.png";
        this.setImage();
        this.setHeight(20);
        this.setWidth(20);
        setTranslateX(250-(this.getWidth()/2));
        setTranslateY(500-(this.getHeight()/2));
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
        if(getTranslateY()>800){
            setTranslateY(800);
        }
    }
    void setColor(int num) throws FileNotFoundException {
        if(num == 0)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path0))));
        if(num == 1)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path1))));
        if(num == 2)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path2))));
        if(num == 3)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path3))));
    }

    @Override
    public void setImage() throws FileNotFoundException {
        this.setFill(new ImagePattern(new Image(new FileInputStream(image_path1))));
    }
}
