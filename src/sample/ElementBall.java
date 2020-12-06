package sample;


import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class ElementBall extends Elements {
    public ElementBall(int x, int y, Image ip){
        super(ip);
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
    void setColor(Image ip){
        this.setFill(new ImagePattern(ip));
    }
//    Image getColor(){
//        return this.getImage();
//    }
}
