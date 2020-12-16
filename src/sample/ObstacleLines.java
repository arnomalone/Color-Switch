package sample;

import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class ObstacleLines extends Obstacle {
    private final Line line1, line2;
    String image_path1, image_path2, image_path3;
    boolean increaseDifficulty = false;
    public ObstacleLines(int val) throws FileNotFoundException {
        super();
        type = 3;
        image_path0 = "src/sample/resources/line-0.png";
        image_path1 = "src/sample/resources/line-1.png";
        image_path2 = "src/sample/resources/line-2.png";
        image_path3 = "src/sample/resources/line-3.png";
        this.switchColor(val);
        this.setTranslateX(290-(this.getWidth()/3));
        colorChanger = new ElementColorChanger();
        colorChanger.setNextColor(val);

        star = new ElementStar(5.0);

        line1 = new Line(125, 125, 125, 25);
        line2 = new Line(125, 125, 125, 25);

        this.rotateProperty().addListener(o -> {
            Point2D start1 = this.localToParent(100, 10);
            Point2D end1 = this.localToParent(100, 190);
            Point2D start3 = this.localToParent(100, 100);
            Point2D end3 = this.localToParent(190, 100);
            line1.setStartX(start1.getX());
            line1.setStartY(start1.getY());
            line1.setEndX(end1.getX());
            line1.setEndY(end1.getY());
            line2.setStartX(start3.getX());
            line2.setStartY(start3.getY());
            line2.setEndX(end3.getX());
            line2.setEndY(end3.getY());
        });

        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(Duration.seconds(3));
        if(this.getTranslateX()!=290-(this.getWidth()/3)){
            transition.setByX(150);
        }
        else{
            transition.setByX(-150);
        }
        transition.setAutoReverse(true);
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        if(C_play.count >= 10){
            increaseDifficulty = true;
        }
        if(increaseDifficulty){
            transition.play();
        }

    }

    @Override
    public boolean isCollision(Elements ball) {
        Shape intersect1 = Shape.intersect(ball, line1);
        Shape intersect2 = Shape.intersect(ball, line2);
        if (intersect1.getBoundsInLocal().getWidth() != -1 || intersect2.getBoundsInLocal().getWidth() != -1) {
            System.out.println("collision line");
            return true;
        }
        return false;
    }

    @Override
    public void switchColor(int num) throws FileNotFoundException {
        this.currColor = num;
        if(num == 0)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path0))));
        if(num == 1)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path1))));
        if(num == 2)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path2))));
        if(num == 3)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path3))));
    }

}
