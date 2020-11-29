package sample;


import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class ElementBall extends Elements {
    public ElementBall(int x, int y, Image ip){
        super(ip);
        this.setFitHeight(15);
        this.setFitWidth(15);
        setTranslateX(200-(this.getFitWidth()/2));
        setTranslateY(500-(this.getFitHeight()/2));
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
    void setColor(Image ip){
        this.setImage(ip);
    }
    Image getColor(){
        return this.getImage();
    }
}
