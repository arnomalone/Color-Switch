package sample;

import javafx.animation.ScaleTransition;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class ObstacleSquare extends Obstacle {
    private final Line line1, line2, line3;
    String image_path1, image_path2, image_path3;
    boolean increaseDifficulty = false;
    boolean increaseDifficulty2 = false;

    public ObstacleSquare(int val) throws FileNotFoundException {
        super();
        type = 2;
        image_path0 = "src/sample/resources/square-0.png";
        image_path1 = "src/sample/resources/square-1.png";
        image_path2 = "src/sample/resources/square-2.png";
        image_path3 = "src/sample/resources/square-3.png";
        this.switchColor(val);
        this.setTranslateX(250-(this.getWidth()/2));
        colorChanger = new ElementColorChanger();
        colorChanger.setNextColor(val);
        star = new ElementStar(5.0);

        line1 = new Line(125, 125, 125, 25);
        line2 = new Line(125, 125, 125, 25);
        line3 = new Line(125, 125, 125, 25);

        this.rotateProperty().addListener(o -> {
            Point2D start1 = this.localToParent(20, 10);
            Point2D end1 = this.localToParent(180, 10);
            Point2D start2 = this.localToParent(10, 20);
            Point2D end2 = this.localToParent(10, 180);
            Point2D start3 = this.localToParent(20, 190);
            Point2D end3 = this.localToParent(180, 190);
            line1.setStartX(start1.getX());
            line1.setStartY(start1.getY());
            line1.setEndX(end1.getX());
            line1.setEndY(end1.getY());
            line2.setStartX(start2.getX());
            line2.setStartY(start2.getY());
            line2.setEndX(end2.getX());
            line2.setEndY(end2.getY());
            line3.setStartX(start3.getX());
            line3.setStartY(start3.getY());
            line3.setEndX(end3.getX());
            line3.setEndY(end3.getY());
        });

        ScaleTransition transition = new ScaleTransition(Duration.seconds(3), this);
        transition.setToX(1.2);
        transition.setToY(1.2);
        transition.setRate(1.1);
        transition.setCycleCount(ScaleTransition.INDEFINITE);
        transition.setAutoReverse(true);
        if(C_play.count >= 10){
            increaseDifficulty = true;
        }
        if(C_play.count >= 20){
            increaseDifficulty2 = true;
        }
        if(increaseDifficulty2){
            double currRate = this.rotateTransition.getRate();
            this.rotateTransition.setRate(currRate+0.35);
        }
        if(increaseDifficulty){
            transition.play();
        }
    }

    @Override
    public boolean isCollision(Elements ball) {
        Shape intersect1 = Shape.intersect(ball, line1);
        Shape intersect2 = Shape.intersect(ball, line2);
        Shape intersect3 = Shape.intersect(ball, line3);
        if (intersect1.getBoundsInLocal().getWidth() != -1 || intersect2.getBoundsInLocal().getWidth() != -1) {
            System.out.println("collision square");
            return true;
        }
        if (intersect3.getBoundsInLocal().getWidth() != -1) {
            System.out.println("collision square");
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
